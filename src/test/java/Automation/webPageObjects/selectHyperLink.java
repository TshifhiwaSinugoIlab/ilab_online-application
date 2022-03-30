package Automation.webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class selectHyperLink {
    protected WebDriver driver;
    public selectHyperLink(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 10), this);
    }

    @FindBy(xpath = "(//a[@class ='wpjb-job_title wpjb-title' ])[1]")
    public WebElement hyperlink_button;
}
