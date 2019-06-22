import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewStupidTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser () {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void calculatorTest ()
    {
        driver.get("https://anotepad.com/");
        driver.findElement(By.id("edit_title")).sendKeys("My First Note");
        driver.findElement(By.id("btnSaveNote")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".alert.alert-warning"), "You have saved your note as a"));

    }

    @After
    public void closeBrowser () {driver.quit();}

}
