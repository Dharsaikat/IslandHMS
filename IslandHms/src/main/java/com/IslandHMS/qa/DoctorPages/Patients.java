package com.IslandHMS.qa.DoctorPages;

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
	public void new_patient_add_button_click()
	{
		new_patient_button.click();
	}
	
	public void new_patients_add_url_check()
	{
		 driver.getCurrentUrl();
	}
	
	public void new_patient_form_fillup(String fname,String lname,String mname,String gender,CharSequence[] phnumber)
	{
		new_patient_add_firstname.sendKeys(fname);
		new_patient_add_last_name.sendKeys(lname);
		new_patient_add_middlename.sendKeys(mname);
		Select pstatus=new Select(new_patient_add_patient_status);
		pstatus.selectByVisibleText("Awaiting reply");
		new_patient_add_patient_sex.sendKeys(gender);
		new_patient_add_patient_phone_number.sendKeys(phnumber);
		
	}
	
	public void new_patient_add()
	{
		new_patient_add_patient_add_button.click();
	}
	
	public void new_patient_cancel()
	{
		new_patient_add_patient_cancel_button.click();
	}
	


}
