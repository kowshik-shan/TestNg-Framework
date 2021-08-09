package testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import listeners.TestListeners;

@Listeners(TestListeners.class)
public class VerifyLoginFunctionality_KeyWord extends BaseTest {
	
	@Parameters({ "sBrowserName" })
	@BeforeTest
	public void setBrowser(String sBrowserName, ITestContext context) {
		System.out.println(sBrowserName);
		context.setAttribute("sBrowserName", sBrowserName);
	}
	
	@BeforeMethod
	public void CreateReport(Method sTestMethod) {
		test = extent.createTest(sTestMethod.getName());
	}
	
	@AfterMethod
	public void CloseDriver() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}


@Test
public void VerifyLoginErrorMessage_01(Method mName) throws IOException {
	
	SoftAssert sa = new SoftAssert();
	
	//driver = getDriver("Chrome");
	//driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
	//sa.assertEquals(driver.getTitle(), "Login | Salesforce");
	//(test).info("Application is launched");

	WebElement sUserName = driver.findElement(By.xpath(oDataUtils.ReadWebElementProperties("we.username.xpath")));
	if(oCommonUtilities.waitForElementVisible(sUserName)) {
		oCommonUtilities.enterText(sUserName, oDataUtils.ReadAccountsProperties("QAaccount.name"), "UserName");
	}
	sa.assertNotNull(sUserName.getText(), "nirmala.march21@abc.com");
	
	WebElement sPassword = driver.findElement(By.xpath(oDataUtils.ReadWebElementProperties("we.password.xpath")));
	sPassword.clear();
	sa.assertEquals(sPassword.getText(), "");

	WebElement sLogin = driver.findElement(By.xpath(oDataUtils.ReadWebElementProperties("we.login.xpath")));
	if(oCommonUtilities.waitForElementVisible(sLogin)) {
		oCommonUtilities.clickonElement(sLogin, "Login Button");
	}
	
	WebElement sError = driver.findElement(By.xpath(oDataUtils.ReadWebElementProperties("we.errormsg.xpath")));
	if(oCommonUtilities.waitForElementVisible(sError)) {
	sa.assertEquals(sError.getText(),oDataUtils.ReadAccountsProperties("login.errormsg"));
	}
	/*if(sError.getText().equals(oDataUtils.ReadAccountsProperties("login.errormsg"))) {
		test.pass(mName.getName()+ "passed");
	}else {
		test.fail(mName.getName()+ "failed");
		test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
	}*/
	sa.assertAll();

}


@Test
public void VerifyLoginToSalseForce_02(Method mName) throws IOException {
	
	SoftAssert sa = new SoftAssert();

	//driver = getDriver("Chrome");
	//driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
	//sa.assertEquals(driver.getTitle(), "Login | Salesforce");
	//(test).info("Application is launched");

	WebElement sUserName = driver.findElement(By.xpath(oDataUtils.ReadWebElementProperties("we.username.xpath")));
	if(oCommonUtilities.waitForElementVisible(sUserName)) {
		oCommonUtilities.enterText(sUserName, oDataUtils.ReadAccountsProperties("QAaccount.name"), "UserName");
	}
	sa.assertNotNull(sUserName.getText(), "nirmala.march21@abc.com");
	
	WebElement sPassword = driver.findElement(By.xpath(oDataUtils.ReadWebElementProperties("we.password.xpath")));
	if(oCommonUtilities.waitForElementVisible(sPassword)) {
		oCommonUtilities.enterText(sPassword, oDataUtils.ReadAccountsProperties("QAaccount.password"), "Password");
	}
	sa.assertNotNull(sPassword.getText(), "A12345!@");

	WebElement sLogin = driver.findElement(By.xpath(oDataUtils.ReadWebElementProperties("we.login.xpath")));
	if(oCommonUtilities.waitForElementVisible(sLogin)) {
		oCommonUtilities.clickonElement(sLogin, "Login Button");
	}
	
	sa.assertEquals(driver.getCurrentUrl(),oDataUtils.ReadPageURLProperties("SalseForce.HomePage") );

	
	/*if(driver.getCurrentUrl().equals(oDataUtils.ReadPageURLProperties("SalseForce.HomePage"))) {
		test.pass(mName.getName() +"passed");
	}else {
		test.fail(mName.getName()+"failed");
		test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
	}*/
	sa.assertAll();

}

}
