package Pages;

import Constants.K;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage {

    public static WebElement getWomenMenu(WebDriver driver) {
        return driver.findElement(By.xpath(K.womenMenuXpath));
    }

    public static void clickSummerDress(WebDriver driver) {
        driver.findElement(By.xpath(K.summerDressXpath)).click();
    }

    public static WebElement getDressMenu(WebDriver driver) {
        return driver.findElement(By.xpath(K.dressMenuXpath));
    }

    public static void clickSummerDressSub(WebDriver driver) {
        driver.findElement(By.xpath(K.dressSubmenuXpath)).click();
    }

    public static WebElement searchBar(WebDriver driver) {
        return driver.findElement(By.xpath(K.searchBarXpath));
    }

    public static void inputSearchBar(WebDriver driver, String searchItem) {
        searchBar(driver).sendKeys(searchItem);
    }

    public static void clickSearch(WebDriver driver) {
        driver.findElement(By.xpath(K.searchBarSearchXpath)).click();
    }

    public static void clickContactus(WebDriver driver) {
        driver.findElement(By.xpath(K.contactusXpath)).click();
    }

    public static void clickFacebook(WebDriver driver) {
        driver.findElement(By.xpath(K.facebookXpath)).click();
    }

    public static void clickTwitter(WebDriver driver) {
        driver.findElement(By.xpath(K.twitterXpath)).click();
    }

    public static void clickYoutube(WebDriver driver) {
        driver.findElement(By.xpath(K.youtubeXpath)).click();
    }

    public static void clickGoogleplus(WebDriver driver) {
        driver.findElement(By.xpath(K.googleplusXpath)).click();
    }
}
