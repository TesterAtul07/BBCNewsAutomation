package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	@FindBy (xpath = "//input[@id='searchInput']")
	private WebElement searchInputFeild;
	
	private WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public void clickOnSearchInputFeild() throws InterruptedException
	{
		Actions actions = new Actions(driver);

		actions.moveToElement(searchInputFeild).click().build().perform();
		Thread.sleep(500);
   }

	
	
	public void sendDataIntoSearchInputFeild(String search) throws InterruptedException
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(searchInputFeild).click().sendKeys(search).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(500);
	}
}
