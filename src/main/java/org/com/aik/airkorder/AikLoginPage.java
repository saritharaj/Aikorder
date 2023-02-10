package org.com.aik.airkorder;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;


public class AikLoginPage  extends TestBase{
	//public JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
	By uname=By.id("formGroupUserNameInput");
	By password=By.id("formGroupPasswordInput");
	By loginbtn=By.xpath("//*[contains(text(),'ログイン')]");
	static By dashboardtext=By.xpath("//*[contains(text(),'現在のタスク')]");

	 By projectlist=By.xpath("//a[contains(@href,'/company/projectList')]");
	//By projectlist=By.xpath("//*[contains(text(),'案件検索')]");
	By appliedprojectlist=By.xpath("//*[contains(text(),'応募済み案件')]");
	By tradinghistory=By.xpath("");
	
	public AikLoginPage getlogin(String user,String pass) {
		driver.findElement(uname).clear();
		driver.findElement(uname).sendKeys(user);
		driver.findElement(password);
		driver.findElement(password).sendKeys(pass);
		WebElement button =driver.findElement(loginbtn);
		button.click();
		return this;
	}
	public AikLoginPage  getdashboardtext(String expectedtitle) {
		
		String dashboardtext1=driver.findElement(dashboardtext).getText().trim();
		return this;
	}

	/*
	 * public AikLoginPage enterusername(String user) {
	 * 
	 * driver.findElement(uname).clear(); driver.findElement(uname).sendKeys(user);
	 * return this; }
	 */
	/*
	 * public AikLoginPage enterpassword(String pass)
	 * 
	 * { driver.findElement(password); driver.findElement(password).sendKeys(pass);
	 * return this; }
	 */
	/*
	 * public AikLoginPage clicklogin()
	 * 
	 * { WebElement button =driver.findElement(loginbtn); button.click();
	 * //JavascriptExecutor js = (JavascriptExecutor)driver;
	 * //jsExecutor.executeScript("arguments[0].click();",button);
	 * 
	 * //clickByXpath(loginbtn); return this;
	 * 
	 * }
	 */

public AikLoginPage verifyprojectlist(String expectedResults){
	
	String actualResult = driver.findElement(projectlist).getText();
	
	//System.out.println(actualResult);
	
	
	/*
	 * String result; //System.out.println(result); if
	 * (expectedResults.equalsIgnoreCase(actualResult)) {
	 * result="projectlist tab is verified"; System.out.println(result);
	 * 
	 * } else { result="projectlist tab is is wrong"; System.out.println("result");
	 * } Assert.assertEquals(actualResult,expectedResults,result);
	 */
	 
	return this;
}

public AikLoginPage verifyappliedprojectlist(String expectedResults) {
	String actualResult=driver.findElement(appliedprojectlist).getText();
	System.out.println(actualResult);
	String result;
	if(expectedResults.equalsIgnoreCase(actualResult))
		
{
		result="appliedproject tab is verified";
		System.out.println(result);
}
	else {
		result="appliedproject is is wrong";
		System.out.println("result");
	}
	Assert.assertEquals(actualResult,expectedResults,result);
	return this;
}

/*
 * public AikLoginPage verifytradingtab(String expectedResults) { String
 * actualResult=driver.findElement(appliedprojectlist)
 * 
 * return this; }
 */

public AikLoginPage verifyprojecttab() {
	String expectedresults="案件検索";
	String actualResult = driver.findElement(projectlist).getText();
	System.out.println(actualResult);
	String result;
	//System.out.println(result);
	if (expectedresults.equalsIgnoreCase(actualResult))
	{
		result="projectlist tab is verified";
		System.out.println(result);

	}
	else {
		result="projectlist tab is is wrong";
		System.out.println("result");
	}
	Assert.assertEquals(actualResult,expectedresults,result);
	
	
	return this;
}




@DataProvider
public Object [][]  ExcelDataRead() throws IOException, InterruptedException 
{
	FileInputStream fileInputStream= new FileInputStream("D:/Automation/airkorder/src/test/java/testdata/AikLoginData.xls"); //Excel sheet file location get mentioned here
	
	HSSFWorkbook workbook = new HSSFWorkbook (fileInputStream); //get my workbook 
	HSSFSheet worksheet = workbook.getSheet("LoginTestData");// get my sheet from workbook
	HSSFRow Row=worksheet.getRow(0);   //get my Row which start from 0   

	int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
	int ColNum= Row.getLastCellNum(); // get last ColNum 

	Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array

	for(int i=0;i<RowNum-1; i++) //Loop work for Rows
	{  
		HSSFRow row= worksheet.getRow(i+1);

		for (int j=0; j<ColNum; j++) //Loop work for colNum
		{
			if(row==null)
				Data[i][j]= "";
			else 
			{
				HSSFCell cell= row.getCell(j);
				if(cell==null)
					Data[i][j]= ""; //if it get Null value it pass no data 
				else
				{
					//						String encoded = URLEncoder.encode(sValue, "UTF-8");

											String value=cell.getStringCellValue();
					//String value=CellValue(cell);


					//						cell.getStringCellValue().getBytes(Charset.forName("UTF-8"));
					Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value

					System.out.println("Excel Data :"+value);
				}
			}
		}
	}

return Data;
}

}


