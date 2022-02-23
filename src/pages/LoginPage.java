package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//*[@class='filled']/a"));
	}
	
	public WebElement getUsernameInput() {
		return driver.findElement(By.xpath("//*[@name='username']"));
	}
	
	public WebElement getPasswordInput() {
		return driver.findElement(By.xpath("//*[@name='password']"));
	}
	
	public WebElement getRememberMeCheckbox() {
		return driver.findElement(By.xpath("//*[@name='remember_me']"));
	}
	
	public WebElement getSubmitButton() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}
	
	public void login(String username, String password) {
		getLoginButton().click();
		getUsernameInput().clear();
		getUsernameInput().sendKeys(username);
		getPasswordInput().clear();
		getPasswordInput().sendKeys(password);
		getSubmitButton().click();
	}
	

}
