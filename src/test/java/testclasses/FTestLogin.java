package testclasses;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pomclasses.HomePage;
import rhl.data.DataReader;
import testcomponant.BaseTest;

public class FTestLogin extends BaseTest {

	WebDriver driver;
	HomePage homePage;
	
	@Test(dataProvider="getData")
	public void checkLogin(HashMap<String,String> input) throws IOException
	{
		driver =initializeBrowser();
		openApplcation();
		homePage = new HomePage(driver);
		homePage.sendEmail(input.get("email"));
		homePage.sendPassword(input.get("password"));
		homePage.clickOnLoginButton();
		String errorMessage = homePage.getErrorMessage();
		System.out.println(errorMessage);
	}
	
	@DataProvider
	public Object [][] getData() throws IOException
	{
//		Object k [][]= {{"sanket.samtech@gmail.com","one piece"},{"rocks.samtech@gmail.com","nika"}};
//		return k;
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email", "sanket.samtech@gmail.com");
//		map1.put("pass", "one piece");
//		
//		HashMap<String,String> map2 = new HashMap<String,String>();
//		 map2.put("email","rocks.samtech@gmail.com");
//		 map2.put("pass","nika");
//		 return new Object [][] {{map1},{map2}};
		
		DataReader dataReader = new DataReader();
		List<HashMap<String,String>> data =
			    dataReader.getJsonData(System.getProperty("user.dir") + "\\src\\test\\java\\rhl\\data\\LoginCredential.json");
		return new Object [][] {{data.get(0)},{data.get(1)}};
	}
}
