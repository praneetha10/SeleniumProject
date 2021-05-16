package Dummy;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy4 {

	public static void main(String[] args) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Bank Manager Login']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(),'Add Customer')]")).click();
		Thread.sleep(5000);
		WebElement fn=driver.findElement(By.xpath("//input[@ng-model='fName']"));
		fn.sendKeys("praneetha");
		Thread.sleep(5000);
		WebElement ln=driver.findElement(By.xpath("//input[@ng-model='lName']"));
		ln.sendKeys("mullapudi");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@ng-model='postCd']")).sendKeys("533346");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Add Customer']")).submit();
		Thread.sleep(5000);
		Screen s=new Screen();
		s.click("\\src\\test\\resources\\Capture.PNG");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(),'Open Account')]")).click();
		Thread.sleep(5000);
		
		WebElement e=driver.findElement(By.name("userSelect"));
		Select s1=new Select(e);
		List<WebElement>item=s1.getOptions();
		ArrayList<String>l1=new ArrayList<String>();
		for(int i=item.size();i>1;i--)
		{
			l1.add(item.get(i-1).getText());
		}
		System.out.println(l1);	
		/*List<String>p1=l1.subList(0,1);
		StringBuffer sb=new StringBuffer();
		for(String s6:p1)
		{
			sb.append(s6);
		}
		String str=sb.toString();
		System.out.println(str);
		String[] p6=str.split(" ");
		String fn1=p6[0];
		String ln1=p6[1];
		System.out.println(fn1);
		System.out.println(ln1);
		for(int i=0;i<l1.size();i++)
		{
			String x1=item.get(i+1).getText();
		}*/
			WebElement curr=driver.findElement(By.name("currency"));
			Select s4=new Select(curr);
			List<WebElement>s5=s4.getOptions();
			for(WebElement s6:s5)
			{
				System.out.println(s6.getText());
			}
			
			
		
	}

	
	
}
	
	


