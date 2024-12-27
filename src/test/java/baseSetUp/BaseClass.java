package baseSetUp;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import utils.ExcelHelpers;


public class BaseClass {
	public static WebDriver driver;

	@BeforeMethod
	public void loadBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(200));
		driver.get("https://demoqa.com/automation-practice-form");
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
	@DataProvider(name = "dp")
	public Object[][] dataProvide() throws IOException {
		return ExcelHelpers.returnExceldata();

	}


}
