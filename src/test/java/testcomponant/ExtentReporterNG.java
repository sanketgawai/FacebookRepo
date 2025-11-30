package testcomponant;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	 private static ExtentReports extent;

	    public static ExtentReports getReportObject() {

	        if (extent == null) {
	            String path = System.getProperty("user.dir") + "/reports/index.html";

	            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	            reporter.config().setReportName("Automation Test Results");
	            reporter.config().setDocumentTitle("Test Report");

	            extent = new ExtentReports();
	            extent.attachReporter(reporter);
	            extent.setSystemInfo("Tester", "Your Name");
	        }

	        return extent;
	    }

	
}
