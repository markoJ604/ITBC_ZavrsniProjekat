package Tests;

import Constants.URL;
import Pages.IndexPage;
import Utility.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class TestSocialPage {

    private static WebDriver driver;

    @Test
    public void testSocialPages() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get(URL.url);
        driver.manage().window().maximize();
        SoftAssert sa = new SoftAssert();

        Utilities.scrollToBottom(driver);

        IndexPage.clickFacebook(driver);
        Thread.sleep(500);
        IndexPage.clickTwitter(driver);
        Thread.sleep(500);
        IndexPage.clickYoutube(driver);
        Thread.sleep(500);
        IndexPage.clickGoogleplus(driver);
        Thread.sleep(500);

        ArrayList<String> tabs5 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs5.get(4));
        sa.assertEquals(URL.facebookURL, driver.getCurrentUrl());
        driver.close();

        driver.switchTo().window(tabs5.get(3));
        sa.assertEquals(URL.twitterURL, driver.getCurrentUrl());
        driver.close();

        driver.switchTo().window(tabs5.get(2));
        sa.assertEquals(URL.youtubeURL, driver.getCurrentUrl());
        driver.close();

        driver.switchTo().window(tabs5.get(1));
        sa.assertEquals(URL.googleplusURL, driver.getCurrentUrl());
        driver.close();

        driver.switchTo().window(tabs5.get(0));
        driver.close();

        sa.assertAll();
    }

    @AfterSuite

    public void tearDown() {
        driver.quit();
    }

}
