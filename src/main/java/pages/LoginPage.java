package pages;

import lombok.extern.log4j.Log4j2;

import static org.junit.Assert.assertEquals;
import static support.context.Context.*;

@Log4j2
public class LoginPage {

    //Page Elements
    private String menuEntrar = "[class=\"header-login-link\"]";
    private String btnEntrar = "[class=\"dft button primary fluid medium\"]";
    private String campoEmail = "[id=\"LoginForm_email\"]";
    private String campoSenha = "[id=\"LoginForm_password\"]";
    private String labelInicio = "[class=\"my-account-menu-item-link col-md-12   is-active  sel-menu-home \"]";

    public void navigateToUrl(){

        web().tentarIrPara(config().getPropsEnv().url());
    }
    public void clicarMenuEntrar() {
        report().takeScreenShot();
        web().getPage().click(menuEntrar);
        web().getPage().waitForTimeout(5000);
    }
    public void navigateToUrlLogin(){
        web().tentarIrPara(config().getPropsEnv().urlLogin());
    }
    public void dadosLogin() {
        report().takeScreenShot();
        web().getPage().type(campoEmail, "jedilsondemelo2@gmail.com");
        web().getPage().type(campoSenha, "123456789");
    }
    public void clicarBotaoEntrar() {
        report().takeScreenShot();
        web().getPage().click(btnEntrar);
        web().getPage().waitForTimeout(5000);
    }
    public void validarPedidoConcluirSucesso() {
        String inicio = web().getPage().innerText(labelInicio);
        assertEquals("Início", inicio);
        web().getPage().waitForTimeout(5000);
    }
}
