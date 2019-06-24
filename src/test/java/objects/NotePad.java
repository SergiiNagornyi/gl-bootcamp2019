package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotePad {

   private static final By noteTitle = By.id("edit_title");
   private static final By noteContent = By.id("edit_textarea");
   private static final By saveTitleButton = By.xpath("//*[@id='btnSaveNote']");
   //private static final By richTextEditor = By.id("btnEnableRichText"); --add function
   private static final By deleteNote = By.cssSelector(".delete");
   private static final By setLoginEmail = By.id("loginEmail");
   private static final By setPassword = By.xpath("//*[@id='password']");
   private static final By login = By.id("submit");

   private WebDriver driver;
   private WebDriverWait wait;

   public NotePad (WebDriver driver)
   {
       this.driver = driver;
       this.wait = new WebDriverWait(this.driver,5);
   }

   @Step
   public NotePad open ()
   {
       driver.get("https://anotepad.com/");
       return this;
   }

    @Step
    public NotePad openCreateAccount ()
    {
        driver.get("https://anotepad.com/create_account");
        return this;
    }

    @Step
    public NotePad setLoginEmail (String email)
    {
        driver.findElement(setLoginEmail).sendKeys(email);
        return this;
    }

    @Step
    public NotePad setPassword (String password)
    {
        driver.findElement(setPassword).sendKeys(password);
        return this;
    }

    @Step
    public NotePad login ()
    {
        driver.findElement(login).click();
        return this;
    }


    @Step
    public NotePad setTitle (String title)
    {
        driver.findElement(noteTitle).sendKeys(title);
        return this;
    }

    @Step
    public NotePad addContent (String content)
    {
        driver.findElement(noteContent).sendKeys(content);
        return this;
    }

    @Step
    public NotePad setContent (String content)
    {
        driver.findElement(noteContent).clear();
        driver.findElement(noteContent).sendKeys(content);
        return this;
    }

    @Step
    public NotePad save ()
    {
        driver.findElement(saveTitleButton).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".alert.alert-warning"), "You have saved your note as a"));
        return this;
    }

    @Step
    public String getNoteContent ()
    {
        return driver.findElement(noteContent).getAttribute("value");
    }
}