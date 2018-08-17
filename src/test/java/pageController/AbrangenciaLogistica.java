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
 
 
 public void InserirAbrangLog()
        {

	 
            String teste = "Aprovado";

            String metodo = "Inserir Abrangencia Logistica";

            String validacao = config.Msg("MsgInclui");
            
            linhaplanilha = linha.Pegalinha(teste);

            AbrangLogisticaPage.Aguardaxpath(telaabranglogistica);

            AbrangLogisticaPage.MenuAbrangLog(telaabranglogistica);
            
            AbrangLogisticaPage.TakescreenShot(metodo);

            AbrangLogisticaPage.Aguardaid(campocodvenda);

            AbrangLogisticaPage.InserirCodVenda(campocodvenda, linhaplanilha[1]);
            
            AbrangLogisticaPage.TakescreenShot(metodo);
            
            AbrangLogisticaPage.Aguardaid("statusTodos");
            
            AbrangLogisticaPage.StatusTodos("statusTodos");
            
            AbrangLogisticaPage.TakescreenShot(metodo);

            AbrangLogisticaPage.ConsultarAbrangenciaLog(consultar);
            
            AbrangLogisticaPage.TakescreenShot(metodo);

            AbrangLogisticaPage.Aguardaxpath(gridcomercial);

            AbrangLogisticaPage.SelecionaAbrangencia(gridcomercial);
            
            AbrangLogisticaPage.TakescreenShot(metodo);

            AbrangLogisticaPage.Aguardaxpath(lupaalterar);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AbrangenciaLogistica.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            AbrangLogisticaPage.Incluir(botaoincluir);
            
            AbrangLogisticaPage.TakescreenShot(metodo);
            
            AbrangLogisticaPage.Aguardaxpath("//*[@id=\"incluirForm\"]/div[2]/div[4]/div[1]/div/div[1]/div/label[2]");
            
            String material = linhaplanilha[5].replace(".","");
            		
            AbrangLogisticaPage.SelecionaMaterial(campomaterial , material);
            
            AbrangLogisticaPage.TakescreenShot(metodo);

            AbrangLogisticaPage.InserePrioridade(campoprioridade, linhaplanilha[6]);
            
            AbrangLogisticaPage.TakescreenShot(metodo);
            
            String cicloini = AbrangLogisticaPage.ObtercicloComercial(cicloinicomercialincl);
            

            AbrangLogisticaPage.InsereCiclo(campocicloinicial , cicloini);
            
            AbrangLogisticaPage.TakescreenShot(metodo);
            
            String ciclofim = AbrangLogisticaPage.ObtercicloComercial(ciclofimcomercialincl);
            
            if (!"".equals(ciclofim)) {
            
            	AbrangLogisticaPage.InsereCiclo(campociclofinal , ciclofim);
            	
            	AbrangLogisticaPage.TakescreenShot(metodo);
            }

            AbrangLogisticaPage.Incluir("btnAddSessionItem");
            
            AbrangLogisticaPage.TakescreenShot(metodo);

	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException ex) {
	            Logger.getLogger(AbrangenciaLogistica.class.getName()).log(Level.SEVERE, null, ex);
	        }
                
           AbrangLogisticaPage.Aguardaxpath("//*[@id=\"tbProdutoAbrangenciaItem\"]/tbody/tr/td[8]/input");
           
            AbrangLogisticaPage.AlterarOuSalvar("btnSalvar");
            
            AbrangLogisticaPage.TakescreenShot(metodo);
          

            AbrangLogisticaPage.Aguardaxpath(mensagemresultado);
            
            AbrangLogisticaPage.TakescreenShot(metodo);
            
            AbrangLogisticaPage.ValidaTextoMensagem(telaerro, mensagemresultado,  validacao, metodo);
         
        }
     
 
 
 
 
 
        public void AprovarRascunhoAbrangLog()
        {

            String teste = "Rascunho";

            String acao = "aprovar";

            String metodo = "Aprovar Abrangência Logística";

            String validacao = config.Msg("MsgAprovaLog");

            linhaplanilha = linha.Pegalinha(teste);

      
           Acao(linhaplanilha[2], linhaplanilha[1], botaoaprovar, validacao, metodo , acao ,metodo );


        }
   

        public void CancelarAbrangLog()
        {
            String teste = "Aprovado";

            String metodo = "Cancelar Abrangência Logistica";

            String acao = "cancelar";

            String validacao = config.Msg("MsgCancelLog");

            linhaplanilha = linha.Pegalinha(teste);


            Acao(linhaplanilha[2], linhaplanilha[1], botaocancelar, validacao, metodo , acao ,metodo);
        }


        public void SalvarAbrangLog()
        {
            String teste = "Encerrado";

            String metodo = "Alterar e salvar Abrangência Logística";

            String validacao = config.Msg("MsgInclui");
            
            linhaplanilha = linha.Pegalinha(teste);
            
            AbrangLogisticaPage.Aguardaxpath(telaabranglogistica);
            
            AbrangLogisticaPage.MenuAbrangLog(telaabranglogistica);
            
            AbrangLogisticaPage.TakescreenShot(metodo);

            AbrangLogisticaPage.InserirCodVenda(campocodvenda, linhaplanilha[1]);
         
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AbrangenciaLogistica.class.getName()).log(Level.SEVERE, null, ex);
            }

            AbrangLogisticaPage.TakescreenShot(metodo);
            
            
            AbrangLogisticaPage.InsereCiclo("cicloInicioPesquisa" , linhaplanilha[3]);
            
            AbrangLogisticaPage.TakescreenShot(metodo);
            
            AbrangLogisticaPage.StatusTodos("statusTodos");
            
            AbrangLogisticaPage.TakescreenShot(metodo);
            
            
            AbrangLogisticaPage.Aguardaid(consultar);

            AbrangLogisticaPage.ConsultarAbrangenciaLog(consultar);
            
            AbrangLogisticaPage.TakescreenShot(metodo);

            AbrangLogisticaPage.Aguardaxpath(gridcomercial);

            AbrangLogisticaPage.SelecionaAbrangencia(gridcomercial);
            
            AbrangLogisticaPage.TakescreenShot(metodo);
            
            AbrangLogisticaPage.Aguardaxpath(lupaalterar);

            AbrangLogisticaPage.SelecionaAbrangencia(lupaalterar);
            
            AbrangLogisticaPage.TakescreenShot(metodo);

             try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AbrangenciaLogistica.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            AbrangLogisticaPage.Aguardaid(botaoAlterar);
             
            AbrangLogisticaPage.AlterarOuSalvar(botaoAlterar);
            
            AbrangLogisticaPage.TakescreenShot(metodo);
            

            AbrangLogisticaPage.Aguardaid(campociclofinal);
            
            AbrangLogisticaPage.Aguardaxpath(linhamaterial);

            AbrangLogisticaPage.SelecionaMaterial(linhamaterial);
            
            AbrangLogisticaPage.TakescreenShot(metodo);

            AbrangLogisticaPage.acao("btnRemoveSessionItems");
            
            AbrangLogisticaPage.TakescreenShot(metodo);
            
            String materiall = linhaplanilha[5].replace(".","");
            
            AbrangLogisticaPage.Aguardaid(campomaterial);
            
            AbrangLogisticaPage.SelecionaMaterial(campomaterial, materiall);
            
            AbrangLogisticaPage.TakescreenShot(metodo);

            AbrangLogisticaPage.InserePrioridade(campoprioridade,linhaplanilha[6]);
            
            AbrangLogisticaPage.TakescreenShot(metodo);
            
            String cicloini = AbrangLogisticaPage.ObtercicloComercial(cicloinicomercialialt);

            AbrangLogisticaPage.InsereCiclo(campocicloinicial ,cicloini);
            
            AbrangLogisticaPage.TakescreenShot(metodo);
            
            
            String ciclofim = AbrangLogisticaPage.ObtercicloComercial(ciclofimcomercialialt);
            
            
            if (!"".equals(ciclofim)) {
                
            	AbrangLogisticaPage.InsereCiclo(campociclofinal , ciclofim);
            	
            	AbrangLogisticaPage.TakescreenShot(metodo);
            }     

            AbrangLogisticaPage.acao("btnAddSessionItem");
            
            AbrangLogisticaPage.TakescreenShot(metodo);

            
               try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AbrangenciaLogistica.class.getName()).log(Level.SEVERE, null, ex);
            }

            AbrangLogisticaPage.acao("btnSalvar");

            AbrangLogisticaPage.Aguardaxpath(mensagemresultado);
            
            AbrangLogisticaPage.TakescreenShot(metodo);

            AbrangLogisticaPage.ValidaTextoMensagem(telaerro, mensagemresultado, validacao, metodo);
        }

 

        public void ExcluiRascunhoLog()
        {
            String teste = "Rascunho";

            String metodo = "Excluir Rascunho Abrangencia Logistica ";

            String acao = "excluir";

            String validacao = config.Msg("MsgExclui");

            linhaplanilha = linha.Pegalinha(teste);

            Acao(linhaplanilha[2], linhaplanilha[1], botaoexcluir, validacao, metodo , acao ,metodo);
        }

 
        public void Acao(String status, String codvenda, String botao, String Validacao, String teste , String acao ,String metodo)
        {

            AbrangLogisticaPage.Aguardaxpath(telaabranglogistica);

            AbrangLogisticaPage.MenuAbrangLog(telaabranglogistica);
            
            AbrangLogisticaPage.TakescreenShot(metodo);

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
            
            AbrangLogisticaPage.TakescreenShot(metodo);
            
            AbrangLogisticaPage.Aguardaxpath(gridlogistica);
            
            AbrangLogisticaPage.SelecionaAbrangenciaLog(gridlogistica , acao , teste);

            AbrangLogisticaPage.TakescreenShot(metodo);
            
            AbrangLogisticaPage.acao(botao);
            
            AbrangLogisticaPage.TakescreenShot(metodo);

            AbrangLogisticaPage.Aguardaxpath(confirmar);

            AbrangLogisticaPage.ConfirmaCancela(confirmar);
            
            AbrangLogisticaPage.TakescreenShot(metodo);


//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(AbrangenciaLogistica.class.getName()).log(Level.SEVERE, null, ex);
//        }
            AbrangLogisticaPage.Aguardaxpath(mensagemresultado);
            
            AbrangLogisticaPage.TakescreenShot(metodo);

            AbrangLogisticaPage.ValidaTextoMensagem(telaerro, mensagemresultado, Validacao, teste);

        }

    }
