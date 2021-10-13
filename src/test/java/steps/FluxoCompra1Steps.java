package steps;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import lombok.extern.log4j.Log4j2;
import pages.FluxoCompra1Page;
import pages.HomePage;
import support.data.DataYaml;

import java.util.Map;

@Log4j2
public class FluxoCompra1Steps {

    //Page Objects
    public HomePage homePage;
    public FluxoCompra1Page fluxoCompra1Page;
    public Map map;

    public FluxoCompra1Steps() {
        homePage = new HomePage();
        fluxoCompra1Page = new FluxoCompra1Page();
    }

//OBTER PRODUTO PARA REALIZAR A COMPRA

    @Dado("que eu estou na homepage")
    // Busca na url base o enviroment indicado no pom.xml
    public void pagina_inicial() {
        fluxoCompra1Page.navigateToUrl();
    }

    @Quando("eu realizar a pesquisa com um {string}")
    public void efetuar_pesquisa(String dataType) {
        map = DataYaml.getMapYamlValues("Produtos", dataType);
        // defini a string produto para o método busca, que está dentro da classe SearchPage
        // o map vai no arquivo produto e pega o valor do atributo produto
        fluxoCompra1Page.buscarProdutoCompra((String) map.get("produto"));
    }

    @Entao("serão apresentados os produtos de acordo com a pesquisa")
    public void validar_produto() {
        homePage.validarMenuPresenteFreteGratis();
        homePage.validarTextoAdidas();
        homePage.validarMenuPresenteEmTodasAsAbas();
    }
    @Dado("que eu clico em um dos produtos")
    public void clicarProdutoProdutoCompra() {

        fluxoCompra1Page.clicarProdutoCompra();
    }
    @E("escolho o tamanho")
    public void selecionarTamanhoProdutoCompra() {

        fluxoCompra1Page.setSelecionarTamanhoProdutoCompra();
    }
    @E("eu clico em Comprar")
    public void clicarComprarProdutoCompra() {
        fluxoCompra1Page.clicarComprarProdutoCompra();
    }
    @E("eu clico em Ir para a Sacola")
    public void clicarIrParaSacola() throws InterruptedException {
        fluxoCompra1Page.clicarIrParaSacolaProdutoCompra();
    }

//CENARIO FINALIZAR COMPRA

    @Dado("que eu estou na tela do carrinho de compras")
    // Busca na url base o enviroment indicado no pom.xml
    public void paginaCart() {
        fluxoCompra1Page.navigateToUrlCart();
        }

    @Quando("eu clicar em Finalizar compra")
    public void clicarFinalizarCompra() throws Exception{
        fluxoCompra1Page.clicarFinalizarCompra();
    }

    @E("a tela de login é exibida")
    public void telaLogin() throws Exception{
        fluxoCompra1Page.navigateToUrlLogin();
    }
    @E("preencho o email e senha")
    public void clicarProduto() throws Exception {
        fluxoCompra1Page.dadosLogin();
    }
    @E("clico em Entrar e finalizar compra")
    public void clicarComprar() throws Exception {
        fluxoCompra1Page.clicarEntrarFinalizarCompra();
    }
    @E("seleciono a forma de pagamento Boleto Bancário")
    public void selecionarBoletoBancario() throws Exception {
        fluxoCompra1Page.selecionarBoletoBancario();
    }
    @E("clico em Finalizar Compra da tela de checkout finish")
    public void clicarFinalizarCompraCheckout() throws Exception {
        fluxoCompra1Page.clicarFinalizarCompraCheckout();
        fluxoCompra1Page.validarPedidoConcluirSucesso();
    }
    @Entao("vejo o numero do pedido exibido na tela checkout success")
    public void numeroDoPedidoDisponiveldaTela() throws Exception {
        fluxoCompra1Page.validarNumeroPedidoVisivelTela();
    }

}
