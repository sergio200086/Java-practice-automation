package utils;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class DriverManager {

    private final WebDriver webDriver;

    public DriverManager(String url) throws URISyntaxException, MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        String gridUrl = System.getenv("SELENIUM_GRID_URL") != null ? System.getenv("SELENIUM_GRID_URL") : Dotenv.load().get("SELENIUM_GRID_URL");
        if (gridUrl != null){
            gridUrl = gridUrl.replaceAll("\\s+", "");
            this.webDriver = new RemoteWebDriver(new URI(gridUrl).toURL(), options);
        }
        else{
            this.webDriver = new ChromeDriver(options);
        }
        this.webDriver.get(url);
    }

    public WebDriver getWebDriver (){
        return this.webDriver;
    }

    public void quitDriver(){
        this.webDriver.quit();
    }
}
