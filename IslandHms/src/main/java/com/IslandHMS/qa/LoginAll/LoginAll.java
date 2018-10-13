package com.IslandHMS.qa.LoginAll;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.IslandHMS.qa.DoctorPages.Patients;
import com.IslandHMS.qa.base.TestBase;

public class LoginAll extends TestBase {
	
	@FindBy(xpath="//input[@id=\"identification\"]")
	public WebElement username;
	@FindBy(xpath="//input[@id=\"password\"]")
	public WebElement password;
	@FindBy(xpath="//button[@class=\"btn btn-lg btn-primary btn-block\"]")
	public WebElement submit_button;
	
	public LoginAll(){
		//initializing page objects
		PageFactory.initElements(driver, this);
	}
	
	
	public Patients doctorLogin(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		submit_button.submit();
		
		return new Patients() ;
		
	}
	

	

}
