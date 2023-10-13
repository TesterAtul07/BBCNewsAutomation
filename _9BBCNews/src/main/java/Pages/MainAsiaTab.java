package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainAsiaTab {
	
	@FindBy (xpath = "(//div[@class='gs-o-media__body'])[1]")
	private WebElement asiaLatestUpdateTitle;
	
	@FindBy (xpath = "(//span[text()='China'])[1]")
	private WebElement chinaTab;
	
	@FindBy (xpath = "(//span[text()='India'])[1]")
	private WebElement indiaTab;
	
	private WebDriver driver;
	private Actions actions;
	
	public MainAsiaTab(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver);
	}

	public String getLatestUpdateTitle()
	{
		System.out.println("Latest news update from Asia");
		String asialatestUpdate = asiaLatestUpdateTitle.getText();
		return asialatestUpdate;
	}
	
	public void clickOnChinaTab() throws InterruptedException
	{
		actions.moveToElement(chinaTab).click().build().perform();
		Thread.sleep(500);
	}
	
	public void clickOnIndiaTab() throws InterruptedException
	{
		actions.moveToElement(indiaTab).click().build().perform();
		Thread.sleep(500);
	}
}
