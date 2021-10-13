package pages;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import lombok.extern.log4j.Log4j2;

import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static support.context.Context.*;

@Log4j2
public class EnderecosPage {

    static Faker fake = new Faker(new Locale("pt-br"));
    static String nome = fake.name().firstName();
    static String sobreNome = fake.name().lastName();
    static String cep = fake.options().option("73100-020","72020-022","73031-501","73031-601");
    static int numero = fake.number().numberBetween(1,100);
    static String complemento = fake.toString();
    static PhoneNumber telefone = fake.phoneNumber();

    //Page Elements
    private String menuMeusEnderecos = "xpath=//*[@id=\"wrapper\"]/div[3]/div[3]/div[2]/div[1]/ul/li[7]/a";
    private String btnCriarNovo = "[class=\"my-account-address-title-link my-account-address-action\"]";
    private String campoNome = "[id=\"AddressForm_first_name\"]";
    private String campoSobrenome = "[id=\"AddressForm_last_name\"]";
    private String campoCep = "[id=\"AddressForm_postcode\"]";
    private String campoNumero = "[id=\"AddressForm_street_number\"]";
    private String campoComplemento = "[id=\"AddressForm_additional_info\"]";
    private String campoTelefone = "[id=\"AddressForm_phone\"]";
    private String checkBoxEnderecoPrincipal = "[id=\"AddressForm_is_default_billing\"]";
    private String checkBoxEnderecoEntrega = "[id=\"AddressForm_is_default_shipping\"]";
    private String btnSalvarEndereco = "[id=\"myaccount-address-submit\"]";
    private String msgEnderecoSalvo = "[class=\"message-description\"]";


    public void navigateToUrlCustomer(){
        report().takeScreenShot();
        web().tentarIrPara(config().getPropsEnv().urlCustomer());
    }
    public void clicarMenuMeusEnderecos() {
        report().takeScreenShot();
        web().getPage().click(menuMeusEnderecos);
        web().getPage().click(btnCriarNovo);
        web().getPage().waitForTimeout(5000);
    }
    public void navigateToUrlCustomerEndereco(){
        report().takeScreenShot();
        web().tentarIrPara(config().getPropsEnv().urlCustomerEndereco());
    }
    public void preencherFormularioEnderecoPrincipal(){
        report().takeScreenShot();
        web().getPage().type(campoNome,nome);
        web().getPage().type(campoSobrenome,sobreNome);
        web().getPage().type(campoCep,cep);
        web().getPage().type(campoNumero, String.valueOf(numero));
        web().getPage().type(campoComplemento,complemento);
        web().getPage().type(campoTelefone, "6199999999");
        web().getPage().check(checkBoxEnderecoPrincipal);
    }
    public void preencherFormularioEnderecoEntrega(){
        report().takeScreenShot();
        web().getPage().type(campoNome,nome);
        web().getPage().type(campoSobrenome,sobreNome);
        web().getPage().type(campoCep,cep);
        web().getPage().type(campoNumero, String.valueOf(numero));
        web().getPage().type(campoComplemento,complemento);
        web().getPage().type(campoTelefone, "6199999999");
        web().getPage().check(checkBoxEnderecoEntrega);
    }
    public void preencherFormularioAmbosEnderecos(){
        report().takeScreenShot();
        web().getPage().type(campoNome,nome);
        web().getPage().type(campoSobrenome,sobreNome);
        web().getPage().type(campoCep,cep);
        web().getPage().type(campoNumero, String.valueOf(numero));
        web().getPage().type(campoComplemento,complemento);
        web().getPage().type(campoTelefone, "6199999999");
        web().getPage().check(checkBoxEnderecoPrincipal);
        web().getPage().check(checkBoxEnderecoEntrega);

    }
    public void clicarSalvarEndereco() {
        report().takeScreenShot();
        web().getPage().click(btnSalvarEndereco);
        web().getPage().waitForTimeout(5000);
    }
    public void validarEnderecoSalvo() {
        report().takeScreenShot();
        String msgSucesso = web().getPage().innerText(msgEnderecoSalvo);
        assertEquals("Endereço salvo!", msgSucesso);
    }
}
