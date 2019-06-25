package com.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class EcommRegistertest extends BaseTest {
  @Test
  public void Register() throws InterruptedException {
	  WebElement SignUplink=driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td[1]/table/tbody/tr[2]/td[2]/a"));
	  SignUplink.click();
	  Thread.sleep(3000);
	  WebElement fname= driver.findElement(By.name("fname"));
	  fname.sendKeys("Nishu");
	  Thread.sleep(3000);
	  WebElement lname= driver.findElement(By.name("lname"));
	  lname.sendKeys("Agarwal");
	  WebElement dobday= driver.findElement(By.name("day"));
	  dobday.sendKeys("17");
	  WebElement dobmonth= driver.findElement(By.name("month"));
	  dobmonth.sendKeys("08");
	  WebElement dobyear= driver.findElement(By.name("year"));
	  dobyear.sendKeys("1987");
	  WebElement Email= driver.findElement(By.name("email"));
	  Email.sendKeys("nishu.agarwal2@gmail.com");
	  WebElement password= driver.findElement(By.name("password"));
	  password.sendKeys("test");
	  WebElement conpassword= driver.findElement(By.name("cpassword"));
	  conpassword.sendKeys("test");
	  WebElement termschkbox= driver.findElement(By.id("terms"));
	  termschkbox.click();
	  WebElement Submitbtn= driver.findElement(By.name("Submit"));
	  Submitbtn.click();
	  Thread.sleep(3000);
	  if (driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div")).isDisplayed())
		 {
			 System.out.println("Registration Done");
		 }else
		 {
			 System.out.println("Registration Failed");
		 }
	  }
}

