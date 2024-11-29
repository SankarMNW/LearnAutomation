package javaSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {
	public static void main(String[] args)throws Throwable {
		// Handle the alerts
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/alert");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Simple alert
		driver.findElement(By.id("accept")).click();
		Alert alert = driver.switchTo().alert();
		// if you need to get alert box text
		System.out.println("Simple Alert text: "+alert.getText());
		alert.accept();
		
		// Confirm Alert
		driver.findElement(By.id("confirm")).click();
		driver.switchTo().alert();
		System.out.println("Confirm Alert text: "+alert.getText());
//		alert.accept();
		alert.dismiss();  // Need to click cancel button use dismiss()
		
		
		// Prompt Alert
		driver.findElement(By.id("prompt")).click();
		driver.switchTo().alert();
		System.out.println("Prompt Alert Text: "+alert.getText());
		alert.sendKeys("Sankar");
		alert.accept();
		
		String text = driver.findElement(By.id("myName")).getText();
		System.out.println("After accept prompt alert:"+text);
		Thread.sleep(5000);
		driver.quit();
		
	
	}
}
