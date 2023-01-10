package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TshirtPage {

	
	@FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
	private WebElement addShirtToCartButton;
	
	public TshirtPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddShirtToCartButton() {
		return addShirtToCartButton;
	}
	
	public void clickOnCart()
	{
		addShirtToCartButton.click();
	}
}
