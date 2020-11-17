package homeWorkWeek10NopCommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ComputerClass extends BaseNopCom {

    String baseUrl = "https://demo.nopcommerce.com/";
    WebElement computerLink, message, desktopLink, deskText;
    @Before
    public void setUp() {
        openMyBrowser(baseUrl);
    }
    @After
    public void closeBrowser() {
        closeMyBrowser();
    }
    @Test
    public void testComputerLink() throws InterruptedException {
        computerLink = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]"));
        computerLink.click();
        Thread.sleep(2000);

        message = driver.findElement(By.xpath("//h1[contains(text(),'Computers')]"));
        String actualMessage = message.getText();
        String expectedMessage = "Computers";
        Assert.assertEquals(expectedMessage, actualMessage);



    }
    @Test
    public void abc () throws InterruptedException {
        testComputerLink();
        desktopLink = driver.findElement(By.xpath("//h2[@class='title']//a[contains(text(),'Desktops')]"));
        desktopLink.click();
        Thread.sleep(2000);

        deskText = driver.findElement(By.xpath("//h1[contains(text(),'Desktops')]"));
        String actualText = deskText.getText();
        String expectedText = "Desktops";
        Assert.assertEquals(actualText, expectedText);


    }


}

