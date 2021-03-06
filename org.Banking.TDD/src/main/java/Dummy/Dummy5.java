package Dummy;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy5 {

	public static void main(String[] args) throws Exception 
	{
		//OpenBrowser
		/*Scanner sc=new Scanner(System.in);
		String x=sc.nextLine();
		sc.close();*/
		String sRow = "0";
		 String sCol = "0";
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Bank Manager Login']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(),'Customers')]")).click();
		Thread.sleep(5000);
		FluentWait<ChromeDriver>w=new FluentWait<ChromeDriver>(driver);
		w.withTimeout(Duration.ofSeconds(50));
		w.pollingEvery(Duration.ofMillis(1000));
		
		/*
		s=s+e1.size();
		System.out.println(s);
		
		for(WebElement e:e1)
		{
			System.out.println(e.getText());
		}*/
		//Heading for columns
		List<WebElement>heading=driver.findElements(By.xpath("//td/child::a"));
		for(WebElement h:heading)
		{
			System.out.print(h.getText());
		}
		
		//get total number of row and test
		try
		{
			List<WebElement> e1=driver.findElements(By.xpath("//table/tbody/tr[@class='ng-scope']/td[@class='ng-binding']"));
			int s=0;
			s=s+e1.size();
			System.out.println(s);
			Thread.sleep(2000);
			System.out.println("Table Data is: ");
			for(int i=1;i<=s;i++)
			{
				System.out.println("Row number "+(i)+" is");
				
				for(int j=1;j<=3;j++)
				{
					String r=driver.findElement(By.xpath("//table/tbody/tr[@class='ng-scope']["+i+"]/td[@class='ng-binding']["+j+"]")).getText();
					System.out.println("Data at Cell with Row "+ (i) + " Column "+(j)+"is" +":"+r);
				}
				
			}
		}
		catch(NoSuchElementException ex)
		{
			
		}
	
		String acc=driver.findElement(By.xpath("(//tr/td)[4]")).getText();
		System.out.println(acc);
		
		List<WebElement>acc1=driver.findElements(By.xpath("(//td)/span[text()]"));
		for(int i=0;i<acc1.size();i++)
		{
			System.out.println(acc1.get(i).getText());
		}
		
		//dymanic scearch content 
		List<WebElement>elem=driver.findElements(By.xpath("//tbody/tr[@class='ng-scope']/td[@class='ng-binding']"));
		elem.size();
		WebElement x=driver.findElement(By.xpath("//input[@ng-model='searchCustomer']"));
		x.sendKeys("he");
		List<WebElement> search=driver.findElements(By.xpath("//table/tbody/tr/td[@class='ng-binding'][1]"));
		search.size();
		for(WebElement s:search)
		{
			System.out.println(s.getText());
		}
		/*List<WebElement> ro=driver.findElements(By.xpath("//tbody/tr[@class='ng-scope']"));
		int s=0;
		s=s+ro.size();
		System.out.println(s);
		for(WebElement e:ro)
		{
			System.out.println(e.getText());
		}*/
		ExpectedCondition<List<WebElement>>ec=ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//tbody/tr[@class='ng-scope']"),3);
		List<WebElement>rows=w.until(ec);
		int s=0;
		s=s+rows.size();
		System.out.println(s);
		for(WebElement e:rows)
		{
			System.out.println(e.getText());
		}
		List<WebElement> e=driver.findElements(By.xpath("//td[not(@class='ng-binding')]"));
		for(int i=0;i<=4;i++)
		{
			System.out.println(e.get(i).getText());
		}
		String x3=driver.findElement(By.xpath("//tbody/tr/td[@class='ng-binding']")).getText();
		System.out.println(x3);
	}
}
