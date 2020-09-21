package Utility;

import Constants.K;
import Pages.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCurrentURL {
    public static String getWomenSummerDressURL() {
        WebDriver driver = new ChromeDriver();
        driver.get(K.url);

        Utility.mouseHover(driver, IndexPage.getWomenMenu(driver));
        IndexPage.clickSummerDress(driver);
        return driver.getCurrentUrl();
    }

    public static String getDressSummerDressURL() {
        WebDriver driver = new ChromeDriver();
        driver.get(K.url);

        Utility.mouseHover(driver, IndexPage.getDressMenu(driver));
        IndexPage.clickSummerDressSub(driver);
        return driver.getCurrentUrl();
    }

}
