package Pages;

import Constants.K;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactUs {

    public static WebElement getSubjectHeading(WebDriver driver) {
        return driver.findElement(By.xpath(K.subjectHeadingXpath));
    }

    public static void selectSubjectHeading(WebDriver driver, String value) {
        Select select = new Select(getSubjectHeading(driver));
        select.selectByVisibleText(value);
    }

    public static WebElement getEmail(WebDriver driver) {
        return driver.findElement(By.xpath(K.emailXpath));
    }

    public static void inputEmail(WebDriver driver, String value) {
        getEmail(driver).sendKeys(value);
    }

    public static WebElement getOrderRef(WebDriver driver) {
        return driver.findElement(By.xpath(K.orderRefXpath));
    }

    public static void inputOrderRef(WebDriver driver, String value) {
        getOrderRef(driver).sendKeys(value);
    }

    public static WebElement getChooseFile(WebDriver driver) {
        return driver.findElement(By.xpath(K.chooseFileXpath));
    }

    public static void chooseFile(WebDriver driver, String path) {
        getChooseFile(driver).sendKeys(path);
    }

    public static WebElement getMessageBody(WebDriver driver) {
        return driver.findElement(By.xpath(K.messageBodyXpath));
    }

    public static void inputMessageBody(WebDriver driver, String value) {
        getMessageBody(driver).sendKeys(value);
    }

    public static void clickSend(WebDriver driver) {
        driver.findElement(By.xpath(K.sendXpath)).click();
    }

    public static WebElement messageStatus(WebDriver driver) {
        return driver.findElement(By.xpath(K.messageStatusXpath));
    }
}
