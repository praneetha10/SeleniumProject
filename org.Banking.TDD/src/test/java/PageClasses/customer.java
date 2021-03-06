package PageClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class customer
{
	//Properties
	private RemoteWebDriver driver;
	private WebDriverWait wait;
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Customers')]")
	private WebElement cust;
	@FindBy(how=How.XPATH,using="//table/tbody/tr[@class='ng-scope']/td[@class='ng-binding']")
	private WebElement table;
	@FindBy(how=How.XPATH,using="//input[@ng-model='searchCustomer']")
	private WebElement search;
	@FindBy(how=How.XPATH,using="//tbody/tr[@class='ng-scope']")
	private WebElement row;
	
	//Constructor method
	public customer(RemoteWebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		this.wait=wait;
	}
	
	//Operational method
	public void clickCustomer()
	{
		wait.until(ExpectedConditions.elementToBeClickable(cust)).click();
	}
	public List<String> getHeadings()
	{
		ExpectedCondition<List<WebElement>>ec=ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//td[not(@class='ng-binding')]"),1);
		List<WebElement>heading=wait.until(ec);
		List<String> l2=new ArrayList<String>();
		for(WebElement r:heading)
		{
			l2.add(r.getText());
		}
		return l2;
	}
	public int getRowCount()
	{
		ExpectedCondition<List<WebElement>>ec=ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr[@class='ng-scope']"),5);
		List<WebElement>rows=wait.until(ec);
		int s=0;
		s=s+rows.size();
		return s;
	}
	public List<String> getRowText()
	{
		ExpectedCondition<List<WebElement>>ec1=ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//tbody/tr[@class='ng-scope']"),3);
		List<WebElement>rows=wait.until(ec1);
		List<String> l1=new ArrayList<String>();
		for(WebElement e:rows)
		{
			l1.add(e.getText());
		}	
		return l1;
	}
	public int getColumnSize() 
	{
		List<WebElement> e1=driver.findElements(By.xpath("//table/tbody/tr[@class='ng-scope']/td[@class='ng-binding']"));
		int s=0;
		s=s+e1.size();
		return s;
	}
	public List<String> value()
	{
		List<WebElement> s3=driver.findElements(By.xpath("//tbody/tr/td[@class='ng-binding']"));
		int s=0;
		s=s+s3.size();
		List<String> actul=new ArrayList<String>();
		for(WebElement s2:s3)
		{
			actul.add(s2.getText());
		}
		
		return actul;
	} 
	
	public List<String> searchBox(String y)
	{
		List<WebElement>elem=driver.findElements(By.xpath("//tbody/tr[@class='ng-scope']/td[@class='ng-binding']"));
		elem.size();
		WebElement x=driver.findElement(By.xpath("//input[@ng-model='searchCustomer']"));
		x.sendKeys(y);
		List<WebElement> search=driver.findElements(By.xpath("//table/tbody/tr/td[@class='ng-binding'][1]"));
		search.size();
		List<String>l4=new ArrayList<String>();
		for(WebElement s:search)
		{
			l4.add(s.getText());
		}
		return l4;
	}
	public List<String> getColumnText()
	{
		List<String>l3=new ArrayList<String>();
		try
		{
			List<WebElement> e1=driver.findElements(By.xpath("//table/tbody/tr[@class='ng-scope']/td[@class='ng-binding']"));
			int s=0;
			s=s+e1.size();
			for(int i=1;i<=s;i++)
			{
				for(int j=1;j<=3;j++)
				{
					l3.add(driver.findElement(By.xpath("//table/tbody/tr[@class='ng-scope']["+i+"]/td[@class='ng-binding']["+j+"]")).getText());
				}
			}
			
		}
		catch(Exception ex)
		{
			
		}
		return l3;
	}
}
