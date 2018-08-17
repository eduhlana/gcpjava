/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageController;

import core.*;
import data.PegaLinhaExcel;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import page.AbrangenciaLogisticaPage;;

/**
 *
 * @author eduardo.lana
 */
public class AbrangenciaLogistica extends BaseTest {
    private AbrangenciaLogisticaPage AbrangLogisticaPage = new AbrangenciaLogisticaPage();
    private MsgConfig config = new MsgConfig();
    private BasePage basepage = new BasePage();
    private PegaLinhaExcel linha = new PegaLinhaExcel();
    
    String telaabranglogistica = "//*[@id=\"sidebar\"]/ul/li[5]/a";
    String botaoincluir = "btnIncluir";
    String botaoaprovar = "btnAprovar";
    String botaocancelar = "btnCancelar";
    String campocodvenda = "txtCodVenda";
    String botaoexcluir = "btnExcluir";
    String consultar = "btnPesquisar";
    String confirmar = "/ html / body / div[6] / div[3] / div / button[1]";
    String telaerro = "/ html / body / div[8]";
    String mensagemresultado = "/ html / body / div[6] / div[2]";
    String abrangencia = "//*[@id=\"arvoreEstrutura\"]/ul/li/span/span[2]";
    String gridcomercial = "//*[@id=\"tbAbrangencia\"]/tbody/tr[1]/td[2]";
    String gridlogistica = "//*[@id=\"tbProdutoAbrangencia\"]/div[1]/div[2]/div[2]/table/tbody/tr/td[4]/input";
    String material = "//*[@id=\"codigoProduto\"]";
    String Aprovado = "1";
    String campomaterial = "codigoProduto";
    String campoprioridade = "nmPrioridade";
    String campocicloinicial = "nmCicloInicio";
    String campociclofinal = "nmCicloTermino";
    String lupaalterar = "//*[@id=\"tbProdutoAbrangencia\"]/div[1]/div[2]/div[2]/table/tbody/tr/td[3]/a";
    String linhamaterial = "//*[@id=\"tbProdutoAbrangenciaItem\"]/tbody/tr[1]/td[8]/input"; 
    String statuslog = "//*[@id=\"pesquisarForm\"]/div[5]/div[1]/div[1]/div[2]/div[1]/label/input";
    String cicloinicomercialincl = "//*[@id=\"incluirForm\"]/div[2]/div[4]/div[1]/div/div[3]/div/label[2]";
    String ciclofimcomercialincl = "//*[@id=\"incluirForm\"]/div[2]/div[4]/div[1]/div/div[4]/div/label[2]";
    String cicloinicomercialialt = "//*[@id=\"alterarForm\"]/div[2]/div[4]/div[1]/div/div[3]/div/label[2]";
    String ciclofimcomercialialt = "//*[@id=\"alterarForm\"]/div[2]/div[4]/div[1]/div/div[4]/div/label[2]";
    String botaoAlterar = "btnAlterar";
    String logistica = "//*[@id=\"tbProdutoAbrangenciaItem\"]/tbody/tr/td[4]";
    
    String[] linhaplanilha = new String[12];
	
 public static void main(String[] args){};
 
 
 public void InserirAbrangLog()
        {

	 
            String teste = "Aprovado";

            String metodo = "Inserir Abrangencia Logistica";

            String validacao = config.Msg("MsgInclui");
            
            linhaplanilha = linha.Pegalinha(teste);

            AbrangLogisticaPage.Aguardaxpath(telaabranglogistica);

            AbrangLogisticaPage.MenuAbrangLog(telaabranglogistica);

            AbrangLogisticaPage.Aguardaid(campocodvenda);

            AbrangLogisticaPage.InserirCodVenda(campocodvenda, linhaplanilha[1]);
            
            AbrangLogisticaPage.Aguardaid("statusTodos");
            
            AbrangLogisticaPage.StatusTodos("statusTodos");

            AbrangLogisticaPage.ConsultarAbrangenciaLog(consultar);

            AbrangLogisticaPage.Aguardaxpath(gridcomercial);

            AbrangLogisticaPage.SelecionaAbrangencia(gridcomercial);

            AbrangLogisticaPage.Aguardaxpath(lupaalterar);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AbrangenciaLogistica.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            AbrangLogisticaPage.Incluir(botaoincluir);
            
            AbrangLogisticaPage.Aguardaxpath("//*[@id=\"incluirForm\"]/div[2]/div[4]/div[1]/div/div[1]/div/label[2]");
            
            String material = linhaplanilha[5].replace(".","");
            		
            AbrangLogisticaPage.SelecionaMaterial(campomaterial , material);

            AbrangLogisticaPage.InserePrioridade(campoprioridade, linhaplanilha[6]);
            
            String cicloini = AbrangLogisticaPage.ObtercicloComercial(cicloinicomercialincl);

            AbrangLogisticaPage.InsereCiclo(campocicloinicial , cicloini);
            
            String ciclofim = AbrangLogisticaPage.ObtercicloComercial(ciclofimcomercialincl);
            
            if (!"".equals(ciclofim)) {
            
            	AbrangLogisticaPage.InsereCiclo(campociclofinal , ciclofim);
            }

            AbrangLogisticaPage.Incluir("btnAddSessionItem");

	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException ex) {
	            Logger.getLogger(AbrangenciaLogistica.class.getName()).log(Level.SEVERE, null, ex);
	        }
                
           AbrangLogisticaPage.Aguardaxpath("//*[@id=\"tbProdutoAbrangenciaItem\"]/tbody/tr/td[8]/input");
           
            AbrangLogisticaPage.AlterarOuSalvar("btnSalvar");
          

            AbrangLogisticaPage.Aguardaxpath(mensagemresultado);
            
            AbrangLogisticaPage.ValidaTextoMensagem(telaerro, mensagemresultado,  validacao, metodo);
         
        }
     
 
 
 
 
 
        public void AprovarRascunhoAbrangLog()
        {

            String teste = "Rascunho";

            String acao = "aprovar";

            String metodo = "Aprovar Abrangência Logística";

            String validacao = config.Msg("MsgAprovaLog");

            linhaplanilha = linha.Pegalinha(teste);

      
           Acao(linhaplanilha[2], linhaplanilha[1], botaoaprovar, validacao, metodo , acao );


        }
   

        public void CancelarAbrangLog()
        {
            String teste = "Aprovado";

            String metodo = "Cancelar Abrangência Logistica";

            String acao = "cancelar";

            String validacao = config.Msg("MsgCancelLog");

            linhaplanilha = linha.Pegalinha(teste);


            Acao(linhaplanilha[2], linhaplanilha[1], botaocancelar, validacao, metodo , acao );
        }


        public void SalvarAbrangLog()
        {
            String teste = "Encerrado";

            String metodo = "Alterar e salvar Abrangência Logística";

            String validacao = config.Msg("MsgInclui");
            
            linhaplanilha = linha.Pegalinha(teste);
            
            AbrangLogisticaPage.Aguardaxpath(telaabranglogistica);
            
            AbrangLogisticaPage.MenuAbrangLog(telaabranglogistica);

            AbrangLogisticaPage.InserirCodVenda(campocodvenda, linhaplanilha[1]);
         
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AbrangenciaLogistica.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            AbrangLogisticaPage.InsereCiclo("cicloInicioPesquisa" , linhaplanilha[3]);
            
            AbrangLogisticaPage.StatusTodos("statusTodos");
            
            
            AbrangLogisticaPage.Aguardaid(consultar);

            AbrangLogisticaPage.ConsultarAbrangenciaLog(consultar);

            AbrangLogisticaPage.Aguardaxpath(gridcomercial);

            AbrangLogisticaPage.SelecionaAbrangencia(gridcomercial);
            
            AbrangLogisticaPage.Aguardaxpath(lupaalterar);

            AbrangLogisticaPage.SelecionaAbrangencia(lupaalterar);

             try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AbrangenciaLogistica.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            AbrangLogisticaPage.Aguardaid(botaoAlterar);
             
            AbrangLogisticaPage.AlterarOuSalvar(botaoAlterar);
            

            AbrangLogisticaPage.Aguardaid(campociclofinal);
            
            AbrangLogisticaPage.Aguardaxpath(linhamaterial);

            AbrangLogisticaPage.SelecionaMaterial(linhamaterial);

            AbrangLogisticaPage.acao("btnRemoveSessionItems");
            
            String materiall = linhaplanilha[5].replace(".","");
            
            AbrangLogisticaPage.Aguardaid(campomaterial);
            
            AbrangLogisticaPage.SelecionaMaterial(campomaterial, materiall);

            AbrangLogisticaPage.InserePrioridade(campoprioridade,linhaplanilha[6]);
            
            String cicloini = AbrangLogisticaPage.ObtercicloComercial(cicloinicomercialialt);

            AbrangLogisticaPage.InsereCiclo(campocicloinicial ,cicloini);
            
            
            String ciclofim = AbrangLogisticaPage.ObtercicloComercial(ciclofimcomercialialt);
            
            if (!"".equals(ciclofim)) {
                
            	AbrangLogisticaPage.InsereCiclo(campociclofinal , ciclofim);
            }     

            AbrangLogisticaPage.acao("btnAddSessionItem");

            
               try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AbrangenciaLogistica.class.getName()).log(Level.SEVERE, null, ex);
            }

            AbrangLogisticaPage.acao("btnSalvar");

            AbrangLogisticaPage.Aguardaxpath(mensagemresultado);

            AbrangLogisticaPage.ValidaTextoMensagem(telaerro, mensagemresultado, validacao, metodo);
        }

 

        public void ExcluiRascunhoLog()
        {
            String teste = "Rascunho";

            String metodo = "Excluir Rascunho Abrangencia Logistica ";

            String acao = "excluir";

            String validacao = config.Msg("MsgExclui");

            linhaplanilha = linha.Pegalinha(teste);

            Acao(linhaplanilha[2], linhaplanilha[1], botaoexcluir, validacao, metodo , acao );
        }

 
        public void Acao(String status, String codvenda, String botao, String Validacao, String teste , String acao )
        {

            AbrangLogisticaPage.Aguardaxpath(telaabranglogistica);

            AbrangLogisticaPage.MenuAbrangLog(telaabranglogistica);

            AbrangLogisticaPage.Aguardaid(campocodvenda);


            AbrangLogisticaPage.InserirCodVenda(campocodvenda, codvenda);
            
            if (!Aprovado.equals(status)) {
            	AbrangLogisticaPage.SelecionaStatusLog(Aprovado);
                
            	 try {
     				Thread.sleep(1000);
                                AbrangLogisticaPage.SelecionaStatusLog(status);
     			} catch (InterruptedException e) {
                        // TODO Auto-generated catch block
     			}
            	
    		}
            
         
             try {
                    Thread.sleep(800);
                        AbrangLogisticaPage.ConsultarAbrangenciaLog(consultar);
     		} catch (InterruptedException e) {
                       
     		}
            	
    		

            
            try {
                    Thread.sleep(3000);
		} catch (InterruptedException e) {
				
		}

            AbrangLogisticaPage.Aguardaxpath(gridcomercial);

            AbrangLogisticaPage.SelecionaAbrangencia(gridcomercial);
            
            
            AbrangLogisticaPage.Aguardaxpath(gridlogistica);
            
            AbrangLogisticaPage.SelecionaAbrangenciaLog(gridlogistica , acao , teste);

            
            AbrangLogisticaPage.acao(botao);

            AbrangLogisticaPage.Aguardaxpath(confirmar);

            AbrangLogisticaPage.ConfirmaCancela(confirmar);


//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(AbrangenciaLogistica.class.getName()).log(Level.SEVERE, null, ex);
//        }
            AbrangLogisticaPage.Aguardaxpath(mensagemresultado);

            AbrangLogisticaPage.ValidaTextoMensagem(telaerro, mensagemresultado, Validacao, teste);

        }

    }
