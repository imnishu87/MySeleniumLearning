package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;


public class GoogleLoginTest_NG extends BaseTest implements GoogleLoginConstant{
	
//	private WebDriver driver;
	@Test
	public void testwithSuccessData() throws InterruptedException{
     //set the test data
		
   	 WebElement SearchboxElm= driver.findElement(By.name(QUERY_NAME_LOCATOR));
   	 SearchboxElm.sendKeys(SEARCH_KEY_WORD);
   	 Thread.sleep(3000);
   	 //click the button
   	 WebElement SearchboxBtn= driver.findElement(By.name(BTN_SEARCH_NAME));
   	 SearchboxBtn.click();
   	 Thread.sleep(1000);
   	 //verify the results
   	 Assert.assertEquals(driver.getTitle(), GOOGLE_SEARCH_CONSTANT);
   	 }
	
	
	@Test
	public void testwithBlankData(){
		
	}
	
	@Test
	public void testwithNumbers(){
		
	}
	
	@Test
	public void testwithCharacters(){
		
	}
}
