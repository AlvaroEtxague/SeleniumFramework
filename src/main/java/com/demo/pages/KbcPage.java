package com.demo.pages;

import com.demo.base.BasePageObject;
import com.demo.utils.Generics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class KbcPage extends BasePageObject<KbcPage> implements KbcModel {
    //CONSTRUCTOR
    public KbcPage(WebDriver driver) {
        super(driver);
    }

    Generics gens = new Generics(driver);
    int defaultTimeout = 5;

    //WEBELEMENTS
    private String kbcRegSaverCalcURL = "https://www.kbc.ie/our-products/savings-and-investments/regular-saver/regular-saver-calculator";

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookiesBtn;

    @FindBy(css = "[for='calcTabOne']")
    private WebElement radioBtnOne;

    @FindBy(css = "[for='calcTabTwo']")
    private WebElement radioBtnTwo;

    @FindBy(css = "input#p_lt_PagePlaceHolderZone_MainPagePlaceHolder_p_lt_ContentZone_RegularSaverCalculator_savings_goal")
    private WebElement inputSavingsAmount;

    @FindBy(css = "select#p_lt_PagePlaceHolderZone_MainPagePlaceHolder_p_lt_ContentZone_RegularSaverCalculator_length_to_leave_for")
    private WebElement selectDDMenu;

    @FindBy(xpath = "//option[@innertext='6 months']")
    private WebElement itemDD2Months;

    @FindBy(css = "[data-content='01'] .button--primary")
    private WebElement calculateButton;

    //GETTERS
    @Override
    public WebElement getCookiesBtn() {
        return cookiesBtn;
    }

    @Override
    public String getKbcRegSaverCalcURL() {
        return kbcRegSaverCalcURL;
    }

    @Override
    public WebElement getRadioBtnOne() {
        return radioBtnOne;
    }

    @Override
    public WebElement getRadioBtnTwo() {
        return radioBtnTwo;
    }

    @Override
    public WebElement getSavingAmountInput() {
        return inputSavingsAmount;
    }

    @Override
    public WebElement getSelectDD() {
        return selectDDMenu;
    }

    @Override
    public WebElement getDDItem() {
        return itemDD2Months;
    }

    @Override
    public WebElement getCalculateBtn() {
        return calculateButton;
    }

    //PAGE INTERACTIONS
    public void clickCookies() {
        gens.waitForElement(getCookiesBtn(), defaultTimeout);
        gens.click(getCookiesBtn());
        System.out.println("Dealing with cookies popup");
    }

    public void selectRadioOne() {
        gens.waitForElement(getRadioBtnOne(), defaultTimeout);
        gens.click(getRadioBtnOne());
        System.out.println("Selecting radio button for: How much should I be saving to reach my savings goal?");
    }

    public void populateSavingsAmount() {
        String amount = gens.generateRandomNumber(4);
        gens.waitForElement(getSavingAmountInput(), defaultTimeout);
        gens.type(amount, getSavingAmountInput());
        System.out.println("Entering Savings Amount");
    }

    public void selectDDMenu() {
        gens.waitForElement(getSelectDD(), defaultTimeout);
        gens.click(getSelectDD());
        System.out.println("Opening DD menu");
    }

    public void getListOfItems() {
        Select select = new Select(getSelectDD());
        List<WebElement> options = select.getOptions();
        ArrayList<String> months = new ArrayList<>();
        for (WebElement we : options)
            months.add(we.getText());
        System.out.println("Current list of DD options: " + months);
    }

    public void pickDDItem() {
        Select select = new Select(getSelectDD());
        List<WebElement> options = select.getOptions();
        String amount = gens.generateRandomNumber(1);
        WebElement item = options.get(Integer.parseInt(amount));
        gens.click(item);
        System.out.println("Clicked item: " + item.getAttribute("value"));
    }

    public void clickCalculateBtn() {
        gens.waitForElement(getCalculateBtn(), defaultTimeout);
        gens.click(getCalculateBtn());
        System.out.println("Clicking Calculate Button");
    }
}
