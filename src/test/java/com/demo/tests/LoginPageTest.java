package com.demo.tests;

import com.demo.baseTest.BaseTest;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void verifyArchitectureLink() throws InterruptedException {
        login.clickArchitectureLink();
    }

    @Test
    public void searchForImage() {
        //go to search bar and type text to search
        login.searchForImage("Cats");
        //click search button
        login.clickSearch();
    }

    @Test
    public void verifyPageSubtitle() {
        login.verifySubtitle();
    }
}
