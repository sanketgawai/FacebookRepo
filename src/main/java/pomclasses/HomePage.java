package pomclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	@FindBy(xpath="//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='pass']")
	private WebElement password;
	
	@FindBy(xpath="//button[text()='Log in']")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[text()='Find your account and log in.']/parent::div")
	private WebElement errorMessage;
	
	@FindBy(xpath="//a[text()='Create new account']")
	private WebElement createNewAccount;
	
	
	public void sendEmail(String eml)
	{
		email.sendKeys(eml);
	}
	
	public void sendPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	
	public String getErrorMessage()
	{
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		return errorMessage.getText().split("Find")[0].trim();
	}
	
	public void clickOnCreateNewAccount()
	{
		wait.until(ExpectedConditions.visibilityOf(createNewAccount));
		createNewAccount.click();
	}
	
}
