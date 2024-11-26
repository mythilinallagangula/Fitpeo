package com.PageElements;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FitpeoPageElements {
	public WebDriver driver;
	@FindBy(xpath = "//div[. = 'Revenue Calculator']")
	WebElement RevenueCalculator;
	@FindBy(xpath = "//span[contains(@class, 'MuiSlider-rail')]") 
	WebElement RevenueCalculator_Slider;
	@FindBy(xpath = "//input[@type = 'number']")
	WebElement sliderValueTextField;
	@FindBy(xpath = "(//input[@type = 'checkbox'])[1]")
	WebElement checkbox_CPT_99091;
	@FindBy(xpath = "(//input[@type = 'checkbox'])[2]")
	WebElement checkbox_CPT_99453;
	@FindBy(xpath = "(//input[@type = 'checkbox'])[3]")
	WebElement checkbox_CPT_99454;
	@FindBy(xpath = "(//input[@type = 'checkbox'])[8]")
	WebElement checkbox_CPT_99474;

	@FindBy(xpath = "(//p[contains(@class,'MuiTypography-root')])[7]/child::p[contains(@class, 'MuiTypography-root')]")
	WebElement totalRecurringReimbursement;



	public FitpeoPageElements(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void clickOnRevenueCalculator_Link()
	{
		RevenueCalculator.click(); 
		String calculatorPageTitle = "Remote Patient Monitoring (RPM) - fitpeo.com";
		assert driver.getTitle().contains(calculatorPageTitle) : "Navigation to Revenue Calculator failed";
	}

	public void ScrollToRevenueCalculatorSliderSection() throws InterruptedException
	{
		clickOnRevenueCalculator_Link();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", RevenueCalculator_Slider);
		System.out.println("Scrolled to the Slider Section");
		boolean isSliderVisible = RevenueCalculator_Slider.isDisplayed();
		assert isSliderVisible : "Slider section is not visible!";
		System.out.println("Slider is visible on the page");
	}

	public String adjustSliderToValue(String targetValue)
	{
		clickOnRevenueCalculator_Link();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView(true);", RevenueCalculator_Slider);
		js.executeScript("window.scrollBy(0,350)", "");
		js.executeScript("arguments[0].value = arguments[1];", RevenueCalculator_Slider, targetValue);
		System.out.println("Slider value set to: " + targetValue);
		String expected_Value = sliderValueTextField.getText();
		return expected_Value;
		
	}

	public String adjustSliderAndUpdateTextField(String targetValue) throws InterruptedException {
		clickOnRevenueCalculator_Link();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(4000);

		sliderValueTextField.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));

		System.out.println("Existed value is cleared!!");

		Thread.sleep(4000);
		sliderValueTextField.sendKeys(targetValue);
		String expected_Value = sliderValueTextField.getText();
		Thread.sleep(4000);
		return expected_Value;
	}

	public void selectCPTCodes() {
		clickOnRevenueCalculator_Link();

		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox_CPT_99091);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,370)", "");
		if (!checkbox_CPT_99091.isSelected()) checkbox_CPT_99091.click();
		if (!checkbox_CPT_99453.isSelected()) checkbox_CPT_99453.click();
		if (!checkbox_CPT_99454.isSelected()) checkbox_CPT_99454.click();
		//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox_CPT_99474);		
		js.executeScript("window.scrollBy(0,380)", "");
		if (!checkbox_CPT_99474.isSelected()) checkbox_CPT_99474.click();

		assert checkbox_CPT_99091.isSelected() : "CPT-99091 checkbox is not selected!";
		assert checkbox_CPT_99453.isSelected() : "CPT-99453 checkbox is not selected!";
		assert checkbox_CPT_99454.isSelected() : "CPT-99454 checkbox is not selected!";
		assert checkbox_CPT_99474.isSelected() : "CPT-99474 checkbox is not selected!";
		System.out.println("All CPT codes selected successfully.");

	}

	public void validateTotalRecurringReimbursement(String expectedValue) {
		
		clickOnRevenueCalculator_Link();
		selectCPTCodes();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", totalRecurringReimbursement);
		String actualValue = totalRecurringReimbursement.getText().trim();
		assert actualValue.equals(expectedValue) : 
			"Validation failed! Expected: " + expectedValue + ", but found: " + actualValue;
		System.out.println("Validation successful! Total Recurring Reimbursement: " + actualValue);
	}



}
