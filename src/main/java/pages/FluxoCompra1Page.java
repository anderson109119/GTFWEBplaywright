package pages;

import lombok.extern.log4j.Log4j2;

import static org.junit.Assert.assertEquals;
import static support.context.Context.*;

@Log4j2
public class FluxoCompra1Page {

//OBTER PRODUTO
    //Page Elements
    private String inputPesquisa = "[name=\"q\"]";
    private String btnButton = "[class=\"search-button icon-magnifier-2\"]";
    private String btnProduto = "[id=\"AD464SCF32JOD\"]";
    private String selecionarTamanho = "xpath=//*[@id=\"add-to-cart\"]/div[2]";
    private String selecionarTamanho2 = "[class=\"selectbox-option-name\"]";
    private String btnComprar = "[class=\"dft button primary large fluid add-to-cart-form-button\"]";
    private String btnIrParaSacola = "xpath=//*[@id=\"wrapper\"]/div[1]/div[2]/div/div/div[3]/div[4]/div[2]/a";

    public void navigateToUrl(){
        report().takeScreenShot();
        web().tentarIrPara(config().getPropsEnv().url());
    }
    public void buscarProdutoCompra (String produto) {
        report().takeScreenShot();
        web().getPage().type(inputPesquisa,produto);
        web().getPage().click(btnButton);

    }
    public void clicarProdutoCompra() {
        report().takeScreenShot();
        web().getPage().click(btnProduto);
    }
    public void setSelecionarTamanhoProdutoCompra() {
        report().takeScreenShot();
        web().getPage().click(selecionarTamanho);
        web().getPage().click(selecionarTamanho2);

    }
    public void clicarComprarProdutoCompra() {
        report().takeScreenShot();
        web().getPage().click(btnComprar);
        web().getPage().waitForTimeout(5000);

    }
    public void clicarIrParaSacolaProdutoCompra() throws InterruptedException {
        report().takeScreenShot();
        web().getPage().click(btnIrParaSacola);
    }

//CENARIO DE FINALIZAR COMPRA

    //Page Elements
    private String btnFinalizarCompra = "[class=\"dft button medium primary fluid \"]";
    private String campoEmail = "[id=\"LoginForm_email\"]";
    private String campoSenha = "[id=\"LoginForm_password\"]";
    private String btnEntrarFinalizarCompra = "[id=\"customer-account-login\"]";
    private String selecionaBoleto = "xpath=//*[@id=\"paymentMethodForm\"]/div[4]/div[1]/label";
    private String btnFinalizarCompraCheckout = "[id=\"btn_finalize_order\"]";
    private String txtMessage = "[class=\"description-text\"]";
    private String pedidoVisivel = "[class=\"title-52\"]";


    public void navigateToUrlCart(){
        report().takeScreenShot();
        web().tentarIrPara(config().getPropsEnv().urlCart());
        web().getPage().waitForTimeout(5000);
    }
    public void navigateToUrlLogin(){
        report().takeScreenShot();
        web().tentarIrPara(config().getPropsEnv().urlCheckoutFinish());
    }
    public void clicarFinalizarCompra () {
        report().takeScreenShot();
        web().getPage().click(btnFinalizarCompra);

    }
    public void dadosLogin () {
        report().takeScreenShot();
        web().getPage().type(campoEmail, "jedilsondemelo2@gmail.com");
        web().getPage().type(campoSenha, "123456789");

    }
    public void clicarEntrarFinalizarCompra() {
        report().takeScreenShot();
        web().getPage().click(btnEntrarFinalizarCompra);
        web().getPage().waitForTimeout(10000);

    }
    public void selecionarBoletoBancario() {
        report().takeScreenShot();
        web().getPage().click(selecionaBoleto);
        web().getPage().waitForTimeout(10000);
    }
    public void clicarFinalizarCompraCheckout() {
        report().takeScreenShot();
        web().getPage().click(btnFinalizarCompraCheckout);
        web().getPage().waitForTimeout(10000);
    }
    public void validarNumeroPedidoVisivelTela() {
        report().takeScreenShot();
        web().getPage().isVisible(pedidoVisivel);
        web().getPage().waitForTimeout(10000);
    }
    public void validarPedidoConcluirSucesso() {
        report().takeScreenShot();
        String msgSucesso = web().getPage().innerText(txtMessage);
        assertEquals("Seu pedido foi concluído com sucesso!", msgSucesso);
    }

}
