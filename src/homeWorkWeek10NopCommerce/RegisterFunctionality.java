package homeWorkWeek10NopCommerce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class RegisterFunctionality extends BaseNopCom {

    String baseUrl = "https://demo.nopcommerce.com/";
    WebElement registerLink, maleRadioBtn,femaleRadioBtn,dobDay,dobMonth,dobYear,firstName, lastName, email, companyField,newletterChkBox, password, confirmPassword, regButton, regMessage;

    @Before
    public void setUp() {
        openMyBrowser(baseUrl);

    }

    @After
    public void closeBrowser() {
        closeMyBrowser();

    }

    @Test
    public void registerFunctionalityUsingMandatoryFields() throws InterruptedException {
        registerLink = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        registerLink.click();

        Thread.sleep(2000);

        maleRadioBtn = driver.findElement(By.xpath("//label[contains(text(),'Male')]"));
        maleRadioBtn.click();

        femaleRadioBtn = driver.findElement(By.xpath("//input[@id='gender-female']"));
        femaleRadioBtn.click();


        firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.click();
        firstName.sendKeys("Alpha");

        lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.click();
        lastName.sendKeys("Beta");

        dobDay = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']//option[contains(text(),'11')]"));

        dobMonth = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']//option[contains(text(),'November')]"));

        dobYear =driver.findElement(By.xpath("//select[@name='DateOfBirthYear']//option[contains(text(),'2011')]"));


        email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.click();

        //Inbuilt Random method called and String concatinated to take auto generated email id
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        email.sendKeys("testemail" + randomInt + "@gmail.com");

        companyField = driver.findElement(By.xpath("//input[@id='Company']"));
        companyField.click();
        companyField.sendKeys("Abc Ltd.");

        newletterChkBox = driver.findElement(By.xpath("//input[@id='Newsletter']"));

        password = driver.findElement(By.xpath("//input[@id='Password']"));
        //password.click();
        password.sendKeys("123456");

        confirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        //confirmPassword.click();
        confirmPassword.sendKeys("123456");

        regButton = driver.findElement(By.xpath("//input[@id='register-button']"));
        regButton.click();

        regMessage = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String actualMessage = regMessage.getText();
        String expectedMessage = "Your registration completed";

        Assert.assertEquals(actualMessage, expectedMessage);
    }

}
