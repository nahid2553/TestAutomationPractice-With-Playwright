package org.test.automation;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;

import java.sql.SQLOutput;

public class BaseDriver {
    public String url = "";

    Playwright playwright;
    BrowserType browserType;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    public void launchPlaywright(String browserName, String headless){
        if (browserName.equalsIgnoreCase("chrome")){
            browserType = playwright.chromium();
            playwright = Playwright.create();
        } else if (browserName.equalsIgnoreCase("webkit")) {
            browserType = playwright.webkit();
            playwright = Playwright.create();
        }
        if (headless.equalsIgnoreCase("true")){
            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setHeadless(true));
        } else {
            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setHeadless(false));
        }

        context = browser.newContext(new Browser.NewContextOptions());
        page = browser.newPage();
        System.out.println("*** Project Browser Name and version is : " + browserName + ":" + browser.version());
    }

    public void launchApplication(String url){
        page.navigate(url, new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
    }


}
