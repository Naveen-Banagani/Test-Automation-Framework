package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class  BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}
	
	public BrowserUtility(String browserName) {
		logger.info("Launching Browser for " + browserName);
		if(browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		}
		else {
			System.err.print("Invalid Browser Name");
			logger.error("Invalid Browser Name....Please select Chrome or Edge only");
		}
	}
	
	public BrowserUtility(Browser browserName) {
		logger.info("Launching Browser for " + browserName);
		if(browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		}
		else if(browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
		}
		else {
			System.err.print("Invalid Browser Name");
			logger.error("Invalid Browser Name....Please select Chrome or Edge only");
		}
	}
	
	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching Browser for " + browserName);

		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new"); // headless
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
//				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {
				driver.set(new ChromeDriver());
//				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}
		}

		else if (browserName == Browser.EDGE) {
			if (isHeadless) {

				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=new");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
//				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}

			else {
				driver.set(new EdgeDriver());
//				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}

		} else if (browserName == Browser.FIREFOX) {

			if (isHeadless) {

				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=o");
				driver.set(new FirefoxDriver(options));
//				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {
				driver.set(new FirefoxDriver());
//				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}
		}

	}

	public void goToUrl(String url) {
		logger.info("Visiting the website " + url);
		driver.get().get(url);
	}
	
	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		logger.info("Finding Element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		element.click();
	}
	
	public void enterText(By locator, String text) {
		logger.info("Finding Element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(text);
	}
	
	public String getText(By locator) {
		WebElement element = driver.get().findElement(locator);
		logger.info("Returning the visibile Text" + element.getText());
		return element.getText();
		
	}
	public String takeScreenShot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();

		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = "./screenshots/" + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return path;
	}

	public void quit() {
		driver.get().quit();
	}
}
