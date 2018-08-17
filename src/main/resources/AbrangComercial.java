
package pageController;

import core.BaseTest;
import core.MsgConfig;
import core.BasePage;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import data.PegaLinhaExcel;
import page.*;

/**
 *
 * @author eduardo.lana
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AbrangComercial extends BaseTest {

	public AbrangComercialPage AbrangComercialPage = new AbrangComercialPage();
	public BasePage basepage = new BasePage();
	public PegaLinhaExcel excel = new PegaLinhaExcel();
	public Login Login = new Login();
	MsgConfig config = new MsgConfig();
	
	String telaabrangcomercial = "//*[@id=\"sidebar\"]/ul/li[4]/a/span";
	String botaoincluir = "btnIncluir";
	String botaoaprovar = "btnAprovar";
	String botaocancelar = "btnCancelar";
	String campocodvenda = "txtCodVenda";
	String botaoexcluir = "btnExcluir";
	String consultar = "btnPesquisar";
	String linhagrid = "//*[@id=\"tbAbrangencia\"]/tbody/tr[1]/td[13]/input";
	String confirmar = "/ html / body / div[6] / div[3] / div / button[1]";
	String mensagemresultado = "/ html / body / div[6] / div[2]";
	String abrangencia = "//*[@id=\"arvoreEstrutura\"]/ul/li/span/span[2]";
	String Aprovado = "1";
	String cicloiniciocomercial = "//*[@id=\"cicloInicio\"]"; 
	String ciclofimcomercial =  "//*[@id=\"cicloTermino\"]";

	String[] linhaplanilha = new String[12];
	
	PegaLinhaExcel linha = new PegaLinhaExcel();
	
	 public static void main(String[] args){};

	 @Test
	public void InserirAbrang()  {
		 
		String telaerro = "/ html / body / div[8]";
		
		String acao = "inserir";

		String teste = "Aprovado";

		String metodo = "Inserir Abrangencia Comercial";

		String validacao = config.Msg("MsgInclui");

		linhaplanilha = linha.Pegalinha(teste);
                
                
                try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		
		}

		AbrangComercialPage.AguardaXPath(telaabrangcomercial);

		AbrangComercialPage.MenuAbrangComercial(telaabrangcomercial);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
		}

		AbrangComercialPage.acao(botaoincluir);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		
		}

		
		AbrangComercialPage.AguardaId("codigoVendaProduto");

		AbrangComercialPage.InserirCodVenda("codigoVendaProduto", linhaplanilha[1]);
		
		AbrangComercialPage.AguardaXPath(abrangencia);
		
		AbrangComercialPage.SelecionarAbrang(abrangencia);
		
		AbrangComercialPage.InsereCiclo("cicloInicioIncluir", linhaplanilha[3]);

		AbrangComercialPage.AlterarOuSalvar("btnSalvar");

		AbrangComercialPage.AguardaXPath(mensagemresultado);
		
		AbrangComercialPage.ValidaTextoMensagem(telaerro, mensagemresultado, validacao, metodo);

	}
	
	

	@Test
	public void AprovarRascunhoAbrang() {
		
		String telaerro = "/ html / body / div[6] /div[2]";
		
		
		String acao = "aprovar";

		String teste = "Rascunho";

		String metodo = "Aprovar Abrangência Comercial";

		String validacao = config.Msg("MsgAprova");

		linhaplanilha = linha.Pegalinha(teste);

		AprovaCancelaouExclui(linhaplanilha[2], linhaplanilha[1], botaoaprovar, validacao, metodo, acao , telaerro );

	}

	@Test
	public void CancelarAbrang() {
		
		String telaerro = "/html/body/div[6]/div[2]";
		
		String acao = "cancelar";

		String teste = "Aprovado";

		String metodo = "Cancelar Abrangência Comercial";

		String validacao = config.Msg("MsgCancel");

		linhaplanilha = linha.Pegalinha(teste);

		AprovaCancelaouExclui(linhaplanilha[2], linhaplanilha[1], botaocancelar, validacao, metodo, acao ,telaerro );
	}

	@Test
	public void SalvarAbrang()  {
		
		String telaerro = "/ html / body / div[8]";
		
		
		String acao = "salvar";

		String teste = "Rascunho";

		String metodo = "Alterar ciclo final e salvar Abrangencia Comercial";

		String validacao = config.Msg("MsgInclui");

		linhaplanilha = linha.Pegalinha(teste);
		
		AbrangComercialPage.AguardaXPath(telaabrangcomercial);

		AbrangComercialPage.MenuAbrangComercial(telaabrangcomercial);


		AbrangComercialPage.InserirCodVenda("txtCodVenda", linhaplanilha[1]);
		
		AbrangComercialPage.statusTodos("statusTodos");

		AbrangComercialPage.SelecionaStatus(linhaplanilha[2]);

		AbrangComercialPage.ConsultarAbrangencia(consultar);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		
		}

		AbrangComercialPage.SelecionaAbrangencia("//*[@id=\"tbAbrangencia\"]/tbody/tr[1]/td[12]/a", acao, metodo);
          
		AbrangComercialPage.AguardaId("btnAlterar");
		
		AbrangComercialPage.AlterarOuSalvar("btnAlterar");
		
		AbrangComercialPage.AguardaId("cicloInicio");
		
		AbrangComercialPage.InsereCiclo("cicloInicio", linhaplanilha[3]);

		AbrangComercialPage.AguardaId("cicloTermino");
		
		AbrangComercialPage.InsereCiclo("cicloTermino", linhaplanilha[4]);
		
		AbrangComercialPage.AguardaId("btnSalvar");
		
		AbrangComercialPage.AlterarOuSalvar("btnSalvar");

		AbrangComercialPage.AguardaXPath(mensagemresultado);

		AbrangComercialPage.ValidaTextoMensagem(telaerro, mensagemresultado, validacao, metodo);
	}

	@Test
	public void ExcluiRascunhoAbrang()  {
		
		String telaerro = "/html/body/div[7]";
		
		String acao = "excluir";

		String teste = "Rascunho";

		String metodo = "Excluir Rascunho Abrangência Comercial ";

		String validacao = config.Msg("MsgExclui");

		linhaplanilha = linha.Pegalinha(teste);

		AprovaCancelaouExclui(linhaplanilha[2], linhaplanilha[1], botaoexcluir, validacao, teste, acao ,telaerro );

	}

	public void AprovaCancelaouExclui(String status, String codvenda, String botao, String texto, String teste, String acao , String telaerro ) {
		
		
		AbrangComercialPage.AguardaXPath(telaabrangcomercial);

		AbrangComercialPage.MenuAbrangComercial(telaabrangcomercial);

		AbrangComercialPage.AguardaId(campocodvenda);
		
		AbrangComercialPage.InserirCodVenda(campocodvenda, codvenda);

		if (!Aprovado.equals(status)) {
			AbrangComercialPage.SelecionaStatus(Aprovado);
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				
			}
			AbrangComercialPage.SelecionaStatus(status);
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

		AbrangComercialPage.ConsultarAbrangencia(consultar);

		AbrangComercialPage.AguardaXPath(linhagrid);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
		
		AbrangComercialPage.SelecionaAbrangencia(linhagrid, acao, teste);
	
		
		AbrangComercialPage.AguardaId(botao);
		
		AbrangComercialPage.acao(botao);
		
		AbrangComercialPage.AguardaXPath(confirmar);

		AbrangComercialPage.Confirma(confirmar);
		
		AbrangComercialPage.AguardaXPath(mensagemresultado);

		AbrangComercialPage.ValidaTextoMensagem(telaerro, mensagemresultado, texto, teste);
		
	}
}
