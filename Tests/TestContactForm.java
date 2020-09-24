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
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

public class TestContactForm {

    private static WebDriver driver;
    private XSSFWorkbook wb;
    private FileInputStream fis;

    @BeforeMethod
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver-2");
        driver = new ChromeDriver();
        driver.get(URL.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @Test
    public void singleContactForm() throws InterruptedException {
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

            //Ovo resenje je pesacko, izbeci
            Assert.assertEquals("alert alert-success", ContactUs.messageStatus(driver).getAttribute("class"));
//            System.out.println("Greska u redu "+(i + 2)); //ODKOMENTARISATI dok se ne isprave sve greske

            //Sledece resenje je malo lepse, ali ne prolazi
//            try{
//                Assert.assertEquals(URL.successMessageTitle, driver.getTitle());
//            } catch (AssertionError e){
//                System.out.println("Greska u redu "+(i + 1));
//                continue; //Bez ovog reda test prolazi, ali prijavljuje greske
//            }

            driver.navigate().back();
        }
    }

    @AfterMethod
    public void closePage() {
        driver.close();
    }

}
