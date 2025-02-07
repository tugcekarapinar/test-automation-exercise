package AkakceUiTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AkakceUiTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.akakce.com");
    }

    @Test
    public void testAddFollowList() {
        WebElement loginPage = driver.findElement(By.cssSelector("#H_rl_v8 > a:nth-child(2)"));
        loginPage.click();

        WebElement userName = driver.findElement(By.cssSelector("#life"));
        userName.click();
        userName.sendKeys("userMail");

        WebElement userPassword = driver.findElement(By.cssSelector("#lifp"));
        userPassword.click();
        userPassword.sendKeys("userPassword");

        WebElement loginButton = driver.findElement(By.cssSelector("#lfb"));
        loginButton.click();

        WebElement searchText = driver.findElement(By.cssSelector("#q"));
        searchText.sendKeys("iphone");

        WebElement searchButton = driver.findElement(By.cssSelector("button[title='Ara']"));
        searchButton.click();

        List<WebElement> goProducts = driver.findElements(By.cssSelector("span.bt_v8"));
        goProducts.get(0).click();

        WebElement followButton = driver.findElement(By.xpath("//*[@id=\"ntf_w\"]/span"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", followButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", followButton);
    }

    @AfterClass
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
