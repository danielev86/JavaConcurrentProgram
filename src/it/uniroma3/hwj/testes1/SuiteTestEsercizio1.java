package it.uniroma3.hwj.testes1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*@RunWith(Suite.class)
@SuiteClasses({
	TestAlberoBinarioCompletoEse1.class,
	TestAlberoSbilanciatoSinistroEse1.class
})*/
public class SuiteTestEsercizio1 {
	public static void main(String[] args){
		org.junit.runner.JUnitCore.main("it.uniroma3.hwj.testes1.TestAlberoBinarioCompletoEse1"
				, "it.uniroma3.hwj.testes1.TestAlberoSbilanciatoDestroEse1"
				,"it.uniroma3.hwj.testes1.TestAlberoSbilanciatoSinistroEse1");


		
	}
}
