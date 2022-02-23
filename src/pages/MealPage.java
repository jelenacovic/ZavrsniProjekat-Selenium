package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage{

	private WebDriver driver;
	
	public MealPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);
	}
	
	public WebElement getMealsButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'navs--main')]//li[1]/a"));
	}
	
	public WebElement getSearchButton() {
		return driver.findElement(By.xpath("//*[@class='js-search-keywords']"));
	}
	
	public WebElement getProduct() {
		return driver.findElement(By.xpath("//*[@id='listing']/div[1]/div/div[2]/div[2]/a"));
	}
	
	public WebElement getQuantityInput() {
		return driver.findElement(By.name("product_qty"));
	}

	public WebElement getAddToCartButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'btn btn--primary btn--large js-proceedtoAddInCart ')]"));
	}
	
	public WebElement getFavouriteButton() {
		return driver.findElement(By.className("favourite itemfav  link "));
	}
	
	public void addProductToTheCart(String quantity) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		getMealsButton().click();
		js.executeScript("arguments[0].click();", getProduct());
		getQuantityInput().clear();
		getQuantityInput().sendKeys(quantity);
		getAddToCartButton().click();
	}
	
	public void addToFavourite() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		getMealsButton().click();
		js.executeScript("arguments[0].click();", getFavouriteButton());
	}

}
