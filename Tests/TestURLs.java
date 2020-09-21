package Tests;

import Constants.K;
import Utility.GetCurrentURL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TestURLs {
    @BeforeTest
    public void setProps(){
        System.setProperty("webdriver.chrome.driver", "chromedriver-2");

    }

    @Test
    public void summerDressURL() {
        WebDriver driver = new ChromeDriver();
        SoftAssert sa = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        sa.assertEquals(GetCurrentURL.getWomenSummerDressURL(), K.summerDressURL);
        driver.navigate().back();
        sa.assertEquals(GetCurrentURL.getDressSummerDressURL(), K.summerDressURL);
        driver.navigate().back();
        sa.assertEquals(GetCurrentURL.getWomenSummerDressURL(), GetCurrentURL.getDressSummerDressURL());

        sa.assertAll();

    }



}
