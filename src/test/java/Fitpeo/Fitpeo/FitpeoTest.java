package Fitpeo.Fitpeo;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.PageElements.FitpeoPageElements;
import com.Utilities.BaseTest;

public class FitpeoTest extends BaseTest{
	@Test(priority = 0)
	public void navigateToTheFitpeoHomePage()
	{
		System.out.println("Navigated to the FitPeo Homepage");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Remote Patient Monitoring (RPM) - fitpeo.com";
		System.out.println("Page Title: " + actualTitle);
		assert actualTitle.contains(expectedTitle) : "Test Failed: Title does not match!";
	}

	@Test(priority = 1)
	public void navigateToRevenueCalculatorPage()
	{
		FitpeoPageElements obj = new FitpeoPageElements(driver);
		obj.clickOnRevenueCalculator_Link();
	}

	@Test(priority = 2)
	public void scrollToSliderSection() throws InterruptedException {
		FitpeoPageElements obj = new FitpeoPageElements(driver);
		obj.ScrollToRevenueCalculatorSliderSection();

	}

	@Test(priority = 3)
	public void adjustSliderAndVerifsValue()
	{
		FitpeoPageElements obj = new FitpeoPageElements(driver);
		String expected_Value = obj.adjustSliderToValue("820");
		String actualValue = "820";
		assert actualValue.contains(expected_Value): "slider values not matched";
	}
	@Test(priority = 4)
	public void adjustSliderUsingTextField() throws InterruptedException {
		FitpeoPageElements obj = new FitpeoPageElements(driver);
		String expected_Value = obj.adjustSliderAndUpdateTextField("560");
		String actualValue = "560";
		assert actualValue.contains(expected_Value): "slider values not matched";
		
	}
	
	@Test(priority = 5)
	public void selectCPTCodesTest() {
	    FitpeoPageElements obj = new FitpeoPageElements(driver);

	    // Scroll and select CPT codes
	    obj.selectCPTCodes();
	}
	
	@Test(priority = 6)
	public void validateTotalRecurringReimbursementTest() {
	    FitpeoPageElements obj = new FitpeoPageElements(driver);

	    // Validate the Total Recurring Reimbursement value
	    obj.validateTotalRecurringReimbursement("$27000");
	}



}
