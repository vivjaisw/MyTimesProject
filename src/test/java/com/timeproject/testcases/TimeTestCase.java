package com.timeproject.testcases;

import org.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.timeproject.pages.TimeProject;
import com.timesproject.testbase.TimeProjectBase;

public class TimeTestCase extends TimeProjectBase {

	TimeProject timeproject;

	TimeTestCase() {
		super();
	}

	@BeforeMethod
	public void setup() throws Exception {

		initialisation();
		timeproject = new TimeProject();

	}

	@Test(priority = 1)
	public void verify_TimesPage() throws InvalidFormatException, Exception {
		timeproject.testcourses();
		Thread.sleep(10000);
		timeproject.alertHandle();
		String success = timeproject.textMessage();

		Assert.assertEquals(success, "Selenium Python & Behave BDD Online Training");

	}

//	@AfterMethod
//	public void tearDown() {
//
//		driver.quit();
//
//	}

}
