package com.demo.pages;

import com.demo.base.BasePageObject;
import com.demo.utils.Generics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePageObject<LoginPage> implements LoginModel{
    //CONSTRUCTOR
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    Generics gens = new Generics(driver);

    //WEBELEMENTS
    private String baseURL = "https://unsplash.com/";

    @FindBy(css = "._1iWCF._27Bp2.jXmar")
    private WebElement subtitle;

    @FindBy(css = "a[href='/t/architecture']")
    private WebElement architectureLink;

    @FindBy(css = "input[name='searchKeyword'][class='dNxMO _1_rwn']")
    private WebElement searchBar;

    @FindBy(css = "._1xG4w._28mw2._3SiJv > button[title='Search Unsplash']")
    private WebElement searchBarBtn;

    //GETTERS
    public String getBaseURL() {
        return baseURL;
    }

    public WebElement getSubtitle() {
        return subtitle;
    }

    public WebElement getArchitectureLink() {
        return architectureLink;
    }

    public WebElement getSearchBar() {
        return searchBar;
    }

    public WebElement getSearchBarBtn() {
        return searchBarBtn;
    }

    //PAGE INTERACTIONS
    public void clickArchitectureLink() {
        gens.waitForElement(getArchitectureLink(), 5);
        gens.click(getArchitectureLink());
        System.out.println("Clicking Architecture Link");
    }

    public void searchForImage(String text) {
        gens.waitForElement(getSearchBar(), 5);
        gens.type(text, getSearchBar());
        System.out.println("Searching for: " + text);
    }

    public void clickSearch(){
        gens.click(getSearchBarBtn());
        System.out.println("Clicking search button");
    }

    public void verifySubtitle(){
        gens.waitForElement(getSubtitle(), 3);
        String expected = "Powered by creators everywhere.";
        String actual = getSubtitle().getText();
        gens.compareStrings(actual, expected);
    }
}
