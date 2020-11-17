package homeWorkWeek10NopCommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GiftCards extends BaseNopCom {
    String baseUrl = "https://demo.nopcommerce.com/";
    WebElement giftCardsLink, giftCardMessage;
    @Before
    public void setUp(){
        openMyBrowser(baseUrl);
    }
    @After
    public void closeSetUp(){
        closeMyBrowser();
    }
    @Test
    public void giftCardMessage() throws InterruptedException {
        giftCardsLink = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/gift-cards']"));
        giftCardsLink.click();
        Thread.sleep(2000);

        giftCardMessage = driver.findElement(By.xpath("//h1[contains(text(),'Gift Cards')]"));
        String actualResult = "Gift Cards";
        String expectedResult = giftCardMessage.getText();

        Assert.assertEquals(actualResult,expectedResult);
    }

}
