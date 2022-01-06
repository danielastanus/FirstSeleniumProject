import net.bytebuddy.utility.RandomString;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegisterTest {
    private WebDriver driver;

    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void registerWithValidCredentials(){
        RandomString randomString = new RandomString();
        String  random = randomString.nextString();
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector(".links [title~=Register]")).click();
        driver.findElement(By.id("firstname")).sendKeys("Daniela");
        driver.findElement(By.name("middlename")).sendKeys("A");
        driver.findElement(By.id("lastname")).sendKeys("Stanus");
        driver.findElement(By.name("email")).sendKeys("daniela.stanus"+random+ "@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456");
        driver.findElement(By.id("is_subscribed")).click();
        WebElement registerButton = driver.findElement(By.cssSelector(".buttons-set [title~=Register]"));
        registerButton.click();
        WebElement registerTextElement = driver.findElement(By.cssSelector(".success-msg"));
        String registerText = registerTextElement.getText();

        Assert.assertTrue(registerTextElement.isDisplayed());
        Assert.assertEquals("Thank you for registering with Madison Island.", registerText);
    }

    @Test
    public void registerWithDifferentPass(){
        RandomString randomString = new RandomString();
        String  random = randomString.nextString();
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account .label"));
        accountLink.click();
        driver.findElement(By.cssSelector(".links [title~=Register]")).click();
        driver.findElement(By.id("firstname")).sendKeys("Daniela");
        driver.findElement(By.name("middlename")).sendKeys("A");
        driver.findElement(By.id("lastname")).sendKeys("Stanus");
        driver.findElement(By.name("email")).sendKeys("daniela.stanus"+random+ "@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("1234567");
        driver.findElement(By.id("is_subscribed")).click();
        WebElement registerButton = driver.findElement(By.cssSelector(".buttons-set [title~=Register]"));
        registerButton.click();
        WebElement registerTextElement = driver.findElement(By.cssSelector(".validation-advice"));
        String registerText = registerTextElement.getText();

        Assert.assertTrue(registerTextElement.isDisplayed());
        Assert.assertEquals("Please make sure your passwords match.", registerText);
    }


    @After
    public void close(){
        driver.quit();
    }


}
