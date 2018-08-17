/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page;

import core.BasePage;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;

/**
 *
 * @author eduardo.lana
 */
public class AbrangenciaLogisticaPage extends BasePage {

	public void MenuAbrangLog(String texto) {
		acao(By.xpath(texto));
	}
	
	public void StatusTodos(String texto) {
		checked(By.id(texto));
	}

	public void Incluir(String texto) {
		acao(By.id(texto));
	}

	public void InserirCodVenda(String texto, String codvenda) {
		Aguardaid(texto);
		Escrever(By.id(texto), codvenda);
	}

	public void SelecionarAbrangLog(String texto) {
		acao(By.xpath(texto));
	}

	public void InsereCiclo(String texto, String ciclo) {
		
		try {
			acao(By.id(texto));
			Thread.sleep(2000);
                        SelectValue(By.id(texto), ciclo);
                        Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	public void Aguardaid(String texto) {
		EsperaCarregamento(By.id(texto));
	}

	public void Aguardaxpath(String texto) {
		EsperaCarregamento(By.xpath(texto));
	}

	public void ValidaTextoMensagem(String telaerro, String Texto, String Texto1, String teste) {

		ValidaMensagemPopup(By.xpath(telaerro), By.xpath(Texto), Texto1, teste);

	}

	public void SelecionaStatus(String status) {
		Status(By.xpath("//input[@name='statusAprovacao'and @value='" + status + "']"));

	}
	public void SelecionaStatusLog(String status) {
		Status(By.xpath("//input[@name='statusAprovacaoProdutoAbrangencia' and  @value='" + status + "']"));

	}
	

	public void ConsultarAbrangenciaLog(String Texto) {
		acao(By.id(Texto));

	}

	public void SelecionaAbrangencia(String Texto) {
		SelecionaGridComercial(By.xpath(Texto));

	}

	public void SelecionaAbrangenciaLog(String Texto, String acao, String teste) {
		SelecionaGrid(By.xpath(Texto), acao, teste);

	}

	public void Aprovar(String Texto) {
		acao(By.id(Texto));

	}

	public void ConfirmaCancela(String Texto) {
		acao(By.xpath(Texto));

	}

	public void SelecionaMaterial(String Texto) {

		acao(By.xpath(Texto));

	}

	public void AlterarOuSalvar(String texto) {

		acao(By.id(texto));
	}

	public void acao(String texto) {

		acao(By.id(texto));
	}

	public void SelecionaMaterial(String texto, String material) {

		
		try {
			Thread.sleep(2000);
			acao(By.id(texto));
			Thread.sleep(2000);
                        SelectValue(By.id(texto), material);
			
		} catch (InterruptedException ex) {
			Logger.getLogger(AbrangenciaLogisticaPage.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}

	public void InserePrioridade(String texto, String prioridade) {

		Escrever(By.id(texto), prioridade);
	}
	public String ObtercicloComercial(String texto) {
		
		return ObtemCiclo(By.xpath(texto));
	};
        public void TakescreenShot(String texto) {
		 testScreenshot(texto);
		
	}
}
