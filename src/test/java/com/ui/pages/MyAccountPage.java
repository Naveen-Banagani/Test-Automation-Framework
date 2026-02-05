package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class MyAccountPage extends BrowserUtility{
	private static final By USER_NAME_LOACTOR = By.xpath("//a[@title='View my customer account']/span");
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	public String getUserName() {
		return getText(USER_NAME_LOACTOR);
	}

}
