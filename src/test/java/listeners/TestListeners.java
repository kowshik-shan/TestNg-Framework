package listeners;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class TestListeners extends BaseTest implements ITestListener {
	String sBrowserName;
	
	@Override
	public void onTestStart(ITestResult result) {
		sBrowserName = result.getTestContext().getAttribute("sBrowserName").toString();
		System.out.println(sBrowserName);
		 try {
			LoginPage(sBrowserName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getTestName() + ": TEST PASSES");
		System.out.println("close report");
		test.pass(result.getName() + "is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getTestName() + ": TEST FAILED");
		test.fail(result.getName()+ "is failed");
		System.out.println(result.getThrowable().getMessage());
		System.out.println(result.getThrowable().getStackTrace());
	
		try {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case is skipped");
		test.skip(result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test case is failed");
		

	}

	@Override
	public void onStart(ITestContext context) {
		Initializereports();

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();

	}

}
