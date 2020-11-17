package homeWorkWeek10NopCommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//
public class LoginFunctionalityFailed extends BaseNopCom {
    // declared string static
    String baseUrl = "https://demo.nopcommerce.com/";

    // Opens Url
    @Before
    public void setUp (){
    openMyBrowser(baseUrl);

    }
// closes the website called method from Base Class
   @After
    public void setUpClose() {
       closeMyBrowser();
   }
// This block show the functionality if the login is unsuccessful
   @Test
    public void loginUsingInvalidCredentials() throws InterruptedException {
        // assigned Xpath to loginlink using findElement
       WebElement loginLink = driver.findElement(By.linkText("Log in"));
       // clicks button
       loginLink.click();
       // Holds the process for 20 Seconds for execution
       Thread.sleep(2000);
      //
       WebElement emailField = driver.findElement(By.id("Email"));
       emailField.click();

       emailField.sendKeys("johnsmith1@gmail.com");

       WebElement passwordField = driver.findElement(By.name("Password"));
       passwordField.click();

       passwordField.sendKeys("abcd1234");

       WebElement loginBtnClick = driver.findElement(By.xpath("//input[@value='Log in']"));
       loginBtnClick.click();

       WebElement errorMessage = driver.findElement(By.xpath("//div[@class = 'message-error validation-summary-errors']"));
       String actualMessage = errorMessage.getText();

       String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
               "No customer account found";

       Assert.assertEquals(expectedMessage,actualMessage);


    }

}
