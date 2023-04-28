package com.ino.rm.resourcemanager;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login_TestCase extends LoginPage {

	@BeforeClass
public void InitializeClass() {
		
		SheetName="LoginTestData";
	}


	@Test(dataProvider = "ExcelDataRead")
	public void testcase(String username, String Password) throws InterruptedException {

		new LoginPage()
		.LaunchApplication()
		.enterusername(username)
		.enterpassword(Password)
		.clicklogin()
		.getDashbardText("Dashboard")
		.clickprojectmngBtn();

	}



}
