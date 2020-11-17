package homeWorkWeek10NopCommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElectronicClass extends BaseNopCom{
    String baseUrl = "https://demo.nopcommerce.com/";
    WebElement electLink, elecMessage,camPhoto , camPhotoMessage;
    @Before
    public void setUp(){
        openMyBrowser(baseUrl);
    }
    @After
    public void closeBrowser(){
        closeMyBrowser();
    }

    @Test
    public void electronicLink (){
       electLink = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]"));
       electLink.click();

        elecMessage = driver.findElement(By.xpath("//h1[contains(text(),'Electronics')]"));
        String actMessage =elecMessage.getText();
        String expMessage = "Electronics";

        Assert.assertEquals(actMessage,expMessage);

    }
    @Test
    public void cameraPhoto() throws InterruptedException {
        electronicLink();
        camPhoto = driver.findElement(By.xpath("//div[@class = 'sub-category-item']//a[contains(text(),'Camera & photo')]"));
        camPhoto.click();
        Thread.sleep(2000);

        camPhotoMessage = driver.findElement(By.xpath("//h1[contains(text(),'Camera & photo')]"));
        String expectedcamPhotoresult = camPhotoMessage.getText();
        String actualcamPhotoresult = "Camera & photo";

        Assert.assertEquals(actualcamPhotoresult,expectedcamPhotoresult);

    }


}
