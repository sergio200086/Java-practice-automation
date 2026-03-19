package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverManager;

public class LoginTest {

    public DriverManager driverManager;
    public WebDriver driver;

    @Before
    public void setUp(){
        driverManager = new DriverManager("https://the-internet.herokuapp.com/login");
        driver = driverManager.getWebDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin(){
        LoginPage login = new LoginPage(driver);
        login.enterUsrName("tomsmith");
        login.enterPassword("SuperSecretPassword!");
        login.clickLoginButton();
        var message = login.succesLogin();

        Assert.assertEquals("You logged into a secure area!\n" +"×", message);
    }

    @After
    public void tearDown(){
        if (driver != null){
            driverManager.quitDriver();
        }
    }


}
