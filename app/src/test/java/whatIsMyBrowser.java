import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class whatIsMyBrowser {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();

        System.setProperty("webdriver.http.factory", "jdk-http-client");

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.whatismybrowser.com/");
                takeScreenshot(chromeDriver, "whatIsMyBrowser_chrome.png");
        chromeDriver.quit();

        WebDriverManager.firefoxdriver().setup();

        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://www.whatismybrowser.com/");
        takeScreenshot(firefoxDriver, "whatIsMyBrowser_firefox.png");
        firefoxDriver.quit();

    }

    public static void takeScreenshot(WebDriver webdriver, String desiredPath) throws Exception{
        TakesScreenshot screenshot = ((TakesScreenshot)webdriver);
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(desiredPath);
        FileUtils.copyFile(screenshotFile, targetFile);
    }
}
