package steps;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import lombok.extern.log4j.Log4j2;
import pages.EnderecosPage;
import pages.HomePage;

import java.util.Map;

@Log4j2
public class EnderecosSteps {

    //Page Objects
    public HomePage homePage;
    public EnderecosPage enderecosPage;
    public Map map;

    public EnderecosSteps() {
        homePage = new HomePage();
        enderecosPage = new EnderecosPage();
    }

    @Dado("que eu estou na page customer")
    // Busca na url base o enviroment indicado no pom.xml
    public void  paginaCustomer() {

        enderecosPage.navigateToUrlCustomer();
    }
    @Quando("eu clico no menu Meus Endereços e  na opção Criar novo")
    public void efetuar_pesquisa() {

        enderecosPage.clicarMenuMeusEnderecos();
    }
    @E("a tela de criação de endereço é exibida")
    public void paginaCustomerEndereco() throws Exception{
        enderecosPage.navigateToUrlCustomerEndereco();
    }
    @E("eu preencho o formulário de cadastro de endereço selecionando-o como endereço principal")
    public void preencherFormularioEnderecoPrincipal() throws Exception{
        enderecosPage.preencherFormularioEnderecoPrincipal();
    }
    @E("preencho o formulário de cadastro de endereço selecionando-o como endereço entrega")
    public void preencherFormularioEnderecoEntrega() throws Exception{
        enderecosPage.preencherFormularioEnderecoEntrega();
    }
    @E("preencho o formulário de cadastro de endereço selecionando-o como endereço de entrega e principal")
    public void preencherFormularioAmbosEnderecos() throws Exception{
        enderecosPage.preencherFormularioAmbosEnderecos();
    }
    @E("clico em Salvar Endereço")
    public void clicarSalvarEndereco() throws Exception {
        enderecosPage.clicarSalvarEndereco();
    }
    @Entao("o endereço principal é cadastrado com sucesso")
    public void validarInclusaoEndereco() throws Exception {
        enderecosPage.validarEnderecoSalvo();

    }
}
