package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponant.AbstractComp;

public class CreateAccount extends AbstractComp{

WebDriver driver;
	
	public CreateAccount(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
		
	}
	
	@FindBy(xpath="//div[text()='First name']/following-sibling::input")
	private WebElement firstName;
	
	@FindBy(xpath="//div[text()='Surname']/following-sibling::input")
	private WebElement surName;

	@FindBy(xpath="//select[@id='day']")
	private WebElement day;
	
	@FindBy(xpath="//select[@id='month']")
	private WebElement month;
	
	@FindBy(xpath="//select[@id='month']")
	private WebElement year;

	@FindBy(xpath="//label[text()='Male']/input")
	private WebElement maleRedioButton;
	
	@FindBy(xpath="(//div[contains(text(),'email address')])[1]")
	private WebElement email;		
			
	@FindBy(xpath="(//div[contains(text(),'New password')])[1]")
	private WebElement pass;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement signupButton;
	
	@FindBy(xpath="(//h2[text()='Enter the code from your email'])[2]")
	private WebElement messageAfterSubmit;
	public void sendFirstName(String nam)
	{
		firstName.sendKeys(nam);
	}
	
	public void sendsurName(String surNam)
	{
		surName.sendKeys(surNam);
	}
	
	public void selectDay(int dy)
	{
//		Select s = new Select(day);
//		s.selectByVisibleText(String.valueOf(dy));
		selectDropDown(day,String.valueOf(dy));
	}
	
	public void selectMonth(int month)
	{
		selectDropDown(day,String.valueOf(month));
	}
	
	public void selectYear(int year)
	{
		selectDropDown(day,String.valueOf(year));
	}
	
	public String sendNameGenderGmailPass(String name,String surNam,String eml,String pas)
	{
		firstName.sendKeys(name);
		surName.sendKeys(surNam);
		maleRedioButton.click();
		email.sendKeys(eml);
		pass.sendKeys(pas);
		signupButton.click();
		waitforWebElementToAppear(driver,messageAfterSubmit);
		return messageAfterSubmit.getText();
	}
}
