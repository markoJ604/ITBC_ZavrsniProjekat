import Constants.URL;
import Pages.ContactUs;
import Pages.IndexPage;
import Pages.SummerDress;
import Utility.Utilities;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

//------- Main class, purpose is to test various scenarios --------

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver-2");
        WebDriver driver = new ChromeDriver();
        driver.get(URL.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);


    }
}

