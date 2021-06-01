package base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.HTMLReporter;

import Pages.UserMenupage;
import Pages.loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.AppConstants;
import utilities.CommonUtilities;
import utilities.DataUtilities;

public class BaseTest {

	public static String sReportTime;
	public static WebDriver driver;
	public static ExtentReports extent = null;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentTest test = null;
	public static Properties sProperties;
	public String sBrowserName;
	public CommonUtilities oCommonUtilities = new CommonUtilities();
	public DataUtilities oDataUtils = new DataUtilities();
	public static Method mName;
	
	public SoftAssert sa = new SoftAssert();

	
	
/*	@BeforeSuite
	public void setup() {
		Initializereports();
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}*/

	public void Initializereports() {
		sReportTime = new SimpleDateFormat("yyyymmddhhmm").format(new Date());
		extent = new ExtentReports();
		htmlreporter = new ExtentHtmlReporter(AppConstants.EXTENT_HTML_REPORT_PATH +"\\" +sReportTime +".html");
		extent.attachReporter(htmlreporter );
				
	}

	public WebDriver getDriver(String BrowserName) {
		sBrowserName = BrowserName.toLowerCase();
		switch (sBrowserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		 break;
		case "ie":
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
			 break;
			 default:
				 driver = null;
		}
		return driver;
	}
	
	public void LoginPage(String brwsr) throws IOException {
		driver = getDriver(brwsr);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();
		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		(test).info("Application is launched");
	}
	
	public void LoginToSalseforce() throws IOException {
		loginpage lp = new loginpage(BaseTest.driver);
		if(oCommonUtilities.waitForElementVisible(lp.Username)) {
			oCommonUtilities.enterText(lp.Username, oDataUtils.ReadAccountsProperties("QAaccount.name"), "UserName");
		}
		if(oCommonUtilities.waitForElementVisible(lp.Password)) {
			oCommonUtilities.enterText(lp.Password, oDataUtils.ReadAccountsProperties("QAaccount.password"), "Password");
		}
		if(oCommonUtilities.waitForElementVisible(lp.Login)) {
			oCommonUtilities.clickonElement(lp.Login, "Login Button");
		}
		sa.assertEquals(driver.getCurrentUrl(),oDataUtils.ReadPageURLProperties("SalseForce.HomePage") );
	}

	public void verifyUsermenu(String ElementXpath) throws IOException {
		UserMenupage ump = new UserMenupage(BaseTest.driver);
		List<WebElement> userMenuItems = BaseTest.driver.findElements(By.xpath("ump.Usermenu"));
		String[] ExpectedmenuItems = { "My Profile", "My Settings", "Developer Console",
				"Switch to Lightning Experience", "Logout" };

		for (int i = 0; i < userMenuItems.size(); i++) {
			sa.assertEquals(userMenuItems.get(i).getText(), ExpectedmenuItems[i]);
		test.info(ExpectedmenuItems[i] + " is Verified");	
		}
	}
	
	public boolean waitForElementVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void enterText(WebElement element, String textToEnter, String elementName) {
		if (element.isDisplayed()) {
			element.sendKeys(textToEnter);
			test.info(elementName + " is entered");
		} else
			test.fail( elementName + " is not displayed");
	}
	
	public void clickonElement(WebElement element, String elementName) {

		element.click();
		test.info( elementName + " is clicked");
	}
	
	public  void SwitchWindow() {
		String getWindow = driver.getWindowHandle();
		driver.switchTo().window(getWindow);
		System.out.println("Switched to new window");
	}
	
	public  void SwitchToiFrame(WebElement element) {
		driver.switchTo().frame(element);
		System.out.println("Switched to iframe");
	}
	
	public  void SelectByText(WebElement ele, String objName) {
		System.out.println(objName);

		Select select = new Select(ele);
		select.selectByVisibleText(objName);
		test.info(objName + " is Selected");
	}

	public  void SelectByValue(WebElement ele, String value) {
		Select select = new Select(ele);
		select.selectByValue(value);
		test.info(value + " is selected");
	}
	
	public  void MouseOver(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		test.info("Mouseover on the element");
	}
	
}
