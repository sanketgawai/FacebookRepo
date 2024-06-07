package qa.utility;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport()  {
	
		ExtentReports extentsReport = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialNinja Test Automation");
		sparkReporter.config().setDocumentTitle("Automation Doc Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentsReport.attachReporter(sparkReporter);
		
		extentsReport.setSystemInfo("Application URL", "https://www.facebook.com/");
		extentsReport.setSystemInfo("Operation System", System.getProperty("os.name"));
		extentsReport.setSystemInfo("UserName", System.getProperty("user.name"));
		extentsReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return extentsReport;
	}
		
}
