package page;

import core.BasePage;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;

/**
 *
 * @author eduardo.lana
 */
public class AbrangComercialPage extends BasePage {

	public void MenuAbrangComercial(String texto) {

		acao(By.xpath(texto));
	}

	public void Incluir(String texto) {
		acao(By.id(texto));
	}

	public void InserirCodVenda(String texto, String codvenda) {
		AguardaId(texto);
		Escrever(By.id(texto), codvenda);
	}

	public void SelecionarAbrang(String texto) {
		checked(By.xpath(texto));
	}

	public void InsereCiclo(String texto, String ciclo) {
		
		try {
			Thread.sleep(1000);
			acao(By.id(texto));
			Thread.sleep(2000);
			
		} catch (InterruptedException ex) {
			Logger.getLogger(AbrangComercialPage.class.getName()).log(Level.SEVERE, null, ex);
		}
		SelectValue(By.id(texto), ciclo);
		
	}

	public void AguardaId(String texto) {
		EsperaCarregamento(By.id(texto));
	}

	public void AguardaXPath(String texto) {
		EsperaCarregamento(By.xpath(texto));
	}

	public void ValidaTextoMensagem(String telaerro, String Texto, String Texto1, String teste) {
		
		ValidaMensagemPopupComercial(By.xpath(telaerro), By.xpath(Texto), Texto1, teste);

	}

	public void SelecionaStatus(String status) {
		Status(By.xpath("//input[@name='statusAprovacao'and @value='" + status + "']"));

	}
	
	public void ConsultarAbrangencia(String Texto) {
		acao(By.id(Texto));

	}

	public void SelecionaAbrangencia(String Texto, String acao, String teste) {
		SelecionaGrid(By.xpath(Texto), acao, teste);

	}

	public void Aprovar(String Texto) {
		acao(By.id(Texto));

	}

	public void Confirma(String Texto) {
		acao(By.xpath(Texto));

	}

	public void Cancelar(String Texto) {
		acao(By.xpath(Texto));

	}

	public void AlterarOuSalvar(String texto) {
		acao(By.id(texto));
	}

	public void acao(String texto) {
		acao(By.id(texto));
	}
	public void statusTodos(String texto) {
		 acao(By.id(texto));
	}
	public String ObtercicloComercial(String texto) {
		return ObtemCicloComercial(By.tagName(texto));
		
	}
	

}
