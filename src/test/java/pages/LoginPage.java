package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final By userName = By.xpath("//input[@id='username']");
    private final By password = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//*[@id='login']/button");
    private final By succesfulLogin = By.xpath("//div[@id='flash']");
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(10));
    }

    public void enterUsrName(String usrName){
        wait.until(d->d.findElement(userName).isDisplayed());
        webDriver.findElement(userName).sendKeys(usrName);
    }

    public void enterPassword(String passwordLogin){
        wait.until(d->d.findElement(password).isDisplayed());
        webDriver.findElement(password).sendKeys(passwordLogin);
    }

    public void clickLoginButton(){
        wait.until(d->d.findElement(loginButton).isDisplayed());
        webDriver.findElement(loginButton).click();
    }

    public String succesLogin(){
        wait.until(d->d.findElement(succesfulLogin).isDisplayed());
        return  webDriver.findElement(succesfulLogin).getText();
    }

}
