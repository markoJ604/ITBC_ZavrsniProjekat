import Constants.K;
import Pages.IndexPage;
import Pages.PreOrder;
import Pages.SummerDress;
import Utility.Utility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver-2");
        WebDriver driver = new ChromeDriver();
        driver.get(K.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);


        Utility.mouseHover(driver, IndexPage.getWomenMenu(driver));
        IndexPage.clickSummerDress(driver);

        Utility.scrollDown(driver);
        Thread.sleep(1000);

        SummerDress.moveToItem(driver);
        Thread.sleep(1000);

        SummerDress.chooseColor(driver);
        PreOrder.clickPlusSign(driver);
        PreOrder.selectFromDropDown(driver, "M");
        PreOrder.addToCart(driver);
    }
}
