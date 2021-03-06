package testcases;

import java.io.IOException;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.UserMenupage;
import Pages.loginpage;
import base.BaseTest;
import listeners.TestListeners;

@Listeners(TestListeners.class)
public class VerifyUserMenuDropdown_POM extends BaseTest {

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
	public void TC05_HomePage(Method mName) throws IOException, InterruptedException {
		SoftAssert sa = new SoftAssert();
		UserMenupage ump = new UserMenupage(BaseTest.driver);
		LoginToSalseforce();
		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLProperties("SalseForce.HomePage"));
		if (waitForElementVisible(ump.Usermenu)) {
			clickonElement(ump.Usermenu, "UsermenuButton");
		}

		verifyUsermenu("ump.Usermenu");
		sa.assertAll();
	}

	@Test
	public void TC06_MyProfile(Method mName) throws IOException, InterruptedException {
		SoftAssert sa = new SoftAssert();
		UserMenupage ump = new UserMenupage(BaseTest.driver);
		LoginToSalseforce();
		Thread.sleep(3000);
		if (waitForElementVisible(ump.Usermenu)) {
			clickonElement(ump.Usermenu, "UsermenuButton");
		}
		if (waitForElementVisible(ump.MyProfile)) {
			clickonElement(ump.MyProfile, "MyProfile");
		}
		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLProperties("SalseForce.MyProfilePage"));
		Thread.sleep(3000);
		waitForElementVisible(ump.Contact);
		if (waitForElementVisible(ump.EditProfile)) {
			clickonElement(ump.EditProfile, "EditProfile");
		}
		SwitchWindow();
		Thread.sleep(3000);
		SwitchToiFrame(ump.iFrame);
		Thread.sleep(3000);
		if (waitForElementVisible(ump.AboutTab)) {
			clickonElement(ump.AboutTab, "AboutTab");
		}
		ump.Lastname.clear();
		if (waitForElementVisible(ump.Lastname)) {
			enterText(ump.Lastname, oDataUtils.ReadAccountsProperties("AboutTab.Lastname"), "Lastname");
		}
		if (waitForElementVisible(ump.SaveAll)) {
			clickonElement(ump.SaveAll, "SaveAll");
		}
		sa.assertEquals(ump.Header.getText().trim(), oDataUtils.ReadAccountsProperties("MyProfile.name").trim());

		if (waitForElementVisible(ump.Post)) {
			clickonElement(ump.Post, "Post");
		}

		SwitchToiFrame(ump.Post_iFrame);
		Thread.sleep(3000);
		if (waitForElementVisible(ump.Message)) {
			enterText(ump.Message, oDataUtils.ReadAccountsProperties("Post.Msg"), "Message");
		}
		driver.switchTo().defaultContent();
		if (waitForElementVisible(ump.Share)) {
			clickonElement(ump.Share, "Share");
		}

		Thread.sleep(3000);

		System.out.println("entered to assertion");
		sa.assertEquals(ump.PostDisplay.getText(), oDataUtils.ReadAccountsProperties("Post.Msg"));
		System.out.println("Post Assertion is passed");

		Thread.sleep(3000);
		if (waitForElementVisible(ump.File)) {
			clickonElement(ump.File, "File");
		}
		if (waitForElementVisible(ump.Upload)) {
			clickonElement(ump.Upload, "Upload");
		}
		if (waitForElementVisible(ump.File_Choose)) {
			enterText(ump.File_Choose, oDataUtils.ReadAccountsProperties("Choose.File"), "File_Choose");
		}
		if (waitForElementVisible(ump.File_Share)) {
			clickonElement(ump.File_Share, "File_Share)");
		}

		System.out.println("Entered to file assertions");
		sa.assertEquals(ump.File_Post.getText(), oDataUtils.ReadAccountsProperties("File_Post"));
		System.out.println("File Assertion is passed");

		Thread.sleep(3000);

		if (waitForElementVisible(ump.Photo)) {
			MouseOver(ump.Photo);
		}
		if (waitForElementVisible(ump.AddPhotoLink)) {
			clickonElement(ump.AddPhotoLink, "AddPhotoLink");
		}
		SwitchWindow();
		SwitchToiFrame(ump.Photo_iFrame);
		if (waitForElementVisible(ump.Photo_Choose)) {
			enterText(ump.Photo_Choose, oDataUtils.ReadAccountsProperties("Choose.Photo"), "Photo_Choose");
		}
		if (waitForElementVisible(ump.Photo_Save)) {
			clickonElement(ump.Photo_Save, "Save");
		}
		if (waitForElementVisible(ump.Photo_Save1)) {
			clickonElement(ump.Photo_Save1, "Save");
		}
		if (waitForElementVisible(ump.AddPhotoLink)) {
			sa.assertEquals(ump.AddPhotoLink.getText(), oDataUtils.ReadAccountsProperties("Photo_Assertion"));
			System.out.println("Profile photo added");
		}
		sa.assertAll();
	}

	@Test
	public void TC07_MySettings(Method mName) throws IOException, InterruptedException {
		SoftAssert sa = new SoftAssert();
		UserMenupage ump = new UserMenupage(BaseTest.driver);
		Thread.sleep(3000);
		LoginToSalseforce();
		if (waitForElementVisible(ump.Usermenu)) {
			clickonElement(ump.Usermenu, "UsermenuButton");
		}
		if (waitForElementVisible(ump.MySettings)) {
			clickonElement(ump.MySettings, "MySettings");
		}
		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLProperties("SalseForce.MySettingPage"));
		if (waitForElementVisible(ump.Personal)) {
			clickonElement(ump.Personal, "Personal");
		}
		if (waitForElementVisible(ump.LoginHistory)) {
			clickonElement(ump.LoginHistory, "LoginHistory");
		}
		if (waitForElementVisible(ump.Download)) {
			clickonElement(ump.Download, "Download");
		}
		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLProperties("SalseForce.LoginHistoryPage"));
		if (waitForElementVisible(ump.Display)) {
			clickonElement(ump.Display, "Display");
		}
		if (waitForElementVisible(ump.MyTab)) {
			clickonElement(ump.MyTab, "MyTab");
		}
		if (waitForElementVisible(ump.CustomApp)) {
			SelectByText(ump.CustomApp, oDataUtils.ReadAccountsProperties("CustomApp.Settings"));
		}
		if (waitForElementVisible(ump.AvailableTabs)) {
			if (SelectByText(ump.AvailableTabs, oDataUtils.ReadAccountsProperties("AvailableTabs.Settings"))) {
				clickonElement(ump.Add_MyTabs, "Add");
				clickonElement(ump.Save_MyTabs, "Save");
				System.out.println("Reports Added");
			} else {
				if (waitForElementVisible(ump.Save_MyTabs)) {
					clickonElement(ump.Save_MyTabs, "Save");
					System.out.println("Save clicked");
				}
			}
				sa.assertEquals(ump.Reports.getText(), oDataUtils.ReadAccountsProperties("AvailableTabs.Settings"));
				Thread.sleep(3000);

				if (waitForElementVisible(ump.Email)) {
					clickonElement(ump.Email, "Email");
				}
				if (waitForElementVisible(ump.MyEmail)) {
					clickonElement(ump.MyEmail, "MyEmail");
				}
				if (waitForElementVisible(ump.EmailName)) {
					enterText(ump.EmailName, oDataUtils.ReadAccountsProperties("EmailName.Settings"), "EmailName");
				}
				if (waitForElementVisible(ump.EmailAddress)) {
					enterText(ump.EmailAddress, oDataUtils.ReadAccountsProperties("EmailAddress.Settings"),
							"EmailAdress");
				}
				if (waitForElementVisible(ump.RadioButton)) {
					clickonElement(ump.RadioButton, "RadioButton");
				}
				if (waitForElementVisible(ump.Save_MyEmail)) {
					clickonElement(ump.Save_MyEmail, "Save");
				}
				sa.assertEquals(ump.SuccessMsg.getText(), oDataUtils.ReadAccountsProperties("SuccessMsg.Email"));

				sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLProperties("SalseForce.MyEmailSetting"));

				if (waitForElementVisible(ump.Calendar)) {
					clickonElement(ump.Calendar, "Calendar");
				}
				if (waitForElementVisible(ump.Activity)) {
					clickonElement(ump.Activity, "Activity");
				}
				if (waitForElementVisible(ump.TestRemainder)) {
					clickonElement(ump.TestRemainder, "TestRemainder");
				}

				String MainWindow = driver.getWindowHandle();
				Set<String> s1 = driver.getWindowHandles();
				Iterator<String> i1 = s1.iterator();
				while (i1.hasNext()) {
					String ChildWindow = i1.next();
					if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
						driver.switchTo().window(ChildWindow);
						Thread.sleep(3000);
						sa.assertEquals(driver.getCurrentUrl(),
								oDataUtils.ReadPageURLProperties("SalseForce.TestRemainder"));
						driver.close();
					}
					driver.switchTo().window(MainWindow);
				}

				sa.assertAll();
			}
		}
	

	@Test
	public void TC08_DeveloperConsole(Method mName) throws IOException, InterruptedException {
		SoftAssert sa = new SoftAssert();
		UserMenupage ump = new UserMenupage(BaseTest.driver);
		LoginToSalseforce();
		if (waitForElementVisible(ump.Usermenu)) {
			clickonElement(ump.Usermenu, "UsermenuButton");
		}
		if (waitForElementVisible(ump.DeveloperConsole)) {
			clickonElement(ump.DeveloperConsole, "DeveloperConsole");
		}
		String MainWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				Thread.sleep(3000);
				sa.assertEquals(driver.getCurrentUrl(),
						oDataUtils.ReadPageURLProperties("SalseForce.DeveloperConsole"));
				driver.close();
			}
			driver.switchTo().window(MainWindow);
		}
		System.out.println(driver.getCurrentUrl());
		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLProperties("SalseForce.HomePage"));
		sa.assertAll();
	}

	@Test
	public void TC09_Logout(Method mName) throws IOException, InterruptedException {
		SoftAssert sa = new SoftAssert();
		UserMenupage ump = new UserMenupage(BaseTest.driver);
		LoginToSalseforce();
		if (waitForElementVisible(ump.Usermenu)) {
			clickonElement(ump.Usermenu, "UsermenuButton");
		}
		if (waitForElementVisible(ump.Logout)) {
			clickonElement(ump.Logout, "Logout");
		}
		Thread.sleep(3000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLProperties("SalseForce.LoginPage"));
		sa.assertAll();
	}
}
