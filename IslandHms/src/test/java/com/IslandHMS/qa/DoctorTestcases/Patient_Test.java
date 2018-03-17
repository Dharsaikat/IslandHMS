package com.IslandHMS.qa.DoctorTestcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.IslandHMS.qa.DoctorPages.Patients;
import com.IslandHMS.qa.LoginAll.LoginAll;
import com.IslandHMS.qa.base.TestBase;

public class Patient_Test extends TestBase {
	
	LoginAll loginAll;
	Patients patient;
	
	public Patient_Test()
	{
		super();
	}
	
	@BeforeSuite
	public void setUp(){
		initialization();
		loginAll = new LoginAll();
		patient = new Patients();
	}
	
	@Test(priority=1)
	public void doctorLogin_Test()
	{
		loginAll.doctorLogin(prop.getProperty("doctor_username"),prop.getProperty("doctor_password"));
		
	}
	
	
	@Test(priority=2)
	public void new_patient_add_button_click_Test()
	{
		patient.new_patient_add_button_click();
	}
	
	@Test(priority=3)
	public void new_patients_add_url_check_Test()
	{
		patient.new_patients_add_url_check();
	}
    @Test(priority=4)
    public void new_patient_form_fillup_Test()
    {
    	patient.new_patient_form_fillup("papai", "dhar", "kumar", "male", "5651547", "23/05/1991");
    }
    @Test(priority=5)
    public void new_patient_add_Test()
    {
    	patient.new_patient_add();
    }
    @Test(priority=6)
    public void search_patient_in_patient_listing_Test()
    {
    	patient.search_patient_in_patient_listing("papai");
    }
}
