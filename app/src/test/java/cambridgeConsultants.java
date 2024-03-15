import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class cambridgeConsultants {
    public static void main(String[] args) throws Exception{

        // Create a new instance of Selenium
//        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        // Use WebDriver to open a new instance of Chrome
        System.setProperty("webdriver.http.factory", "jdk-http-client");
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();

        // Instruct the driver to browse to the Makers website
        driver.get("https://www.cambridgeconsultants.com/");

        // Take a screenshot of what's currently on the page,
        // and store it in a file 'makers.png' in your project root
        takeScreenshot(driver, "cc_on_firefox.png");

        // Find the title of the webpage (the value inside the HTML
        // <title> element) and print it to the terminal
        String firstWord = driver.getTitle().split("\\s+")[0];
        System.out.println("*** Begin of terminal print commands ***");
        System.out.println("The full Title is: " + driver.getTitle());
        System.out.println("The first work on the website is: " + firstWord);
        System.out.println("*** End of terminal print commands ***");

        // Close down Selenium and end the test
        driver.quit();
    }

    // Helper function for taking screenshots using WebDriver
    public static void takeScreenshot(WebDriver webdriver,String desiredPath) throws Exception{
        TakesScreenshot screenshot = ((TakesScreenshot)webdriver);
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(desiredPath);
        FileUtils.copyFile(screenshotFile, targetFile);
    }
}
