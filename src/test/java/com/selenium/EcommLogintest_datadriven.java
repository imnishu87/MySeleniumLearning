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

public class EcommLogintest_datadriven extends BaseTest implements EcommLoginConstant {
	//private WebDriver driver=null;
	
	@DataProvider (name="loginsuccessids")
	public Object [][] getdataforSuccessLogin(){
	String [][] data=getTableArray("google_ids.xls","Sheet1","EcommerceIds");
	return data;
	}
     @Test(dataProvider="loginsuccessids")
     public void testSuccessLogin(String emailid,String pwd) throws InterruptedException {
	 WebElement Usrname= driver.findElement(By.name(EMAIL_NAME_LOCATOR));
	 Usrname.sendKeys(emailid);
   	 Thread.sleep(3000);
	 
   	WebElement Password=driver.findElement(By.name(PASSWORD_NAME_LOCATOR));
    Password.sendKeys(pwd);
	  
    WebElement Loginbtn=driver.findElement(By.linkText("Login"));
    Loginbtn.click();
    Thread.sleep(1000);
    
    if (driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div")).isDisplayed())
	 {
		 System.out.println("Test Pass");
	 }else
	 {
		 System.out.println("Test Failed");
	 }
    }
  
  @Test
  public void testwithBlankLogin() {
  	
  }
  
  @Test
  public void testwithBlankPassword() {
  }
  
  @Test
  public void testwithBothBlank() {
  }
  
  @Test
  public void testwithInvalidLogin() {
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
