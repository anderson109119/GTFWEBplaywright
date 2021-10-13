package support.browser;

import lombok.extern.log4j.Log4j2;
import support.browser.type.*;
import support.exception.BrowserFactoryException;

import static support.context.Context.web;

@Log4j2
public class BrowserFactory {

    public static void getInstance(String browserType) {
        if(web().getPage() != null) return;
        try {
            switch (browserType.toUpperCase()) {
                case "EDGE":
                    EdgeFactory.createInstance();
                    break;
                case "CHROME":
                    ChromeFactory.createInstance();
                    break;
                case "CHROMIUM":
                    ChromiumFactory.createInstance();
                    break;
                case "FIREFOX":
                    FirefoxFactory.createInstance();
                    break;
                case "WEBKIT":
                    WebKitFactory.createInstance();
                    break;
                case "REMOTE":
                    RemoteFactory.createInstance();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + browserType);
            }
        }catch (BrowserFactoryException e){
            log.error(e.getMessage());
        }
    }
}
