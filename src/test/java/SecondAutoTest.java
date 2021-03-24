import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SecondAutoTest {
    WebDriver driver;

    @BeforeClass
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
    }
    @Test
    public void test(){
        String searchText = "Монитор";
        WebElement searchElement = driver.findElement(By.xpath("//input[@name='search']"));
        searchElement.clear();
        searchElement.sendKeys(searchText);

        WebElement searchButton = driver.findElement(By.cssSelector(".button.search-form__submit"));
        searchButton.click();

        Assert.assertEquals("Монитор", "Монитор");
    }

    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }
}
