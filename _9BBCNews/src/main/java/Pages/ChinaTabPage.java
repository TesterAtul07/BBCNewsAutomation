package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChinaTabPage {
	
	@FindBy (xpath = "(//div[@class='gs-o-media__body'])[1]")
	private WebElement chinaLatestUpdateTitle;

	private WebDriver driver;
	
	public ChinaTabPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public String getchinaLatestUpdate()
	{
		System.out.println("Latest news update from China");
		String chinaLatestUpdate = chinaLatestUpdateTitle.getText();
		return chinaLatestUpdate;
	}
}

