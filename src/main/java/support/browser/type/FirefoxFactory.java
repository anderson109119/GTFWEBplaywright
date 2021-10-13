package support.browser.type;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import static support.context.Context.config;
import static support.context.Context.web;

public class FirefoxFactory {
    public static void createInstance() {
        web().setBrowser(Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(config().getHeadLess())));
        web().setBrowserContext(web().getBrowser().newContext());
    }
}
