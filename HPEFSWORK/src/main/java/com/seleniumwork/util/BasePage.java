package com.seleniumwork.util;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

/**
 * BasePage 提供公用方法，供其他类使用
 * @author xiaozhe
 *
 */
public abstract class BasePage {
	public static String xmlLocatorPath;
	public static String xmlPageName;
	public static WebDriver driver;
	public static GetElement getElement=new GetElement();
	static HashMap<String, Locator> maps;
	public String strDataSourcePath;

	public BasePage(){
		
	}
	public BasePage(String xmlLocatorPath,WebDriver driver,String strDataSourcePath){
		this.xmlLocatorPath=DriverFactory.getLocatorPath(xmlLocatorPath);
		this.xmlPageName=this.getClass().getName();
		this.driver=driver;
		this.strDataSourcePath=DriverFactory.getDataSourcePath(strDataSourcePath);
	}
	
	/** 
	* @Title: getLocators 
	* @Description: 获取Locator的map 
	* @return HashMap<String,Locator> 
	* @throws
	 */
	public HashMap<String, Locator> getLocators(){
		try {
			maps=xmlUtils.readXMLDocument(xmlLocatorPath, xmlPageName);
		} catch (Exception e) {
			System.out.println("Could not found xmlLocatorPath or xmlPageName");
			e.printStackTrace();
		}
		return maps;
	}

	public  String getXmlLocatorPath() {
		return xmlLocatorPath;
	}

	public  void setXmlLocatorPath(String xmlLocatorPath) {
		BasePage.xmlLocatorPath = xmlLocatorPath;
	}

	public  String getXmlPageName() {
		return xmlPageName;
	}

	public  void setXmlPageName(String xmlPageName) {
		BasePage.xmlPageName = xmlPageName;
	}

	public  WebDriver getDriver() {
		return driver;
	}

	public  void setDriver(WebDriver driver) {
		BasePage.driver = driver;
	}
	
}
