package javaSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumScrollOperations {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/");
		driver.manage().window().maximize();
		
		
		
		//implicit wait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Explicit Wait
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		
//		Fluent Wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(Exception.class);
		
		
		//Javascript Executor - Scroll the webpage
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Horizontal scroll
//		js.executeScript("window.scrollBy(2000,0)", "");
		
		// Vertical scroll
//		js.executeScript("window.scrollBy(0,500)", "");

		
		// Vertical Scroll Down to Page Bottom
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		// Vertical Scroll up to Page Top
//		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		
		WebElement editProfileBtn = driver.findElement(By.xpath("//button[@id='j_idt211']"));
		wait.until(ExpectedConditions.visibilityOf(editProfileBtn));
		js.executeScript("arguments[0].scrollIntoView();", editProfileBtn);		
		System.out.println("Button Text: "+editProfileBtn.getText());
		
		Thread.sleep(5000);
		driver.quit();
	}

}
