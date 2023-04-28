package com.ino.rm.resourcemanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.formula.functions.Replace;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProjectmanageTestCase extends ProjectManagementPage {
static List<String>ProjectManagementTestdata;
static List<String>ProjectManagementRemoveTestdata;
	@BeforeClass
public void InitializeClass() {
		
		SheetName="ProjectDetailsTestData";
	}
	
	

	
	@Test(dataProvider = "ExcelDataRead")
	 public void VerifyProjectManagementList(String p_code,String p_name,String p_description,String PoptionType,String ManageroptionText,String p_client,String s_date,String e_date) throws Exception {
		ProjectManagementTestdata=Arrays.asList(p_code,p_name,p_description,PoptionType, ManageroptionText,p_client,s_date,e_date);
		//System.out.println(ProjectManagementTestdata);
		
	}
	
	public void RemoveValueFromList(String p_code, String p_name, String PoptionType, String ManageroptionText, String p_client, String s_date, String e_date) throws Exception {
	    ProjectManagementRemoveTestdata = new ArrayList<>(Arrays.asList(p_code, p_name, PoptionType, ManageroptionText, p_client, s_date, e_date));
	    ProjectManagementRemoveTestdata.remove(2);
	    ProjectManagementRemoveTestdata.remove(5);
	    ProjectManagementTestdata.remove(6);
	    ProjectManagementTestdata.remove(7);
	    // add more remove statements here for other values you want to remove
	}
	@Test(dataProvider = "ExcelDataRead")

	public void testcas2(String p_code, String p_name, String p_description, String PoptionType, String ManageroptionText, String p_client, String s_date, String e_date) throws InterruptedException {

		
		this.clicknewBtn();
//		this.entercode(ProjectManagementTestdata.get(0));
//		this.enetername(ProjectManagementTestdata.get(1));
//		this.enterDescription(ProjectManagementTestdata.get(2));
//		this.enterProjectType(ProjectManagementTestdata.get(3));
//		this.enterProjectManager(ProjectManagementTestdata.get(4));
//		this.enterClient(ProjectManagementTestdata.get(5));
//		this.EnterstartDate(ProjectManagementTestdata.get(6));
//		this.EnterendDate(ProjectManagementTestdata.get(7));
		this.entercode(p_code);
		this.enetername(p_name);
		this.enterDescription(p_description);
		this.enterProjectType(PoptionType);
		this.enterProjectManager(ManageroptionText);
		this.enterClient(p_client);
		this.EnterstartDate(s_date);
		this.EnterendDate(e_date);
		this.EnterTechnology();
		this.EnterSubmitbtn();
		//this.VerifyProjectDetailslist1(p_code,p_name,PoptionType,ManageroptionText);
		
		//this.getprojectmanagementName("Project Management");
		//this.Clickfilter();
		//this.projectnamefilter();
		//this.getFilterverifyText("IL_JP_MAM_006");
		//this.editbtnclick();
		//this.getprojectdetails("Project Details");
		//this.getClosebutton();

	}
	
	@Test(priority=2)
	  public void VerifyProjectdetailsListed() throws Exception 
	  {
	   // date = ProjectManagementTestdata.get(6)("dd/APR/yyyy");
//		String date=ProjectManagementTestdata.get(6).format("dd/APR/yyyy");
//		ProjectManagementTestdat= Replace(ProjectManagementTestdata[6],date);
//		date = ProjectManagementTestdata[6].format("dd/mm/yyyy");
//		ProjectManagementTestdata[7] = Replace(ProjectManagementTestdata[6],date);
		
	         this.VerifyProjectDetailslist(ProjectManagementRemoveTestdata);
	          
	    
	  }
	
	@Test(priority=3)
	public void VerifyEditPageDatels() {
		this.VerifyEditPageData();
	}
	
}



