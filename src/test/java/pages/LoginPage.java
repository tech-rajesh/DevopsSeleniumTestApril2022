package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver rdriver) {

		this.driver = rdriver;

	}

	// Identification
	By txt_UserName = By.cssSelector("input#txtUsername");
	By txt_Password = By.cssSelector("input#txtPassword");
	By btn_Login = By.xpath("//input[@type='submit']");
	By lbl_errorMessage = By.id("spanMessage");
	By lbl_dashboard = By.tagName("h1");

	// methods
	public void enterUserName(String user) {

		driver.findElement(txt_UserName).clear();
		driver.findElement(txt_UserName).sendKeys(user);

	}

	public void enterPassword(String pass) {

		driver.findElement(txt_Password).clear();
		driver.findElement(txt_Password).sendKeys(pass);

	}

	public void clickLoginButton() {

		driver.findElement(btn_Login).click();

	}

	public void verifyErroMessage(String expectedErrorMsg) {

		String actualErrorMessage = driver.findElement(lbl_errorMessage).getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMsg);

	}

	public void verifyDashBoardIsDisplayed() {

		Boolean actualErrorMessage = driver.findElement(lbl_dashboard).isDisplayed();
		System.out.println("**************: " +driver.findElement(lbl_dashboard).getText());
		Assert.assertTrue(actualErrorMessage);

	}

}
