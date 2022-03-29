package Automation.pageObjects;


import Automation.reports.extentReport;
import Automation.webPageObjects.*;
import Automation.webUtilities.RandomPhoneNumberGenerator;
import Automation.webUtilities.webActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;


public class webFunctions extends webActions{

    public extentReport report = new extentReport();

    public void NavigateToCareers(WebDriver driver, ExtentTest node){
        ilabCareers career = new ilabCareers(driver);

        try{

            clickObject(career.career_button, driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void Location(WebDriver driver) {
        selectLocation loc = new selectLocation(driver);

        try{
            clickObject(loc.location_button, driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SelectFirstHyperLink(WebDriver driver){
        selectHyperLink hyper_link = new selectHyperLink(driver);

        try{

            clickObject(hyper_link.hyperlink_button, driver);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ApplyOnline(WebDriver driver){
        selectApply apply = new selectApply(driver);

        try{

            clickObject(apply.applOnline_btn, driver);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void FillInFields(WebDriver driver, ExtentTest node, String YourName, String Email, String WhyIlab) {
        FillingForm fill = new FillingForm(driver);

        try {
            passData(fill.name, driver, YourName);
            passData(fill.email, driver, Email);
            passData(fill.contact, driver, RandomPhoneNumberGenerator.RandomGenerator());
            passData(fill.why_iLAB, driver, WhyIlab);

            clickObject(fill.submit, driver);
            String filename = report.CaptureScreenShot(driver);

            //validation of uploading files
            if (fill.validate_text.isDisplayed()) {
                node.pass("Error message displayed", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());

            } else {
                node.fail("Error message is not displayed",  MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());

            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
