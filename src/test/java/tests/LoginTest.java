package tests;

import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	
	@Test(priority = 1)
	public void login_userName_password_blank_tc_01() {
		
		lp.clickLoginButton();
		lp.verifyErroMessage("Username cannot be empty");
		
		
	}
	
	@Test(priority = 2)
	public void login_userNameAdmin_password_blank_tc_02() {
		
		lp.enterUserName(conf.getUserName());
		lp.clickLoginButton();
		lp.verifyErroMessage("Password cannot be empty");
		
		
	}
	
	@Test(priority = 3)
	public void login_userNameAdmin_password_Demo_tc_03() {
		
		lp.enterUserName(conf.getUserName());
		lp.enterPassword("demo123");
		lp.clickLoginButton();
		lp.verifyErroMessage("Invalid credentials");
		
		
	}
	
	@Test(priority = 4)
	public void login_validUserDetails_tc_04() {
		
		lp.enterUserName(conf.getUserName());
		lp.enterPassword(conf.getPassword());
		lp.clickLoginButton();
		lp.verifyDashBoardIsDisplayed();
		
	}

}
