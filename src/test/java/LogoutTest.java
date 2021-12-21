import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogoutTest {
    private WebDriver driver;

    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }

    @Test
    public void logOut() {

        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("danielaaa.stanus@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        WebElement accountLink2 = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink2.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        WebElement textElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.page-title > h1"));
        String text = textElement.getText();
        Assert.assertTrue(textElement.isDisplayed());
        Assert.assertEquals("YOU ARE NOW LOGGED OUT",text);


    }
    @After
    public void close(){
        driver.quit();
    }
}

