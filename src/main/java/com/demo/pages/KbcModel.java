package com.demo.pages;

import org.openqa.selenium.WebElement;

public interface KbcModel {

    WebElement getCookiesBtn();

    String getKbcRegSaverCalcURL();

    WebElement getRadioBtnOne();

    WebElement getRadioBtnTwo();

    WebElement getSavingAmountInput();

    WebElement getSelectDD();

    WebElement getDDItem();

    WebElement getCalculateBtn();
}
