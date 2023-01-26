package amazonTestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automationCore.baseClass;
import utilities.ExtentReportNG;

public class listners extends baseClass implements ITestListener  {
  ExtentTest test;
  ExtentReports extent =ExtentReportNG.getReportObject();
  ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
@Override
public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestStart(result);
	//to add field for each test
	test = extent.createTest(result.getMethod().getMethodName());
	extentTest.set(test);
}
@Override
public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestSuccess(result);
	extentTest.get().log(Status.PASS, "Test PASSED");
}
@Override
public void onTestFailure(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestFailure(result);
	extentTest.get().fail(result.getThrowable());
	String testMethodName = result.getMethod().getMethodName();
	
	try {
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		extentTest.get().addScreenCaptureFromPath(getScreenshotPath(testMethodName, driver), result.getMethod().getMethodName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@Override
public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestSkipped(result);
	extentTest.get().log(Status.SKIP,"Test Case SKIPPED");
}
@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
}
@Override
public void onTestFailedWithTimeout(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestFailedWithTimeout(result);
}
@Override
public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	ITestListener.super.onStart(context);
}
@Override
public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	ITestListener.super.onFinish(context);
	extent.flush();
}
  
}
