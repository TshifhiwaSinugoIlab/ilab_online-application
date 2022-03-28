package Automation.webUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webUtilities {

    protected static WebDriver driver;
    public static WebDriver getWebDriver(){
        return driver;
    }

    public void setWebDriver(WebDriver DriverTest){
        this.driver = DriverTest;
    }

    public WebDriver initializeWebDriver(String sBrowser) {
        switch (sBrowser.toUpperCase()) {

            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "IE":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }
    public  void navigate(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);

    }
}
