package webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrashWebElements {
    public WebDriver driver;
    public TrashWebElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String trashTabString = "//div[@id='root']//li[text()='Trash']";
    @FindBy(xpath = "//div[@id='root']//li[text()='Trash']")
    public WebElement trashButton;

    @FindBy(css = "tbody tr:first-child td:last-child div svg:last-child")
    public WebElement removeTrashCan;

    @FindBy(css = "tbody tr:first-child td:last-child div svg:first-child")
    public WebElement restoreRemovedRecord;
}
