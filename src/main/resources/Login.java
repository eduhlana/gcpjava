package pageController;

import core.BaseTest;
import core.BaseTest;
import core.MsgConfig;
import data.PegaLinhaExcel;
import core.BasePage;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import page.LoginPage;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Login extends BaseTest{
	
	
	public LoginPage LoginPage = new LoginPage();
	public PegaLinhaExcel excel = new PegaLinhaExcel();
	String[] linhaplanilha = new String[12];
	
	public void Logar() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		linhaplanilha = excel.Pegalinha("Aprovado");
		LoginPage.AguardaXpath("//*[@id=\"username\"]");
		String User = linhaplanilha[10].replace(".","");
		LoginPage.Setusuario("username",User );
		LoginPage.Setusuario("password", linhaplanilha[11]);
		LoginPage.logar("//*[@id=\"loginForm\"]/fieldset/div[3]/button");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
