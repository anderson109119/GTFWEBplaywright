package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigFactory;
import support.browser.BrowserFactory;
import support.context.Context;

@Log4j2
public class Hook extends Context{

    @Before
    public void init(Scenario scenario) {
        setScenario(scenario);
        log.info(String.format("TESTE INICIADO: %s", scenario.getName()));
        ConfigFactory.setProperty("env", System.getProperty("env"));
        BrowserFactory.getInstance(System.getProperty("browser"));

        if(web().pageExist())
            web().createNewPage();
    }

    @After
    public void end() {
        web().finishScenario(getScenario());
        log.info(String.format("TESTE FINALIZADO: %s", getScenario().getName()));
        log.info(String.format("TESTE STATUS: %s", getScenario().getStatus()));
    }

}









