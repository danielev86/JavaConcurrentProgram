package it.uniroma3.hwj.es3;

import it.uniroma3.hwj.base.BinaryTreeAdder;
import it.uniroma3.hwj.base.Node;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingDeque;

public class BinaryTreeAdderImplementForkJoin implements BinaryTreeAdder{
	private final int NCPU;

	public BinaryTreeAdderImplementForkJoin(int numThread){
		this.NCPU = numThread;
	}

	@Override
	public int computeOnerousSum(Node root) {
		BlockingDeque<Node> buffer  = new LinkedBlockingDeque<Node>();
		buffer.add(root);
		final ForkJoinPool pool = new ForkJoinPool(this.NCPU);
		final ForkJoinCalculator finder = new ForkJoinCalculator(root);
		return pool.invoke(finder);
	}
}
