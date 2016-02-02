package it.uniroma3.hwj.base;

public class NodeImplement implements Node {
	private Node nodoSx;
	private Node nodoDx;
	private int value;

	public NodeImplement(Node nodoSx, Node nodoDx, int value) {
		this.nodoSx = nodoSx;
		this.nodoDx = nodoDx;
		this.value = value;
	}

	@Override
	public Node getSx() {
		return this.nodoSx;
	}

	@Override
	public Node getDx() {
		return this.nodoDx;
	}

	@Override
	public int getValue() {
		return this.value;
	}

}
