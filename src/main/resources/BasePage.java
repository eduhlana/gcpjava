
package core;

import static org.junit.Assert.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author eduardo.lana
 */
public class BasePage {

	protected void acao(By Element) {
		DriverFactory.GetDriver().findElement(Element).click();
                
	}
        
        protected void checked(By Element) {
        
            if(!DriverFactory.GetDriver().findElement(Element).isSelected()){
                DriverFactory.GetDriver().findElement(Element).click();
            }
		
                
	}
        

	protected void SelecionaGridComercial(By Element) {
		try {
			DriverFactory.GetDriver().findElement(Element).click();
		} catch (NoSuchElementException a) {
			System.out.println("Nao existe abrangencia comercial cadastrada para esse codigo de venda ");
			throw a;
		}
	}

	protected void SelecionaGrid(By Element, String acao, String teste) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		String logDate = df.format(today);
		try {
			DriverFactory.GetDriver().findElement(Element).click();
		} catch (NoSuchElementException a) {

			System.out.println("Nao existe registro para  " + acao);
			throw a;
		}
	}

	protected void Escrever(By Element, String Text) {

		DriverFactory.GetDriver().findElement(Element).sendKeys(Text);
	}

	protected void SelectValue(By Element, String Text) {

		new Select(DriverFactory.GetDriver().findElement(Element)).selectByValue(Text);
	}

	protected void Status(By Element) {

		DriverFactory.GetDriver().findElement(Element).click();

	}

	protected String ObterTexto(By Element) {
		return DriverFactory.GetDriver().findElement(Element).getText();
	}

	
	protected void ValidaMensagemPopup(By Element, By Element1, String Texto1, String teste) {

		Date logDate = new Date();

		String result;
		try {
			
			String mensagem = DriverFactory.GetDriver().findElement(Element1).getText();
			result = logDate + " - " + teste + ": " + mensagem;
			
				assertEquals(mensagem, Texto1);
			
			

		} catch (NoSuchElementException a) {
			
			String mensagem = DriverFactory.GetDriver().findElement(Element).getText();
			result = logDate + " - " + teste + ": " + mensagem;
			assertEquals(mensagem, Texto1);
		}

	}
	
	protected void ValidaMensagemPopupComercial(By Element, By Element1, String Texto1, String teste) {

		Date logDate = new Date();

		String result;
		try {
			
			String mensagem = DriverFactory.GetDriver().findElement(Element).getText();
			result = logDate + " - " + teste + ": " + mensagem;
			
				assertEquals(mensagem, Texto1);
			
			

		} catch (NoSuchElementException a) {
			
			String mensagem = DriverFactory.GetDriver().findElement(Element1).getText();
			result = logDate + " - " + teste + ": " + mensagem;
			assertEquals(mensagem, Texto1);
		}

	}


	protected void EsperaCarregamento(By Element) {

		WebDriverWait wait = new WebDriverWait(DriverFactory.GetDriver(), 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated((Element)));
 
	}
	
	
	protected String ObtemCiclo(By Element) {
		try {
			return DriverFactory.GetDriver().findElement(Element).getText();
		}catch(Exception e) {
				return "";
			}
		
	}
	
	protected String ObtemCicloComercial(By Element) {
		try {
			String valor = DriverFactory.GetDriver().findElement(Element).getAttribute("value");
			return valor;
		}catch(Exception e) {
				return "";
			}
		
	}
	protected String resultado(By Element) {
		try {
			
			return DriverFactory.GetDriver().findElement(Element).getText();
			
		}catch(Exception e) {
				return "";
			}
		
	}

}
