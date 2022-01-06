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

        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title~= Log]")).click();
        driver.findElement(By.id("email")).sendKeys("danielaaa.stanus@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        WebElement accountLink2 = driver.findElement(By.cssSelector(".skip-account"));
        accountLink2.click();
        driver.findElement(By.cssSelector("[title~=Log]")).click();
        WebElement textElement = driver.findElement(By.cssSelector(".page-title"));
        String text = textElement.getText();
        Assert.assertTrue(textElement.isDisplayed());
        Assert.assertEquals("YOU ARE NOW LOGGED OUT",text);


    }
    @After
    public void close(){
        driver.quit();
    }
}

