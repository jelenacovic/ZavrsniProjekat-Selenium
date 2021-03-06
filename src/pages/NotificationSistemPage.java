package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSistemPage extends BasicPage {
	private WebDriver driver;
	
	public NotificationSistemPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);
	}
	
	public WebElement getMessage() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success')"));
	}
	
	public String getNotificationMessage() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success')]//li")).getText();
	}

	public void waitForMessageToDisappear() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.attributeToBe(By.xpath(" //*[contains(@class, 'system_message')]"), "style",
				"display: none;"));
	}
}
