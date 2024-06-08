package qa.TestClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.PomClasses.HomePage;
import qa.base.baseC;
import qa.utility.Utility;

public class LoginSendDataWithExcelTest extends baseC{
	//by master
	WebDriver driver = new ChromeDriver();
	public WebDriver driver;
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
	
	@Test(dataProvider="validCredential")
	public void login(String email, String password)
	{
		homePage.sendEmail(email);
		homePage.sendPass(password);
	}

	@DataProvider(name="validCredential")
	public Object [][] supplyTestData()
	{
		Object[][] data = Utility.getTestDataFromexcel("Login");
		return data;
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
	
}
