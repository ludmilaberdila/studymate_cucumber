package steps;

import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElements.LogInWebElements;
import webElements.TrashWebElements;

import java.time.Duration;


public class TrashStepsDefinition {
    public static WebDriver driver = null;
    public static Wait<WebDriver> wait;
    private static Driver shareDriver;
    public static TrashWebElements trashElements;

    @Before
    public void initialization(){
        // will create new options and driver for every test case
        if(shareDriver == null){
            shareDriver = new Driver();
            shareDriver.setDriver();
        }
        if(driver == null){
            driver = shareDriver.getDriver();
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        trashElements = new TrashWebElements(driver);
    }
    @After
    public void afterFinishClassTest(){
        // will quit driver after finishing class testing
        if(driver != null){
            driver = null;
        }
        if(shareDriver.getDriver() != null){
            shareDriver.quitDriver();
        }
    }
    @When("wait for web element containing text {string}")
    public void wait_for_element(String text_content) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(trashElements.trashTabString)));
    }
    @When("user clicks on trash button")
    public void click_on_trash_tab() throws InterruptedException {
        Thread.sleep(1000);
        trashElements.trashButton.click();
    }
    @When("user clicks to {string} first record from trash list")
    public void remove_first_record(String remove_restore) throws InterruptedException {
        Thread.sleep(2000);
        if(remove_restore.trim().equals("remove")){trashElements.removeTrashCan.click();}
        if(remove_restore.trim().equals("restore")){trashElements.restoreRemovedRecord.click();}

    }

}
