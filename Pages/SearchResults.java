package Pages;

import Constants.K;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResults {

    public static String headingCounter(WebDriver driver) {
        return driver.findElement(By.xpath(K.headingCounterXpath)).getText();
    }

    public static WebElement yellowItem1(WebDriver driver) {
        return driver.findElement(By.cssSelector(K.yellowItem1CSS));
    }

    public static WebElement yellowItem2(WebDriver driver) {
        return driver.findElement(By.cssSelector(K.yellowItem2CSS));
    }

    public static WebElement yellowItem3(WebDriver driver) {
        return driver.findElement(By.cssSelector(K.yellowItem3CSS));
    }

}
