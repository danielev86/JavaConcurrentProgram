package it.uniroma3.hwj.support;
import it.uniroma3.hwj.base.Node;
import it.uniroma3.hwj.base.NodeImplement;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import javax.rmi.CORBA.Util;

import it.uniroma3.hwj.base.FakeProcessor;
import it.uniroma3.hwj.base.Node;
import it.uniroma3.hwj.es1.BinaryTreeAdderImplement;
import it.uniroma3.hwj.es2.BinaryTreeAdderImplementWithDeque;
import it.uniroma3.hwj.es3.BinaryTreeAdderImplementForkJoin;
import it.uniroma3.hwj.es4.BinaryTreeAdderCompletableFuture;
import it.uniroma3.hwj.support.AlberoBinario;

public class AlberoBinario {

	public AlberoBinario(){
	}

	/*=============================================*/
	public Node alberoBinarioCompleto(int livelli) {
		if(livelli==-1)
			return null;
		int r = (int) (1);
		Node s = alberoBinarioCompleto(livelli-1);
		Node d = alberoBinarioCompleto(livelli-1);
		return new NodeImplement(s, d, r);
	}
	/*=============================================*/
	public Node alberoSbilanciatoSinistro(int livello, int profondita){
		if(livello>profondita)
			return null;
		else if(livello==0){
			int r=(int) (1);
			Node s = alberoSbilanciatoSinistro(1,profondita);
			Node d = alberoSbilanciatoSinistro(2,profondita);
			return new NodeImplement(s, d, r);
			
		}else{
			int r=(int) (1);
			Node s = alberoSbilanciatoSinistro(livello+1,profondita);
			Node d = alberoSbilanciatoSinistro(livello+1,profondita);
			return new NodeImplement(s, d, r);
		}
	}
	/*=============================================*/
	public Node alberoSbilanciatoDestro(int livello, int profondita){
		if(livello>profondita)
			return null;
		else if(livello==0){
			int r=(int) (1);
			Node s = alberoSbilanciatoDestro(2,profondita);
			Node d = alberoSbilanciatoDestro(1,profondita);
			return new NodeImplement(s, d, r);
			
		}else{
			int r=(int) (1);
			Node s = alberoSbilanciatoDestro(livello+1,profondita);
			Node d = alberoSbilanciatoDestro(livello+1,profondita);
			return new NodeImplement(s, d, r);
		}
	}
	
	
	/*=============================================*/
	public int contaNodi(Node root) {
		if (root == null)
			return 0;
		else {
			int nodisx = contaNodi(root.getSx());
			int nodidx = contaNodi(root.getDx());
			return 1 + nodisx + nodidx;
		}
		
	
	}
	/*=============================================*/
	public int contaNodiFiglioSinistroRadice(Node root){
		return (contaNodi(root.getSx()));
	}
	
	public int contaNodiFiglioDestroRadice(Node root){
		return (contaNodi(root.getDx()));
	}
	/*=============================================*/

	public int profondita(Node node){
		if (node == null)
			return -1;
		else { 
			int ps = profondita(node.getSx());
			int	pd = profondita(node.getDx());
			if (ps > pd)
				return 1 + ps;
			else return 1 + pd;
		}
	}
}

