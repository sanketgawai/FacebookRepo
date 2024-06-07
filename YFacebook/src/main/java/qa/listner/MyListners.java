package qa.listner;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import qa.utility.ExtentReporter;

public class MyListners implements ITestListener {

	ExtentReports extentReport;
	ExtentTest extentTest;
	
	public void onStart(ITestContext context) {
		
		//ExtentReports extentReport = ExtentReporter.generateExtentReport();
		extentReport = ExtentReporter.generateExtentReport();
	}
	
	public void onTestStart(ITestResult result) {
		
		//extentTest = extentReport.createTest(result.getName());
		//extentTest.log(Status.INFO, result.getName()+" started execution");
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS, result.getName()+" got sucessfull executed");
	}

	/*public void onTestFailure(ITestResult result) {
		
		WebDriver driver =null;
		
			try {
				driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchFieldException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 	
	
		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"\\Screenshots\\" +result.getName()+".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentTest.addScreenCaptureFromPath(dest.getAbsolutePath());//it return pathname in string
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName());
	}*/
	
	public void onTestFailure(ITestResult result) {
	    WebDriver driver = null;
	    
	    try {
	        driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    if (driver != null) {
	        TakesScreenshot t = (TakesScreenshot) driver;
	        File src = t.getScreenshotAs(OutputType.FILE);
	        String screenshotDir = System.getProperty("user.dir") + File.separator + "Screenshots";
	        File dest = new File(screenshotDir, result.getName() + ".png");
	        
	        try {
	            Files.createDirectories(Paths.get(screenshotDir));
	            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
	            extentTest.addScreenCaptureFromPath(dest.getAbsolutePath());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    extentTest.log(Status.INFO, result.getThrowable());
	    extentTest.log(Status.FAIL, result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName()+"got skipped");
	}
	
	public void onFinish(ITestContext context) {
		extentReport.flush();
		
		//***** below code for auto logic for extent report 
				String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
				File extentReport = new File(pathOfExtentReport);//path of extent report 
				try {
					Desktop.getDesktop().browse(extentReport.toURI());
				} catch (IOException e) {
					e.printStackTrace();
				}
		
	}

}
