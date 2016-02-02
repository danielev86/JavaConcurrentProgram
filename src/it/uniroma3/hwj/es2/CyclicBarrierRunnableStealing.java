package it.uniroma3.hwj.es2;

import it.uniroma3.hwj.base.Node;

import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierRunnableStealing implements Runnable{
	CyclicBarrier barriera = null;
	private ExecutorService executor;
	private ConcurrentLinkedQueue<BlockingDeque<Node>> poolDeque;

	public CyclicBarrierRunnableStealing(ExecutorService executor,ConcurrentLinkedQueue<BlockingDeque<Node>> poolDeque) {
		this.executor = executor;
		this.poolDeque = poolDeque;
	}
	@Override
	public void run(){
		Iterator <BlockingDeque<Node>> it = this.poolDeque.iterator();
		while(it.hasNext()){
			BlockingDeque<Node> otherDeque = it.next();
			
		}
		
		this.executor.shutdownNow();
		

	}

	public void setBarrier(CyclicBarrier barrier){
		this.barriera = barrier;
	}
}
