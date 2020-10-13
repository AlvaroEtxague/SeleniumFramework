package com.demo.tests;

import com.demo.baseTest.BaseTest;
import org.testng.annotations.Test;

public class SimplifyCommerceTest extends BaseTest {

    @Test
    public void verifyLogo(){
        simplifyLogin.verifyLogoIsDisplayed();
    }

    @Test
    public void verifyInvalidUserLogin(){
        simplifyLogin.populateLoginDetails("test@invalid.com", "BadPass123");
    }

    @Test
    public void verifyResetPasswordLink(){
        simplifyLogin.verifyResetPasswordLink();
        simplifyLogin.clickResetPasswordLink();
    }
}
