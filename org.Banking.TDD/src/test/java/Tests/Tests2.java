package Tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import PageClasses.BankManagerLogin;
import PageClasses.LoginPage;
import PageClasses.openaccount;
import Utilities.TestUtilites;


public class Tests2
{
	public RemoteWebDriver driver;
	public WebDriverWait wait;
	public TestUtilites tu;
	public BankManagerLogin bml;
	public openaccount op;
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
		bml=new BankManagerLogin(driver,wait);
		op=new openaccount(driver,wait);
	}  
	
	@Test(priority=3)
	@Parameters({"f","l","pin"})
	public void addCustomer(String fn,String ln,String pin) throws Exception
	{
			bml.blmClick();
			bml.custmer();
			bml.firstname(fn);
			bml.Lastname(ln);
			bml.code(pin);
			bml.custClick();
			bml.Notification();
	}
	@Test(priority=2)
	@Parameters({"fn1","ln1","pin1"})
	public void isBlankFields(String fn3,String ln3,String pin3)
	{   
		bml.blmClick();
		bml.custmer();
		if(fn3.length()==0 && ln3.length()==0 && pin3.length()==0)
		{
			if(bml.custClick())
			{
				Reporter.log("uid blank test passed");
				Assert.assertTrue(true);
			}
			else
			{
				Reporter.log("uid test failed");
				Assert.assertTrue(false);
			}
		}
	}
	@Test(priority=4)
	@Parameters({"fn2","ln2","pin2"})
	public void dropDrown(String fn1,String ln1,String pin2) throws Exception
	{	
		Thread.sleep(2000);
		bml.blmClick();
		bml.custmer();
		bml.firstname(fn1);
		bml.Lastname(ln1);
		bml.code(pin2);
		bml.custClick();
		Thread.sleep(8000);
		bml.Notification();
		Thread.sleep(5000);
		op.linkOpenaccount();
		op.customer();
		List<String> actual=op.dropDrown();
		Reporter.log("actual values of dropdown"+actual);
		List<String>expected=Arrays.asList("---Customer Name---","Hermoine Granger","Harry Potter","Ron Weasly","Albus Dumbledore","Neville Longbottom","praneetha mullapudi");
		Assert.assertEquals(actual, expected);
		Reporter.log("Test passed");
	} 
	@Test(priority=5)
	public void currenies() throws Exception
	{
		List<String> cur=op.Currency();
		Reporter.log("actualvalues of dropdown currency"+cur);
		List<String>expected=Arrays.asList("---Currency---","Dollar","Pound","Rupee");
		Assert.assertEquals(cur, expected);
	}
}
