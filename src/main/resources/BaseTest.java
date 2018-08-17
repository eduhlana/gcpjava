package core;
import org.junit.After;
import org.junit.Before;


/**
 * @author eduardo.lana
 */
public class BaseTest {
	
	
    @Before
     public void Inicializa()
       {
    	
            DriverFactory.GetDriver().navigate().to("http://hml3-naturahml.sysmap.com.br/gcpweb/");
            //DriverFactory.GetDriver().navigate().to("http://gcphml.natura.net/gcpweb/pages/preco/pesquisar");
    		
            DriverFactory.GetDriver().manage().window().maximize();
            
            
            
       }
    
    @After
     public void Finaliza()
        {
            DriverFactory.KillDriver();
        }
    
}
