package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	private WebDriver driver;

	public ProfilePage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);
	}

	public WebElement getAuthButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'after-arrow user-trigger-js user-trigger-active')]"));
	}

	public WebElement getMyAccountButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'my-account-dropdown')]//li[1]/a"));
	}

	public WebElement getProfileButton() {
		return driver.findElement(By.xpath("//*[@id = 'fixed__panel']//li[2]/a"));
	}

	public WebElement getUploadPhotoButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'upload uploadFile-Js')]"));
	}

	public WebElement getRemovePhotoButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'remove')]"));
	}

	public WebElement getFirstNameInput() {
		return driver.findElement(By.xpath("//*[@name='user_first_name']"));
	}

	public WebElement getLastNameInput() {
		return driver.findElement(By.xpath("//*[@name='user_last_name']"));
	}

	public WebElement getEmailInput() {
		return driver.findElement(By.xpath("//*[@name='user_email']"));
	}

	public WebElement getAddressInput() {
		return driver.findElement(By.xpath("//*[@name='user_address']"));
	}

	public WebElement getPhoneNo() {
		return driver.findElement(By.xpath("//*[@name='user_phone']"));
	}

	public WebElement getZipCode() {
		return driver.findElement(By.xpath("//*[@name='user_zip']"));
	}

	public void selectCountry(String country) {
		Select dropdownCountry = new Select(driver.findElement(By.id("user_country_id")));
		dropdownCountry.selectByVisibleText(country);
	}

	public void selectState(String state) {
		Select dropdownState = new Select(driver.findElement(By.id("user_state_id")));
		dropdownState.selectByVisibleText(state);
	}

	public void selectCity(String city) {
		Select dropdownCity = new Select(driver.findElement(By.id("user_city")));
		dropdownCity.selectByVisibleText(city);
	}

	public WebElement getPersonalInformationSaveButton() {
		return driver.findElement(
				By.xpath("//*[contains(@class, 'col-lg-12 col-md-12 col-sm-12 col-lg-12 align--right')]//input"));
	}

	public void goToProfilePage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getMyAccountButton());
		getProfileButton().click();
	}

	public void uploadPhoto(String pathToThePicture) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		File profilePhoto = new File(pathToThePicture);
		js.executeScript("arguments[0].click();", getUploadPhotoButton());
		WebElement profilePhotoUpload = driver.findElement(By.name("file"));
		profilePhotoUpload.sendKeys(profilePhoto.getAbsolutePath());
		Thread.sleep(2000);
	}

	public void removePhoto() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getRemovePhotoButton());
	}

	public void changePersonalInformation(String firstName, String lastName, String email, String address,
			String phoneNumber, String zipCode, String country, String state, String city) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		getFirstNameInput().clear();
		getLastNameInput().clear();
		getAddressInput().clear();
		getPhoneNo().clear();
		getZipCode().clear();
		getFirstNameInput().sendKeys(firstName);
		getLastNameInput().sendKeys(lastName);
		getAddressInput().sendKeys(address);
		getPhoneNo().sendKeys(phoneNumber);
		getZipCode().sendKeys(zipCode);
		selectCountry(country);
		selectState(state);
		selectCity(city);
		js.executeScript("arguments[0].click();", getPersonalInformationSaveButton());
	}

}
