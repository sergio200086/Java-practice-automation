package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    private final WebDriver webDriver;

    public DriverManager(String url){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        this.webDriver = new ChromeDriver(options);
        this.webDriver.get(url);
    }

    public WebDriver getWebDriver (){
        return this.webDriver;
    }

    public void quitDriver(){
        this.webDriver.quit();
    }
}
