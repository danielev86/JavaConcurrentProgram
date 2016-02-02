package it.uniroma3.hwj.es4;

import it.uniroma3.hwj.base.BinaryTreeAdder;
import it.uniroma3.hwj.base.Node;
import it.uniroma3.hwj.base.FakeProcessor;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinaryTreeAdderCompletableFuture implements BinaryTreeAdder{

	public BinaryTreeAdderCompletableFuture(){
	}

	@Override
	public int computeOnerousSum(Node root) {
		List<CompletableFuture<Integer>> poolResult = splitToStream(root)
				.map(node->CompletableFuture.supplyAsync(()->(new FakeProcessor(2000).onerousFunction(node.getValue()))))
				.collect(Collectors.toList());
		return poolResult.stream().map(CompletableFuture::join).reduce(0, (a,b)->a+b);
	}

	public static Stream<Node> splitToStream(Node root){
		if(root.getDx()==null && root.getSx()==null)
			return Stream.of(root);
		else
			return Stream.concat(Stream.concat(Stream.of(root), splitToStream(root.getSx())), splitToStream(root.getDx()));
	}
}
