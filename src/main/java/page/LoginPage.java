package page;
import org.openqa.selenium.By;

import org.junit.BeforeClass;
import core.BasePage;
import data.PegaLinhaExcel;

public class LoginPage extends BasePage{

	public PegaLinhaExcel excel = new PegaLinhaExcel();
	String[] linhaplanilha = new String[12];

	public void Setusuario(String user , String usuario) {
		
		Escrever(By.id(user),usuario);
	}
	public void Setsenha(String password , String senha) {
		
		Escrever(By.id(password),senha);
	}
	public void logar(String logar)
	{
		acao(By.xpath(logar));
	}
	public void AguardaXpath(String xpath) {
		EsperaCarregamento(By.xpath(xpath));
	}
        public void TakescreenShot(String texto) {
		 testScreenshot(texto);
		
	}
        
	@BeforeClass
	public void Logar() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		linhaplanilha = excel.Pegalinha("Aprovado");
		AguardaXpath("//*[@id=\"username\"]");
		String User = linhaplanilha[10].replace(".","");
		Setusuario("username",User );
		Setsenha("password", linhaplanilha[11]);
		logar("//*[@id=\"loginForm\"]/fieldset/div[3]/button");
		
	}

}
