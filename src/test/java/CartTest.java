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
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title~= Log]")).click();
        driver.findElement(By.id("email")).sendKeys("danielaaa.stanus@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector(".nav-6")).click();
        driver.findElement(By.id("product-collection-image-412")).click();
        driver.findElement(By.cssSelector("#option26")).click();
        driver.findElement(By.id("option80")).click();
        driver.findElement(By.cssSelector(".add-to-cart .btn-cart")).click();
        WebElement succesTextElement = driver.findElement(By.cssSelector(".success-msg"));
        String succesText = succesTextElement.getText();

    Assert.assertTrue(succesTextElement.isDisplayed());
    Assert.assertEquals("Lexington Cardigan Sweater was added to your shopping cart.", succesText);

    }

    @Test
    public void emptyCart(){
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title~= Log]")).click();
        driver.findElement(By.id("email")).sendKeys("danielaaa.stanus@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector(".nav-6")).click();
        driver.findElement(By.id("product-collection-image-412")).click();
        driver.findElement(By.cssSelector("#option26")).click();
        driver.findElement(By.id("option80")).click();
        driver.findElement(By.cssSelector(".add-to-cart .btn-cart")).click();
        driver.findElement(By.cssSelector("#empty_cart_button")).click();
        WebElement textElement = driver.findElement(By.cssSelector(".page-title"));
        String text = textElement.getText();
        Assert.assertTrue(textElement.isDisplayed());
        Assert.assertEquals("SHOPPING CART IS EMPTY", text);

    }
    @Test
    public void moveToWishlist() {
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account"));
        accountLink.click();
        driver.findElement(By.cssSelector("[title~= Log]")).click();
        driver.findElement(By.id("email")).sendKeys("danielaaa.stanus@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.cssSelector(".nav-6")).click();
        driver.findElement(By.id("product-collection-image-412")).click();
        driver.findElement(By.cssSelector("#option26")).click();
        driver.findElement(By.id("option80")).click();
        driver.findElement(By.cssSelector(".add-to-cart .btn-cart")).click();
        driver.findElement(By.cssSelector(".product-cart-actions .use-ajax")).click();
        WebElement textElement = driver.findElement(By.cssSelector(".success-msg"));
        String text = textElement.getText();

        Assert.assertTrue(textElement.isDisplayed());
        Assert.assertEquals("Lexington Cardigan Sweater has been moved to wishlist Wishlist", text);

    }



@After
public void close(){
    driver.quit();
}

}
