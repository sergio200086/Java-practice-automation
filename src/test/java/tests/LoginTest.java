package tests;

import io.qameta.allure.*;
import org.testng.annotations.*;
import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverManager;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class LoginTest {

    public DriverManager driverManager;
    public WebDriver driver;

    @BeforeMethod
    public void setUp() throws URISyntaxException, MalformedURLException {
        driverManager = new DriverManager("https://the-internet.herokuapp.com/login");
        driver = driverManager.getWebDriver();
        driver.manage().window().maximize();
    }

    @Test
    @Description("This test attempt to log into the website using a userName and a password. Fails if any error happens ")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Sergio Suárez")
    @Story("Login")
    public void testLogin(){
        LoginPage login = new LoginPage(driver);
        login.enterUsrName("tomsmith");
        login.enterPassword("SuperSecretPassword!");
        login.clickLoginButton();
        var message = login.succesLogin();
        Assert.assertTrue(message.contains("You logged into a secure area!"));
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driverManager.quitDriver();
        }
    }
}
