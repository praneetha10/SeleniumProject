package Dummy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy3 {

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Bank Manager Login']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@ng-class='btnClass1']")).click();
		Thread.sleep(5000);
		
		WebElement e=driver.findElement(By.xpath("//button[text()='Add Customer']"));
		e.click();
		Screen s=new Screen();
		if(s.exists("\\src\\test\\resources\\Capture1.PNG")!=null)
		{
			System.out.println("test passed");
		}
		else
		{
			System.out.println("test failed");
		}
	}
	


}
