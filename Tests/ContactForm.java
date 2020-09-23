package Tests;

import Constants.URL;
import Pages.ContactUs;
import Pages.IndexPage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.ls.LSOutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ContactForm {

    private static WebDriver driver;
    private static SoftAssert sa;
    private XSSFWorkbook wb;
    private FileInputStream fis;

    @BeforeTest
    public void setProps() {
        System.setProperty("webdriver.chrome.driver", "chromedriver-2");

    }

    @Test
    public void singleContactForm() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get(URL.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        IndexPage.clickContactus(driver);
        ContactUs.selectSubjectHeading(driver, "Webmaster");
        ContactUs.inputEmail(driver, "marko@abc.com");
        ContactUs.inputOrderRef(driver, "100020003");
        ContactUs.chooseFile(driver, "/Users/ivana/Downloads/1ddb3bc7f02c30cbd857008e4c8467a7.jpg");
        ContactUs.inputMessageBody(driver, "Cao, ja sam Marko.");
        ContactUs.clickSend(driver);
        Thread.sleep(1000);
        Assert.assertEquals(ContactUs.messageStatus(driver).getAttribute("class"), "alert alert-success");

    }

    @Test
    public void multiContactForm() throws Exception {

        fis = new FileInputStream("ContactFormData.xlsx");
        wb = new XSSFWorkbook(fis);
        driver = new ChromeDriver();
        driver.get(URL.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        Sheet sheet = wb.getSheetAt(0);

        for (int i = 1; i < 31; i++) {
            Thread.sleep(1000);

            Row row = sheet.getRow(i);
            Cell subjectHeading = row.getCell(0);
            Cell email = row.getCell(1);
            Cell orderRef = row.getCell(2);
            Cell message = row.getCell(3);

            IndexPage.clickContactus(driver);
            ContactUs.selectSubjectHeading(driver, subjectHeading.toString());
            ContactUs.inputEmail(driver, email.toString());
            ContactUs.inputOrderRef(driver, orderRef.toString());
            ContactUs.inputMessageBody(driver, message.toString());
            ContactUs.clickSend(driver);
            Thread.sleep(1000);

            Assert.assertEquals("alert alert-success", ContactUs.messageStatus(driver).getAttribute("class"));
            System.out.println(i+2); //Za svaki izvrseni red se printa broj, kad padne test poslednji isprintani broj je zapravo broj reda u kome se nalazi greska

            driver.navigate().back();
        }
    }


    @AfterTest
    public void closePage() {
        driver.close();
    }

}
