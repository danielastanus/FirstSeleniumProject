import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.lang3.RandomStringUtils;

public class LoginTest {
    private WebDriver driver;

@Before
    public void openBrowser(){
    System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://testfasttrackit.info/selenium-test/");

}

@Test
    public void loginWithValidCredentials(){

        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title~= Log]")).click();
        driver.findElement(By.id("email")).sendKeys("danielaaa.stanus@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        WebElement welcomeTextElement = driver.findElement(By.cssSelector(".hello"));
        String welcomeText = welcomeTextElement.getText();

    Assert.assertTrue(welcomeTextElement.isDisplayed());
    Assert.assertEquals("Hello, Daniela A Stanus!", welcomeText);

    }

@Test
    public void loginWithInvalidCredentials(){

        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title~= Log]")).click();
        driver.findElement(By.id("email")).sendKeys("danielaaa.stanus@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys(RandomStringUtils.randomAlphabetic(7));
        driver.findElement(By.id("send2")).click();
        WebElement welcomeTextElement = driver.findElement(By.cssSelector(".error-msg"));
        String text = welcomeTextElement.getText();

    Assert.assertTrue(welcomeTextElement.isDisplayed());
    Assert.assertEquals("Invalid login or password.", text);
    }

@Test
    public void forgetPassword(){
       WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
       accountLink.click();
       driver.findElement(By.cssSelector("[title~= Log]")).click();
       driver.findElement(By.id("email")).sendKeys("danielaaa.stanus@mailinator.com");
       driver.findElement(By.cssSelector(".f-left")).click();
       driver.findElement(By.cssSelector("#email_address")).sendKeys("danielaaa.stanus@mailinator.com");
       driver.findElement(By.cssSelector(".buttons-set .button")).click();
       WebElement textElement = driver.findElement(By.cssSelector(".success-msg"));
       String text2 = textElement.getText();

    Assert.assertTrue(textElement.isDisplayed());
    Assert.assertEquals("If there is an account associated with danielaaa.stanus@mailinator.com you will receive an email with a link to reset your password.", text2);
}


@After
   public void close(){
    driver.quit();
}
}
