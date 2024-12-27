package pageObject;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumHelpers;

public class FormPage {
	WebDriver driver;

	public FormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}

	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement fn;

	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement ln;

	@FindBy(xpath = "//input[@id='userEmail']")
	private WebElement emailEle;

	@FindBy(xpath = "//label[text()='\" + gender + \"']")
	private WebElement gender;

	@FindBy(xpath = "//input[@id='userNumber']")
	private WebElement mobile;

	@FindBy(xpath = "//*[@id='subjectsContainer']//input")
	private WebElement subject;

	@FindBy(xpath = "//label[text()='Sports']")
	private WebElement sportsEle;

	@FindBy(xpath = "//label[text()='Reading']")
	private WebElement readingEle;

	@FindBy(xpath = "//label[text()='Music']")
	private WebElement musicEle;

	@FindBy(xpath = "//input[@id='uploadPicture']")
	private WebElement filepathEle;

	@FindBy(xpath = "//textarea")
	private WebElement addressEle;

	@FindBy(xpath = "//div[@id='state']")
	private WebElement stateEle;

	@FindBy(xpath = "//div[@id='city']")
	private WebElement cityEle;

	@FindBy(xpath = "//button[@id='submit']")
	private WebElement submitEle;

	public void setFirstName(String fName) throws InterruptedException {
		Thread.sleep(1000);
		SeleniumHelpers.sendData(fn,fName);
	}

	public void setLastName(String lName) {
		SeleniumHelpers.sendData(ln, lName);
	}

	public void setEmail(String email) {
		String emailRegex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		boolean e = email.matches(emailRegex);
		if (e) {
			SeleniumHelpers.sendData(emailEle, email);
		} else {
			return;
		}

	}

	public void setGender(String gender) {
		if (gender.equals("Male") || gender.equals("Female") || gender.equals("Other")) {
			WebElement gen = driver.findElement(By.xpath("//label[text()='" + gender + "']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gender);
			gen.click();
		}

	}

	public void setMobileNo(String mobileNo) {
		SeleniumHelpers.sendData(mobile, mobileNo);
	}

//public void setDateOfBirth(String dateOfBirth) {
//	
//}

	public void setSubject(String subjects) {
		if (subjects == null) {
			return;
		} else {
			Actions actions = new Actions(driver);
			SeleniumHelpers.sendData(subject, subjects);
			actions.keyDown(Keys.ENTER).click().keyUp(Keys.ENTER).perform();

		}

	}

	public void setSports(String sports) {
		if (sports.equals("TRUE")) {
			SeleniumHelpers.check(sportsEle);
		}
	}

	public void setReading(String reading) {
		WebElement read = driver.findElement(By.xpath("//label[text()='Reading']"));
		if (reading.equals("TRUE")) {
			SeleniumHelpers.check(readingEle);
		}
	}

	public void setMusic(String music) {
		WebElement mus = driver.findElement(By.xpath("//label[text()='Music']"));
		if (music.equals("TRUE")) {
			SeleniumHelpers.check(musicEle);
		}
	}

	public void setChooosefile(String filePath) {
		SeleniumHelpers.uploadFile(filepathEle,filePath);
	}

	public void setAddress(String address) {
		if (address.length() > 0 && address.length() <= 20) {
			SeleniumHelpers.sendData(addressEle, address);
		} else {
			return;
		}
	}

	public void setStateAndCity(String state, String city) {
		try {
			
			SeleniumHelpers.check(stateEle);
			
			if (state.isEmpty()) {
				return;
			}
			WebElement ss = driver.findElement(By.xpath("//div[text()='" + state + "']"));
			ss.click();

			SeleniumHelpers.check(cityEle);

			if (city.isEmpty()) {
				return;
			} else {
				WebElement cs = driver.findElement(By.xpath("//div[text()='" + city + "']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cs);
				cs.click();
			}
		} 
		catch (NoSuchElementException e) {
			System.out.println("Dropdown not found for ID: " + state);
		}
		catch (ElementClickInterceptedException e) {
			System.out.println("Element click intercepted for dropdown ID: " + city);
		} 
		catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
	}
	
	public void setSubmit() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitEle);
		SeleniumHelpers.check(submitEle);
		Thread.sleep(4000);
	}

}
