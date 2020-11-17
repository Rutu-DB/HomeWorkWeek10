package homeWorkWeek10NopCommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JewelleryClass extends BaseNopCom {
    String baseUrl = "https://demo.nopcommerce.com/";
    WebElement jewelleryLink, jewelleryMessage;

    @Before
    public void setUp(){
        openMyBrowser(baseUrl);
    }
    @After
    public void closeSetUp(){
        closeMyBrowser();
    }
    @Test
    public void jewelleryLinkMethod(){

        jewelleryLink = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/jewelry']"));
        jewelleryLink.click();

        jewelleryMessage = driver.findElement(By.xpath("//h1[contains(text(),'Jewelry')]"));
        String actualMessage = "Jewelry";
        String expectedMessage = jewelleryMessage.getText();

        Assert.assertEquals(actualMessage,expectedMessage);
    }

}
