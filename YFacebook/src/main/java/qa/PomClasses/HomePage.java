package qa.PomClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	Actions act;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="passContainer")
	private WebElement pass;
	
	public HomePage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
		js = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver,10);
	}
	
	public void sendEmail(String eml)
	{
		email.sendKeys(eml);//kaido@gmail.com
	}
	
	public void sendPass(String ps)
	{
		//pass.sendKeys("kaido@empror");
		act.moveToElement(pass).click().sendKeys(ps).build().perform();//kaido@empror
	}
}
