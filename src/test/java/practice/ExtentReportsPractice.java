package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsPractice {
	
	WebDriver driver;
	
	ExtentHtmlReporter reporter ;
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeSuite 
	public void configureBS() {
		reporter = new ExtentHtmlReporter("../vtiger/SDET20ExtentRep/EXTENT20.html");
		reporter.config().setTheme(Theme.DARK);
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		
		System.out.println("Execute Configuration Before Suite");
	}
	
	@BeforeClass
	public void configureBC() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void configureBM() {
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
	}
	
	@Test
	public void extentReportTest1() {
		reports.createTest("extentReportTest1");
		String homeTitle = "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		String actualHomeTitle	 = driver.getTitle();
		
		System.out.println("Home page title expected ::"+homeTitle);
		System.out.println("Home page title actual ::"+actualHomeTitle);
//		if(actualHomeTitie.equals(homeTitle) ) {
//			System.out.println("Home page displyed successfully");
//		} else {
//			System.out.println("Home page is not displayed");
//		}
		Assert.assertEquals(actualHomeTitle, homeTitle);
		
	}
	
	@Test
	public void extentReportTest2() {
		reports.createTest("extentReportTest2");
		driver.findElement(By.linkText("Organizations")).click();
		String orgTitle = "Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM";
		String actualOrgTitle = driver.getTitle();
		
		System.out.println("Home page title expected ::"+orgTitle);
		System.out.println("Home page title actual ::"+actualOrgTitle);
//		if(actualOrgTitle.equals(orgTitle) ) {
//			System.out.println("Organization page displyed successfully");
//		} else {
//			System.out.println("Organization page is not displayed");
//		}
		Assert.assertEquals(actualOrgTitle, orgTitle);
	}
	
	@AfterMethod
	public void configureAM() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}
	@AfterClass
	public void configureAC() {
		driver.quit();
	}
	
	@AfterSuite 
	public void configureAS() {
		reports.flush();
		System.out.println("Execute Configuration After Suite");
	}
}

