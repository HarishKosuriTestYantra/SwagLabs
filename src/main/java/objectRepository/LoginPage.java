package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id = "user-name")
	private WebElement usernameTxtField;
	
	@FindBy(id = "password")
	private WebElement passwordTxtField;
	
	@FindBy(id = "login-button")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameTxtField() {
		return usernameTxtField;
	}

	public WebElement getPasswordTxtField() {
		return passwordTxtField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void login(String username, String password)
	{
		usernameTxtField.sendKeys(username);
		passwordTxtField.sendKeys(password);
		loginButton.click();
	}

}
