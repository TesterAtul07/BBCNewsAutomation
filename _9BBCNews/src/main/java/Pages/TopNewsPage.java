package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopNewsPage {

	@FindBy (xpath = "//h1[@id='main-heading']")
	private WebElement newsTitle;
	
private WebDriver driver;
	
	public TopNewsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	
	public String getNewsTitle()
	{
		String titleOfNews = newsTitle.getText();
		//System.out.println(titleOfNews);
		
		
		return titleOfNews;
		
	}

	
}
