package Tests;

import Constants.K;
import Constants.URL;
import Pages.*;
import Utility.GetCurrentURL;
import Utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Testovi {

    private static WebDriver driver;
    private static SoftAssert sa;

    @BeforeTest
    public void setProps() {
        System.setProperty("webdriver.chrome.driver", "chromedriver-2");
    }

    @Test
    public void summerDressURL() {
        driver = new ChromeDriver();
        sa = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        sa.assertEquals(GetCurrentURL.getWomenSummerDressURL(), URL.summerDressURL);
        driver.navigate().back();
        sa.assertEquals(GetCurrentURL.getDressSummerDressURL(), URL.summerDressURL);
        driver.navigate().back();
        sa.assertEquals(GetCurrentURL.getWomenSummerDressURL(), GetCurrentURL.getDressSummerDressURL());

        sa.assertAll();

    }

    @Test
    public void cartTest() throws InterruptedException {
        driver = new ChromeDriver();
        sa = new SoftAssert();
        driver.get(URL.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Utility.mouseHover(driver, IndexPage.getWomenMenu(driver));
        IndexPage.clickSummerDress(driver);
        Utility.scrollDown(driver);
        Thread.sleep(1000);
        SummerDress.moveToItem(driver);
        Thread.sleep(1000);
        SummerDress.chooseColor(driver);
        Thread.sleep(1000);
        PreOrder.clickPlusSign(driver);
        PreOrder.selectFromDropDown(driver, "M");
        PreOrder.addToCart(driver);
        PreOrder.proceedToCheckout(driver);

        sa.assertEquals(CheckOut.getItemDesc(driver), K.itemDesriptionLink);
        sa.assertEquals(CheckOut.getItemColorSize(driver),K.itemColorSizeLink);
        sa.assertEquals(CheckOut.getItemQty(driver), "2");

        sa.assertAll();
    }

    @Test

    public void ItemsFound() {
        driver = new ChromeDriver();
        sa = new SoftAssert();
        driver.get(URL.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        IndexPage.inputSearchBar(driver, "yellow");
        IndexPage.clickSearch(driver);
        sa.assertEquals(SearchResults.headingCounter(driver), URL.searchResults);
        Utility.scrollDown(driver);
        Utility.mouseHover(driver, SearchResults.yellowItem1(driver));
        sa.assertEquals(SearchResults.yellowItem1(driver).getAttribute("style"), URL.yellowItemStyle);
        sa.assertEquals(SearchResults.yellowItem2(driver).getAttribute("style"), URL.yellowItemStyle);
        sa.assertEquals(SearchResults.yellowItem3(driver).getAttribute("style"), URL.yellowItemStyle);

        sa.assertAll();
    }

    @AfterTest

    public void closePage(){
        driver.close();
    }

}
