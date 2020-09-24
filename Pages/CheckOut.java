package Pages;

import Constants.K;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOut {

    public static String getItemDesc(WebDriver driver) {
        WebElement element = driver.findElement(By.linkText(K.itemDesriptionLink));
        return element.getText();
    }

    public static String getItemColorSize(WebDriver driver) {
        WebElement element = driver.findElement(By.linkText(K.itemColorSizeLink));
        return element.getText();
    }

    public static String getItemQty(WebDriver driver) {
        WebElement element = driver.findElement(By.cssSelector(K.itemQtyCSS));
        return element.getAttribute("value");
    }
}
