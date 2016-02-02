package it.uniroma3.hwj.testes1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.hwj.base.Node;
import it.uniroma3.hwj.es1.BinaryTreeAdderImplement;
import it.uniroma3.hwj.support.AlberoBinario;



public class TestAlberoSbilanciatoSinistroEse1 {
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
		System.out.println("Init Suite Albero Binario Sbilanciato Sinistro Esercizio 1");
		albero = new AlberoBinario();
		warmup = 10;
		NCPU = Runtime.getRuntime().availableProcessors();
		speedup1 = new Long(0);
		speedup2 = new Long(0);
		speedup3 = new Long(0);
		singleExec = 1;
		somma = 0;
		root = null;
		numeroNodi=0;
		
	}
	
	@Test
	public void test_SbilanciatoSinistroProfondita09(){
		
		root=albero.alberoSbilanciatoSinistro(0, 9);
		numeroNodi=albero.contaNodi(root);
		System.out.println("Test Albero Sbilanciato Sinistro Profondita 9");
		System.out.println("------Numero Nodi: "+numeroNodi);
		System.out.println("------Numero Nodi Figlio Destro Radice: "+ albero.contaNodiFiglioDestroRadice(root));
		System.out.println("------Numero Nodi Figlio Sinistro Radice: "+ albero.contaNodiFiglioSinistroRadice(root));
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
		BinaryTreeAdderImplement parallela = new BinaryTreeAdderImplement(NCPU);
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
		//assertTrue(speedup1<(double)NCPU);
		assertTrue(albero.contaNodiFiglioSinistroRadice(root)>albero.contaNodiFiglioDestroRadice(root));

		
	}
	
	@Test
	public void test_SbilanciatoSinistroProfondita11(){
		
		root=albero.alberoSbilanciatoSinistro(0, 11);
		numeroNodi=albero.contaNodi(root);
		System.out.println("Test Albero Sbilanciato Sinistro Profondita 11");
		System.out.println("------Numero Nodi: "+numeroNodi);
		System.out.println("------Numero Nodi Figlio Destro Radice: "+ albero.contaNodiFiglioDestroRadice(root));
		System.out.println("------Numero Nodi Figlio Sinistro Radice: "+ albero.contaNodiFiglioSinistroRadice(root));
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
		BinaryTreeAdderImplement parallela = new BinaryTreeAdderImplement(NCPU);
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
		//assertTrue(speedup2<(double)NCPU);
		assertTrue(albero.contaNodiFiglioSinistroRadice(root)>albero.contaNodiFiglioDestroRadice(root));

		
	}
	
	@Test
	public void test_SbilanciatoSinistroProfondita13(){
		
		root=albero.alberoSbilanciatoSinistro(0, 13);
		numeroNodi=albero.contaNodi(root);
		System.out.println("Test Albero Sbilanciato Sinistro Profondita 13");
		System.out.println("------Numero Nodi: "+numeroNodi);
		System.out.println("------Numero Nodi Figlio Destro Radice: "+ albero.contaNodiFiglioDestroRadice(root));
		System.out.println("------Numero Nodi Figlio Sinistro Radice: "+ albero.contaNodiFiglioSinistroRadice(root));
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
		BinaryTreeAdderImplement parallela = new BinaryTreeAdderImplement(NCPU);
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
		/*speedupeff = speedupeff/3;
		System.out.println("Calcolo speedup effettivo");
		System.out.println("------speedup:"+speedupeff);
		assertTrue(speedupeff<(double)NCPU);*/
		
		assertEquals(somma,sumP);
		//assertTrue(speedup3<(double)NCPU);
		assertTrue(albero.contaNodiFiglioSinistroRadice(root)>albero.contaNodiFiglioDestroRadice(root));
		
		
	}
	
	@Test
	public void test_SbilanciatoSinistroProfondita14(){
		
		root=albero.alberoSbilanciatoSinistro(0, 14);
		numeroNodi=albero.contaNodi(root);
		System.out.println("Test Albero Sbilanciato Sinistro Profondita 14");
		System.out.println("------Numero Nodi: "+numeroNodi);
		System.out.println("------Numero Nodi Figlio Destro Radice: "+ albero.contaNodiFiglioDestroRadice(root));
		System.out.println("------Numero Nodi Figlio Sinistro Radice: "+ albero.contaNodiFiglioSinistroRadice(root));
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
		BinaryTreeAdderImplement parallela = new BinaryTreeAdderImplement(NCPU);
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
		//assertTrue(speedup3<(double)NCPU);
		assertTrue(albero.contaNodiFiglioSinistroRadice(root)>albero.contaNodiFiglioDestroRadice(root));
		
		
	}
	
	@Test
	public void test_SbilanciatoSinistroProfondita15(){
		
		root=albero.alberoSbilanciatoSinistro(0, 15);
		numeroNodi=albero.contaNodi(root);
		System.out.println("Test Albero Sbilanciato Sinistro Profondita 15");
		System.out.println("------Numero Nodi: "+numeroNodi);
		System.out.println("------Numero Nodi Figlio Destro Radice: "+ albero.contaNodiFiglioDestroRadice(root));
		System.out.println("------Numero Nodi Figlio Sinistro Radice: "+ albero.contaNodiFiglioSinistroRadice(root));
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
		BinaryTreeAdderImplement parallela = new BinaryTreeAdderImplement(NCPU);
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
		speedupeff = speedupeff/5;
		System.out.println("Calcolo speedup effettivo");
		System.out.println("------speedup:"+speedupeff);
		assertTrue(speedupeff<(double)NCPU);
		
		assertEquals(somma,sumP);
		//assertTrue(speedup3<(double)NCPU);
		assertTrue(albero.contaNodiFiglioSinistroRadice(root)>albero.contaNodiFiglioDestroRadice(root));
		
		
	}


	
	

	

}
