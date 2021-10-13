package support.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:conf/${env}.properties"})
public interface Configuration extends Config {

    @Key("url.base")
    String url();

    @Key("url.cart")
    String urlCart();

    @Key("url.checkoutFinish")
    String urlCheckoutFinish();

    @Key("url.login")
    String urlLogin();

    @Key("url.customer")
    String urlCustomer();

    @Key("url.customerEndereco")
    String urlCustomerEndereco();

    @Key("timeout")
    int timeout();

    @Key("faker.locale")
    String faker();

    @Key("url.remote")
    String urlRemote();
}
