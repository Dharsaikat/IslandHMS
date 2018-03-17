package com.IslandHMS.qa.DoctorPages;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.IslandHMS.qa.base.TestBase;

public class Patients extends TestBase {
	
	@FindBy(className="view-current-title")
	public WebElement patient_listing_title;
	
	@FindBy(xpath="//button[@class=\"btn btn-primary\"]")
	public WebElement new_patient_button;
	
	@FindBy(xpath="//input[@id=\"firstName-ember1877\" ]")
	public WebElement new_patient_add_firstname;
	
	@FindBy(xpath="//input[@id=\"middleName-ember1918\" ]")
	public WebElement new_patient_add_middlename;
	
	@FindBy(xpath="//input[@id=\"lastName-ember1923\" ]")
	public WebElement new_patient_add_last_name;
	
	@FindBy(xpath="//select[@id=\"status-ember1998\" ]")
	public WebElement new_patient_add_patient_status;
	
	@FindBy(xpath="//input[@id=\"sex-ember1942\" ]")
	public WebElement new_patient_add_patient_sex;
	
	@FindBy(xpath="//input[@id=\"display_dateOfBirth-ember1951\" ]")
	public WebElement new_patient_add_patient_date_of_birth;
	
	@FindBy(xpath="//input[@id=\"phone-ember2072\" ]")
	public WebElement new_patient_add_patient_phone_number;
	
	@FindBy(xpath="//button[@class=\"btn btn-primary on-white disabled-btn\"]")
	public WebElement new_patient_add_patient_add_button;
	
	@FindBy(xpath="//button[@class=\"btn btn-default warning\"]")
	public WebElement new_patient_add_patient_cancel_button;
	
	
	
	
	public Patients(){
		//initializing page objects
		PageFactory.initElements(driver, this);
	}
	public  void new_patient_add_button_click()
	{
		new_patient_button.click();
	}
	
	public void new_patients_add_url_check()
	{
		 driver.getCurrentUrl();
	}
	
	public void new_patient_form_fillup(String fname,String lname,String mname,String gender,String phnumber,String date)
	{
		new_patient_add_firstname.sendKeys(fname);
		new_patient_add_last_name.sendKeys(lname);
		new_patient_add_middlename.sendKeys(mname);
		Select pstatus=new Select(new_patient_add_patient_status);
		pstatus.selectByVisibleText("Awaiting reply");
		new_patient_add_patient_sex.sendKeys(gender);
		new_patient_add_patient_phone_number.sendKeys(phnumber);
		new_patient_add_patient_date_of_birth.sendKeys(date);
		
	}
	
	public void new_patient_add()
	{
		new_patient_add_patient_add_button.click();
	}
	
	public void new_patient_cancel()
	{
		new_patient_add_patient_cancel_button.click();
	}
	
	public void search_patient_in_patient_listing(String fname)
	{
		
		String searched_patient=driver.findElement(By.xpath("//tr[@class=\"clickable\"]//child::td//following-sibling::td")).getText();
		if(searched_patient.equalsIgnoreCase(fname))
		{
		 System.out.println("patient is found in table" + fname);	
		}
		else
		{
			System.out.println("patient is not found");
		}
		
	}
	
	//button[text()="Edit" and @class="btn btn-default neutral"]
	public void edit_patient_from_table()
	{
		List<WebElement> edit_patient=driver.findElements(By.xpath("//button[text()=\"Edit\" and @class=\"btn btn-default neutral\"]"));
		for(WebElement i:edit_patient)
		{
			i.click();
			break;
		}
	}
		
	public void discharge_patient_from_table()
		{
			List<WebElement> discharge_patient=driver.findElements(By.xpath("//button[text()=\"Discharge\" and @class=\"btn btn-primary info\"]"));
			for(WebElement j: discharge_patient)
			{
				j.click();
				break;
			}
	    }

	public Imaging imageing_page_click()
	{
		driver.findElement(By.xpath("//a[@id=\"ember671\"]")).click();
		return new Imaging();
	}

}
