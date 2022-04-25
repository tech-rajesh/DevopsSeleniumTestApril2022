package locatorExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMLocator extends BaseTest {

	
//	ID
//	NAME
//	ClassName
//	TagName
//
//	LinkText
//	PartialLinkText
//
//		condition
//			
//
//	XPATH
//	CSS Selector
	
	
	
	@Test
	public void login() throws Exception {

		// Identification
		//ID
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		
		//Name
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		
		//ClassName
		String actualAttributeLogin =  driver.findElement(By.className("button")).getAttribute("value");
		System.out.println("Attribute value: " + actualAttributeLogin);
		driver.findElement(By.className("button")).click();
		
		Thread.sleep(2000);
		
		//Tagname
		String actualdashLabel = driver.findElement(By.tagName("h1")).getText();
		System.out.println("Label text are: " + actualdashLabel);
		
		Thread.sleep(2000);
		//partiallinkText			----- Welcome SQA Engineer
		driver.findElement(By.partialLinkText("Welcome")).click();
		
		Thread.sleep(4000);
		//LinkText
		driver.findElement(By.linkText("Logout")).click();
		
		
		Thread.sleep(2000);
		//XPATH  ----- click on Login button using xpath
		driver.findElement(By.xpath("//input[@class='button']")).click();
		
		
		
		Thread.sleep(2000);
		//partiallinkText		---- forgot password
		driver.findElement(By.partialLinkText("Forgot your pass")).click();
		
		
		
		Thread.sleep(2000);
		//CSS 		---- Cancel Button
		driver.findElement(By.cssSelector("input[value='Cancel']")).click();
		
		
		Thread.sleep(2000);
		//partiallinkText		---- forgot password
		driver.findElement(By.partialLinkText("your passw")).click();
		
		
	}

}
