package Automation.webTests;

import Automation.data.data;
import Automation.pageObjects.webFunctions;
import Automation.reports.extentReport;
import Automation.webUtilities.DbConnection;
import Automation.webUtilities.webUtilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestApplication {

    public webUtilities web = new webUtilities();
    public webFunctions functions = new webFunctions();
    public DbConnection conn = new DbConnection();
    public extentReport repo = new extentReport();
    public ExtentReports reports;
    
    ResultSet FromData;


    String sUrl, sBrowser;

    @Parameters({"ilabURL", "Browser"})
    @BeforeTest
    public void init(String silabURL, String Browser) {
        sUrl = silabURL;
        sBrowser = Browser;

        web.setWebDriver(web.initializeWebDriver(sBrowser));
        reports = repo.initilizeExtentReporters("reports/test.html");

        FromData = conn.ConnectDb();

    }

    @Test
    public void ilabApplication() throws SQLException {
        ExtentTest test = reports.createTest("Test Application").assignAuthor("Tshifhiwa Sinugo");
        ExtentTest node = test.createNode("Test");

        try {
            while (FromData.next()){

                web.navigate(sUrl);
                functions.NavigateToCareers(webUtilities.getWebDriver(), node);
                functions.Location(webUtilities.getWebDriver());
                functions.SelectFirstHyperLink(webUtilities.getWebDriver());
                functions.ApplyOnline(webUtilities.getWebDriver());
                functions.FillInFields(web.getWebDriver(), node, FromData.getString("Name"), FromData.getString("EmailAddress"), FromData.getString("WhyiLAB"));


            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterTest
    public void tearDown() throws InterruptedException {

        webUtilities.getWebDriver().quit();
        reports.flush();

    }

}
