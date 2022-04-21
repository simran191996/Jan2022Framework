package com.qa.opencart.pages;

import org.openqa.selenium.By;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class RegistrationPage {
	private ElementUtil eleUtil;
	
	private By Header = By.cssSelector("div#content h1");
	private By firstName=By.xpath("input-firstname");
	
	public String getLoginPageTitle() {
		return eleUtil.waitForTitleIs(Constants.DEFAULT_TIME_OUT, Constants.LOGIN_PAGE_TITLE);
	}

}
