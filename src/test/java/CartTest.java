import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartTest {
    private WebDriver driver;

@Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

@Test
    public void addToCartTest(){
        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("danielaaa.stanus@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-6 > a")).click();
        driver.findElement(By.id("product-collection-image-412")).click();
        driver.findElement(By.cssSelector("#swatch26 > span.swatch-label > img")).click();
        driver.findElement(By.id("option80")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        WebElement succesTextElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > ul > li > ul > li > span"));
        String succesText = succesTextElement.getText();

    Assert.assertTrue(succesTextElement.isDisplayed());
    Assert.assertEquals("Lexington Cardigan Sweater was added to your shopping cart.", succesText);

    }

    @Test
    public void emptyCart(){
        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("danielaaa.stanus@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-6 > a")).click();
        driver.findElement(By.id("product-collection-image-412")).click();
        driver.findElement(By.cssSelector("#swatch26 > span.swatch-label > img")).click();
        driver.findElement(By.id("option80")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        driver.findElement(By.cssSelector("#empty_cart_button > span > span")).click();
        WebElement textElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.page-title > h1"));
        String text = textElement.getText();
        Assert.assertTrue(textElement.isDisplayed());
        Assert.assertEquals("SHOPPING CART IS EMPTY", text);

    }
    @Test
    public void moveToWishlist() {
        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("danielaaa.stanus@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-6 > a")).click();
        driver.findElement(By.id("product-collection-image-412")).click();
        driver.findElement(By.cssSelector("#swatch26 > span.swatch-label > img")).click();
        driver.findElement(By.id("option80")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > ul > li:nth-child(2) > a")).click();
        WebElement textElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart-empty > ul > li > ul > li > span"));
        String text = textElement.getText();

        Assert.assertTrue(textElement.isDisplayed());
        Assert.assertEquals("Lexington Cardigan Sweater has been moved to wishlist Wishlist", text);

    }



@After
public void close(){
    driver.quit();
}

}
