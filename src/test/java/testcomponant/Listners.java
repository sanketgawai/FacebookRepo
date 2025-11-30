package testcomponant;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class Listners extends BaseTest implements ITestListener{
	
	ExtentTest test;
	ExtentReporterNG extentReporterNG = new ExtentReporterNG();
	ExtentReports extent = extentReporterNG.getReportObject();
	//*** when run parallel it not work bec test get override use ThreadLocal class same we use in browser open
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();//Thread safe
	
	 @Override
	    public void onTestStart(ITestResult result) {
	        System.out.println("start teset"+result.getName());
	        test =extent.createTest(result.getMethod().getMethodName());
	        extentTest.set(test);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        System.out.println("Test passed: " + result.getName());
	        extentTest.get().log(Status.PASS, "TestPass");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        System.out.println("Test failed: " + result.getName());
	        extentTest.get().fail(result.getThrowable());
	        try {
				//here it will check class from xml, getRealClass- it will go testclass, getField give that class driver
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e) {//***** Exception e this is generic exception no need other exception then this is parent of all exception 
			// TODO Auto-generated catch block
			e.printStackTrace();
			} 
			
			
			String filePath = null;
			try {
			filePath = getScreentShot(result.getMethod().getMethodName(),driver);
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			}
			
			extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());

	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("Test skipped: " + result.getName());
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    	
	    }

	    @Override
	    public void onTestFailedWithTimeout(ITestResult result) {
	        onTestFailure(result);
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        System.out.println("TestNG Suite started");
	    }
	    
	    @Override
	    public void onFinish(ITestContext context) {
	    	 System.out.println("All Tests Completed: " + context.getName());
	         extent.flush();
	    }
	    
	}

