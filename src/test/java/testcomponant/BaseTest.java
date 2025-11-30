package testcomponant;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

public class BaseTest {

	WebDriver driver;
	public WebDriver initializeBrowser() throws IOException
	{
		String browserName = "chrome";
		
		Properties prop = new Properties();
		//File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\GlobalData.properties");
		FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\GlobalData.properties"));
		prop.load(fis);
		
		if(prop.getProperty("browserName").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browserName").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
			
		}
		else if(prop.getProperty("browserName").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public void openApplcation()
	{
		driver.get("https://www.facebook.com/");
	}
	
	public String getScreentShot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot t =(TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"//report//"+testCaseName+".png");
		FileUtils.copyFile(src, dest);
		return System.getProperty("user.dir")+"//report//"+testCaseName+".png";
	}
	
}
