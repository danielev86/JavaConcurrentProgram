package it.uniroma3.hwj.es1;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingDeque;

import it.uniroma3.hwj.base.FakeProcessor;
import it.uniroma3.hwj.base.Node;

public class GenerateTaskUnlimitedBuffer implements Callable<Integer> {
	private LinkedBlockingDeque<Node> buffer;
	private CyclicBarrier barriera;
	
	public GenerateTaskUnlimitedBuffer(LinkedBlockingDeque<Node> buffer, CyclicBarrier barriera){
		this.buffer = buffer;
		this.barriera = barriera;
	}
	
	@Override
	public Integer call() throws Exception {
		return calculatorSum(this.buffer.poll());
	}
	/*===============================================================*/
	/*===============================================================*/
	public int calculatorSum(Node node){
		int somma = 0;
		//do{
		while(node!=null){
			if(this.barriera.getNumberWaiting()>0)
				this.barriera.reset();
			if(node.getSx()!=null)
				this.buffer.addLast(node.getSx());
			if(node.getDx()!=null)
				this.buffer.addLast(node.getDx());
			somma = somma + new FakeProcessor(2000).onerousFunction(node.getValue());
			node = this.buffer.pollFirst();
		}
		try {
			this.barriera.await(); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) { 
			node = this.buffer.pollFirst();
			somma = calculatorSum(node);
		}
		return somma;
	}
	
	
	
}