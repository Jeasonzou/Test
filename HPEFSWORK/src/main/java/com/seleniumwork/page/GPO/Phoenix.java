/**   
* @Title: Phoenix.java 
* @Package com.seleniumwork.page 
* @Description: TODO
* @author wxz  
* @date 2016年12月26日 下午4:28:07 
*/

package com.seleniumwork.page.GPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.seleniumwork.util.BasePage;
import com.seleniumwork.util.DataEngine;
import com.seleniumwork.util.Locator;

/* @author xiaozhe
 *
 * @date 2016年12月26日 下午4:28:07 
 */
public class Phoenix extends BasePage{
	Locator Schedules=getLocators().get("Schedules");
	Locator CustomerSelectionByName = getLocators().get("CustomerSelectionByName");
	Locator CustomerSelectionByID = getLocators().get("CustomerSelectionByID");
	Locator CustomerInputID = getLocators().get("CustomerInputID");
	Locator selectBowdoinCollege = getLocators().get("selectBowdoinCollege");
	Locator schedulesCustomerSearch = getLocators().get("schedulesCustomerSearch");
	Locator schedulesAddNew = getLocators().get("schedulesAddNew");
	
	public Phoenix(String xmlLocatorPath,WebDriver driver,String strDataSourcePath){
		super(xmlLocatorPath, driver, strDataSourcePath);
	}
	
	public void goToSchedules(){
		getElement.getElement(driver, Schedules).click();
	}
	public void customerSelectionByName(){
		getElement.getElement(driver, CustomerSelectionByName).sendKeys(DataEngine.getValueByRowID(strDataSourcePath,"CustomerSelectionByName",1));
		getElement.getElement(driver, selectBowdoinCollege).click();
	}
	public void customerSelectionByID() throws InterruptedException{
		getElement.getElement(driver, CustomerSelectionByID).click();
		System.out.println("xxx");
		Thread.sleep(3000);
		getElement.getElement(driver, CustomerInputID).sendKeys(DataEngine.getValueByRowID(strDataSourcePath,"ID",1));
		
	}
	public void schedulesCustomerSearch() {
		//getElement.getElement(driver, schedulesCustomerSearch).click();	
		Actions Action = new Actions(driver);
		Action.doubleClick(getElement.getElement(driver, schedulesCustomerSearch)).perform();
	}
	public void selectBowdoinCollege() {
		getElement.getElement(driver, selectBowdoinCollege).click();			
	}

}