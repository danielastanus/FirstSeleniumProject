import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest {

    private WebDriver driver;

    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void addToWishList(){

        WebElement saleLink = driver.findElement(By.cssSelector(".nav-5"));
        saleLink.click();
        WebElement productLink = driver.findElement(By.cssSelector("#product-collection-image-403"));
        productLink.click();
        driver.findElement(By.cssSelector(".link-wishlist")).click();
        WebElement textElement = driver.findElement(By.cssSelector(".page-title"));
        String text = textElement.getText();

        Assert.assertTrue(textElement.isDisplayed());
        Assert.assertEquals("LOGIN OR CREATE AN ACCOUNT", text);



    }
    @After
    public void close(){
        driver.quit();

    }




}
