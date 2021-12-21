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

        WebElement saleLink = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent"));
        saleLink.click();
        WebElement productLink = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li > div > h2 > a"));
        productLink.click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a")).click();
        WebElement textElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-login > div > h1"));
        String text = textElement.getText();

        Assert.assertTrue(textElement.isDisplayed());
        Assert.assertEquals("LOGIN OR CREATE AN ACCOUNT", text);



    }
    @After
    public void close(){
        driver.quit();

    }




}
