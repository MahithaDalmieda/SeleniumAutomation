package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extentReports;
    public ExtentTest logger;
    public static WebDriver driver;
    public static Properties properties;
    public static FileInputStream fileInputStream;

    @BeforeTest
    public void beforeTest() {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "testReport");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        sparkReporter.config().setTheme(Theme.DARK);
        extentReports.setSystemInfo("HostName", "RHELS");
        extentReports.setSystemInfo("UserName", "root");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Automation Test Results");

        try {
            properties = new Properties();
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @BeforeMethod
    // @Parameters("browser")
    public void initialiseDriver(Method testMethod) {
        logger = extentReports.createTest(testMethod.getName());
        setupDriver(properties.getProperty("browser"));
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test case Failed", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test case Failed", ExtentColor.RED));
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test case SKIPPED", ExtentColor.ORANGE));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " -  Test case PASSED", ExtentColor.GREEN));
        }
        driver.quit();
    }

    @AfterTest
    public void afterTest() {
        extentReports.flush();
    }

    public void setupDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
        }
    }

    public static void main(String[] args) {
        properties = new Properties();
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("prop : " + properties.getProperty("browser"));
    }

}
