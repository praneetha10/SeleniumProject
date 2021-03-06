package Tests;

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
import PageClasses.customer;
import PageClasses.openaccount;
import Utilities.TestUtilites;

public class Test3 
{
	//Properties
	public RemoteWebDriver driver;
	public WebDriverWait wait;
	public TestUtilites tu;
	public openaccount op;
	public LoginPage lp;
	public customer cust;
	public BankManagerLogin bml;
	
	
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
		String url=tu.getPropertiesValueInFile("url");
		tu.launchSite(url);
		bml=new BankManagerLogin(driver,wait);
		cust=new customer(driver,wait);
		bml.blmClick();
		cust.clickCustomer();
	}
	@Test(priority=2)
	public void rowValues()
	{
		List<String> head=cust.getHeadings();
		{
			Reporter.log("test passed"+head);
		}
		int x=cust.getRowCount();
		{
			Reporter.log("test passed"+x);
		}
		List<String> a=cust.getRowText();
		{
			Reporter.log("test passed"+a);
		}
		int y=cust.getColumnSize();
		{
			Reporter.log("column size"+y);
		}
		List<String> actualcell=cust.getColumnText();
		{
			Reporter.log("test passed"+actualcell);
		}
	}
	@Test(priority=3)
	@Parameters({"x"})
	public void validation(String y)
	{
		List<String>n= cust.searchBox(y);
		Reporter.log("test passed"+ n);
	}
	@Test(priority=4)
	@Parameters({"fn1","ln1","pin"})
	public void validationDropDown(String fn1,String ln1, String pin) throws Exception
	{
		Thread.sleep(5000);
		bml.homeButton();
		bml.blmClick();
		bml.custmer();
		bml.firstname(fn1);
		bml.Lastname(ln1);
		bml.code(pin);
		bml.custClick();
		bml.Notification();
		Thread.sleep(2000);
		cust.clickCustomer();
		List<String> a=cust.value();
		Reporter.log("actual values"+a);
	    if(a.contains(fn1)&&a.contains(ln1))
	    {
	    	Reporter.log("test paased"+fn1);
	    }
	    else
	    {
	      Reporter.log("test failed");
	    	
	    }
	}
}
