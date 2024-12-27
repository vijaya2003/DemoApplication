package executionClasses;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseSetUp.BaseClass;
import pageObject.FormPage;
import utils.TestNGHelpers;

public class FormTest extends BaseClass {
	
	@Test(dataProvider = "dp")
	public void test(String fName, String lName, String email, String gender, String mobileNo, String subjects,
			String sports, String reading, String music, String filepath, String address, String state, String city,String submit) throws InterruptedException {
		FormPage fp = new FormPage(driver);
		fp.setFirstName(fName);
		fp.setLastName(lName);
		fp.setEmail(email);
		fp.setGender(gender);
		fp.setMobileNo(mobileNo);
//		setDateOfBirth(dateOfBirth);
		fp.setSubject(subjects);
		fp.setSports(sports);
		fp.setReading(reading);
		fp.setMusic(music);
		fp.setChooosefile(filepath);
		fp.setAddress(address);
		fp.setStateAndCity(state, city);
		fp.setSubmit();
//		setCity(city);
		TestNGHelpers.validateUsingAsserts(driver,fName, lName, gender, mobileNo);

	}

	
	
	

}
