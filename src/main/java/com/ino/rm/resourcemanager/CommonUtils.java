package com.ino.rm.resourcemanager;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class CommonUtils {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Actions act;
	public static String file_location="D:/Automation/resourcemanager/src/test/java/testdata/Rm_Test_Data.xls";
	public static String SheetName;
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Automation\\resourcemanager\\Driver\\chromedriver.exe");
		String url = "https://innovatu:rm@123@dev-rm.innovaturelabs.com";
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize(); 
		wait = new WebDriverWait(driver, 20);
		act=new Actions(driver);
	}
	


	@DataProvider
	public Object[][] ExcelDataRead() throws IOException, InterruptedException {
		FileInputStream fileInputStream = new FileInputStream(file_location); // Excel sheet file location D:/Automation/resourcemanager/src/test/java/testdata/Rm_Test_Data.xls
																							// get mentioned here
		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream); // get my workbook
		HSSFSheet worksheet = workbook.getSheet(SheetName);// get my sheet from workbook
		HSSFRow Row = worksheet.getRow(0); // get my Row which start from 0

		int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
		int ColNum = Row.getLastCellNum(); // get last ColNum

		Object Data[][] = new Object[RowNum - 1][ColNum]; // pass my count data in array

		for (int i = 0; i < RowNum - 1; i++) // Loop work for Rows
		{
			HSSFRow row = worksheet.getRow(i + 1);

			for (int j = 0; j < ColNum; j++) // Loop work for colNum
			{
				if (row == null)
					Data[i][j] = "";
				else {
					HSSFCell cell = row.getCell(j);
					if (cell == null)
						Data[i][j] = ""; // if it get Null value it pass no data
					else {
						// String encoded = URLEncoder.encode(sValue, "UTF-8");

						String value = cell.getStringCellValue();
						// String value=CellValue(cell);

						// cell.getStringCellValue().getBytes(Charset.forName("UTF-8"));
						Data[i][j] = value; // This formatter get my all values as string i.e integer, float all type
											// data value

						System.out.println("Excel Data :" + value);
					}
				}
			}
		}

		return Data;
	}

}
