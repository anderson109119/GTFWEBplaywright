package support.browser.type;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import static support.context.Context.config;
import static support.context.Context.web;


public class EdgeFactory {
    public static void createInstance() {
        web().setBrowser(Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(config().getHeadLess())));
        web().setBrowserContext(web().getBrowser().newContext());
    }
}
