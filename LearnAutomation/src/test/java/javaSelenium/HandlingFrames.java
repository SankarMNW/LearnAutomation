package javaSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/frame");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Best example of Method Overloading in selenium is frame(); because we can pass the argument as index value or name/id or webelement.
		
		
		// if we need to access the iframe elements used to switchTo() method using index value, name, or webelement
		driver.switchTo().frame("firstFr"); // using name
		driver.findElement(By.name("fname")).sendKeys("Sankar");
		driver.findElement(By.name("lname")).sendKeys("S");
		
		//switch to frame inside frame using xpath element
		WebElement innerIFrame = driver.findElement(By.xpath("//iframe[@src='innerFrame']"));
		driver.switchTo().frame(innerIFrame);
		driver.findElement(By.name("email")).sendKeys("sankar@gmail.com");
		
		// if need to back to the parent frame use parentFrame() method
		driver.switchTo().parentFrame();
		driver.findElement(By.name("lname")).clear();
		driver.findElement(By.name("lname")).sendKeys("Selvaraj");
		
		//if need to back to the all the frames to main content use defaultContent() method
		driver.switchTo().defaultContent();
		// click the Watch Tutorial button in main page
		driver.findElement(By.xpath("//a[text()='Watch tutorial']")).click();
		
		
		Thread.sleep(5000);
		driver.quit();
	
	}

}
