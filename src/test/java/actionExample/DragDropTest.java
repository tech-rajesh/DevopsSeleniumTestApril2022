package actionExample;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDropTest {

	
	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		System.out.println("launch browser- app");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {
		System.out.println("close browser");
		Thread.sleep(4000);
		driver.close();
	}
	
	
	
	
	@Test
	public void promptAlert() throws Exception {
		
		//Multiple frmae on page
		WebElement myFrame = driver.findElement(By.xpath("//iframe[contains(@data-src,'droppable/photo')]"));
		
		driver.switchTo().frame(myFrame);
		
		Thread.sleep(4000);
		
		WebElement img3 = driver.findElement(By.xpath("//img[contains(@src,'tatras3')]"));
		WebElement img4 = driver.findElement(By.xpath("//img[contains(@src,'tatras4')]"));
		WebElement trash = driver.findElement(By.cssSelector("div#trash"));
		
		
		//actions
		
		Actions act = new Actions(driver);
		act.dragAndDrop(img3, trash).perform();
		act.dragAndDrop(img4, trash).perform();
		
		//Thread.sleep(4000);
		
	}
	
	
	
	
	
	
}
