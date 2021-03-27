import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SecondAutoTest {
    WebDriver driver;
    By searchResults = By.cssSelector(".catalog-grid .goods-tile__title");

    @BeforeClass
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
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

        List<WebElement> results = driver.findElements(searchResults);
        String firstResultTitle = results.get(0).getText();
        Assert.assertEquals(firstResultTitle, "Mонитор 27\" Samsung Odyssey G5 LC27G54T Black (LC27G54TQWIXCI) + DisplayPort и HDMI кабель");
    }

    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }
}
