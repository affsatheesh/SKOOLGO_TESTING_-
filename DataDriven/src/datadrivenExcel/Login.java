package datadrivenExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import jxl.read.biff.BiffException;

public class Login 
{
	  WebDriver driver;
	  
	  ExtentReports extentreport;
	  
	  ExtentHtmlReporter htmlreporter;
	  
	  ExtentTest testcase;

	@Test(dataProvider="logindata")
	public void loginwithbothcorrect (String uname ,String pword) throws IOException, InterruptedException
	{
		extentreport = new ExtentReports();
	    htmlreporter = new ExtentHtmlReporter("ExtentReport1.html");
	    extentreport.attachReporter(htmlreporter);
	    
		System.setProperty("webdriver.chrome.driver", "D:\\software\\Study@@\\jar files\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		
		ExtentTest testcase1= extentreport.createTest(" verify the Login testcase");
		testcase1.log(Status.INFO, "NAVIGATING TO PixcelMind URL");
	     Thread.sleep(6000);
		driver.get("https://skoolgo.pixelmindit.com:5000/#/");
	    
		WebElement username = driver.findElement(By.id("userName"));
		username.sendKeys(uname);
		testcase1.log(Status.INFO, "Username Entered");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(pword);
		testcase1.log(Status.INFO, "password Enterted");
		WebElement login =driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
	    String url = driver.getCurrentUrl();
	    
	    testcase1.log(Status.PASS, "Login page displayed testcase Pass");
	    if (url.equals("https://skoolgo.pixelmindit.com:5000/#/"))
	    	
	    {
	    	System.out.println("Login test case pass");
	    	testcase1.log(Status.INFO, "Login testcase_1 pass");
	    	driver.close();
	    }
	    else 
	    {
	    	System.out.println("login test case fail");
	    	testcase1.log(Status.INFO, "Login testcase_1 fail");
		      TakesScreenshot screenshot = (TakesScreenshot)this.driver;
		      File src = (File)screenshot.getScreenshotAs(OutputType.FILE);
		      File des = new File("Failedtestcase.png");
		      FileHandler.copy(src, des);
		      testcase1.log(Status.INFO, "taking failed tasecase screenshot");
		      testcase1.addScreenCaptureFromPath("Failedtestcase.png", "Homepage is not displayed");
		      driver.close();
	    }
	    

	}
	
	String [][] data =null;

	@DataProvider(name ="logindata")
	public String [][] logindataprovider() throws BiffException, IOException
	{
		data=getexceldata();
		return data;
	}
	public String[][] getexceldata() throws IOException, BiffException
	{
		FileInputStream excel = new FileInputStream("./Data/Book1.xls");
		jxl.Workbook workbook = jxl.Workbook.getWorkbook(excel);
		jxl.Sheet sheet = workbook.getSheet(0);
		int rowcount = sheet.getRows();
		int cowcount= sheet.getColumns();

		String testData[][]=new String [rowcount-1][cowcount];
		for(int i=1;i<rowcount;i++)
		{
			for(int j=0;j<cowcount;j++)
			{
				testData [i-1][j] = sheet.getCell(j,i).getContents();
			}
		}

		return testData;
	}
	
	@AfterSuite
	public void closeBrowser()
	{
		driver.quit();
		extentreport.flush();
	}
}
