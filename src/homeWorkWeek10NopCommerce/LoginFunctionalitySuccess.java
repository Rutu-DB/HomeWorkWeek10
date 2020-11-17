package homeWorkWeek10NopCommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginFunctionalitySuccess extends BaseNopCom {

    // declared string static
    String baseUrl = "https://demo.nopcommerce.com/";


    // Opens Url
    @Before
    public void setUp(){
        openMyBrowser(baseUrl);

    }

    // Closes the Website
    @After
    public void closeWebsite(){
        closeMyBrowser();
    }

    // this blocks checks the functionality if thelogin is is successful.
    @Test
    public void loginUsingValidCredentials () throws InterruptedException {
        WebElement loginlink = driver.findElement(By.linkText("Log in"));
        loginlink.click();
        Thread.sleep(2000);

        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.click();

        emailField.sendKeys("dummytest@gmail.com");

        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.click();

        passwordField.sendKeys("123456");

        WebElement loginBtnClick = driver.findElement(By.xpath("//input[@value='Log in']"));
        loginBtnClick.click();

        WebElement loginMessage = driver.findElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        String actualMessage = loginMessage.getText();

        String expectedMessage = "Welcome to our store";

        Assert.assertEquals(expectedMessage,actualMessage);


    }



}
