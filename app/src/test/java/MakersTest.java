import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.firefox.FirefoxDriver;
public class MakersTest {
    private static FirefoxDriver driver;
    @BeforeAll
    static void launchBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
    @Test
    void shouldPrintPageTitle() {
        driver.get("https://makers.tech");
        System.out.println(driver.getTitle());
    }
    @AfterAll
//    Run once, at the end of the test run.
    static void closerBrowser() {
        driver.quit();
    }

}
