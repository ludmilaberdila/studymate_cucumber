package steps;

import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import webElements.LogInWebElements;

public class HomeStepsDefinition {

    private WebDriver driver = null;
    private static Driver shareDriver;
    public static LogInWebElements logInElements;


    @Before
    public void initialization(){
        // will create new options and driver for every test case
        if(shareDriver == null){
            shareDriver = new Driver();
            shareDriver.setDriver();
        }
        driver = shareDriver.getDriver();
        if(driver == null){
            driver = shareDriver.getDriver();
        }
        logInElements = new LogInWebElements(driver);
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

    @Then("quit the driver")
    public void quit_driver(){
        shareDriver.quitDriver();
        driver = null;
    }

    @Given("user navigate to log in page {string}")
    public void navigate_to_login(String loginPage) throws InterruptedException {
        driver.get(loginPage);
        Thread.sleep(2000);
    }
    @Given("user fill email {string} and password {string} in the login form")
    public void input_username_and_password(String username, String password) {
        if(username.equals("-")){username = "";}
        if(password.equals("-")) {password = "";}
        logInElements.logInUserNameInput.sendKeys(username);
        logInElements.logInPasswordInput.sendKeys(password);
    }

    @When("user clicks on log in button")
    public void click_on_login() {
        logInElements.loginSubmitBtn.click();
    }

    @Then("user should be logged in on page {string}")
    public void user_is_logged_in(String langInPage) throws InterruptedException {
        Thread.sleep(2000);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(langInPage, actualUrl);
    }

    @Then("alert message should display {string}")
    public void compare_alert_message(String alertMsg) throws InterruptedException{
        if(!alertMsg.trim().equals("-")){
            WebElement alertPop = logInElements.errorLoginAlert;
            Thread.sleep(500);
            Assert.assertEquals(alertPop.getText(), alertMsg);
        }
    }

    @Given("user change language {string}")
    public void select_language(String language) throws InterruptedException {
       String liElement = "//li[contains(text(),'**')]".replace("**",language);
       logInElements.languageDropDown.click();
       logInElements.languageUl.findElement(By.xpath(liElement)).click();
    }

    @Then("username error should match {string} and password should match {string}")
    public void match_error_messages(String username_error_msg, String pass_error_msg){
        String requireEmailText = logInElements.requiredEmailError.getText();
        String requirePassText = logInElements.requiredPasswordError.getText();
        Assert.assertEquals(requireEmailText, username_error_msg);
        Assert.assertEquals(requirePassText, pass_error_msg);
    }

    @Then("check first nav link for language change, should contain {string}")
    public void check_language_change(String linkText) throws InterruptedException {
        Thread.sleep(3000);
        String firstLinkText = logInElements.firstNavLink.getText();
        Assert.assertEquals(linkText, firstLinkText);
    }

    @When("user click on forgot password link")
    public void clickForgotPass(){
        logInElements.forgotPassLink.click();
    }
    @Given("enter {string} email {string} to retrieve password")
    public void enterEmailForgotPassword(String correctIncorrect, String userEmail){
        if (userEmail.equals("-")) {userEmail = "";}
        logInElements.forgotPassInputEmail.sendKeys(userEmail);
    }
    @When("user click on submit on forgot password form")
    public void submitForgotPassForm(){
        logInElements.forgotPassSubmitBtn.click();
    }

    @Then("user should be redirected to page {string}")
    public void redirectedPage(String redirectedUrl) throws InterruptedException {
        Thread.sleep(1000);
        String currentPage = driver.getCurrentUrl();
        Assert.assertEquals(currentPage, redirectedUrl);
    }

    @When("user gets out of input by using tab")
    public void hitTabOutOfForgotPassInput(){
        logInElements.forgotPassInputEmail.sendKeys(Keys.TAB);
    }

    @Then("forgot password input form should have error class {string}")
    public void checkErrorClassName(String cssClassName){
        String className = logInElements.forgotPassInputLabel.getAttribute("class");
        Assert.assertTrue(className.contains(cssClassName));
    }

    @When("user change language from home page to {string}")
    public void changeLanguageFromHome(String toLanguage) throws InterruptedException {
        Thread.sleep(2000);
        logInElements.homeLanguageChangeBtn.click();
        String liSelector = "//li[text()='" + toLanguage + "']";
        logInElements.homeLanguageDropDown.findElement(By.xpath(liSelector)).click();
        Thread.sleep(1000);
    }

    @When("user clicks on log out button")
    public void clickOnLogOutButton() throws InterruptedException {
        Thread.sleep(2000);
        logInElements.administratorBtnPath.click();
        Thread.sleep(2000);
        logInElements.logOutButton.click();
    }

    @When("user select {string} button")
    public void confirmCancelButton(String confirm_cancel){
        String logoutOrCancel = "//button[text()='" + confirm_cancel +"']";
        logInElements.confirmCancelModal.findElement(By.xpath(logoutOrCancel)).click();
    }



}
