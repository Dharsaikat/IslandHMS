package com.IslandHMS.qa.DoctorPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.IslandHMS.qa.base.TestBase;

public class Imaging extends TestBase {
	
	@FindBy(xpath="//a[@id=\"ember1765\"]")
	public WebElement image_request_list;
	
	@FindBy(xpath="//a[@id=\"ember1768\"]")
	public WebElement image_completed_list;
	
	@FindBy(xpath="//a[@id=\"ember1787\"]")
	public WebElement image_new_request;

	@FindBy(xpath="//input[@id=\"patientTypeAhead-ember2799\"]")
	public WebElement image_new_request_patient_name;
	
	@FindBy(xpath="//select[@id=\"visit-ember2804\"]")
	public WebElement image_new_request_new_visit;
	
	@FindBy(xpath="//input[@id=\"ember2813\"]")
	public WebElement image_new_image_type_radio;
	
	@FindBy(xpath="//button[@class=\"btn btn-primary on-white \"]")
	public WebElement image_new_request_add_button;
	
	
	public Imaging(){
		//initializing page objects
		PageFactory.initElements(driver, this);
	}
	
	
}
