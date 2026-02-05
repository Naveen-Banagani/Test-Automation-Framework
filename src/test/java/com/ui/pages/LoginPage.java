package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility{
	
		public LoginPage(WebDriver driver) {
		super(driver); //To call the Parent Class(BrowserUtility) Constructor from the child constructor
	}
		private static final By EMAIL_TEXTBOX_LOCATOR = By.id("email"); //id is quick and best locator
		private static final By PASSWORD_TEXTBOX_LOCATOR = By.id("passwd"); //id is quick and best locator
		private static final By SUBMIT_BTN_LOCATOR = By.id("SubmitLogin"); //id is quick and best locator
		
		public MyAccountPage userLogin(String email, String password) {
			enterText(EMAIL_TEXTBOX_LOCATOR, email);
			enterText(PASSWORD_TEXTBOX_LOCATOR, password);
			clickOn(SUBMIT_BTN_LOCATOR);
			MyAccountPage myAccountPage = new MyAccountPage(getDriver());
			return myAccountPage;
		}
}
