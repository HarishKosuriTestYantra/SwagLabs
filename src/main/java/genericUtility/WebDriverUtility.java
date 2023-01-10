package genericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	
	public void maximizeScreen(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
	}
	
	public void selectDropDown(WebElement ele, int index)
	{
		Select s =new Select(ele);
		s.selectByIndex(index);
	}
	
	public void selectDropDown(WebElement ele, String value)
	{
		Select s =new Select(ele);
		s.selectByValue(value);
	}
	
	public void selectDropDown(String text, WebElement ele)
	{
		Select s =new Select(ele);
		s.selectByVisibleText(text);
	}
}
