package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleutil;

	// 1. private by locators:
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwd = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	private By myRepo = By.linkText("My Repo");


	// 2. public page const....
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}

	// 3. public page actions:
	public String getLoginPageTitle() {
		return eleutil.waitForTitleIs(Constants.DEFAULT_TIME_OUT, Constants.LOGIN_PAGE_TITLE);
	}

	public String getLoginPageUrl() {
		return eleutil.waitForUrl(Constants.DEFAULT_TIME_OUT, Constants.LOGIN_PAGE_FRACTION_URL);
	}

	public boolean isForgotPwdLinkExist() {
		return eleutil.doIsDisplayed(forgotPwd);
	}

	public AccountsPage doLogin(String un, String pwd) {
		eleutil.waitForElementToBeVisible(emailId, Constants.DEFAULT_TIME_OUT).sendKeys(un);
		eleutil.doSendKeys(password, pwd);
		eleutil.doClick(loginBtn);
		return new AccountsPage(driver);
	}
	
	public boolean isRegisterLinkExist() {
		return eleutil.waitForElementToBeVisible(registerLink, Constants.DEFAULT_TIME_OUT).isDisplayed();

	}
	
	public void navigateToRegisterPage() {
		if(isRegisterLinkExist()) {
			eleutil.doClick(registerLink);
		}
	}
	

}

