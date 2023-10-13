package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy (xpath = "(//span[text()='Search BBC'])[2]")
	private WebElement searchFeildTab;
	
	
	@FindBy (xpath = "(//span[text()='Travel'])[1]")
	private WebElement travelTab;
	
	
	@FindBy (xpath = "(//span[text()='Asia'])[1]")
	private WebElement asiaTab;
	
	private WebDriver driver;
	private Actions actions;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver);
		
	}
	
	public void clickOnSearchFeildTab() throws InterruptedException
	{
		actions.moveToElement(searchFeildTab).click().build().perform();
		Thread.sleep(500);	
	}
	
	public void clickOnAsiaTab() throws InterruptedException
	{
		actions.moveToElement(asiaTab).click().build().perform();
		Thread.sleep(500);
	}
	
	public void clickOnTravelTab() throws InterruptedException
	{
		actions.moveToElement(travelTab).click().build().perform();
		Thread.sleep(500);
	}


}
