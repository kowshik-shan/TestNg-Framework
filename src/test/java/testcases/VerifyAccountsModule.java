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



import Pages.AccountsPage;
import Pages.UserMenupage;
import base.BaseTest;
import listeners.TestListeners;

@Listeners(TestListeners.class)
public class VerifyAccountsModule extends BaseTest {
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
	public void TC10_CreateAccount(Method mName) throws IOException, InterruptedException {
		SoftAssert sa = new SoftAssert();
		AccountsPage ap = new AccountsPage(BaseTest.driver);
		LoginToSalseforce();
		if (waitForElementVisible(ap.Account)) {
			clickonElement(ap.Account, "Account");
		}
		Thread.sleep(3000);
		sa.assertEquals(driver.getCurrentUrl(),oDataUtils.ReadPageURLProperties("SalseForce.AccountsPage") );
		//sa.assertEquals(ap.View.getText(),oDataUtils.ReadAccountsProperties("Accounts.View") );
		if (waitForElementVisible(ap.New)) {
			clickonElement(ap.New, "New");
		}
		sa.assertEquals(driver.getCurrentUrl(),oDataUtils.ReadPageURLProperties("SalseForce.NewAccountPage") );
		
		if (waitForElementVisible(ap.AccountName)) {
			enterText(ap.AccountName, oDataUtils.ReadAccountsProperties("AccountName"), "AccountName");
		}
		if (waitForElementVisible(ap.Save_Accounts)) {
			clickonElement(ap.Save_Accounts, "Save");
		}
		sa.assertEquals(ap.NewAccHeader.getText(),oDataUtils.ReadAccountsProperties("AccountName") );
	}
	@Test
	public void TC11_CreateNewView(Method mName) throws IOException, InterruptedException {
		SoftAssert sa = new SoftAssert();
		AccountsPage ap = new AccountsPage(BaseTest.driver);
		LoginToSalseforce();
		Thread.sleep(3000);
		if (waitForElementVisible(ap.Account)) {
			clickonElement(ap.Account, "Account");
		}
		sa.assertEquals(driver.getCurrentUrl(),oDataUtils.ReadPageURLProperties("SalseForce.AccountsPage") );
		sa.assertEquals(ap.View.getText(),oDataUtils.ReadAccountsProperties("Accounts.View") );
		
		Thread.sleep(3000); 
		if (waitForElementVisible(ap.NewView)) {
			clickonElement(ap.NewView, "NewView");
		}
		if (waitForElementVisible(ap.ViewName)) {
			enterText(ap.ViewName, oDataUtils.ReadAccountsProperties("Accounts.ViewName"), "ViewName");
		}
		if (waitForElementVisible(ap.ViewUniqueName)) {
			ap.ViewUniqueName.clear();
			enterText(ap.ViewUniqueName, oDataUtils.ReadAccountsProperties("Accounts.ViewName"), "ViewUniqueName");
		}
		if (waitForElementVisible(ap.Save_NewView)) {
			clickonElement(ap.Save_NewView, "Save");
		}
		sa.assertEquals(ap.NewViewAccName.getText(),oDataUtils.ReadAccountsProperties("Accounts.ViewName"));
	}
	
	@Test
	public void TC12_Editview(Method mName) throws IOException, InterruptedException {
		SoftAssert sa = new SoftAssert();
		AccountsPage ap = new AccountsPage(BaseTest.driver);
		LoginToSalseforce();
		sa.assertEquals(driver.getCurrentUrl(),oDataUtils.ReadPageURLProperties("SalseForce.HomePage") );
		sa.assertEquals(ap.Usermenu.getText(),oDataUtils.ReadAccountsProperties("MyProfile.name"));
		Thread.sleep(3000);
		if (waitForElementVisible(ap.Account)) {
			clickonElement(ap.Account, "Account");
		}
			sa.assertEquals(driver.getCurrentUrl(),oDataUtils.ReadPageURLProperties("SalseForce.AccountsPage") );
			Thread.sleep(2000);
			System.out.println("Enter to select tab");
			if (waitForElementVisible(ap.View)) {
				SelectByText(ap.View, oDataUtils.ReadAccountsProperties("Accounts.View"));
			}
			System.out.println("Viewname selected");
			if (waitForElementVisible(ap.Edit)) {
				clickonElement(ap.Edit, "Edit");
			}
			sa.assertEquals(driver.getCurrentUrl(),oDataUtils.ReadPageURLProperties("SalseForce.AccountsEditPage") );
			Thread.sleep(3000);
			if (waitForElementVisible(ap.ViewName)) {
				ap.ViewName.clear();
				enterText(ap.ViewName, oDataUtils.ReadAccountsProperties("Accounts.ViewName"), "ViewName");
			}
			if (waitForElementVisible(ap.Field)) {
				SelectByText(ap.Field, oDataUtils.ReadAccountsProperties("Accounts.FieldName"));
			}
			
			if (waitForElementVisible(ap.Operator)) {
				SelectByText(ap.Operator, oDataUtils.ReadAccountsProperties("Accounts.Operator"));
			}
			if (waitForElementVisible(ap.Value)) {
				ap.Value.clear();
				enterText(ap.Value, oDataUtils.ReadAccountsProperties("Accounts.Value"), "Value");
			}
			if (waitForElementVisible(ap.AvailableFields)) {
				SelectByText(ap.AvailableFields, oDataUtils.ReadAccountsProperties("Acc.AvailableFields"));
			}
			if (waitForElementVisible(ap.Add)) {
				clickonElement(ap.Add, "Add");
			}
			if (waitForElementVisible(ap.Save_EditView)) {
				clickonElement(ap.Save_EditView, "Save");
			}
			sa.assertEquals(ap.ViewBar.getText(),oDataUtils.ReadAccountsProperties("Accounts.ViewName"));
			sa.assertEquals(ap.LastActivity.getText(),oDataUtils.ReadAccountsProperties("Acc.AvailableFields") );
			
	}
			
			
			
		

}
