package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class ProductInfoTest extends BaseTest {

	
	
	@BeforeClass
	public void productInfoSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void productInfoHeaderTest() {
		searchResultsPage = accPage.doSearch("MacBook");
		productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
		Assert.assertEquals(productInfoPage.getProductHeaderText(), "MacBook Pro");
	}
	
	@Test
	public void productImagesTest() {
		searchResultsPage = accPage.doSearch("MacBook");
		productInfoPage = searchResultsPage.selectProduct("MacBook Air");
		Assert.assertTrue(productInfoPage.getPorductImagesCount() == Constants.MACBOOK_IMAGES_COUNT);
	}
	
	@Test
	public void productInfoTest() {
		searchResultsPage = accPage.doSearch("MacBook");
		productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
		Map<String, String> actProductInfoMap = productInfoPage.getProductInfo();
		actProductInfoMap.forEach((k,v) -> System.out.println(k + ":" + v));
		
		softAssert.assertEquals(actProductInfoMap.get("productname"), "MacBook Pro");
		softAssert.assertEquals(actProductInfoMap.get("Brand"), "Apple");
		softAssert.assertEquals(actProductInfoMap.get("Reward Points"), "800");
		softAssert.assertEquals(actProductInfoMap.get("price"), "$2,000.00");
		softAssert.assertEquals(actProductInfoMap.get("Product Code"), "Product 18");
		softAssert.assertAll();
	}
	
	
	
	
	
	

}

}
