package com.demo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory{

    protected WebDriver driver;

    public BrowserFactory(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver browserSetup(String browser){
        WebDriver driver = null;
        switch (browser) {
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
                driver = new FirefoxDriver();
                System.out.println("Opening Firefox Browser");
                break;

            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
                driver = new ChromeDriver();
                System.out.println("Opening Chrome Browser");
                break;

            default:
                System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
                driver = new FirefoxDriver();
                System.out.println("Opening Firefox Browser");
                break;
        }
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        return driver;
    }
}
