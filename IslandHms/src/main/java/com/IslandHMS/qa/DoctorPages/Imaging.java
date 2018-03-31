package com.IslandHMS.qa.DoctorPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(xpath="//button[@class=\"btn btn-default warning\"]")
	public WebElement image_new_request_cancel_button;
	
	
	public Imaging(){
		//initializing page objects for imaging page
		PageFactory.initElements(driver, this);
	}
	
	public void image_request_list_click()
	{
		image_request_list.click();
	}
	
	public void image_completed_list_click()
	{
		image_completed_list.click();
	}
	
	public void image_new_request_click()
	{
		image_new_request.click();
	}
	public String image_new_request_page_title_check()
	{
		String page_title_1=driver.findElement(By.xpath("//h1[@class=\"view-current-title\"]")).getText();
		return page_title_1;
		
	}
	
	public void image_new_request_form_fillup(String patient_name,String visit_date)
	{
		driver.findElement(By.xpath("//input[@id=\"patientTypeAhead-ember2542\"]")).sendKeys(patient_name);
		WebElement visit=driver.findElement(By.xpath("//select[@id=\"visit-ember2547\"]"));
		Select visit_d=new Select(visit);
		visit_d.deselectByVisibleText(visit_date);
		if(!driver.findElement(By.xpath("//input[@id=\"ember2556\"]")).isSelected())
		{
			driver.findElement(By.xpath("//input[@id=\"ember2556\"]")).click();
		}
		
	}
	
	public void image_new_request_form_fillup_add_button()
	{
		image_new_request_add_button.submit();
	}
	
	public void image_new_request_form_fillup_cancel_button()
	{
		image_new_request_cancel_button.click();
	}
	
	
	
	//searching any name in the list request//
	public void search_image_request_in_listing(String patient_name)
	{
		List<WebElement> searched_patient_name_req= driver.findElements(By.xpath("//tr[@class=\"table-header\"]//following::tr[@class=\"clickable ember-view\"]//child::td[@class=\"requested-by\"]"));
		for(WebElement name1:searched_patient_name_req)
		{
			if(name1.getText().equalsIgnoreCase(patient_name))
			{
				System.out.println("patient requested for image:" + patient_name);
			}
			else {
				System.out.println("SORRY! patient name is not found in list" + patient_name);
			}
		}
	}
	
	//searching any name in the list completed//
	public void search_image_completed_in_listing(String patient_name)
	{
		List<WebElement> searched_patient_name_comp= driver.findElements(By.xpath("//table[@class=\"table imaging-completed-table\"]//child::tr//following-sibling::tr[@class=\"ember-view\"]//child::td[@class=\"requested-by\"]"));
		for(WebElement name2:searched_patient_name_comp)
		{
			if(name2.getText().equalsIgnoreCase("patient_name"))
			{
				System.out.println("patient request completed:" + patient_name);
			}
			else
			{
				System.out.println("SORRY! patient name is not found in list\" + patient_name");
			}
		}
	}
	
	
}
