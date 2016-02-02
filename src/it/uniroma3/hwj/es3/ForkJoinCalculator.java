package it.uniroma3.hwj.es3;

import java.util.concurrent.RecursiveTask;

import it.uniroma3.hwj.base.FakeProcessor;
import it.uniroma3.hwj.base.Node;

public class ForkJoinCalculator extends RecursiveTask<Integer>  {

	/*dalle sperimentazione la soglia di THRESHOLD = 10000 risulta ottimale*/

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final long THRESHOLD = 10000;
	private Node root;

	public ForkJoinCalculator(Node root){
		this.root = root;
	}

	@Override
	protected Integer compute() {
		final int numeroNodi = numNodiProfondita(this.root,14);
		if(numeroNodi<THRESHOLD){
			return computeDirectly(this.root);
		}
		else{
			final ForkJoinCalculator left = new ForkJoinCalculator(this.root.getSx());
			final ForkJoinCalculator right = new ForkJoinCalculator(this.root.getDx());
			left.fork();
			int rightAns = right.compute();
			int leftAns = left.join();
			return rightAns + leftAns + new FakeProcessor(2000).onerousFunction(this.root.getValue());
		}
	}

	public int numNodiProfondita(Node node, int h){
		if (node == null)
			return 0;
		if (h==0) 
			return 1;
		else 
			return numNodiProfondita(node.getSx(), h-1) + numNodiProfondita(node.getDx(), h-1);
	}

	public int computeDirectly(Node node) {
		if(node==null)
			return 0;
		else
			return new FakeProcessor(2000).onerousFunction(node.getValue()) + computeDirectly(node.getSx()) +computeDirectly(node.getDx());
	}
}
