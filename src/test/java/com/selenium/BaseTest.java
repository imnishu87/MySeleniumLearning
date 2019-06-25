package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		//create the driver
	   	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\chromedriver_win32\\chromedriver.exe");
	   	 driver=new ChromeDriver();
	   	 //open the url
	   	 driver.get("http://ecommerce.saipratap.net/customerlogin.php");
	   	
	}
	
	@AfterMethod
	public void CleanUp() {
		//close the browser
	   	 driver.close();
	}
	
}
