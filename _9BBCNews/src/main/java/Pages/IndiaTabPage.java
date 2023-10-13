package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndiaTabPage {

	@FindBy (xpath = "(//div[@class='gs-o-media__body'])[1]")
	private WebElement indiaLatestUpdateTitle;
	
	private WebDriver driver;
	
	public IndiaTabPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public String getindiaLatestUpdate()
	{
		System.out.println("Latest news update from India");
        String indiaLatestUpdate = indiaLatestUpdateTitle.getText();
        return indiaLatestUpdate;
		
	}
}
