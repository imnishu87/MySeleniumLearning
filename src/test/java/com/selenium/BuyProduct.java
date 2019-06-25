package com.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class BuyProduct extends BaseTest implements EcommLoginConstant {
  @Test
  public void Product() throws InterruptedException {
	    WebElement Usrname= driver.findElement(By.name(EMAIL_NAME_LOCATOR));
		Usrname.sendKeys("nishu.agarwal@gmail.com");
		WebElement Password=driver.findElement(By.name(PASSWORD_NAME_LOCATOR));
	    Password.sendKeys("test");
		WebElement Loginbtn=driver.findElement(By.linkText("Login"));
	    Loginbtn.click();
	    Thread.sleep(1000);
	    if (driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div")).isDisplayed())
		 {
			 System.out.println("Test with valid Login Pass");
		 }else
		 {
			 System.out.println("Test with valid Login Failed");
		 }
	    
	    Thread.sleep(2000);
  //Click on Products link	    
	 
        WebElement Productlink=driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/div/ul/li[4]/a"));
        Productlink.click();
        Thread.sleep(2000);
        WebElement Viewitembtn=driver.findElement(By.xpath("//*[@id=\"rightcontent\"]/p[2]/a/img"));
        Viewitembtn.click();
        Thread.sleep(2000);
        WebElement AddCartbtn=driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr/td/form[1]/table/tbody/tr[6]/td[3]/input"));
        AddCartbtn.click();
        Thread.sleep(2000);
        WebElement Checkoutbtn=driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table[1]/tbody/tr[3]/td/table/tbody/tr[5]/td[2]/a/div"));
        Checkoutbtn.click();
        Thread.sleep(2000);
        WebElement Continuebtn=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table[3]/tbody/tr/td/a/img"));
        Continuebtn.click();
        Thread.sleep(2000);
      
        WebElement Shippingmethod=driver.findElement(By.id("shipopt-2"));
        Shippingmethod.click();
        WebElement Houseno=driver.findElement(By.name("houseno"));
        Houseno.sendKeys("617");
        WebElement Streetname=driver.findElement(By.name("address"));
        Streetname.sendKeys("halfway drive");
        WebElement Town=driver.findElement(By.name("city"));
        Town.sendKeys("foster");
        WebElement Postalcode=driver.findElement(By.name("code"));
        Postalcode.sendKeys("94404");
        WebElement updatebtn=driver.findElement(By.name("Submit"));
        updatebtn.click();
        WebElement continuebtn1=driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table[2]/tbody/tr/td[2]/img"));
        continuebtn1.click();
        WebElement continuebtn2=driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td/form/table[2]/tbody/tr/td[2]/a/img"));
        continuebtn2.click();
        if (driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/span[5]")).isDisplayed())
       		 {
       			 System.out.println("Order Confirmation window is displayed");
       		 }else
       		 {
       			 System.out.println("Order Confirmation window is not displayed");
       		 }
        Thread.sleep(1000);
        WebElement securebtn=driver.findElement(By.xpath("//*[@id=\"form1\"]/input[1]"));
        securebtn.click();
        
    
        
        
  }
  
}
