package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {

	private WebDriver driver;
	
	public AuthPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);
	}
	
	public WebElement getAuthButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'after-arrow user-trigger-js user-trigger-active')]"));
	}
	
	public WebElement getMyAccountButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'my-account-dropdown')]//li[1]/a"));
	}

	public WebElement getLogoutButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'my-account-dropdown')]//li[2]/a"));
	}
	
	public void logOut() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getLogoutButton());
	}
}
