package homeWorkWeek10NopCommerce;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DigitalDownloads extends BaseNopCom {

    String baseUrl = "https://demo.nopcommerce.com/";
    WebElement digitalLink,digitalMessage;

    @Before
    public void setup(){
        openMyBrowser(baseUrl);
    }
    @After
    public void closeSetUp(){
        closeMyBrowser();
    }

    @Test
    public void setDigitalDownloadLink(){
        digitalLink = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/digital-downloads']"));
        digitalLink.click();

        digitalMessage = driver.findElement(By.xpath("//h1[contains(text(),'Digital downloads')]"));
        String actualResult = "Digital downloads";
        String expectedResult = digitalMessage.getText();

    }


}
