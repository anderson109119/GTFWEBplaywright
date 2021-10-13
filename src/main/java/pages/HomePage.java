package pages;


import lombok.extern.log4j.Log4j2;

import static support.context.Context.report;
import static support.context.Context.web;


@Log4j2
public class HomePage {

    //Page Elements
    public String txtMessage = "xpath=//*[@id=\"wrapper\"]/div[1]/div[1]/div/div/div/div[1]/div[1]/a/b";

    public boolean validarMenuPresenteFreteGratis() {

        report().takeScreenShot();
        return web().getPage().isVisible(txtMessage);
    }



    public boolean validarTextoAdidas() {

        String produtoprimeirapagina = web().getPage().innerHTML("#wrapper > div.l-full-content.l-container > div.container.catalog-page > div.catalog-breadcrumb.clearfix > div > ul > li:nth-child(2) > a");
        String produtoprimeirapaginamatch = "adidas";

        report().takeScreenShot();
        if (produtoprimeirapagina == produtoprimeirapaginamatch) {
            return true;
        }
        else {
            return false;
        }
    }

    public void validarMenuPresenteEmTodasAsAbas() {
/*
        String produto = web().getPage().innerHTML("#wrapper > div.l-full-content.l-container > div.container.catalog-page > div.catalog-breadcrumb.clearfix > div > ul > li:nth-child(2) > a");
        // System.out.println(produto);
        String btnButton = "xpath=//*[@id=\"wrapper\"]/div[3]/div[3]/div[3]/div/div[3]/div/ul/li[5]/a";

        for(int pageNumber = 1; pageNumber < web().getBrowserContext().pages().size(); pageNumber++){
            web().changeFocusPage(pageNumber);
            report().takeScreenShot();
            web().getPage().click(btnButton);
            assertTrue(produto,true);
        }

 */
    }
}
