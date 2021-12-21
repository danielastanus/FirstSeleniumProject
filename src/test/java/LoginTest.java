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

        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("danielaaa.stanus@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        WebElement welcomeTextElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.welcome-msg > p.hello > strong"));
        String welcomeText = welcomeTextElement.getText();

    Assert.assertTrue(welcomeTextElement.isDisplayed());
    Assert.assertEquals("Hello, Daniela A Stanus!", welcomeText);

    }

@Test
    public void loginWithInvalidCredentials(){

        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("danielaaa.stanus@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys(RandomStringUtils.randomAlphabetic(7));
        driver.findElement(By.id("send2")).click();
        WebElement welcomeTextElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-login > ul > li > ul > li > span"));
        String text = welcomeTextElement.getText();

    Assert.assertTrue(welcomeTextElement.isDisplayed());
    Assert.assertEquals("Invalid login or password.", text);
    }

@After
   public void close(){
    driver.quit();
}
}
