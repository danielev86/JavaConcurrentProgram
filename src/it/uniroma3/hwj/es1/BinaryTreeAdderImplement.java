package it.uniroma3.hwj.es1;

import it.uniroma3.hwj.base.BinaryTreeAdder;
import it.uniroma3.hwj.base.Node;

import java.util.concurrent.CompletionService;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class BinaryTreeAdderImplement implements BinaryTreeAdder{
	private final int NCPU;

	public BinaryTreeAdderImplement(int numThread){
		this.NCPU = numThread;
	}

	@Override
	public int computeOnerousSum(Node root) {
		int somma = 0;
		ExecutorService executor = Executors.newFixedThreadPool(this.NCPU);
		LinkedBlockingDeque<Node> buffer = new LinkedBlockingDeque<Node>();
		buffer.offer(root);

		CyclicBarrierRunnable actionBarrier = new CyclicBarrierRunnable(executor,buffer);
		CyclicBarrier barriera = new CyclicBarrier(this.NCPU, actionBarrier);
		actionBarrier.setBarrier(barriera);

		CompletionService<Integer> poolResult = new ExecutorCompletionService<Integer>(executor);
		for(int i=0; i<this.NCPU; i++)
			poolResult.submit(new GenerateTaskUnlimitedBuffer(buffer, barriera));
		
		for(int j=0; j<this.NCPU; j++)
			try {
				somma = somma + poolResult.take().get();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		return somma;
	}
}
