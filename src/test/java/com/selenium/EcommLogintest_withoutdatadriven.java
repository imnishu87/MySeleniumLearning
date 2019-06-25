package com.selenium;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import java.io.File;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class EcommLogintest_withoutdatadriven extends BaseTest implements EcommLoginConstant {
	//private WebDriver driver=null;
	@Test
	public void testSuccessLogin() throws InterruptedException {
    WebElement Usrname= driver.findElement(By.name(EMAIL_NAME_LOCATOR));
	Usrname.sendKeys("nishu.agarwal@gmail.com");
   	Thread.sleep(3000);
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
    }
  
  @Test
  public void testwithBlankLogin() throws InterruptedException {
	  WebElement Usrname= driver.findElement(By.name(EMAIL_NAME_LOCATOR));
	  Usrname.sendKeys("");
	  Thread.sleep(3000);
	  WebElement Password=driver.findElement(By.name(PASSWORD_NAME_LOCATOR));
	  Password.sendKeys("test");
	  WebElement Loginbtn=driver.findElement(By.linkText("Login"));
	  Loginbtn.click();
	  Thread.sleep(1000);
	  if (driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/span")).isDisplayed())
		 {
			 System.out.println("Blank Login Test Pass");
		 }else
		 {
			 System.out.println("Blank Login Test Failed");
		 }
	    }
  
  @Test
  public void testwithBlankPassword() throws InterruptedException {
	  WebElement Usrname= driver.findElement(By.name(EMAIL_NAME_LOCATOR));
	  Usrname.sendKeys("nishu.agarwal@gmail.com");
	  Thread.sleep(3000);
	  WebElement Password=driver.findElement(By.name(PASSWORD_NAME_LOCATOR));
	  Password.sendKeys("");
	  WebElement Loginbtn=driver.findElement(By.linkText("Login"));
	  Loginbtn.click();
	  Thread.sleep(1000);
	  if (driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/span")).isDisplayed())
		 {
			 System.out.println("Blank Password Test Pass");
		 }else
		 {
			 System.out.println("Blank Password Test Failed");
		 }
  }
  
  @Test
  public void testwithBothBlank() throws InterruptedException {
	  WebElement Usrname= driver.findElement(By.name(EMAIL_NAME_LOCATOR));
	  Usrname.sendKeys("");
	  WebElement Password=driver.findElement(By.name(PASSWORD_NAME_LOCATOR));
	  Password.sendKeys("");
	  WebElement Loginbtn=driver.findElement(By.linkText("Login"));
	  Loginbtn.click();
	  Thread.sleep(1000);
	  if (driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/span")).isDisplayed())
		 {
			 System.out.println("Blank Username and Password Test Pass");
		 }else
		 {
			 System.out.println("Blank Username and Password Test Failed");
		 }
  }
  
  @Test
  public void testwithInvalidLogin() throws InterruptedException {
	  WebElement Usrname= driver.findElement(By.name(EMAIL_NAME_LOCATOR));
	  Usrname.sendKeys("nishu.agarwal@gmail.com");
	  WebElement Password=driver.findElement(By.name(PASSWORD_NAME_LOCATOR));
	  Password.sendKeys("test123");
	  WebElement Loginbtn=driver.findElement(By.linkText("Login"));
	  Loginbtn.click();
	  Thread.sleep(1000);
	  if (driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/span")).isDisplayed())
		 {
			 System.out.println("Invalid Login details Test Pass");
		 }else
		 {
			 System.out.println("Invalid Login details Test Failed");
		 }
  
  }
  
  public String[][] getTableArray(String xlFilePath, String sheetName, String tableName){
      String[][] tabArray=null;
      try{
          Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
          Sheet sheet = workbook.getSheet(sheetName);
          int startRow,startCol, endRow, endCol,ci,cj;
          Cell tableStart=sheet.findCell(tableName);
          startRow=tableStart.getRow();
          startCol=tableStart.getColumn();

          Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);                               

          endRow=tableEnd.getRow();
          endCol=tableEnd.getColumn();
          System.out.println("startRow="+startRow+", endRow="+endRow+", " +
                  "startCol="+startCol+", endCol="+endCol);
          tabArray=new String[endRow-startRow-1][endCol-startCol-1];
          ci=0;

          for (int i=startRow+1;i<endRow;i++,ci++){
              cj=0;
              for (int j=startCol+1;j<endCol;j++,cj++){
                  tabArray[ci][cj]=sheet.getCell(j,i).getContents();
              }
          }
      }
      catch (Exception e)    {
          System.out.println("error in getTableArray()");
      }

      return(tabArray);
  }

}
