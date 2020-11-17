package homeWorkWeek10NopCommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BooksLinkClass extends BaseNopCom {
    String baseUrl = "https://demo.nopcommerce.com/";
    WebElement booksLink, bookMessage;

    @Before
    public void setUp(){
        openMyBrowser(baseUrl);
    }
    @After
    public void closeSetUp(){
        closeMyBrowser();
    }
    @Test
    public void booksMethod(){
        booksLink = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/books']"));
        booksLink.click();

        bookMessage = driver.findElement(By.xpath("//h1[contains(text(),'Books')]"));
        String actualMessage = "Books";
        String expectedMessage = bookMessage.getText();

        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
