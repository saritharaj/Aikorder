package org.com.aik.airkorder;

import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;



public class AikLogin_TestCase  extends AikLoginPage{

	@BeforeTest
	public  void setup() 
{
	OpenBrowser();
	 
}
	@Test(dataProvider="ExcelDataRead")
	public  void testcase(String username,String Password,String appliedprojectlist) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		/*
		* .enterusername(username) .enterpassword(Password) .clicklogin()
		*/
		//.verifyprojecttab();;
		new AikLoginPage() //class object creation
		.getlogin(username, Password)
		//AikLoginPage titl=.getdashboardtext(expectedtitle);
		
		
		
		
		//.verifyprojectlist(projectlist)
		.verifyappliedprojectlist(appliedprojectlist);
		//.projectlistelementpresent()
		
		
	
}}
