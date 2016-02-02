package it.uniroma3.hwj.es2;

import it.uniroma3.hwj.base.BinaryTreeAdder;
import it.uniroma3.hwj.base.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Future;

public class BinaryTreeAdderImplementWithDeque implements BinaryTreeAdder{
	private int NCPU;
	private int dequeSize;

	public BinaryTreeAdderImplementWithDeque(int numThread, int dequeSize){
		this.NCPU = numThread;
		this.dequeSize = dequeSize;
	}

	@Override
	public int computeOnerousSum(Node root) {
		int somma = 0;
		ExecutorService executor = Executors.newFixedThreadPool(this.NCPU);
		ConcurrentLinkedQueue<BlockingDeque<Node>> poolDequeBufer = new ConcurrentLinkedQueue<BlockingDeque<Node>>();
		
		CyclicBarrierRunnableStealing actionBarrier = new CyclicBarrierRunnableStealing(executor,poolDequeBufer);
		CyclicBarrier barriera = new CyclicBarrier(this.NCPU, actionBarrier);
		actionBarrier.setBarrier(barriera);

		CompletionService<Integer> poolResult = new ExecutorCompletionService<Integer>(executor);

		BlockingDeque<Node> mydeque = new LinkedBlockingDeque<Node>(this.dequeSize);
		List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
		mydeque.offerFirst(root);
		poolDequeBufer.add(mydeque);
		poolResult.submit(new GenerateTaskDeque(mydeque, barriera, poolDequeBufer));

		for(int i=1; i<this.NCPU; i++){
			BlockingDeque<Node> otherdeque = new LinkedBlockingDeque<Node>(this.dequeSize);
			poolDequeBufer.add(otherdeque);
			futures.add(poolResult.submit(new GenerateTaskDeque(otherdeque, barriera, poolDequeBufer)));
		}
		
		for(Future it:futures)
			try {
				somma +=(Integer)it.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return somma;
	}
}
