package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.WebElement;

public class GoogleLoginTest {
     public static void main (String[]args) throws InterruptedException
     {
    	 //create the driver
    	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\chromedriver_win32\\chromedriver.exe");
    	 WebDriver driver=new ChromeDriver();
    	 
    	 //open the url
    	 
    	 driver.get("http://www.google.com");
    	
    	 //set the test data
    	 WebElement SearchboxElm= driver.findElement(By.name("q"));
    	 SearchboxElm.sendKeys("selenium programs");
    	 Thread.sleep(1000);
    	 
    	 //click the button
    	 WebElement SearchboxBtn= driver.findElement(By.name("btnK"));
    	 SearchboxBtn.click();
    	 Thread.sleep(1000);
    	 
    	 //verify the results
    	 System.out.println(driver.getTitle());
//    	 if (driver.getTitle().equals("https://www.seleniumhq.org/"))
    	 System.out.println(driver.findElement(By.id("logo")).getAttribute("title"));
    	 if (driver.findElement(By.id("logo")).isDisplayed())
    	 {
    		 System.out.println("Test Pass");
    	 }else
    	 {
    		 System.out.println("Test Failed");
    	 }
    	 
    	 //close the browser
    	 driver.close();
     }
     
     
}
