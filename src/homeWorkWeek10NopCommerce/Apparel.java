package homeWorkWeek10NopCommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Apparel extends BaseNopCom {

    public String baseUrl = "https://demo.nopcommerce.com/";
    WebElement apparelLink, apparelMessage, shoeLink, shoeMessage;

    @Before
    public void setUp() {
        openMyBrowser(baseUrl);
    }

    @After
    public void setupClose() {
        closeMyBrowser();
    }

    @Test
    public void apparelMethod() throws InterruptedException {
        apparelLink = driver.findElement(By.xpath("//div/ul[@class= 'top-menu notmobile']//a[contains(text(),'Apparel')]"));
        apparelLink.click();
        Thread.sleep(2000);

        apparelMessage = driver.findElement(By.xpath("//h1[contains(text(),'Apparel')]"));
        String actualMessage = "Apparel";
        String expectedMessage = apparelMessage.getText();

        Assert.assertEquals(actualMessage, expectedMessage);


    }

    @Test
    public void shoeMethod() throws InterruptedException {
        apparelMethod();
        shoeLink = driver.findElement(By.xpath("//div/h2[@class='title']//a[@href='/shoes']"));
        shoeLink.click();
        Thread.sleep(2000);

        shoeMessage = driver.findElement(By.xpath("//h1[contains(text(),'Shoes')]"));
        String actualResult = "Shoes";
        String expectedResult = shoeMessage.getText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
