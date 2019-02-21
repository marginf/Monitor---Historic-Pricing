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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser('')

//Logs User into MF')
WebUI.navigateToUrl('https://marginfueltest.azurewebsites.net/Home/Login')
WebUI.maximizeWindow()
WebUI.setText(findTestObject('Global Objects/input_Username'), 'PTJucy')
WebUI.setText(findTestObject('Global Objects/input_Password'), Password)
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
WebUI.selectOptionByIndex(findTestObject('Historic Pricing/Pickup Location'),0) //'Auckland Airport' 
WebUI.click(findTestObject('Historic Pricing/Pickup Location'))

// Select Dropoff Location
WebUI.click(findTestObject('Historic Pricing/Dropoff Location'))
WebUI.selectOptionByIndex(findTestObject('Historic Pricing/Dropoff Location'),0) //'Auckland Airport'
WebUI.click(findTestObject('Historic Pricing/Dropoff Location'))

// Select Category Type
WebUI.click(findTestObject('Historic Pricing/Category'))
WebUI.selectOptionByIndex(findTestObject('Historic Pricing/Category'),3) //'ce925f44-8dfa-409c-bdf6-7b250edd4993' Styla (Mazda 3 (2015-2017))
WebUI.click(findTestObject('Historic Pricing/Category'))

// Select Dropoff Location
WebUI.click(findTestObject('Historic Pricing/Duration'))
WebUI.selectOptionByIndex(findTestObject('Historic Pricing/Duration'),4) // '10'
WebUI.click(findTestObject('Historic Pricing/Duration'))

// Select Extract Date From
WebUI.click(findTestObject('Historic Pricing/Extract Date From'))
//WebUI.click(findTestObject('Historic Pricing/Date Arrow Left'))
//WebUI.click(findTestObject('Historic Pricing/Date From 1st'))
//WebUI.getText(findTestObject('Historic Pricing/Extract Date From - Text'))
//WebUI.sendKeys(findTestObject('Historic Pricing/Extract Date From'), Keys.chord(Keys.CONTROL, 'a'))
//WebUI.sendKeys(findTestObject('Historic Pricing/Extract Date From'), Keys.chord(Keys.CONTROL, 'c'))
//WebUI.sendKeys(findTestObject('Historic Pricing/Extract Date From - Text'), Keys.chord(Keys.CONTROL, 'v'))
WebUI.getText(findTestObject('Historic Pricing/Extract Date From - Text'))
ExtractFromDate = WebUI.getText(findTestObject('Historic Pricing/Extract Date From - Text'))

// Select Extract Date To
WebUI.click(findTestObject('Historic Pricing/Extract Date To'))
//WebUI.click(findTestObject('Historic Pricing/Date Arrow Left'))
//WebUI.click(findTestObject('Historic Pricing/Date From 1st'))
//WebUI.getText(findTestObject('Historic Pricing/Extract Date To - Text'))
//WebUI.sendKeys(findTestObject('Historic Pricing/Extract Date To'), Keys.chord(Keys.CONTROL, 'a'))
//WebUI.sendKeys(findTestObject('Historic Pricing/Extract Date To'), Keys.chord(Keys.CONTROL, 'c'))
//WebUI.sendKeys(findTestObject('Historic Pricing/Extract Date To - Text'), Keys.chord(Keys.CONTROL, 'v'))
ExtractToDate = WebUI.getText(findTestObject('Historic Pricing/Extract Date To - Text'))

// Select Pickup Date
WebUI.click(findTestObject('Historic Pricing/Pickup Date'))
//WebUI.click(findTestObject('Historic Pricing/Pickup Date From 1st'))
WebUI.getText(findTestObject('Historic Pricing/Pickup Date - Text'))

// Select Search button
WebUI.waitForElementClickable(findTestObject('Historic Pricing/Search Button'),2)
WebUI.click(findTestObject('Historic Pricing/Search Button'))
WebUI.waitForPageLoad(10)

// Select Down Arrow
WebUI.waitForElementClickable(findTestObject('Historic Pricing/Space Button'),2)
WebUI.click(findTestObject('Historic Pricing/Space Button'))

// Select All Competitors Checkbox
WebUI.check(findTestObject('Historic Pricing/All Competitors checkbox'))

//Change to number of records viewed
WebUI.click(findTestObject('Historic Pricing/Display Records'))
WebUI.selectOptionByValue(findTestObject('Historic Pricing/Display Records'),'100',false)
WebUI.click(findTestObject('Historic Pricing/Display Records'))

WebDriver driver = DriverFactory.getWebDriver()
'Expected value from Table'
String ExpectedValue = "Toyota Corolla or Similar Compact (Automatic Transmission)";
'To locate table'
WebElement Table = driver.findElement(By.xpath("//table/tbody"))
'To locate rows of table it will Capture all the rows available in the table'
List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
'To calculate no of rows In table'
int rows_count = rows_table.size()
'Loop will execute for all the rows of the table'
Loop:
for (int row = 0; row < rows_count; row++) {
'To locate columns(cells) of that specific row'
List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))
 
'To calculate no of columns(cells) In that specific row'
int columns_count = Columns_row.size()
 
println((('Number of cells In Row ' + row) + ' are ') + columns_count)
 
'Loop will execute till the last cell of that specific row'
for (int column = 0; column < columns_count; column++) {
'It will retrieve text from each cell'
String celltext = Columns_row.get(column).getText()
 
println((((('Cell Value Of row number ' + row) + ' and column number ') + column) + ' Is ') + celltext)
 
'Checking if Cell text is matching with the expected value'
if (celltext == ExpectedValue) {
'Getting the Model Name if cell text i.e Model name matches with Expected value'
println('Text present in row number 3 is: ' + Columns_row.get(2).getText())
 
'After getting the Expected value from Table we will Terminate the loop'
break Loop;
}
}
}

// Click to download csv file (verify file has been downloaded)
WebUI.focus(findTestObject('Historic Pricing/Download_CSV Button'))
WebUI.click(findTestObject('Historic Pricing/Download_CSV Button'))

// Select Copy button
//WebUI.scrollToElement(findTestObject('Historic Pricing/Tooltip'),1)
WebUI.focus(findTestObject('Historic Pricing/Copy Button'))
WebUI.click(findTestObject('Historic Pricing/Copy Button'))
WebUI.verifyTextPresent('Copy to clipboard', false)
WebUI.getText(findTestObject('Historic Pricing/Copy Button'))


//User Logs out
'Switch back to default content'
WebUI.switchToDefaultContent()
WebUI.focus(findTestObject('Global Objects/span_Welcome'))
WebUI.click(findTestObject('Global Objects/span_Welcome'))
WebUI.focus(findTestObject('Global Objects/a_Logout'))
WebUI.click(findTestObject('Global Objects/a_Logout'))
WebUI.closeBrowser()