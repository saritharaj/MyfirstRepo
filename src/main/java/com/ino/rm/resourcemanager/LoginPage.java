package com.ino.rm.resourcemanager;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import com.ino.rm.resourcemanager.DataProvider;
import org.testng.annotations.DataProvider;

public class LoginPage extends CommonUtils {
	
	private By uname = By.name("email");
	private By password = By.name("password");
	private By loginbtn = By.xpath("//input[@type='submit' and @value='Submit']");
	private By logout = By.xpath("//button[@aria-label='logout']");
	private By arrowdown = By.xpath("//mat-icon[@data-mat-icon-type='font' and contains(text(),'keyboard_arrow_down')]");
	private By project_management = By.xpath("//a[@routerlink='project-management']//span[@class='mat-list-item-content']");
	private By dashboardtext = By.xpath("//h1[text()='Dashboard']");

	public LoginPage LaunchApplication() {
		this.launchBrowser();
		return this;
	}

	public LoginPage enterusername(String user) {
		// driver.findElement(uname).clear();
		WebElement inputField1 = driver.findElement(uname);
		inputField1.clear();
		inputField1.sendKeys(user);
		return this;
	}

	public LoginPage enterpassword(String pass)

	{

		WebElement inputField2 = driver.findElement(password);
		inputField2.sendKeys(pass);
		return this;
	}

	public LoginPage clicklogin()

	{
		WebElement button = driver.findElement(loginbtn);
		button.click();
		return this;

	}
	
	
	public LoginPage getDashbardText(String expectedResults)  {
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardtext));
		String actualResult = driver.findElement(dashboardtext).getText();
		Assert.assertEquals(actualResult, expectedResults);
		return this;
	}

	public void clickprojectmngBtn() {

		//WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(project_management));
		WebElement button1=driver.findElement(project_management);
		button1.click();

	}

	public LoginPage clicklogout() {
		WebElement arrowdwn = driver.findElement(arrowdown);
		arrowdwn.click();
		WebElement logoutbtn = driver.findElement(logout);
		logoutbtn.click();
		return this;

	}


}