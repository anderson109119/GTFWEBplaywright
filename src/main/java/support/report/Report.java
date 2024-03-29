package support.report;

import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j2;
import static support.context.Context.*;

@Log4j2
public class Report {

    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] takeScreenShot() {
        log.info("Tirando print screen da tela");
        return web().getPage().screenshot();
    }

    @Attachment(value = "{text}", type = "image/png")
    public byte[] takeScreenShot(String text) {
        log.info("Tirando print screen da tela: " + text);
        return web().getPage().screenshot();
    }
}
