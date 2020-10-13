package com.demo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

// T Type
public class BasePageObject<T> {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePageObject(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 40);
        PageFactory.initElements(driver, this);
    }
}
