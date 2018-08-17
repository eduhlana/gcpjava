package pageController;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import core.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Regressao extends BaseTest {
	
	public  AbrangComercial AbComercial = new AbrangComercial();
	public  AbrangenciaLogistica AbLogistica = new AbrangenciaLogistica();
	public  Preco Preco = new Preco();

	
	@Test
	public  void AAInserirAbrang() {

		AbComercial.InserirAbrang();
	}
	@Test
	public  void BAprovarRascunhoAbrang() {

		AbComercial.AprovarRascunhoAbrang();
	}
	@Test
	public  void CancelarAbrangLog() {

		AbLogistica.CancelarAbrangLog();
	}
	@Test
	public   void _03InserirAbrangLog() {

		AbLogistica.InserirAbrangLog();
	}
	@Test
	public   void _05AprovarRascunhoAbrangLog() {

		AbLogistica.AprovarRascunhoAbrangLog();
	}
	@Test
	public   void _06SalvarAbrangLog() {

		AbLogistica.SalvarAbrangLog();
	}
	@Test
	public   void _07ExcluiRascunhoLog() {

		AbLogistica.ExcluiRascunhoLog();
	}				
			
	@Test
	public   void _08InserirPreco() {


		Preco.InserirPreco();
	}
	@Test
	public   void _12CancelarPreco() {

		Preco.CancelarPreco();
	}
	@Test		
	public   void _09AprovarPreco() {


		Preco.AprovarPreco();
	}		
	@Test	
	public  void _12SalvarPreco() {


		Preco.SalvarPreco();
	}

	@Test	
	public   void _13ExcluiPreco() {

		Preco.ExcluiPreco();
	}		
			
	@Test	
	public   void _16cancelarAbrang() {


		AbComercial.CancelarAbrang();
	}	
	@Test	
	public  void _15SalvarAbrang() {


		AbComercial.SalvarAbrang();
	}
		
	@Test	
	public void _16ExcluiRascunhoAbrang() {


		AbComercial.ExcluiRascunhoAbrang();
	}
	public static  void main(String[] args) {
		
		org.junit.runner.JUnitCore.main("Regrassao.java");
	};	
	
}
