package com.seleniumwork.util;


/**
 * This is for element library
 * 
 * @author Young
 *
 */
public class Locator {
	public String loatorvalue;

	private int waitSec;

	/**
	 * create a enum variable for By
	 * 枚举类型：在实际问题中，有些变量的取值被限定在一个有限的范围内
	 * @author Young
	 *
	 */
	public enum ByType {
		xpath, id, linkText, name, className, cssSelector, partialLinkText, tagName
	}

	private ByType byType;
	private String locatorName;

	public String getLocatorName() {
		return locatorName;
	}

	public void setLocatorName(String locatorName) {
		this.locatorName = locatorName;
	}

	public Locator() {

	}

	/**
	 * defaut Locator ,use Xpath
	 * 
	 * @author 
	 * @param element
	 */
	public Locator(String loatorvalue) {
		this.loatorvalue = loatorvalue;
		this.waitSec = 3;
		this.byType = ByType.xpath;
	}

	public Locator(String loatorvalue, int waitSec) {
		this.waitSec = waitSec;
		this.loatorvalue = loatorvalue;
		this.byType = ByType.xpath;
	}

	public Locator(String loatorvalue, int waitSec, ByType byType,String locatorName) {
		this.waitSec = waitSec;
		this.loatorvalue = loatorvalue;
		this.byType = byType;
		this.locatorName =locatorName;
	}

	

	public int getWaitSec() {
		return waitSec;
	}

	public ByType getBy() {
		return byType;
	}

	public void setBy(ByType byType) {
		this.byType = byType;
	}

	public void setReplace(String rep, String rex)
	{
		StringTools.replaceAll(loatorvalue, rex, rep);
	}

	public String getLoatorvalue() {
		return loatorvalue;
	}

	public void setLoatorvalue(String loatorvalue) {
		this.loatorvalue = loatorvalue;
	}
}
