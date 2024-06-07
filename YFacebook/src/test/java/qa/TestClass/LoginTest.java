package qa.TestClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import qa.PomClasses.HomePage;
import qa.base.baseC;

public class LoginTest extends baseC{
//change in person1
	WebDriver driver;
	HomePage homePage;
	
	@BeforeTest
	public void openBrowser()
	{
		loadProperties();
		driver = initializeBrowser(prop.getProperty("browserName"));
	}
	
	@BeforeClass
	public void createPomClass()
	{
		homePage = new HomePage(driver);
	}
	@BeforeMethod
	public void getUrl()
	{
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	public void login()
	{
		homePage.sendEmail(prop.getProperty("email"));
		homePage.sendPass(prop.getProperty("pass"));
	}
	
//	@AfterMethod
//	public void afterMethod()
//	{
//		System.out.println("after Method");
//	}
//	
//	@AfterClass
//	public void afterClass()
//	{
//		System.out.println("after Class");
//		homePage=null;
//	}
//	
//	@AfterTest
//	public void afterTest()
//	{
//		System.out.println("after Test");
//		driver.quit();
//		System.gc();
//	}
	
}
/*WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.get("https://www.facebook.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
email.sendKeys("kaido@gmail.com");
WebElement pass =driver.findElement(By.xpath("//div[@id='passContainer']"));
Actions act = new Actions(driver);
act.moveToElement(pass).click().sendKeys("kaido@empror").build().perform();
String ema = email.getAttribute("aria-label");
System.out.println(ema);*/
