package com.timeproject.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.timesproject.testbase.TimeProjectBase;

public class TimeProject extends TimeProjectBase {
	
	JavascriptExecutor je = (JavascriptExecutor) driver;

	@FindBy(xpath = "(//span[contains(text(),'All Courses')])[1]")
	WebElement allCourses;

	@FindBy(xpath = "//li[@id='menu-item-27582']")
	WebElement selenium;

	@FindBy(xpath = "(//span[contains(text(),'Selenium with Python')])[1]")
	WebElement seleniumwithPython;

	@FindBy(xpath = "//h2[contains(text(),'Selenium Python & Behave BDD Online Training')]")
	WebElement textMessage;
	
	@FindBy(xpath = "//a[contains(text(),'Free lifetime access to Selenium Python Tutorials')]")
	WebElement lifeTimeText;
	
	

	public TimeProject() {
		PageFactory.initElements(driver, this);

	}

	public void testcourses() {
		Actions actions = new Actions(driver);

		allCourses.click();

		actions.moveToElement(selenium).perform();

		seleniumwithPython.click();

	}

	public void alertHandle() {
		try {

			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {

		}

	}

	public String textMessage() {

		String successMessage = textMessage.getText();
		
		je.executeScript("arguments[0].scrollIntoView(true);",lifeTimeText);
		
		lifeTimeText.click();

		return successMessage;

	}
	
	public void clickFreeLifeTime() {
		
		je.executeScript("arguments[0].scrollIntoView(true);",lifeTimeText);
		
		lifeTimeText.click();
	}
	

}
