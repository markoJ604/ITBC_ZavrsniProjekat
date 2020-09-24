import Constants.URL;
import Pages.IndexPage;
import Pages.SummerDress;
import Utility.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver-2");
        WebDriver driver = new ChromeDriver();
        driver.get(URL.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        System.out.println(SummerDress.getDressSummerDressURL(driver));
        System.out.println(SummerDress.getWomenSummerDressURL(driver));

    }
}
