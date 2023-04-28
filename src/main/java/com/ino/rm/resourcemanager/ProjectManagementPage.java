package com.ino.rm.resourcemanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProjectManagementPage extends CommonUtils {
	//public static WebDriverWait wait;
	
	private By addnew_btn = By.xpath("//button[@aria-label='createNewProjectButton']");
	private By projectmanagetext = By.xpath("//h1[text()='Project Management']");
	private By projectCode = By.xpath("(//input[@formcontrolname='projectCode'])[21]");
	private By projectName = By.xpath("(//input[@aria-label='Project Name']/ancestor::div[contains(@class, 'mat-form-field-infix')])[22]");
	private By pdescription = By.xpath("(//textarea[@aria-label='Project Description'])[21]");
	private By client = By.xpath("(//input[@formcontrolname='clientName' and @aria-label='Project Client'])[21]");
	private By pstart_date = By.xpath("(//button[@aria-label='Open calendar'])[43]");
	private By pend_date = By.xpath("(//button[@aria-label='Open calendar'])[44]");
	private By filterbtn = By.xpath("//mat-panel-title[contains(@class, 'mat-expansion-panel-header-title') and contains(text(), 'Filter')]");
	private By filterprojectname = By.xpath("(//input[contains(@class, 'mat-input-element') and @aria-label='Project Name' and @formcontrolname='projectName'])[1]");
	private By editicon = By.xpath("(//mat-icon[@mattooltip='Edit'])[1]");
	private By projectdetailtext = By.xpath("//h1[text()='Project Details']");
	private By filterverifytext=By.xpath("//span[@class='project_code ng-tns-c226-1'  and contains(text(),' IL_JP_MAM_006 ')]");
	private By projecttypedrop=By.xpath("(//*[@formcontrolname='projectType'])[2]");
	private By dropdownelement=By.xpath("(//*[@formcontrolname='manager'])[2]");
	
	private By pdropOtions=By.xpath("//mat-option[contains(.,' Internal ')]");
	private By dropoptions=By.xpath("//mat-option[contains(.,'test cadte')]");
	private By dateelement=By.xpath("(//button[@class='mat-calendar-body-cell'])[18]");
	private By enddateelement=By.xpath("(//button[@class='mat-calendar-body-cell'])[2]");
	private By techdropdwn=By.xpath("(//*[@formcontrolname='skill'])[21]");
	private By techOptions=By.xpath("//mat-pseudo-checkbox[contains(.,'')][1]");
	private By submitbtn=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Submit')]");
	private By closebtn=By.xpath("(//mat-icon[@class='mat-icon notranslate material-icons mat-icon-no-color' and @data-mat-icon-type='font' and text()='clear'])[2]");
	private By editbtn=By.xpath("//tr[contains(., 'Issurly ')]//button[@aria-label='expandRowButton']/span/mat-icon[@mattooltip='Edit']");
//private By actualxpath=By.xpath("//table[@role='table']/tbody/tr[i]/td[j]")
	private By calendar=By.xpath("//mat-calendar[@id='mat-datepicker-2']");
	private By editpagetitle=By.xpath("//h1[@class='mat-dialog-title']");


	public ProjectManagementPage getprojectmanagementName(String expectedResults) {
		String actualResult = driver.findElement(projectmanagetext).getText();
		Assert.assertEquals(actualResult, expectedResults);
		return this;
	}

	public void clicknewBtn() {
		WebElement addnewbtn=wait.until(ExpectedConditions.elementToBeClickable(addnew_btn));
		Actions actions = new Actions(driver);
		actions.moveToElement(addnewbtn).click().build().perform();
	}

	public ProjectManagementPage entercode(String code) {
		
		// Get current window handle
		String mainWindowHandle = driver.getWindowHandle();

		// Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(windowHandle);

				break;
			}
		}
		WebElement pcode =wait.until(ExpectedConditions.elementToBeClickable(projectCode));
		//Actions actions = new Actions(driver);
		act.moveToElement(pcode).click().sendKeys(code).build().perform();
//		pcode.click();
//		pcode.sendKeys(code);
		return this;

	}

	public ProjectManagementPage enetername(String Pname) {
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		
		WebElement pname = wait.until(ExpectedConditions.elementToBeClickable(projectName));
		//Actions actions = new Actions(driver);
		act.moveToElement(pname).click().sendKeys(Pname).build().perform();
		return this;
	}

	public ProjectManagementPage enterDescription(String description) {

		WebElement popupElement3 = driver.findElement(pdescription);
		//Actions actions = new Actions(driver);
		act.moveToElement(popupElement3).click().sendKeys(description).build().perform();
		return this;
	}

	public ProjectManagementPage enterProjectType(String optionText ) throws InterruptedException {

		//Thread.sleep(3000);

////Locate the mat-select element and click on it to open the dropdown
		//WebDriverWait wait1 = new WebDriverWait(driver, 50);
		WebElement ptypeElement = wait
				.until(ExpectedConditions.elementToBeClickable(projecttypedrop));
		ptypeElement.click();

////Locate the desired option and click on it
//		try {
//		//WebDriverWait wait6 = new WebDriverWait(driver, 20);
//			
//		WebElement optionPtype = wait
//				.until(ExpectedConditions.elementToBeClickable(pdropOtions));
//		optionPtype.click();
//		}
//		catch(StaleElementReferenceException e) {
//			//WebDriverWait wait6 = new WebDriverWait(driver, 20);
//			WebElement optionElement = wait
//					.until(ExpectedConditions.elementToBeClickable(pdropOtions));
//			optionElement.click();
//		}
		
		String xpathExpression ="//mat-option[contains(.,'" + optionText + " ')]";
	    WebElement option = driver.findElement(By.xpath(xpathExpression));
	    option.click();
		return this;
	}
	
	
	
	
	public ProjectManagementPage enterProjectManager(String ManageroptionText ) throws InterruptedException {

		//Thread.sleep(3000);

////Locate the mat-select element and click on it to open the dropdown
		//WebDriverWait wait1 = new WebDriverWait(driver, 50);
		WebElement selectElement = wait
				.until(ExpectedConditions.elementToBeClickable(dropdownelement));
		selectElement.click();

////Locate the desired option and click on it
//		try {
//		//WebDriverWait wait6 = new WebDriverWait(driver, 20);
//		WebElement optionElement = wait
//				.until(ExpectedConditions.elementToBeClickable(dropoptions));
//		optionElement.click();
//		}
//		catch(StaleElementReferenceException e) {
//			//WebDriverWait wait6 = new WebDriverWait(driver, 20);
//			WebElement optionElement = wait
//					.until(ExpectedConditions.elementToBeClickable(dropoptions));
//			optionElement.click();
//		}
		try {
		String xpathExpression ="//mat-option[contains(.,'" + ManageroptionText +"')]";
	    WebElement option = driver.findElement(By.xpath(xpathExpression));
	    option.click();}
		catch(StaleElementReferenceException e) {
			String xpathExpression ="//mat-option[contains(.,'" + ManageroptionText +"')]";
		    WebElement option = driver.findElement(By.xpath(xpathExpression));
		    option.click();
		}
		
		
		return this;
	}

	public ProjectManagementPage enterClient(String Client) {

		WebElement pclient = driver.findElement(client);
		//Actions actions = new Actions(driver);
		act.moveToElement(pclient).click().sendKeys(Client).build().perform();
		return this;
	}

	public ProjectManagementPage EnterstartDate(String start_date) {
		WebElement calendar = driver.findElement(pstart_date);
		calendar.click();
		//waite for calendar to be visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-calendar-header[@class='ng-star-inserted']")));
		
		// Split the date string to get the day, month, and year values
		
		String[] date_Parts=start_date.split("/");
		String day=date_Parts[0];
		String month=date_Parts[1];
		String year=date_Parts[2];
		
		// Select the month and year in the calendar
		
		
		WebElement yearMonthDropdown=driver.findElement(By.xpath("//button[contains(@class, 'mat-calendar-period-button') and contains(@aria-label, 'Choose month and year')]"));
		yearMonthDropdown.click();
		WebElement yearOption=driver.findElement(By.xpath("//button[@class='mat-calendar-body-cell mat-calendar-body-active' and @aria-label='2023']/div[text()=' "+year+" ']"));
		yearOption.click();
		WebElement monthOption=driver.findElement(By.xpath("//button[contains(@class, 'mat-calendar-body-cell') and contains(@aria-label, 'April 2023')]/div[text()=' "+month+" ']"));
		monthOption.click();
		
		// Select the day in the calendar
		
		WebElement dayOption=driver.findElement(By.xpath("//button[@aria-label='20 April 2023']/div[text()=' "+day+" ']"));
		dayOption.click();
		
//		String todayCelllocator ="(//button[@class='mat-calendar-body-cell'])[18]";
//		 EnterstartDate(todayCelllocator);
//		WebElement todayCell = new WebDriverWait(driver, 30).until(
//				ExpectedConditions.elementToBeClickable(dateelement));
//	todayCell.click();
		return this;
	}

	public ProjectManagementPage EnterendDate(String end_Date) {
		WebElement calendar2 = driver.findElement(pend_date);
		calendar2.click();
		
		
		//waite for calendar to be visible////mat-calendar[@id='mat-datepicker-3']
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-calendar-header[@class='ng-star-inserted']")));
				
				// Split the date string to get the day, month, and year values
				
				String[] end_date_Parts=end_Date.split("/");
				String day1=end_date_Parts[0];
				String month1=end_date_Parts[1];
				String year1=end_date_Parts[2];
				
				WebElement yearMonthDropdown=driver.findElement(By.xpath("//button[contains(@class, 'mat-calendar-period-button') and contains(@aria-label, 'Choose month and year')]"));
				yearMonthDropdown.click();
				WebElement yearOption=driver.findElement(By.xpath("//button[@class='mat-calendar-body-cell mat-calendar-body-active' and @aria-label='2023']/div[text()=' "+year1+" ']"));
				//button[@class='mat-calendar-body-cell mat-calendar-body-active' and @aria-label='2023']/div[text()=' 2023 ']
				yearOption.click();
				WebElement monthOption=driver.findElement(By.xpath("//button[contains(@class, 'mat-calendar-body-cell') and contains(@aria-label, 'April 2023')]/div[text()=' "+month1+" ']"));
				monthOption.click();
				
				// Select the day in the calendar
				
				WebElement dayOption=driver.findElement(By.xpath("//button[@aria-label='21 April 2023']/div[text()=' "+day1+" ']"));
				dayOption.click();
				
				

		
//		String endtodaycell="(//button[@class='mat-calendar-body-cell'])[2]";
//		EnterendDate(endtodaycell);
//		WebElement todayCell2 = new WebDriverWait(driver, 30).until(
//				ExpectedConditions.elementToBeClickable(enddateelement));
//		todayCell2.click();

		return this;
	}

	public ProjectManagementPage EnterTechnology() throws InterruptedException {
		//Thread.sleep(3000);
		//WebDriverWait wait4 = new WebDriverWait(driver, 20);
		WebElement selectElement2 = wait
				.until(ExpectedConditions.elementToBeClickable(techdropdwn));

		// Interact with the element
		selectElement2.click();

		// Locate the desired option and click on it
		//WebDriverWait wait5 = new WebDriverWait(driver, 20);
		WebElement optionElement2 = wait
				.until(ExpectedConditions.elementToBeClickable(techOptions));
		optionElement2.click();
		return this;
	}

	public ProjectManagementPage EnterSubmitbtn() {
		WebElement buttonElement = driver.findElement(submitbtn);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", buttonElement);
		return this;
	}

	public ProjectManagementPage Clickfilter() {

		WebElement filter = driver.findElement(filterbtn);
		filter.click();
		return this;
	}

	public ProjectManagementPage projectnamefilter() throws InterruptedException {
		WebElement filtername = driver.findElement(filterprojectname);
		filtername.sendKeys("SurveyDB");
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).build().perform();

		return this;
	}

	public ProjectManagementPage editbtnclick() {
		WebElement Edit = driver.findElement(editicon);
		Edit.click();
		return this;

	}

	public ProjectManagementPage getprojectdetails(String expectedResults) throws InterruptedException {
		//Thread.sleep(3000);
		String actualResult = driver.findElement(projectdetailtext).getText();
		
		Assert.assertEquals(actualResult, expectedResults);
		

		return this;
	}
	
	public ProjectManagementPage getClosebutton() {
		WebElement close=driver.findElement(closebtn);
		close.click();
		
		return this;
	}

	
	
	public ProjectManagementPage getFilterverifyText(String expectedResults) throws InterruptedException {
		Thread.sleep(3000);
		String actualResult = driver.findElement(filterverifytext).getText();
		// System.out.println(actualResult);

		String result;

		if (expectedResults.equalsIgnoreCase(actualResult)) {
			result = "filterby project name is verified";
			System.out.println(result);
		} else {
			result = "filterby project name is not verified";

			System.out.println(result);

		}
		Assert.assertEquals(actualResult, expectedResults, result);
		// Assert.assertEquals(actualResult.trim(), "Project Management");

		return this;
	}
	
	public ProjectManagementPage VerifyEditPageData() {
		
		WebElement editButton=driver.findElement(editbtn);
		editButton.click();
		WebElement editpageTitle=driver.findElement(editpagetitle);
		assert editpageTitle.getText().equals("Project Details");
		WebElement projectcode=driver.findElement(projectCode);
		assert projectcode.getAttribute("value").equals("INR");
		return null;
		
	}
	
	public ProjectManagementPage VerifyProjectDetailslist1(String p_code, String p_name,String PoptionType, String ManageroptionText) throws InterruptedException {
		Thread.sleep(5000);
		
		List<String>ProjectListDetails_UI=new ArrayList<String>();
		//int limit=Expected_Testdata.size();
		 int limit = 1;
//		 if (expectedValues != null) { // check if Expected_Testdata is null
//		        limit = expectedValues.size();
//		    }
		for(int i=0;i<limit;i++) {
			//String expectedValue = expectedValues.get(i);
			String actualxpath = "//*[text()=' pos" + (i + 1) + " ']";
			//String actualxpath ="//*[text()=' pos9 ']";
				System.out.println(actualxpath);
			WebElement element=driver.findElement(By.xpath(actualxpath));
		
			//wait.until(ExpectedConditions.presenceOfElementLocated(element));
			ProjectListDetails_UI.add(actualxpath);
	
		}
		Assert.assertEquals(ProjectListDetails_UI.size(),limit, "The lists do not match"); 
		return new ProjectManagementPage();}
	
	
	
	public ProjectManagementPage VerifyProjectDetailslist(List<String>Expected_Testdata) throws InterruptedException {
		Thread.sleep(5000);
		
		List<String>ProjectListDetails_UI=new ArrayList<String>();
		//int limit=Expected_Testdata.size();
		 int limit = 0;
		 if (Expected_Testdata != null) { // check if Expected_Testdata is null
		        limit = Expected_Testdata.size();
		    }
		for(int i=0;i<limit;i++) {
			String expectedValue = Expected_Testdata.get(i);
			String actualxpath = "//*[text()=' " +expectedValue+ " ']";
			//String actualxpath ="//*[text()=' pos9 ']";
				System.out.println(actualxpath);
			WebElement element=driver.findElement(By.xpath(actualxpath));
		
			//wait.until(ExpectedConditions.presenceOfElementLocated(element));
			ProjectListDetails_UI.add(actualxpath);
	
		}
		Assert.assertEquals(ProjectListDetails_UI, Expected_Testdata, "The lists do not match"); 
		return new ProjectManagementPage();}
	
}
