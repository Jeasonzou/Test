package com.seleniumwork.util;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.jackson.Log4jJsonObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;





public class GetElement {
	WebElement e;
	public GetElement() {
		
	}
	/**
	 * 由给定的Locator对象在 driver里面找该对象，找对象的间隔频率为Locator中定义的timeout，最大超时时间默认为120秒
	 * @param driver
	 * @param locator
	 * @return webElement
	 */
	public WebElement getElement(WebDriver driver,Locator locator) {
		Log log	= new Log(this.getClass());
		int timeout = locator.getWaitSec();
		Long startTime = Calendar.getInstance().getTimeInMillis(); 
		Long endTime;
		do  {
			try {
				switch (locator.getBy()) {
				case xpath:
					log.debug("find element By xpath");
					e = driver.findElement(By.xpath(locator.getLoatorvalue()));
					break;
				case id:
					log.debug("find element By id");
					e = driver.findElement(By.id(locator.getLoatorvalue()));
					break;
				case name:
					log.debug("find element By name");
					e = driver.findElement(By.name(locator.getLoatorvalue()));
					break;
				case cssSelector:
					log.debug("find element By cssSelector");
					e = driver.findElement(By.cssSelector(locator.getLoatorvalue()));
					break;
				case className:
					log.debug("find element By className");
					e = driver.findElement(By.className(locator.getLoatorvalue()));
					break;
				case tagName:
					log.debug("find element By tagName");
					e = driver.findElement(By.tagName(locator.getLoatorvalue()));
					break;
				case linkText:
					log.debug("find element By linkText");
					e = driver.findElement(By.linkText(locator.getLoatorvalue()));
					break;
				case partialLinkText:
					log.debug("find element By partialLinkText");
					e = driver.findElement(By.partialLinkText(locator.getLoatorvalue()));
					break;
				default:
					e = driver.findElement(By.id(locator.getLoatorvalue()));
				}
				log.info(locator.getLocatorName()+" is existed ,go on");
				return e;
			} catch (Exception e2) {
				log.warn(locator.getLocatorName()+" current is not existed ,go on");
				try {
					Thread.sleep(timeout*1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				endTime = Calendar.getInstance().getTimeInMillis(); 
			}
		}while(24*1000>(endTime-startTime));
		log.error("Cannot find the element: "+locator.getClass().getName()+"["+locator.getLocatorName()+"]");
		return null;
	}
	/**
	 * 判断元素是否存在，超时120秒仍找不到 则返回false， 否则返回TRUE
	 * @param driver
	 * @param locator
	 * @return
	 */
	public boolean isExist(WebDriver driver,Locator locator){
		Boolean flag = false;
		Log log	= new Log(this.getClass());
		int timeout = locator.getWaitSec();
		Long startTime = Calendar.getInstance().getTimeInMillis(); 
		Long endTime;
		do  {
			try {
				switch (locator.getBy()) {
				case xpath:
					log.debug("find element By xpath");
					e = driver.findElement(By.xpath(locator.getLoatorvalue()));
					break;
				case id:
					log.debug("find element By id");
					e = driver.findElement(By.id(locator.getLoatorvalue()));
					break;
				case name:
					log.debug("find element By name");
					e = driver.findElement(By.name(locator.getLoatorvalue()));
					break;
				case cssSelector:
					log.debug("find element By cssSelector");
					e = driver.findElement(By.cssSelector(locator.getLoatorvalue()));
					break;
				case className:
					log.debug("find element By className");
					e = driver.findElement(By.className(locator.getLoatorvalue()));
					break;
				case tagName:
					log.debug("find element By tagName");
					e = driver.findElement(By.tagName(locator.getLoatorvalue()));
					break;
				case linkText:
					log.debug("find element By linkText");
					e = driver.findElement(By.linkText(locator.getLoatorvalue()));
					break;
				case partialLinkText:
					log.debug("find element By partialLinkText");
					e = driver.findElement(By.partialLinkText(locator.getLoatorvalue()));
					break;
				default:
					e = driver.findElement(By.id(locator.getLoatorvalue()));
				}
				log.info(locator.getLocatorName()+" is existed ,go on");
				return true;
			} catch (Exception e2) {
				log.warn(locator.getLocatorName()+" current is not existed ,go on");
				try {
					Thread.sleep(timeout*1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				endTime = Calendar.getInstance().getTimeInMillis(); 
			}
		}while(24*1000>(endTime-startTime));
		log.error("Cannot find the element: "+locator.getClass().getName()+"["+locator.getLocatorName()+"]");
		return flag;
	}
}
