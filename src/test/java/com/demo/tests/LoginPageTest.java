package com.demo.tests;

import com.demo.baseTest.BaseTest;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void verifyArchitectureLink() throws InterruptedException {
        initLogin();
        login.clickArchitectureLink();
    }

    @Test
    public void searchForImage() {
        initLogin();
        //go to search bar and type text to search
        login.searchForImage("Cats");
        //click search button
        login.clickSearch();
    }

    @Test
    public void verifyPageSubtitle() {
        initLogin();
        login.verifySubtitle();
    }
}
