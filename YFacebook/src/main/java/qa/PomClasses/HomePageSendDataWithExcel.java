package qa.PomClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageSendDataWithExcel {

	public WebDriver driver;
	Actions act;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="passContainer")
	private WebElement pass;
	
	public HomePageSendDataWithExcel(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	public void sendEmail()
	{
		email.sendKeys("kaido@gmail.com");
	}
	
	public void sendPass()
	{
		pass.sendKeys("kaido@empror");
	}
}
