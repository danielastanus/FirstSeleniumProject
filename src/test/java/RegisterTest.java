import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    public void registerWithValidCredentials(){System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Daniela");
        driver.findElement(By.name("middlename")).sendKeys("A");
        driver.findElement(By.id("lastname")).sendKeys("Stanus");
        driver.findElement(By.name("email")).sendKeys("danielaaa.stanus@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456");
        driver.findElement(By.id("is_subscribed")).click();
        WebElement registerButton = driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span"));
        registerButton.click();
        String registerText = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > ul > li > ul > li > span")).getText();
        if (registerText.equals("Thank you for registering with Madison Island."))
            System.out.println("Succesful test");
        else
            System.err.println("Fail");
        driver.quit();



    }


}
