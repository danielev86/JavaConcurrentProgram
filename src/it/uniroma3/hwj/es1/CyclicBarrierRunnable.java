package it.uniroma3.hwj.es1;

import it.uniroma3.hwj.base.Node;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;

public class CyclicBarrierRunnable implements Runnable{
	CyclicBarrier barrier = null;
	private ExecutorService executor;
	private LinkedBlockingDeque<Node> buffer;

	public CyclicBarrierRunnable(ExecutorService executor,LinkedBlockingDeque<Node> buffer) {
		this.executor = executor;
		this.buffer = buffer;
	}
	@Override
	public void run() {
		if(this.buffer.isEmpty()){
			this.executor.shutdown();
		}
		else{
			this.barrier.reset();
		}
	}

	public void setBarrier(CyclicBarrier barrier){
		this.barrier = barrier;
	}

}
