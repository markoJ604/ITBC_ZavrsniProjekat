package Utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utility {

    public static void mouseHover(WebDriver driver, WebElement element) {
        Actions hover = new Actions(driver);
        hover.moveToElement(element);
        hover.build().perform();
    }

    public static void scrollDown(WebDriver driver){
        Actions scroll = new Actions(driver);
        scroll.sendKeys(Keys.PAGE_DOWN);
        scroll.build().perform();
    }
}
