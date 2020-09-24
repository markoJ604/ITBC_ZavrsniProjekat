package Tests;

import Constants.URL;
import Pages.SummerDress;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestURLs {

    private static WebDriver driver;

    @BeforeSuite
    public void setProperties() {
        System.setProperty("webdriver.chrome.driver", "chromedriver-2");
    }

    @BeforeMethod
    public void setDriver() {
        driver = new ChromeDriver();
        driver.get(URL.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @Test
    public void summerDressURL() {
        Assert.assertEquals(SummerDress.getWomenSummerDressURL(driver), URL.summerDressURL);
    }

    @Test
    public void summerDressURL2() {
        Assert.assertEquals(SummerDress.getDressSummerDressURL(driver), URL.summerDressURL);
    }

    @Test
    public void summerDressURL3() {
        Assert.assertTrue(SummerDress.getDressSummerDressURL(driver).equals(SummerDress.getWomenSummerDressURL(driver)));
    }

    @AfterMethod

    public void closePage() {
        driver.close();
    }
}
