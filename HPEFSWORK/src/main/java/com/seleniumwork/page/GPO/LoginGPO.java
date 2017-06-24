package com.seleniumwork.page.GPO;

import com.seleniumwork.util.BasePage;
import com.seleniumwork.util.DataEngine;
import com.seleniumwork.util.DriverFactory;
import com.seleniumwork.util.Locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.seleniumwork.util.DataEngine;
import com.seleniumwork.util.DriverFactory;
import com.seleniumwork.util.GetElement;
import com.seleniumwork.util.Locator;
import com.seleniumwork.util.xmlUtils;

/**
 * GPO login page
 * @author xiaozhe
 *
 */
public class LoginGPO extends BasePage{

	
	Locator logname=getLocators().get("logname");
	Locator logpass=getLocators().get("logpass");
	Locator LogIn=getLocators().get("LogIn");
	
	
	public LoginGPO(String xmlLocatorPath,WebDriver driver,String strDataSourcePath){
		super(xmlLocatorPath, driver,strDataSourcePath);
	}
	
	/**
	* @Title: loginGPO 
	* @Description: 登录GPO，成功返回true 
	* @param @return
	* @return boolean 
	* @throws
	 */
	public void loginGPO(){
		System.out.println(DataEngine.getValueByRowID(strDataSourcePath,"username",3));
		getElement.getElement(driver, logname).sendKeys(DataEngine.getValueByRowID(strDataSourcePath,"username",3));
		System.out.println(DataEngine.getValueByRowID(strDataSourcePath,"password",3));
		getElement.getElement(driver, logpass).sendKeys(DataEngine.getValueByRowID(strDataSourcePath,"password",3));
		getElement.getElement(driver, LogIn).click();

	}
}
