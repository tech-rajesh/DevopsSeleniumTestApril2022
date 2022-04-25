package controlExample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NOPCommLoginTest extends BaseTestSample{
	
	
	
	@Test
	public void InputBox() throws Exception {
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		
		driver.findElement(By.name("Password")).clear();
		driver.findElement(By.name("Password")).sendKeys("admin");
		
		
		driver.findElement(By.tagName("button")).click();
		
		//click on customerMenu 
		Thread.sleep(5000);
		driver.findElements(By.xpath("//p[contains(text(),'Customers')]")).get(0).click();
		Thread.sleep(3000);
		//driver.findElements(By.xpath("//a[@href=\"/Admin/Customer/List\"]")).get(1).click();
		driver.findElements(By.xpath("//p[contains(text(),'Customers')]")).get(1).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='/Admin/Customer/Create']")).click();
		
	}

}
