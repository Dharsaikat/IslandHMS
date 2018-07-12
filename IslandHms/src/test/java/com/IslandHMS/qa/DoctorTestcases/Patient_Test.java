package com.IslandHMS.qa.DoctorTestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.IslandHMS.qa.DoctorPages.Patients;
import com.IslandHMS.qa.LoginAll.LoginAll;
import com.IslandHMS.qa.base.TestBase;

public class Patient_Test extends TestBase {

	public LoginAll loginAll;
	public Patients patient;

	public Patient_Test() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginAll = new LoginAll();
		patient = new Patients();
		// ---entering patient page from login page---//
		patient = loginAll.doctorLogin(prop.getProperty("doctor_username"), prop.getProperty("doctor_password"));

	}

	@Test(priority = 1)
	public void new_patient_add_button_click_Test() {
		patient.new_patient_add_button_click();
	}

	@Test(priority = 2)
	public void new_patients_add_url_check_Test() {
		patient.new_patients_add_url_check();
	}

	
	@DataProvider
	public static void getTestData()
	{
		
	}
	@Test(priority = 3,dataProvider="getTestData")
	public void new_patient_form_fillup_Test() {
		patient.new_patient_form_fillup("papai", "dhar", "kumar", "male", "5651547", "23/05/1991");
	}

	@Test(priority = 4)
	public void new_patient_add_Test() {
		patient.new_patient_add();
	}

	@Test(priority = 5)
	public void search_patient_in_patient_listing_Test() {
		patient.search_patient_in_patient_listing("papai");
	}

	@Test(dependsOnMethods = "search_patient_in_patient_listing_Test()")
	public void imageing_page_click_test() {
		patient.imageing_page_click();
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}
}
