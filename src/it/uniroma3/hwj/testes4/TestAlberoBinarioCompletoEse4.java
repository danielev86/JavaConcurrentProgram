package it.uniroma3.hwj.testes4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.hwj.base.Node;
import it.uniroma3.hwj.es1.BinaryTreeAdderImplement;
import it.uniroma3.hwj.es4.BinaryTreeAdderCompletableFuture;
import it.uniroma3.hwj.support.AlberoBinario;

public class TestAlberoBinarioCompletoEse4 {
	private AlberoBinario albero;
	private int warmup;
	private int NCPU;
	private double speedup1;
	private double speedup2;
	private double speedup3;
	private double speedup4;
	private double speedup5;
	private int singleExec;
	private int somma;
	private Node root;
	private int numeroNodi;
	private static  double speedupeff=0;
	@Before
	public void setUp(){
		System.out.println();
		System.out.println("Init Suite Albero Binario Completo Esercizio 4");
		albero = new AlberoBinario();
		warmup = 10;
		NCPU = Runtime.getRuntime().availableProcessors();
		speedup1 = 0;
		speedup2 = 0;
		speedup3 = 0;
		singleExec = 1;
		somma = 0;
		root = null;
		numeroNodi=0;
		
	}
	
	@Test
	public void test_BinarioCompletoProfondita09(){
		
		root=albero.alberoBinarioCompleto(9);
		numeroNodi=albero.contaNodi(root);
		System.out.println("Test Albero Binario Completo Profondità 9");
		System.out.println("------Numero Nodi: "+numeroNodi);
		/*Warmup esecuzione seriale*/
		BinaryTreeAdderImplement seriale = new BinaryTreeAdderImplement(singleExec);
		for(int i = 0; i<warmup; i++){
			seriale.computeOnerousSum(root);
		}
		/*Calcolo speedup esecuzione seriale*/
		Long startSerial = System.currentTimeMillis();
		somma  = seriale.computeOnerousSum(root);
		Long serialTime = System.currentTimeMillis() - startSerial;
		System.out.println("------Somma seriale nodi: "+somma);
		System.out.println("------Tempo Esecuzione seriale: "+serialTime+"ms");
		/*Fine esecuzione seriale*/
		/*Inizio esecuzione parallela*/
		BinaryTreeAdderCompletableFuture parallela = new BinaryTreeAdderCompletableFuture();
		for(int i = 0; i<warmup; i++){
			parallela.computeOnerousSum(root);
		}
		Long startParallel = System.currentTimeMillis();
		int sumP = parallela.computeOnerousSum(root);
		Long finalParallel = System.currentTimeMillis()-startParallel;
		
		/*Fine esecuzione parallella e inizio calcolo speedup*/
		speedup1 = (double)serialTime/(double)finalParallel;
		System.out.println("------Somma parallela: "+sumP);
		System.out.println("------Tempo Esecuzione parallela: "+finalParallel+"ms");
		System.out.println("------speedup test: "+speedup1);
		speedupeff+=speedup1;
		assertEquals(somma,sumP);
		
		
		
		
	}
	
	@Test
	public void test_BinarioCompletoProfondita11(){
		
		root=albero.alberoBinarioCompleto(11);
		numeroNodi=albero.contaNodi(root);
		System.out.println("Test Albero Binario Completo Profondità 11");
		System.out.println("------Numero Nodi: "+numeroNodi);
		/*Warmup esecuzione seriale*/
		BinaryTreeAdderImplement seriale = new BinaryTreeAdderImplement(singleExec);
		for(int i = 0; i<warmup; i++){
			seriale.computeOnerousSum(root);
		}
		/*Calcolo speedup esecuzione seriale*/
		Long startSerial = System.currentTimeMillis();
		somma  = seriale.computeOnerousSum(root);
		Long serialTime = System.currentTimeMillis() - startSerial;
		System.out.println("------Somma seriale nodi: "+somma);
		System.out.println("------Tempo Esecuzione seriale: "+serialTime+"ms");
		/*Fine esecuzione seriale*/
		/*Inizio esecuzione parallela*/
		BinaryTreeAdderCompletableFuture parallela = new BinaryTreeAdderCompletableFuture();
		for(int i = 0; i<warmup; i++){
			parallela.computeOnerousSum(root);
		}
		Long startParallel = System.currentTimeMillis();
		int sumP = parallela.computeOnerousSum(root);
		Long finalParallel = System.currentTimeMillis()-startParallel;
		/*Fine esecuzione parallella e inizio calcolo speedup*/
		speedup2 = (double)serialTime/(double)finalParallel;
		System.out.println("------Somma parallela: "+sumP);
		System.out.println("------Tempo Esecuzione parallela: "+finalParallel+"ms");
		System.out.println("------speedup test: "+speedup2);
		speedupeff+=speedup2;
		assertEquals(somma,sumP);
		
		
	}
	
	@Test
	public void test_BinarioCompletoProfondita13(){
		
		root=albero.alberoBinarioCompleto(13);
		numeroNodi=albero.contaNodi(root);
		System.out.println("Test Albero Binario Completo Profondità 13");
		System.out.println("------Numero Nodi: "+numeroNodi);
		/*Warmup esecuzione seriale*/
		BinaryTreeAdderImplement seriale = new BinaryTreeAdderImplement(singleExec);
		for(int i = 0; i<warmup; i++){
			seriale.computeOnerousSum(root);
		}
		/*Calcolo speedup esecuzione seriale*/
		Long startSerial = System.currentTimeMillis();
		somma  = seriale.computeOnerousSum(root);
		Long serialTime = System.currentTimeMillis() - startSerial;
		System.out.println("------Somma seriale nodi: "+somma);
		System.out.println("------Tempo Esecuzione seriale: "+serialTime+"ms");
		/*Fine esecuzione seriale*/
		/*Inizio esecuzione parallela*/
		BinaryTreeAdderCompletableFuture parallela = new BinaryTreeAdderCompletableFuture();
		for(int i = 0; i<warmup; i++){
			parallela.computeOnerousSum(root);
		}
		Long startParallel = System.currentTimeMillis();
		int sumP = parallela.computeOnerousSum(root);
		Long finalParallel = System.currentTimeMillis()-startParallel;
		/*Fine esecuzione parallella e inizio calcolo speedup*/
		speedup3 = (double)serialTime/(double)finalParallel;
		System.out.println("------Somma parallela: "+sumP);
		System.out.println("------Tempo Esecuzione parallela: "+finalParallel+"ms");
		System.out.println("------speedup test: "+speedup3);
		speedupeff+=speedup3;
		assertEquals(somma,sumP);
		
		
		
	}
	@Test
	public void test_BinarioCompletoProfondita14(){
		
		root=albero.alberoBinarioCompleto(14);
		numeroNodi=albero.contaNodi(root);
		System.out.println("Test Albero Binario Completo Profondità 14");
		System.out.println("------Numero Nodi: "+numeroNodi);
		/*Warmup esecuzione seriale*/
		BinaryTreeAdderImplement seriale = new BinaryTreeAdderImplement(singleExec);
		for(int i = 0; i<warmup; i++){
			seriale.computeOnerousSum(root);
		}
		/*Calcolo speedup esecuzione seriale*/
		Long startSerial = System.currentTimeMillis();
		somma  = seriale.computeOnerousSum(root);
		Long serialTime = System.currentTimeMillis() - startSerial;
		System.out.println("------Somma seriale nodi: "+somma);
		System.out.println("------Tempo Esecuzione seriale: "+serialTime+"ms");
		/*Fine esecuzione seriale*/
		/*Inizio esecuzione parallela*/
		BinaryTreeAdderCompletableFuture parallela = new BinaryTreeAdderCompletableFuture();
		for(int i = 0; i<warmup; i++){
			parallela.computeOnerousSum(root);
		}
		Long startParallel = System.currentTimeMillis();
		int sumP = parallela.computeOnerousSum(root);
		Long finalParallel = System.currentTimeMillis()-startParallel;
		/*Fine esecuzione parallella e inizio calcolo speedup*/
		speedup4 = (double)serialTime/(double)finalParallel;
		System.out.println("------Somma parallela: "+sumP);
		System.out.println("------Tempo Esecuzione parallela: "+finalParallel+"ms");
		System.out.println("------speedup test: "+speedup4);
		speedupeff+=speedup4;
		assertEquals(somma,sumP);
	
		
	}
	@Test
	public void test_BinarioCompletoProfondita15(){
		
		root=albero.alberoBinarioCompleto(15);
		numeroNodi=albero.contaNodi(root);
		System.out.println("Test Albero Binario Completo Profondità 15");
		System.out.println("------Numero Nodi: "+numeroNodi);
		/*Warmup esecuzione seriale*/
		BinaryTreeAdderImplement seriale = new BinaryTreeAdderImplement(singleExec);
		for(int i = 0; i<warmup; i++){
			seriale.computeOnerousSum(root);
		}
		/*Calcolo speedup esecuzione seriale*/
		Long startSerial = System.currentTimeMillis();
		somma  = seriale.computeOnerousSum(root);
		Long serialTime = System.currentTimeMillis() - startSerial;
		System.out.println("------Somma seriale nodi: "+somma);
		System.out.println("------Tempo Esecuzione seriale: "+serialTime+"ms");
		/*Fine esecuzione seriale*/
		/*Inizio esecuzione parallela*/
		BinaryTreeAdderCompletableFuture parallela = new BinaryTreeAdderCompletableFuture();
		for(int i = 0; i<warmup; i++){
			parallela.computeOnerousSum(root);
		}
		Long startParallel = System.currentTimeMillis();
		int sumP = parallela.computeOnerousSum(root);
		Long finalParallel = System.currentTimeMillis()-startParallel;
		/*Fine esecuzione parallella e inizio calcolo speedup*/
		speedup5 = (double)serialTime/(double)finalParallel;
		System.out.println("------Somma parallela: "+sumP);
		System.out.println("------Tempo Esecuzione parallela: "+finalParallel+"ms");
		System.out.println("------speedup test: "+speedup5);
		speedupeff+=speedup5;
		assertEquals(somma,sumP);
		speedupeff = speedupeff/5;
		System.out.println("Calcolo speedup effettivo");
		System.out.println("------speedup:"+speedupeff);
		assertTrue(speedupeff<(double)NCPU);		
		
		
	}
	
	

}
