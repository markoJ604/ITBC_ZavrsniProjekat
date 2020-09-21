package Pages;

import Constants.K;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.URL;

public class IndexPage {

//    public static URL indexURL(){
//        return driver
//
//    }

    public static WebElement getWomenMenu(WebDriver driver){
        return driver.findElement(By.xpath(K.womenMenuXpath));
    }

    public static void clickSummerDress(WebDriver driver){
        driver.findElement(By.xpath(K.summerDressXpath)).click();
    }

    public static WebElement getDressMenu(WebDriver driver){
        return driver.findElement(By.xpath(K.dressMenuXpath));
    }

    public static void clickSummerDressSub(WebDriver driver){
        driver.findElement(By.xpath(K.dressSubmenuXpath)).click();
    }



}
