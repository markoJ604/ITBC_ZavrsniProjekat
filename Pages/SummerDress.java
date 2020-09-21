package Pages;

import Constants.K;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SummerDress {

    public static WebElement colorPicker(WebDriver driver) {
        return driver.findElement(By.xpath(K.colorPickerId));
    }

    public static WebElement getItem2(WebDriver driver){
        return driver.findElement(By.xpath(K.item2Xpath));
    }

    public static void moveToItem(WebDriver driver){
        Actions action = new Actions(driver);
        action.moveToElement(getItem2(driver));
        action.perform();
    }

    public static void chooseColor(WebDriver driver) {
        colorPicker(driver).click();
    }




}

