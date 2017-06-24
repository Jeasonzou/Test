package com.seleniumwork.page.GPO;

import org.openqa.selenium.WebDriver;

import com.seleniumwork.util.BasePage;
import com.seleniumwork.util.Locator;

public class HPEFSHome extends BasePage{
	
	//Locator communities=getLocators().get("Communitiess");
	Locator PhoenixLink=getLocators().get("PhoenixLink");
	
	public HPEFSHome(String xmlLocatorPath,WebDriver driver,String strDataSourcePath){
		super(xmlLocatorPath, driver, strDataSourcePath);
	}
	
	public void goToPhoenix(){
		getElement.getElement(driver, PhoenixLink).click();
	}
	
}
