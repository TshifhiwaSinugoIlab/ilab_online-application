package Automation.webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FillingForm {

    protected WebDriver driver;
    public FillingForm(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 10), this);
    }

    @FindBy(xpath = "//*[@id=\"applicant_name\"]")
    public WebElement name;

    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement email;

    @FindBy(xpath = "//*[@id=\"phone\"]")
    public WebElement contact;

    @FindBy(xpath = "//*[@id=\"message\"]")
    public WebElement why_iLAB;

    @FindBy(xpath = "//*[@id=\"wpjb_submit\"]")
    public WebElement submit;

    @FindBy(xpath = "//li[text()[contains(.,'You need to upload at least one file')]]")
    public WebElement validate_text;




}
