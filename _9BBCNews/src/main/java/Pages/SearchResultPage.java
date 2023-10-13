package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
	@FindBy (xpath = "(//div[@data-testid='default-promo'])[1]")
	private WebElement topNews;
	
	
	
	private WebDriver driver;
	
	public SearchResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickOnTopNews() throws InterruptedException
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(topNews).click().build().perform();
		Thread.sleep(500);
	}
	
	
}
