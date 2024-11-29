package javaSelenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/windows");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("home")).click();
		
		// getWindowHandles used to store the number of Window id's in Set collection
		Set<String> windowHandles = driver.getWindowHandles();
		
		// Set don't have a get() method so convert to List
		List<String> list = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(list.get(1));
		System.out.println(driver.getCurrentUrl());
		
		// Navigate and close the the Parent window 
		driver.switchTo().window(list.get(0));
		driver.close();
		
		// After close the any window we can't access the remaining window if try to access "NoSuchWindowException" happen
		// So again we can create getWindowHandles()
		Set<String> windowHandles2 =  driver.getWindowHandles();
		
		// clear the list and add all the new get windows
		list.clear();
		list.addAll(windowHandles2);
		
		// now switchTo the remaining window
		driver.switchTo().window(list.get(0));
		System.out.println(driver.getCurrentUrl());
		
		
		driver.quit();
	}

}
