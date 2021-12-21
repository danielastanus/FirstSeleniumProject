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
        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Daniela");
        driver.findElement(By.name("middlename")).sendKeys("A");
        driver.findElement(By.id("lastname")).sendKeys("Stanus");
        driver.findElement(By.name("email")).sendKeys("daniela.stanus"+random+ "@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456");
        driver.findElement(By.id("is_subscribed")).click();
        WebElement registerButton = driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span"));
        registerButton.click();
        WebElement registerTextElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > ul > li > ul > li > span"));
        String registerText = registerTextElement.getText();

        Assert.assertTrue(registerTextElement.isDisplayed());
        Assert.assertEquals("Thank you for registering with Madison Island.", registerText);
    }

    @Test
    public void registerWithDifferentPass(){
        RandomString randomString = new RandomString();
        String  random = randomString.nextString();
        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Daniela");
        driver.findElement(By.name("middlename")).sendKeys("A");
        driver.findElement(By.id("lastname")).sendKeys("Stanus");
        driver.findElement(By.name("email")).sendKeys("daniela.stanus"+random+ "@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("1234567");
        driver.findElement(By.id("is_subscribed")).click();
        WebElement registerButton = driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span"));
        registerButton.click();
        WebElement registerTextElement = driver.findElement(By.id("advice-validate-cpassword-confirmation"));
        String registerText = registerTextElement.getText();

        Assert.assertTrue(registerTextElement.isDisplayed());
        Assert.assertEquals("Please make sure your passwords match.", registerText);
    }


    @After
    public void close(){
        driver.quit();
    }


}
