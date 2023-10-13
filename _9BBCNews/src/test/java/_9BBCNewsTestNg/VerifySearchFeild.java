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

import Pages.HomePage;
import Pages.SearchPage;
import Pages.SearchResultPage;
import Pages.TopNewsPage;
import dev.failsafe.internal.util.Assert;

public class VerifySearchFeild {
	
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
	public void verifySearchFeildFunctionality() throws InterruptedException
	{
		HomePage homePage = new HomePage(driver);
		homePage.clickOnSearchFeildTab();
		
		SearchPage searchPage = new SearchPage(driver);
		searchPage.clickOnSearchInputFeild();
		searchPage.sendDataIntoSearchInputFeild("India");
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.bbc.co.uk/search?q=India&seqId=95d9adb0-5ba0-11ee-80c7-2b1544d18854&d=news_gnl";		
		assertEquals(actualUrl, expectedUrl);
		
		String actualTitle = driver.getTitle();
		String expeectedTitle = "BBC - Search results for India";
		assertEquals(actualTitle, expeectedTitle);
        
		searchResultPage.clickOnTopNews();
		TopNewsPage topNewsPage = new TopNewsPage(driver);
		topNewsPage.getNewsTitle();	
	}
	
	@AfterMethod
	public void testStatement()
	{
		System.out.println("Test2");
	}
	
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}

}
