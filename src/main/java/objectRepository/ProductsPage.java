package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author haris
 *
 */
public class ProductsPage {
	
	@FindBy(id = "item_1_title_link")
	private WebElement tshirtLink;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement cartIcon;
	
	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuBar;
	
	@FindBy(id = "logout_sidebar_link")
	private WebElement logoutLink;
	
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	private List<WebElement> inventoryProducts;

	
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getTshirtLink() {
		return tshirtLink;
	}
	
	public WebElement getCartIcon() {
		return cartIcon;
	}
	

	public WebElement getMenuBar() {
		return menuBar;
	}

	public WebElement getLououtLink() {
		return logoutLink;
	}
	

	public List<WebElement> getInventoryProducts() {
		return inventoryProducts;
	}

	public void clickOnTshirtLink()
	{
		tshirtLink.click();
	}
	
	public void clickOnCartIcon()
	{
		cartIcon.click();
	}
	
	public void clickOnMenuBar()
	{
		menuBar.click();
	}
	
	public void logout()
	{
		logoutLink.click();
	}
	

}
