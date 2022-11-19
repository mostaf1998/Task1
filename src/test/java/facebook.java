import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class facebook {
    WebDriver driver = null;

    @BeforeTest
    public void open_browser() {
        System.setProperty("webdriver.chrome.driver", "D:\\Task1\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void search() {
        driver.findElement(By.cssSelector("input[class=\"gLFyf\"]")).sendKeys("facebook");
        driver.findElement(By.name("btnK")).click();

        //Assertion	About (number) results ( (number) seconds))
        Assert.assertTrue(driver.findElement(By.id("result-stats")).isDisplayed(),"true");



    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }
}
