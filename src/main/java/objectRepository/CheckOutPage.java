package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	@FindBy(id = "first-name")
	private WebElement firstNameTxtField;
	
	@FindBy(id = "last-name")
	private WebElement lastNameTxtField;
	
	@FindBy(id = "continue")
	private WebElement continueButton;
	
	@FindBy(id = "finish")
	private WebElement finishButton;
	
	@FindBy(id = "postal-code")
	private WebElement postalCodeTxtField;
	
	@FindBy(xpath = "//span[contains(.,'Checkout')]")
	private WebElement checkOutTab; 
	
	@FindBy(id = "back-to-products")
	private WebElement backToProductsButton;
	
	
	
	public CheckOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstNameTxtField() {
		return firstNameTxtField;
	}

	public WebElement getLastNameTxtField() {
		return lastNameTxtField;
	}

	public WebElement getPostalCodeTxtField() {
		return postalCodeTxtField;
	}
	
	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getFinishButton() {
		return finishButton;
	}

	public WebElement getCheckOutTab() {
		return checkOutTab;
	}

	public WebElement getBackToProductsButton() {
		return backToProductsButton;
	}

	public void userInfo(String firstName, String lastName, String postalCode)
	{
		firstNameTxtField.sendKeys(firstName);
		lastNameTxtField.sendKeys(lastName);
		postalCodeTxtField.sendKeys(postalCode);
	}
	
	public void clickOnContinueButton()
	{
		continueButton.click();
	}
	
	public void clickOnFinishButton()
	{
		finishButton.click();
	}
	
	public String getcheckOutTabText()
	{
		return checkOutTab.getText();
	}
	
	public void clickOnBackToProductsButton()
	{
		backToProductsButton.click();
	}

}
