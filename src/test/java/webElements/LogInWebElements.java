package webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInWebElements {
    public WebDriver driver;
    public LogInWebElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@autocomplete='username']")
    public WebElement logInUserNameInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement logInPasswordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginSubmitBtn;

    @FindBy(xpath = "//div[contains(@class, 'MuiAlert-message')]//p")
    public WebElement errorLoginAlert;

    @FindBy(xpath = "//div[@id='mui-component-select-language']")
    public WebElement languageDropDown;

    @FindBy(xpath = "//div[@id='menu-language']//ul")
    public WebElement languageUl;

    @FindBy(xpath = "//form//div[contains(@class, 'sc-bjfHbI')][1]//p[contains(@class, 'MuiFormHelperText')]//span")
    public WebElement requiredEmailError;

    @FindBy(xpath = "//form//div[contains(@class, 'sc-bjfHbI')][2]//p[contains(@class, 'MuiFormHelperText')]//span")
    public WebElement requiredPasswordError;

    @FindBy(xpath = "//nav//a[1]//li")
    public WebElement firstNavLink;

    @FindBy(xpath = "//form//button[text()='Forgot password ?']")
    public WebElement forgotPassLink;

    @FindBy(xpath = "//div[@id='modal']//form//input")
    public WebElement forgotPassInputEmail;

    @FindBy(xpath = "//div[@id='modal']//form//button[text()='Submit']")
    public WebElement forgotPassSubmitBtn;

    @FindBy(xpath = "//div[@id='modal']//form//label")
    public WebElement forgotPassInputLabel;

    @FindBy(css = "header svg.jam")
    public WebElement homeLanguageChangeBtn;

    @FindBy(css = "div.MuiPaper-root.MuiPaper-elevation[style*='opacity: 1'] ul.MuiList-root")
    public WebElement homeLanguageDropDown;

    @FindBy(xpath = "//header//p[text()='Administrator']")
    public WebElement administratorBtnPath;

    @FindBy(css = "div.MuiPaper-root.MuiPaper-elevation[style*='opacity: 1'] ul.MuiList-root li")
    public WebElement logOutButton;

    @FindBy(xpath = "//div[contains(@class, 'MuiModal-root')]")
    public  WebElement confirmCancelModal;
//    @FindBy(xpath = "//div[contains(@class, 'MuiModal-root')]//button[text()='Cancel']")
//    public WebElement cancelLogoutButton;
//
//    @FindBy(xpath = "//div[contains(@class, 'MuiModal-root')]//button[text()='Log out']")
//    public WebElement confirmLogOutButton;
}
