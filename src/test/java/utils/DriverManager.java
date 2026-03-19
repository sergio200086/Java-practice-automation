package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private final WebDriver webDriver;

    public DriverManager(String url){
        this.webDriver = new ChromeDriver();
        this.webDriver.get(url);
    }

    public WebDriver getWebDriver (){
        return this.webDriver;
    }

    public void quitDriver(){
        this.webDriver.quit();
    }
}
