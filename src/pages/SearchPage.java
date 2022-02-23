package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasicPage {

	private WebDriver driver;
	
	public SearchPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);
	}
	
	public WebElement getMealsButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'navs--main')]//li[1]/a"));
	}
	
	public List<WebElement> getSearchResults() {
		return driver.findElements(By.xpath("//*[@class='product-name']/a"));
	}

	public ArrayList<String> searchResultNames() {
		String name = null;
		ArrayList<String> names = new ArrayList<String>();
		for (int i = 0; i < names.size(); i++) {
			name = getSearchResults().get(i).getText();
			names.add(name);
		}
		return names;
	}
	
	public int searchResultsNumber() {
		return getSearchResults().size();
	}
}
