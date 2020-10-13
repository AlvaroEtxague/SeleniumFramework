package com.demo.pages;

import org.openqa.selenium.WebElement;

public interface LoginModel {
    String getBaseURL();
    WebElement getSubtitle();
    WebElement getArchitectureLink();
    WebElement getSearchBar();
    WebElement getSearchBarBtn();
}

