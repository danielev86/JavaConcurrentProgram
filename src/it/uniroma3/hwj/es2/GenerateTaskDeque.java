package it.uniroma3.hwj.es2;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CyclicBarrier;

import it.uniroma3.hwj.base.FakeProcessor;
import it.uniroma3.hwj.base.Node;

public class GenerateTaskDeque implements Callable<Integer> {
	private CyclicBarrier barriera;
	private ConcurrentLinkedQueue<BlockingDeque<Node>> dequeList;
	private BlockingDeque<Node> buffer;

	public GenerateTaskDeque(BlockingDeque<Node> myDeque, CyclicBarrier barriera,
			ConcurrentLinkedQueue<BlockingDeque<Node>> dequeList){
		this.buffer = myDeque;
		this.barriera = barriera;
		this.dequeList = dequeList;
	}
	/*==========================================================================*/
	@Override
	public Integer call() throws Exception {
		int somma=0;


		while(isAllBufferEmpty() || this.barriera.getParties()==this.barriera.getNumberWaiting()){
			if(this.buffer.isEmpty()){
				Node node1 = stealNode();
				if(node1!=null)
					this.buffer.add(node1);
			}
			Node node = this.buffer.poll();
			if(this.barriera.getNumberWaiting()>0)
				this.barriera.reset();
			somma = somma + calculateSum(node);
		}
		//calculateSum(null);//serve a terminare: tutti i buffer sono vuoti
		return somma;
	}

	/*==========================================================================*/
	/*==========================================================================*/
	public int calculateSum(Node node){
		int somma = 0;
		if(node!=null)
			return depthVisit(node);
		else{
			try {
				this.barriera.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				//				Node newNode = stealNode();
				//				if(newNode != null)
				//					this.buffer.addFirst(newNode);
				return 0;
			}
			return somma;
		}
	}
	/*==========================================================================*/
	/*==========================================================================*/
	public int depthVisit(Node node) {
		if(node==null){		
			return 0;
		}
		if(node.getDx()!=null){
			this.buffer.addFirst(node.getDx());
			if(this.barriera.getNumberWaiting()>0)
				this.barriera.reset();
		}
		return new FakeProcessor(2000).onerousFunction(node.getValue()) + depthVisit(node.getSx());
	}
	/*==========================================================================*/
	//steal last element
	/*==========================================================================*/
	public Node stealNode(){
		Node node = null;
		boolean test = false;
		Iterator <BlockingDeque<Node>> it = this.dequeList.iterator();
		while(it.hasNext()  && !test){
			BlockingDeque<Node> otherDeque = it.next();
			if(!otherDeque.isEmpty()){
				node = otherDeque.pollLast();
				test = true;
			}
		}
		return node;
	}
	/*==========================================================================*/
	/*return true if any buffer contain node element*/
	/*==========================================================================*/
	public synchronized boolean isAllBufferEmpty(){
		boolean test = false;
		Iterator <BlockingDeque<Node>> it = this.dequeList.iterator();
		while(it.hasNext() && !test){
			BlockingDeque<Node> otherDeque = it.next();
			if(!otherDeque.isEmpty()){
				test = true;
			}
			else
				test = false;
		}
		return test;
	}
}