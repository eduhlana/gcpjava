package core;

import java.io.File;
import java.io.IOException;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 *
 * @author eduardo.lana
 */
public class ScreenShots extends BaseTest{
    public static void takeScreenshot(String fileName){
        File scrFile = ((TakesScreenshot)DriverFactory.GetDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFileToDirectory(scrFile, new File("E:\\GCP\\SeleniumScreenShots\\"+fileName),true);
        } catch (IOException e) {
            
        }
    }
    
}
