package datadrivenExcel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Verifying_NewMember
{
	  WebDriver driver;
	  
	  static ExtentReports extentreport;
	  
	  static ExtentHtmlReporter htmlreporter;
	  
	  ExtentTest testcase;
	  
	public static void main(String[] args) throws InterruptedException, AWTException, IOException
	{
		extentreport = new ExtentReports();
	    htmlreporter = new ExtentHtmlReporter("ExtentReport3.html");
	    extentreport.attachReporter(htmlreporter);
	    ExtentTest testcase2= extentreport.createTest(" verify the Newly created Member testcase");
	    
		System.setProperty("webdriver.chrome.driver", "D:\\software\\Study@@\\jar files\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://skoolgo.pixelmindit.com:5000/#/add-member");
		testcase2.log(Status.INFO, "NAVIGATING TO PixcelMind Skoolgo URL");

		WebElement username = driver.findElement(By.id("userName"));
		username.sendKeys("admin@pixel.com");
		
		testcase2.log(Status.INFO, "Username Enter successfully");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("sk12345");
		testcase2.log(Status.INFO, "Password Enter successfully");
		
		WebElement login =driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
		
		testcase2.log(Status.INFO, "click login button successfully");
		Thread.sleep(10000);

		WebElement member= driver.findElement(By.xpath("//p[text()='Members']"));
		testcase2.log(Status.INFO, "NAVIGATING TO Member");
		WebElement memberlist= driver.findElement(By.xpath("//a[text()='Members List']"));
		Actions action = new Actions(driver);
		action.moveToElement(member).build().perform();
		action.doubleClick(memberlist).build().perform();
		testcase2.log(Status.INFO, "NAVIGATING TO Memberlist");
		 Thread.sleep(5000);
		WebElement Newmembers= driver.findElement(By.xpath("//a[text()='New Members']"));
		Newmembers.click();
           Thread.sleep(5000);
           testcase2.log(Status.INFO, "NAVIGATING TO NewMember");
           boolean name=   driver.findElement(By.xpath("//h5[text()='satheshkumar']")).isDisplayed();
           
           if(name==true)
           {
        	   testcase2.log(Status.INFO, "Verifycation pass membercreated Successfully");
        	  
        	   WebElement Details = driver.findElement(By.xpath("//a[text()='Details']"));
        	   testcase2.log(Status.INFO, "Open the Details successfully");
				Details.click();
				testcase2.log(Status.INFO, "Click on Close button");
				 testcase2.log(Status.INFO, "==TESTCASE PASSED== ");
				driver.close();
				extentreport.flush();
			
           }
           else
           {
        	   testcase2.log(Status.INFO, "==TESTCASE FAILED==");
        	      TakesScreenshot screenshot = (TakesScreenshot)driver;
        	      File src = (File)screenshot.getScreenshotAs(OutputType.FILE);
        	      File des = new File("PIXCELMINDtestcase3.png");
        	      FileHandler.copy(src, des);
        	      testcase2.addScreenCaptureFromPath("PIXELMINDtestcase2.png", "Not created NewMember");
           }
		}
	}
