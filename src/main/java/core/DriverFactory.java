package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 *
 * @author eduardo.lana
 */
public class DriverFactory {
     private static WebDriver driver;

        public static WebDriver GetDriver()
        {
            String browser = "e";

            if (driver == null)
            {
                
                if (browser.equals("firefox")){
                        FirefoxOptions  options = new FirefoxOptions();
                        String pathselenium = "E:\\GCP\\webdriver\\geckodriver.exe";
                        System.setProperty("webdriver.gecko.driver", pathselenium);
                        options.addArguments("--headless");
                        driver = new FirefoxDriver(options);
                }else{
                
                    ChromeOptions options = new ChromeOptions();
                    String pathselenium = "C:\\Users\\eduardo.lana\\.nuget\\packages\\selenium.webdriver.chromedriver\\2.37.0\\driver\\win32\\chromedriver.exe";
                    System.setProperty("webdriver.chrome.driver", pathselenium);
                    driver = new ChromeDriver(options);                 
                }
                        
            }
            return driver;
        }

        public static void KillDriver()
        {
            if (driver != null)
            {
                driver.quit();
                driver = null;
            }
        }
}
    

