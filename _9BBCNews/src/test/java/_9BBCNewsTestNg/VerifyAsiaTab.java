package _9BBCNewsTestNg;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.ChinaTabPage;
import Pages.HomePage;
import Pages.IndiaTabPage;
import Pages.MainAsiaTab;

public class VerifyAsiaTab {

	private WebDriver driver;
	@BeforeClass
	public void launchBrowser()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nagea\\Desktop\\Automation\\Tools\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		
	    driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	@BeforeMethod 
	public void login() throws InterruptedException
	{
		driver.get("https://www.bbc.com/news");
		Thread.sleep(500);
		
	}
	
	@Test
	public void verifyAsiaTabFunctionality() throws InterruptedException
	{
		HomePage homePage = new HomePage(driver);
		homePage.clickOnAsiaTab();
		
		MainAsiaTab mainAsiaTab = new MainAsiaTab(driver);
		mainAsiaTab.getLatestUpdateTitle();
		
		mainAsiaTab.clickOnChinaTab();
		ChinaTabPage chinaTabPage = new ChinaTabPage(driver);
		chinaTabPage.getchinaLatestUpdate();
		
		mainAsiaTab.clickOnIndiaTab();
		IndiaTabPage indiaTabPage = new IndiaTabPage(driver);
		indiaTabPage.getindiaLatestUpdate();
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.bbc.com/news/world/asia/india";		
		assertEquals(actualUrl, expectedUrl);
		
		String actualTitle = driver.getTitle();
		String expeectedTitle = "India - BBC News";
		assertEquals(actualTitle, expeectedTitle);
        	}
	
	@AfterMethod
	public void testStatement()
	{
		System.out.println("Test1");
	}

	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}

	
}
