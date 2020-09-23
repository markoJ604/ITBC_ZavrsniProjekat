import Constants.URL;
import Pages.ContactUs;
import Pages.IndexPage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver-2");
        WebDriver driver = new ChromeDriver();
        driver.get(URL.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        XSSFWorkbook wb;
        FileInputStream fis;

        try {
            fis = new FileInputStream("ContactFormData.xlsx");
            wb = new XSSFWorkbook(fis);

            Sheet sheet = wb.getSheetAt(0);



            for(int i=1;i<31;i++){
                Row row = sheet.getRow(i);
                Cell subjectHeading = row.getCell(0);
                Cell email = row.getCell(1);
                Cell orderRef = row.getCell(2);
                Cell message = row.getCell(3);

                IndexPage.clickContactus(driver);
                ContactUs.selectSubjectHeading(driver,subjectHeading.toString());
                ContactUs.inputEmail(driver, email.toString());
                ContactUs.inputOrderRef(driver, orderRef.toString());
                ContactUs.inputMessageBody(driver, message.toString());
                ContactUs.clickSend(driver);
                Thread.sleep(1000);
                driver.navigate().back();

            }
//POSLE SVAKOG SENDA, UBACI @AFTERTEST METODU DA PROVERI DA LI JE USPESNO POSLATO


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
