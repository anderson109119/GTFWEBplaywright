package steps;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import lombok.extern.log4j.Log4j2;
import pages.HomePage;
import pages.SearchPage;
import support.data.DataYaml;

import java.util.Map;

@Log4j2
public class SearchSteps {

    //Page Objects
    public SearchPage searchPage;
    public HomePage homePage;
    public Map map;

    public SearchSteps() {
        searchPage = new SearchPage();
        homePage = new HomePage();
    }

    @Dado("eu estou na home page")
    // Busca na url base o enviroment indicado no pom.xml
    public void pagina_inicial() {searchPage.navigateToUrl();}

    @Quando("eu realizar a pesquisa com {string}")
    public void efetuar_pesquisa(String dataType) {
        map = DataYaml.getMapYamlValues("Produtos", dataType);
        // defini a string produto para o método busca, que está dentro da classe SearchPage
        // o map vai no arquivo produto e pega o valor do atributo produto
        searchPage.buscar((String) map.get("produto"));
    }

    @Entao("sera apresentado produto adidas")
    public void validar_produto() {
        homePage.validarMenuPresenteFreteGratis();
        homePage.validarTextoAdidas();
        homePage.validarMenuPresenteEmTodasAsAbas();
    }
}
