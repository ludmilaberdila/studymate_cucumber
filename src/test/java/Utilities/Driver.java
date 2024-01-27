package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {

    private static WebDriver driver = null;
    public String title = "";

    public void setDriver(){
        if (Driver.driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origin=*");
            driver = new ChromeDriver(options);
        }
    }

    public void quitDriver(){
        Driver.driver.quit();
        Driver.driver = null;
    }
    public WebDriver getDriver() {
        if(Driver.driver == null){
            setDriver();
        }
        return Driver.driver;
    }
}
