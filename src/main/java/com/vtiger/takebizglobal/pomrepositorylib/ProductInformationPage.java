package com.vtiger.takebizglobal.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	
	public ProductInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//td[text()='Product No']/following-sibling::td[@class='dvtCellInfo' and not(@id)]")
	private WebElement autogeneratedProdNum;

	public WebElement getAutogeneratedProdNum() {
		return autogeneratedProdNum;
	}
	
}
