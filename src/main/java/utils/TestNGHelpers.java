package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestNGHelpers {
	public static void validateUsingAsserts(WebDriver driver,String fName, String lName, String gender, String mobileNo) {
        int temp = 0;
		if (fName.isEmpty()) {
			temp=1;
			String fNameAct = driver.findElement(By.xpath("//input[@id='firstName']")).getCssValue("border-color");
			String fNameEx = "rgb(220, 53, 69)";
			Assert.assertEquals(fNameAct, fNameEx, "First name is Mandatory");

		}

		if (lName.isEmpty()) {
			temp=1;
			String lNameAct = driver.findElement(By.xpath("//input[@id='lastName']")).getCssValue("border-color");
			String lNameEx = "rgb(220, 53, 69)";
			Assert.assertEquals(lNameAct, lNameEx, "Last name is Mandatory");
		}

		if (gender.isEmpty() || !(gender.equals("Male") || gender.equals("Female") || gender.equals("Other"))) {
			temp=1;
			String genderAct = driver.findElement(By.xpath("//label[text()='Male']")).getCssValue("color");
			String genderEx = "rgba(220, 53, 69, 1)";
			Assert.assertEquals(genderAct, genderEx, "gender is Mandatory");
		}
		if (mobileNo.isEmpty() || !(mobileNo.length() == 10 || (mobileNo).matches("^[1-9]\\d{9}$"))) {
			temp=1;
			String mobileNoAct = driver.findElement(By.xpath("//input[@id=\"userNumber\"]"))
					.getCssValue("border-color");
			String mobileNoEx = "rgb(40, 167, 69)";
			Assert.assertEquals(mobileNoAct, mobileNoEx, "mobile number is Mandatory");
		}
		if(temp==0) {
			String actual = driver.findElement(By.xpath("//div[contains(text(),'Thanks')]")).getText();
			String expected = "Thanks for submitting the form";
			Assert.assertEquals(actual, expected,"Form submitted");
		}

	}


}
