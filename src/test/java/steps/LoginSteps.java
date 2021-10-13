package steps;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import lombok.extern.log4j.Log4j2;
import pages.HomePage;
import pages.LoginPage;

import java.util.Map;

@Log4j2
public class LoginSteps {

    //Page Objects
    public HomePage homePage;
    public LoginPage loginPage;
    public Map map;

    public LoginSteps() {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Dado("que eu estou na homepage para fazer login")
    // Busca na url base o enviroment indicado no pom.xml
    public void  pagina_inicial() {
        loginPage.navigateToUrl();
    }
    @Quando("eu clicar no menu Entrar")
    public void efetuar_pesquisa() {
        loginPage.clicarMenuEntrar();
    }
    @E("a tela de login inicial é exibida")
    public void telaLogin() throws Exception{
        loginPage.navigateToUrlLogin();
    }
    @E("preencho o email e senha para efetuar login")
    public void preencherDadosLogin() throws Exception {
        loginPage.dadosLogin();
    }
    @Entao("clico em Entrar")
    public void clicarEntrar() throws Exception {
        loginPage.clicarBotaoEntrar();
    }
}
