package Tests;

import Constants.K;
import Constants.URL;
import Pages.*;
import Utility.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TestCart {

    private static WebDriver driver;
    private static SoftAssert sa;

    @BeforeMethod
    public void setDriver() {
        driver = new ChromeDriver();
        driver.get(URL.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        sa = new SoftAssert();
    }

    // ------- Test 4 & 5 --------

    @Test
    public void cartTest() throws InterruptedException {
        Utilities.mouseHover(driver, IndexPage.getWomenMenu(driver));
        IndexPage.clickSummerDress(driver);
        Utilities.scrollDown(driver);
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
        sa.assertEquals(CheckOut.getItemColorSize(driver), K.itemColorSizeLink);
        sa.assertEquals(CheckOut.getItemQty(driver), "2");
        sa.assertAll();
    }

    // ------- Test 6 --------

    @Test

    public void ItemsFound() {
        IndexPage.inputSearchBar(driver, "yellow");
        IndexPage.clickSearch(driver);
        sa.assertEquals(SearchResults.headingCounter(driver), URL.searchResults);
        Utilities.scrollDown(driver);
        Utilities.mouseHover(driver, SearchResults.yellowItem1(driver));
        sa.assertEquals(SearchResults.yellowItem1(driver).getAttribute("style"), URL.yellowItemStyle);
        sa.assertEquals(SearchResults.yellowItem2(driver).getAttribute("style"), URL.yellowItemStyle);
        sa.assertEquals(SearchResults.yellowItem3(driver).getAttribute("style"), URL.yellowItemStyle);
        sa.assertAll();
    }

    @AfterMethod

    public void closePage() {
        driver.close();
    }

}
