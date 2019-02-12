import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.testng.Assert as Assert

WebUI.openBrowser('')

//Logs User into MF')
WebUI.navigateToUrl('https://marginfueltest.azurewebsites.net/Home/Login')
WebUI.maximizeWindow()
WebUI.setText(findTestObject('Global Objects/input_Username'), 'PTThriftyNZ')
WebUI.setText(findTestObject('Global Objects/input_Password'), 'P@ssw0rd')
WebUI.click(findTestObject('Global Objects/button_Login'))

// Navigates to Historic Market Pricing
WebUI.waitForPageLoad(2)
WebUI.click(findTestObject('Global Objects/a_Monitor'))
WebUI.click(findTestObject('Global Objects/a_Historical Market Pricing'))
WebUI.switchToFrame(findTestObject('Historic Pricing/i-frame Historical Pricing'),2)

// Select Market from Drop Down
WebUI.click(findTestObject('Historic Pricing/Market'))
WebUI.selectOptionByValue(findTestObject('Historic Pricing/Market'),NZ, false)
WebUI.click(findTestObject('Historic Pricing/Market'))

// Select Category Type
WebUI.click(findTestObject('Historic Pricing/Category Type'))
WebUI.selectOptionByValue(findTestObject('Historic Pricing/Category Type'),'0fe6fdbe-50ed-4b99-91e5-2abf9413f8f8', false) // Car
WebUI.click(findTestObject('Historic Pricing/Category Type'))

// Select Pickup Location
WebUI.click(findTestObject('Historic Pricing/Pickup Location'))
WebUI.selectOptionByLabel(findTestObject('Historic Pricing/Pickup Location'),'Auckland Airport', false) 
WebUI.click(findTestObject('Historic Pricing/Pickup Location'))

// Select Dropoff Location
WebUI.click(findTestObject('Historic Pricing/Dropoff Location'))
WebUI.selectOptionByLabel(findTestObject('Historic Pricing/Dropoff Location'),'Auckland Airport', false)
WebUI.click(findTestObject('Historic Pricing/Dropoff Location'))

// Select Category Type
WebUI.click(findTestObject('Historic Pricing/Category'))
WebUI.selectOptionByValue(findTestObject('Historic Pricing/Category'),'59e8a429-6a90-43a1-8948-6936e8116368', false) // Intermediate Car (ICAR) (Toyota Corolla Sedan)
WebUI.click(findTestObject('Historic Pricing/Category'))

// Select Dropoff Location
WebUI.click(findTestObject('Historic Pricing/Duration'))
WebUI.selectOptionByLabel(findTestObject('Historic Pricing/Duration'),'7', false)
WebUI.click(findTestObject('Historic Pricing/Duration'))

// Select Extract Date From
WebUI.click(findTestObject('Historic Pricing/Extract Date From'))
//WebUI.click(findTestObject('Historic Pricing/Date Arrow Left'))
//WebUI.click(findTestObject('Historic Pricing/Date From 1st'))

// Select Extract Date To
WebUI.click(findTestObject('Historic Pricing/Extract Date To'))
//WebUI.click(findTestObject('Historic Pricing/Date Arrow Left'))
//WebUI.click(findTestObject('Historic Pricing/Date From 1st'))

// Select Pickup Date
WebUI.click(findTestObject('Historic Pricing/Pickup Date'))
//WebUI.click(findTestObject('Historic Pricing/Pickup Date From 1st'))

// Select Rate Type
WebUI.click(findTestObject('Historic Pricing/Rate Type'))
WebUI.selectOptionByValue(findTestObject('Historic Pricing/Rate Type'),'1',false) //Gross
//WebUI.selectOptionByValue(findTestObject('Historic Pricing/Rate Type'),'2',false) //Net
WebUI.click(findTestObject('Historic Pricing/Rate Type'))

// Select Search button
WebUI.focus(findTestObject('Historic Pricing/Search Button - ThriftyNZ'))
WebUI.click(findTestObject('Historic Pricing/Search Button - ThriftyNZ'))
WebUI.waitForPageLoad(10)

// Select Down Arrow
WebUI.waitForElementClickable(findTestObject('Historic Pricing/Space Button - ThriftyNZ'),1)
WebUI.click(findTestObject('Historic Pricing/Space Button - ThriftyNZ'))

// Select All Competitors Checkbox
WebUI.check(findTestObject('Historic Pricing/All Competitors checkbox'))
//WebUI.verifyElementChecked(findTestObject('Historic Pricing/Direct checkbox'))
//WebUI.verifyElementChecked(findTestObject('Historic Pricing/Rentalcars checkbox'))

//Hover Mouse over graph to get Tooltip
WebUI.scrollToElement(findTestObject('Historic Pricing/Tooltip'),1)
WebUI.mouseOver(findTestObject('Historic Pricing/Tooltip'))
WebUI.getText(findTestObject('Historic Pricing/Tooltip'))
WebUI.verifyTextPresent('Daily Rate',false)
WebUI.clickOffset(findTestObject('Historic Pricing/Tooltip'), 284, 814)
WebUI.getText(findTestObject('Historic Pricing/Tooltip'))
WebUI.verifyTextPresent('Daily Rate',false)
WebUI.clickOffset(findTestObject('Historic Pricing/Tooltip'), 494, 215)
WebUI.getText(findTestObject('Historic Pricing/Tooltip'))
WebUI.verifyTextPresent('Daily Rate',false)

// Click to download csv file (verify file has been downloaded)
WebUI.focus(findTestObject('Historic Pricing/Download_CSV Button'))
WebUI.click(findTestObject('Historic Pricing/Download_CSV Button'))

// Select Copy button
//WebUI.scrollToElement(findTestObject('Historic Pricing/Tooltip'),1)
WebUI.focus(findTestObject('Historic Pricing/Copy Button'))
WebUI.click(findTestObject('Historic Pricing/Copy Button'))
WebUI.verifyTextPresent('Copy to clipboard', false)

//Change to number of records viewed
WebUI.click(findTestObject('Historic Pricing/Display Records'))
WebUI.selectOptionByValue(findTestObject('Historic Pricing/Display Records'),'50',false)
WebUI.click(findTestObject('Historic Pricing/Display Records'))
WebUI.scrollToElement(findTestObject('Historic Pricing/Pagination'),1)

//Sort Data Table
WebUI.click(findTestObject('Historic Pricing/Data Table - Extract'))
WebUI.click(findTestObject('Historic Pricing/Data Table - Extract'))

WebUI.click(findTestObject('Historic Pricing/Data Table - Channel'))
WebUI.click(findTestObject('Historic Pricing/Data Table - Channel'))

WebUI.click(findTestObject('Historic Pricing/Data Table - Company'))
WebUI.click(findTestObject('Historic Pricing/Data Table - Company'))

WebUI.click(findTestObject('Historic Pricing/Data Table - Category'))
WebUI.click(findTestObject('Historic Pricing/Data Table - Category'))

WebUI.click(findTestObject('Historic Pricing/Data Table - Pickup Date'))
WebUI.click(findTestObject('Historic Pricing/Data Table - Pickup Date'))

WebUI.click(findTestObject('Historic Pricing/Data Table - Dropoff Date'))
WebUI.click(findTestObject('Historic Pricing/Data Table - Dropoff Date'))

WebUI.click(findTestObject('Historic Pricing/Data Table - Duration'))
WebUI.click(findTestObject('Historic Pricing/Data Table - Duration'))

WebUI.click(findTestObject('Historic Pricing/Data Table - Pickup Location'))
WebUI.click(findTestObject('Historic Pricing/Data Table - Pickup Location'))

WebUI.click(findTestObject('Historic Pricing/Data Table - Dropoff Location'))
WebUI.click(findTestObject('Historic Pricing/Data Table - Dropoff Location'))

WebUI.click(findTestObject('Historic Pricing/Data Table - Daily Rate'))
WebUI.click(findTestObject('Historic Pricing/Data Table - Daily Rate'))

WebUI.click(findTestObject('Historic Pricing/Data Table - Total Rate'))
WebUI.click(findTestObject('Historic Pricing/Data Table - Total Rate'))

//User Logs out
'Switch back to default content'
WebUI.switchToDefaultContent()
WebUI.focus(findTestObject('Global Objects/span_Welcome'))
WebUI.click(findTestObject('Global Objects/span_Welcome'))
WebUI.focus(findTestObject('Global Objects/a_Logout'))
WebUI.click(findTestObject('Global Objects/a_Logout'))
WebUI.closeBrowser()