package commonLibraries;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CommonFunctions {

    public static WebDriver driver;
    public String screenshotPath = new File("src/main/resources/errorScreenshots").getAbsolutePath();

    public void openBrowser(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    public void closeBrowser(){

        driver.quit();

    }

    public void wait(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void takeScreenshots(String screenshotFileName) throws IOException{

        TakesScreenshot takesScreenshot = ((TakesScreenshot)driver);
        File virtualFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(screenshotPath+"/"+screenshotFileName+".png");
        FileUtils.copyFile(virtualFile,destinationFile);



    }

}
