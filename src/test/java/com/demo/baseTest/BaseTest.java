package com.demo.baseTest;

import com.demo.pages.LoginPage;
import com.demo.utils.Generics;
import com.demo.utils.Screenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage login;
    protected Screenshots screenshots;
    protected Generics gens;

    @BeforeMethod
    public void testSetup() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        login = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get(login.getBaseURL());
    }

    @AfterMethod
    public void closeDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            screenshots = new Screenshots();
            screenshots.takeScreenshot(driver, result.getName());
            System.out.println("FAILED: " + result.getMethod().getMethodName());
        }
        if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("PASSED: " + result.getName());
        }
        driver.quit();
    }
}
