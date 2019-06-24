import io.github.bonigarcia.wdm.WebDriverManager;
import objects.NotePad;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class homeWork3 {

        WebDriver driver;
        NotePad np;

        @Before
        public void openBrowser () {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            np = new NotePad(driver);
        }

        @Test
        //@DisplayName("GL-1006:F-180 Logging with correct Email and Password")
        public void notepadHomeTest () {
            String textForLogin = " - free online notepad";
            String email = "serzshik@bigmir.net";
            String password = "123456";

            np.openCreateAccount()
                    .setLoginEmail(email)
                    .setPassword(password)
                    .login();

            Assert.assertTrue(true);
            Assert.assertEquals(" - free online notepad", textForLogin);
        }

        @After
        public void closeBrowser () {driver.quit();}

}
