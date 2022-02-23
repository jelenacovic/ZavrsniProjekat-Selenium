package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage extends BasicPage{

	private WebDriver driver;
	
	public CartSummaryPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);
	}
	
	public WebElement getClearAllButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'btn btn--third  btn--small no-radius')]"));
	}

	public void clearAll() {
		getClearAllButton().click();
	}

}
