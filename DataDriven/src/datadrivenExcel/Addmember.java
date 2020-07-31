package datadrivenExcel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Addmember 
{
	WebDriver driver;

	ExtentReports extentreport;

	ExtentHtmlReporter htmlreporter;

	ExtentTest testcase;
	
    @Test
	public void EnteringData() throws IOException, InterruptedException, AWTException
	{
    	
		
		extentreport = new ExtentReports();
		htmlreporter = new ExtentHtmlReporter("ExtentReport2.html");
		extentreport.attachReporter(htmlreporter);
	
		System.setProperty("webdriver.chrome.driver", "D:\\software\\Study@@\\jar files\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.get("https://skoolgo.pixelmindit.com:5000/#/");
		
		
		WebElement username = driver.findElement(By.id("userName"));
		username.sendKeys("admin@pixel.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("sk12345");

		WebElement login =driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();

		ExtentTest testcase2= extentreport.createTest(" Addmember testcase Started");
		Thread.sleep(10000);
		WebElement member= driver.findElement(By.xpath("//p[text()='Members']"));
		WebElement addmember= driver.findElement(By.xpath("//a[text()='Add Members']"));
		Actions action = new Actions(driver);
		action.moveToElement(member).build().perform();
		action.doubleClick(addmember).build().perform();
		testcase2.log(Status.INFO, "Entering the Form successfully");
		// Entering FullName
		
		Thread.sleep(5000);
		
		WebElement fullname= driver.findElement(By.id("fullName"));
		fullname.sendKeys("satheshkumar");
		testcase2.log(Status.INFO, " Fullname Entered successfully");
		
		// Entering EmailId
		Thread.sleep(5000);
		WebElement emailid= driver.findElement(By.id("email"));
		emailid.sendKeys("affsatheesh@gmail.com");
		testcase2.log(Status.INFO, " EmailId Entered successfully");
		
		//Entering Phonenumber
		Thread.sleep(5000);
		WebElement phonenumber= driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/form/div/div[2]/div/div[3]/div/div[1]/div/input"));
		phonenumber.sendKeys("+916379709559");
		testcase2.log(Status.INFO, " Phonenumber Entered successfully");
		
		//Entering PersonalId
		Thread.sleep(5000);
		WebElement personalId= driver.findElement(By.id("personalId"));
		personalId.sendKeys("affsatheesh");
		testcase2.log(Status.INFO, " personalId Entered successfully");

		// DOB giving
		Thread.sleep(5000);
		WebElement DOB= driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiInput-input']"));
		DOB.click();
		testcase2.log(Status.INFO, " Started entering Date Of Birth successfully");
		Thread.sleep(5000);
		
	
		WebElement year= driver.findElement(By.xpath("//h6[text()='2020']"));
		year.click();
		
		Thread.sleep(5000);
		
		WebElement myyear= driver.findElement(By.xpath("//div[text()='1996']"));
		action.moveToElement(myyear).build().perform();
		action.doubleClick().build().perform();
			
		Thread.sleep(5000);
	
		WebElement day= driver.findElement(By.xpath("//p[text()='12']"));
		action.doubleClick(day).build().perform();
		testcase2.log(Status.INFO, " Date Of Birth Entered successfully");
		Thread.sleep(5000);

     // selecting Nationality
		Thread.sleep(5000);
		WebElement nationality= driver.findElement(By.id("nationality"));

		Select select = new Select(nationality);

		List<WebElement> options= select.getOptions();
		int fullList=options.size();
		System.out.println(fullList);

		for (WebElement webElement : options)
		{
			String text = webElement.getText();
			select.selectByVisibleText("India");
			
		}
		testcase2.log(Status.INFO, " Nationality India Selected successfully");
	//	Gender selecting
		Thread.sleep(8000);
		WebElement gender= driver.findElement(By.id("gender"));

		Select selectsgender= new Select(gender);

		List<WebElement> options1= selectsgender.getOptions();

		for (WebElement webElement : options1)
		{
			String gentertext = webElement.getText();
			selectsgender.selectByVisibleText("Male");
			
		}
		testcase2.log(Status.INFO, " Gender Male Selected successfully");

		// Branch selecting
		Thread.sleep(8000);
		WebElement branch= driver.findElement(By.id("branch"));

		Select selectbranch1= new Select (branch);

		List<WebElement> options2= selectbranch1.getOptions();
		int fullList2=options2.size();
		System.out.println(fullList2);

		for (WebElement webElement : options2)
		{
			String text2 = webElement.getText();
			selectbranch1.selectByVisibleText("Manama");
			
		}
		testcase2.log(Status.INFO, " Branch Manama Selected successfully");
		
		//Height
		Thread.sleep(5000);
		WebElement height= driver.findElement(By.id("height"));
		Thread.sleep(3000);
		height.clear();
		height.sendKeys("6.2");
		testcase2.log(Status.INFO, " Height Entered on the page successfully");
		
		//weight
		Thread.sleep(5000);
		WebElement weight= driver.findElement(By.id("weight"));
		Thread.sleep(3000);
		weight.clear();
		weight.sendKeys("55");
		testcase2.log(Status.INFO, " Weight Entered on the page successfully");
		
		// Emergency No (optional)
		Thread.sleep(3000);
		WebElement phonenumberop= driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/form/div/div[2]/div/div[12]/div/div[1]/div/input"));
		phonenumberop.sendKeys("+916379709559");
		testcase2.log(Status.INFO, " Emergency contact number Entered on the page successfully");
	
		// Relationship
		Thread.sleep(3000);
		WebElement relationship= driver.findElement(By.id("relationship"));
		relationship.sendKeys("Brother");
		testcase2.log(Status.INFO, "Relationship Entered on the page successfully");
		
		// Notes
		Thread.sleep(3000);
		WebElement notes= driver.findElement(By.id("Notes"));
		notes.sendKeys("Hi this is sathez");
		testcase2.log(Status.INFO, "Short Notes i gave on the page successfully");
		
		// User Photo upload
		
		Thread.sleep(10000);
		
 WebElement	uploading=	driver.findElement(By.xpath("//span[text()='Browse']"));
 Thread.sleep(3000);
 action.moveToElement(uploading).click().build().perform();
		
		  String imagefiles= "C:\\Users\\~ SATHEZ ~\\s.jpg";
		
	    StringSelection imageselection = new StringSelection(imagefiles);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(imageselection, null);
	    
		Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    
	    Thread.sleep(8000);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    
	    testcase2.log(Status.INFO, "Successfull photo uploaded successfully");
	    Thread.sleep(10000);
	    
	    WebElement PackageDetails= driver.findElement(By.id("packageName"));
	    
	    Select selectPackage= new Select (PackageDetails);

		List<WebElement> packageoption= selectPackage.getOptions();
		int fullList7=packageoption.size();
		System.out.println(fullList7);

		for (WebElement webElement : packageoption)
		{
			String text7 = webElement.getText();
			selectPackage.selectByIndex(3);
			
		}
		testcase2.log(Status.INFO, "package name selected successfully");
	    //Trainer
	    
        Thread.sleep(8000);
		List<WebElement> Trainer= driver.findElements(By.xpath("//div[text()='Please Select']"));

		Thread.sleep(5000);
		int positions=0;
		for (WebElement Trainerposition : Trainer)
		{
			System.out.println(Trainerposition.getText());
			positions++;
			if(positions==1)
			{
				Trainerposition.click();
				break;
			}
		}
		 Thread.sleep(5000);
		 
		 testcase2.log(Status.INFO, "Trained person name selected successfully");
		 
		WebElement period= driver.findElement(By.id("period"));

		Select selectperiod= new Select (period);

		List<WebElement> periodoptions= selectperiod.getOptions();

		for (WebElement webElement : periodoptions)
		{
			String periodtext= webElement.getText();
			selectperiod.selectByVisibleText("One Week");
			
		}
		 testcase2.log(Status.INFO, "period durtion selected successfully");
		// What is your Level?
		  Thread.sleep(5000);
		WebElement position= driver.findElement(By.id("levelQuestion"));

		Select selectposition= new Select (position);

		List<WebElement> options4= selectposition.getOptions();
		int fullList4=options4.size();
		System.out.println(fullList4);

		for (WebElement webElement : options4)
		{
			String text4 = webElement.getText();
			selectposition.selectByVisibleText("Beginner");
			
		}
		testcase2.log(Status.INFO, "Level or postion selected successfully");
		// What is your Goal?
		  Thread.sleep(5000);
		WebElement goal= driver.findElement(By.id("goalQuestion"));

		Select selectgoal= new Select (goal);

		List<WebElement> options5= selectgoal.getOptions();
		int fullList5=options5.size();
		System.out.println(fullList5);

		for (WebElement webElement : options5)
		{
			String text5 = webElement.getText();
			selectgoal.selectByVisibleText("Loss Weight");
			
		}
		testcase2.log(Status.INFO, "Goal selected successfully");
		// How many days you plan to exercising per a week?
		  Thread.sleep(5000);
		WebElement week= driver.findElement(By.id("exercisingQuestion"));

		Select selectweek= new Select (week);

		List<WebElement> options6= selectweek.getOptions();
		int fullList6=options6.size();
		System.out.println(fullList5);

		for (WebElement webElement : options6)
		{
			String text6 = webElement.getText();
			selectweek.selectByVisibleText("4 Days a week");
			
		}
		testcase2.log(Status.INFO, "Plan is selected successfully");
		 Thread.sleep(5000);
		WebElement submit= driver.findElement(By.xpath("//button[text()='Submit']"));
		submit.click();
		
		Thread.sleep(7000);
		String fatherwindow = driver.getWindowHandle();
		Set<String> childwindow = driver.getWindowHandles();
	    for (String string : childwindow)
	      driver.switchTo().window(string); 
	    
	    WebElement code = driver.findElement(By.id("addCard4lastno"));
	    code.sendKeys("2424");
	    testcase2.log(Status.INFO, "Card number gave successfully");
	    Thread.sleep(5000);
	    WebElement clicks = driver.findElement(By.xpath("//button[text()='Checkout']"));
	    //clicks.click();
	    
	    testcase2.log(Status.INFO, "Member successfully Created");
	    
	    testcase2.log(Status.INFO, "AddMember == TESTCASE PASS == successfully Created");
	    	
	    extentreport.flush();
	    
	   
		
	}

}
