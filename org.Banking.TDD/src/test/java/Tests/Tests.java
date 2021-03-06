package Tests;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageClasses.BankManagerLogin;
import PageClasses.LoginPage;
import Utilities.TestUtilites;


public class Tests 
{
	//properties
	public RemoteWebDriver driver;
	public WebDriverWait wait;
	public TestUtilites tu;
	public LoginPage lp;
	

	@BeforeClass
	public void setUp()
	{
		 tu=new TestUtilites();
		
	}
	@Test(priority=1)
	@Parameters({"browser"})
	public void launch(String bn) throws Exception
	{
		driver=tu.openBrowser(bn);
		wait=tu.defineWait(driver);
		String  url=tu.getPropertiesValueInFile("url");
		tu.launchSite(url);
		lp=new LoginPage(driver,wait);
		lp.clickCust();
	}
	@Test(priority=2)
	public void validateSelectDropDown() throws Exception 
	{
		Thread.sleep(2000);
		List<String> actual=lp.dropDrown();
		Reporter.log("actualValues of dropdown"+actual);
		List<String>expected=Arrays.asList("---Your Name---","Hermoine Granger","Harry Potter","Ron Weasly","Albus Dumbledore","Neville Longbottom");
		Reporter.log("Expectedvalues of dropdown"+expected);
		Assert.assertEquals(actual, expected,"Error in Dropdown options compare at model dropdown");
	}
	
}
