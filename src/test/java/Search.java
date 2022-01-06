import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {
        private WebDriver driver;

    @Before
        public void openBrowser(){
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
        public void searchByValidProduct(){
            driver.findElement(By.cssSelector("#search")).sendKeys("book");
            driver.findElement(By.cssSelector(".search-button")).click();
            WebElement searchResultElement = driver.findElement(By.cssSelector(".page-title"));
            String text = searchResultElement.getText();
        Assert.assertTrue(searchResultElement.isDisplayed());
        Assert.assertEquals("SEARCH RESULTS FOR 'BOOK'", text);

    }

    @Test
        public void searchByInvalidProduct(){
            driver.findElement(By.cssSelector("#search")).sendKeys("pizza");
            driver.findElement(By.cssSelector(".search-button")).click();
            WebElement searchResultElement = driver.findElement(By.cssSelector(".note-msg"));
            String text = searchResultElement.getText();
        Assert.assertTrue(searchResultElement.isDisplayed());
        Assert.assertEquals("Your search returns no results.", text);

    }

    @After
    public void close() {
        driver.quit();
    }

}