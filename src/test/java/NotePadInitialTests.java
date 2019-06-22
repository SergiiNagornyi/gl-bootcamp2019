import io.github.bonigarcia.wdm.WebDriverManager;
import objects.NotePad;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NotePadInitialTests {

    WebDriver driver;
    NotePad np;

    @Before
    public void openBrowser () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        np = NotePad (driver);
    }

    @Test
    public void calculatorTest () {
        String note = "Note content\nLine2\nLine3";

        np.open().
                setTitle("My new Note").
                setContent(note).
                save().addContent("Ignat").save();

        Assert.assertArrayEquals(note, np.getNoteContent());
    }

    @After
    public void closeBrowser () {driver.quit();}
}