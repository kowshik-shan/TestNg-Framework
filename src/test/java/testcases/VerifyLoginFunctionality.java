package testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.loginpage;
import base.BaseTest;
import listeners.TestListeners;

@Listeners(TestListeners.class)
public class VerifyLoginFunctionality extends BaseTest {
	

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
		sa.assertAll();
		Thread.sleep(3000);
		driver.close();
	}

	
@Test
public void VerifyLoginErrorMessage_01(Method mName) throws IOException {
	
	SoftAssert sa = new SoftAssert();
	loginpage lp = new loginpage(driver);
	
		if(waitForElementVisible(lp.Username)) {
		enterText(lp.Username, oDataUtils.ReadAccountsProperties("QAaccount.name"), "UserName");
	}
	sa.assertEquals(lp.Username.getText(),oDataUtils.ReadAccountsProperties("QAaccount.name") );
	
		lp.Password.clear();
	sa.assertEquals(lp.Password.getText(), "");


	if(waitForElementVisible(lp.Login)) {
		clickonElement(lp.Login, "Login Button");
	}
	
	if(waitForElementVisible(lp.Errormsg)) {
	sa.assertEquals(lp.Errormsg.getText(),oDataUtils.ReadAccountsProperties("login.errormsg"));
	}
	
}


@Test
public void VerifyLoginToSalseForce_02(Method mName) throws IOException {
	
	SoftAssert sa = new SoftAssert();
	loginpage lp = new loginpage(BaseTest.driver);

		if(waitForElementVisible(lp.Username)) {
		enterText(lp.Username, oDataUtils.ReadAccountsProperties("QAaccount.name"), "UserName");
	}
	sa.assertEquals(lp.Username.getText(),oDataUtils.ReadAccountsProperties("QAaccount.name") );
	
	if(waitForElementVisible(lp.Password)) {
		enterText(lp.Password, oDataUtils.ReadAccountsProperties("QAaccount.password"), "Password");
	}
	sa.assertEquals(lp.Password.getText(), oDataUtils.ReadAccountsProperties("QAaccount.password"));

	if(waitForElementVisible(lp.Login)) {
		clickonElement(lp.Login, "Login Button");
	}
	
	sa.assertEquals(driver.getCurrentUrl(),oDataUtils.ReadPageURLProperties("SalseForce.HomePage") );

}

@Test
public void VerifyCheckRememberMe_03(Method mName) throws IOException, InterruptedException {
	
	SoftAssert sa = new SoftAssert();
	loginpage lp = new loginpage(BaseTest.driver);
	if(waitForElementVisible(lp.Username)) {
	enterText(lp.Username, oDataUtils.ReadAccountsProperties("QAaccount.name"), "UserName");
	}
	sa.assertEquals(lp.Username.getText(),oDataUtils.ReadAccountsProperties("QAaccount.name") );
	
	if(waitForElementVisible(lp.Password)) {
		enterText(lp.Password, oDataUtils.ReadAccountsProperties("QAaccount.password"), "Password");
	}
	sa.assertEquals(lp.Password.getText(), oDataUtils.ReadAccountsProperties("QAaccount.password"));
	
	if(waitForElementVisible(lp.RememberMe)) {
		clickonElement(lp.RememberMe, "Remember Me");
	}
	
	if(waitForElementVisible(lp.Login)) {
		clickonElement(lp.Login, "Login Button");
	}
	sa.assertEquals(driver.getCurrentUrl(),oDataUtils.ReadPageURLProperties("SalseForce.HomePage") );
	
	if(waitForElementVisible(lp.Usermenu)) {
		clickonElement(lp.Usermenu, "Usermenu");
	}
	
	if(waitForElementVisible(lp.Logout)) {
	clickonElement(lp.Logout, "Logout");
	}
	Thread.sleep(3000);
	sa.assertEquals(driver.getCurrentUrl(),oDataUtils.ReadPageURLProperties("SalseForce.LoginPage") );
	sa.assertEquals(lp.Username.getText(),oDataUtils.ReadAccountsProperties("QAaccount.name") );
}

@Test
public void VerifyForgotPassword_04A(Method mName) throws IOException{
	SoftAssert sa = new SoftAssert();
	loginpage lp = new loginpage(BaseTest.driver);
	
	if(waitForElementVisible(lp.ForgotPassword)) {
		clickonElement(lp.ForgotPassword, "Forgot Password");
	}
	sa.assertEquals(driver.getCurrentUrl(),oDataUtils.ReadPageURLProperties("SalseForce.ForgotPassword") );
	if(waitForElementVisible(lp.Forgotusername)) {
		enterText(lp.Forgotusername, oDataUtils.ReadAccountsProperties("QAaccount.name"), "UserName");
	}
	if(waitForElementVisible(lp.Continue)) {
		clickonElement(lp.Continue, "Continue");
	}
	if(waitForElementVisible(lp.Header)) {
		sa.assertEquals(lp.Header.getText(),oDataUtils.ReadAccountsProperties("ForgotPassword.errormsg"));
		}	
}

@Test
public void VerifyForgotPassword_04B(Method mName) throws IOException{
	SoftAssert sa = new SoftAssert();
	loginpage lp = new loginpage(driver);
	
		if(waitForElementVisible(lp.Username)) {
		enterText(lp.Username, oDataUtils.ReadAccountsProperties("WrongUsername"), "UserName");
	}
		sa.assertNotEquals(lp.Username.getText(),oDataUtils.ReadAccountsProperties("QAaccount.name") );
	
	if(waitForElementVisible(lp.Password)) {
	enterText(lp.Password, oDataUtils.ReadAccountsProperties("WrongPassword"), "Password");
	}
	sa.assertNotEquals(lp.Password.getText(), oDataUtils.ReadAccountsProperties("QAaccount.password"));


	if(waitForElementVisible(lp.Login)) {
	clickonElement(lp.Login, "Login Button");
	}
	
	if(waitForElementVisible(lp.Error)) {
	sa.assertEquals(lp.Error.getText(),oDataUtils.ReadAccountsProperties("ErrorMsg"));
	}
}

}

