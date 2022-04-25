package actionExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDropTest2 {
	
	WebDriver driver;
	@BeforeTest
	public void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		driver.manage().window().maximize();
		
	}
	
	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(4000);
		driver.close();
		
	}
	
	@Test
	public void dragTest() {
		
		
		WebElement DragDropFrame = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(DragDropFrame);
		
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.cssSelector("div#droppable"));

		
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).perform();;
		
	}

}
