package Pages;

import Constants.K;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PreOrder {

    public static WebElement getPlusSign(WebDriver driver) {
        return driver.findElement(By.xpath(K.plusSignXpath));
    }

    public static void clickPlusSign(WebDriver driver) {
        getPlusSign(driver).click();
    }

    public static WebElement getDropDown(WebDriver driver) {
        return driver.findElement(By.xpath(K.dropDownXpath));
    }

    public static void selectFromDropDown(WebDriver driver, String value) {
        Select selectDropDown = new Select(getDropDown(driver));
        selectDropDown.selectByVisibleText(value);
    }

    public static void addToCart(WebDriver driver) {
        driver.findElement(By.xpath(K.addToCartXpath)).click();
    }

    public static void proceedToCheckout(WebDriver driver) {
        driver.findElement(By.xpath(K.proceedToCheckXpath)).click();
    }
}
