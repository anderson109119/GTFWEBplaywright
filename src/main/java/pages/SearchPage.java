package pages;

import lombok.extern.log4j.Log4j2;

import static support.context.Context.*;

@Log4j2
public class SearchPage {

    //Page Elements
    private String inputPesquisa = "[name=\"q\"]";
    private String btnButton = "[class=\"search-button icon-magnifier-2\"]";
    private String btnProduto = "[id=\"AD464SCF15FAE\"]";
    private String selecionarTamanho = "xpath=//*[@id=\"add-to-cart\"]/div[2]";
    private String selecionarTamanho2 = "[class=\"selectbox-option-name\"]";
    private String btnComprar = "[class=\"dft button primary large fluid add-to-cart-form-button\"]";
    private String btnIrParaSacola = "xpath=//*[@id=\"wrapper\"]/div[1]/div[2]/div/div/div[3]/div[4]/div[2]/a";

    public void navigateToUrl(){

        web().tentarIrPara(config().getPropsEnv().url());
    }

    public void buscar (String produto) {
        report().takeScreenShot();
        web().getPage().type(inputPesquisa,produto);
        web().getPage().click(btnButton);

    }
    public void clicarProduto() {
        report().takeScreenShot();
        web().getPage().click(btnProduto);
    }
    public void setSelecionarTamanho() {
        report().takeScreenShot();
        web().getPage().click(selecionarTamanho);
        web().getPage().click(selecionarTamanho2);

    }
    public void clicarComprar() throws Exception {
        report().takeScreenShot();
        web().getPage().click(btnComprar);
        web().getPage().waitForTimeout(5000);

    }
    public void clicarIrParaSacola() throws InterruptedException {
        report().takeScreenShot();
        web().getPage().click(btnIrParaSacola);
    }
}
