package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage {
	
	private WebDriver driver;
	
	public LocationPopupPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);
	}
	
	public WebElement getCloseElement() {
		return driver.findElement(By.xpath("//*[contains(@class, 'close-btn close-btn-white')]"));
	}
	
	public WebElement getLocationButton() {
		return this.driver.findElement(By.xpath("//div[@class='location-selector']/a"));
	}

	public WebElement getKeyword() {
		return this.driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}
	
	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}
	
	public WebElement getLocationInput() {
		return driver.findElement(By.id("//*[@id='location_id']"));
	}
	
	public WebElement getSubmit() {
		return driver.findElement(By.name("//*[@name='btn_submit']"));
	}
	
	public void openLocation() {
		this.getLocationButton().click();
	}
	
	public void setLocation(String locationName) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		this.getKeyword().click();
		String value = getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value=arguments[1];", getLocationInput(), value);
		js.executeScript("arguments[0].click();", getSubmit());
	}
	
	public void closeElement() {
		this.getCloseElement().click();
	}
}
