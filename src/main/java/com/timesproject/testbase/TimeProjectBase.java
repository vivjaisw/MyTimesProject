package com.timesproject.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.timesproject.util.Utility;

public class TimeProjectBase {

	public static WebDriver driver;
	public Properties prop;

	public TimeProjectBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\timesproject\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	public void initialisation() {
    String browserName = prop.getProperty("browserName");
    	if(browserName.equals("chrome"))
	{

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\timesproject\\config\\chromedriver.exe");
		
		driver = new ChromeDriver();

	}
    	driver.manage().window().maximize();driver.manage().deleteAllCookies();
    	driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT,TimeUnit.SECONDS);
    	driver.get(prop.getProperty("url"));
	System.out.println("System changed");

}

}
