package org.test.automation;

import com.microsoft.playwright.Playwright;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class FirstTestRun extends BaseDriver{


    @Test
    public void openUrl(@Optional("https://testautomationpractice.blogspot.com/") String url, @Optional("chrome") String browserName,
                        @Optional("false") String headless) throws InterruptedException {
        playwright = Playwright.create();
        launchPlaywright(browserName,headless);
        launchApplication(url);


    }


    }

