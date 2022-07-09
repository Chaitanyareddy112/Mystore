package com.mystore.utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mystore.actiondriver.Action;
import com.mystore.basepage.TestBase;


public class ListenerClass extends Extentmanager implements ITestListener {

	Action action= new Action();
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	test.createNode(result.getName());
	}

	public void onTestSuccess(ITestResult result1) {
		if (result1.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Pass Test case is: " + result1.getName());
		}
	}

	public void onTestFailure(ITestResult result2) {
		if (result2.getStatus() == ITestResult.FAILURE) {
			try {
				test.log(Status.FAIL,
						MarkupHelper.createLabel(result2.getName() + " - Test Case Failed", ExtentColor.RED));
				test.log(Status.FAIL,
						MarkupHelper.createLabel(result2.getThrowable() + " - Test Case Failed", ExtentColor.RED));
				String imgPath = action.screenShot(TestBase.driver, result2.getName());
			
				test.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult result3) {
		if (result3.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test case is: " + result3.getName());
		}
	}

	/*public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}*/
}