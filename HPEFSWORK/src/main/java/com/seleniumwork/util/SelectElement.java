package com.seleniumwork.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectElement {

	public SelectElement() {
	}
	/**
	 * 通过文本选择下拉框元素，最长等待时间24秒
	 * @param driver
	 * @param locator
	 * @param value
	 */
	public void selectByText(WebDriver driver,Locator locator,String value){
		Log log	= new Log(this.getClass());
		Select select = new Select(new GetElement().getElement(driver, locator));
		Boolean flag;
		Long limitTime =0L;
		do {
			flag = false;
			try {
				select.selectByVisibleText(value);
			} catch (Exception e) {
				try {
					Thread.sleep(500);
					limitTime = limitTime+500;
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if(limitTime<24*1000){
					flag = true;
				}else{
					log.error("Cannot find or select the value: "+locator.getClass().getName()+"["+locator.getLocatorName()+"."+value+"]");
				}
			}
		} while (flag);
	}
	/**
	 * 通过文本选择下拉框元素，最长等待时间24秒
	 * @param driver
	 * @param locator
	 * @param value
	 */
	public void selectByValue(WebDriver driver,Locator locator,String value){
		Log log	= new Log(this.getClass());
		Select select = new Select(new GetElement().getElement(driver, locator));
		Boolean flag;
		Long limitTime =0L;
		do {
			flag = false;
			try {
				select.selectByValue(value);
			} catch (Exception e) {
				try {
					Thread.sleep(500);
					limitTime = limitTime+500;
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if(limitTime<24*1000){
					flag = true;
				}else{
					log.error("Cannot find or select the value: "+locator.getClass().getName()+"["+locator.getLocatorName()+"."+value+"]");
				}
			}
		} while (flag);
	}
}
