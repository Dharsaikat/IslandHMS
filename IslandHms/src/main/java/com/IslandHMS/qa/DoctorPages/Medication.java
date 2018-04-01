package com.IslandHMS.qa.DoctorPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.IslandHMS.qa.base.TestBase;

public class Medication extends TestBase{
	
	@FindBy(xpath="//div[@class=\"view-top-bar\"]//child::h1[@class=\"view-current-title\"]")
	public WebElement medication_listing_title;
	
	

}
