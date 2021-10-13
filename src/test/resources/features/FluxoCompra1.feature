# language: pt
# charset: UTF-8
# Supported severity values: blocker, critical, normal, minor, trivial. ex.: @severity=critical
# Every Feature or Scenario can be annotated by following tags: @flaky, @muted, @known


Funcionalidade: Teste de validação Web - Fluxo de Compra 01 - Produto com cliente PF já
  existente para a forma de pagamento Boleto (Sem vale troca e sem cupom de desconto).

  Eu como cliente gostaria de finalizar a compra de produto com sucesso

    Contexto:
    Dado que eu estou na homepage
    Quando eu realizar a pesquisa com um "produto valido"
    Entao serão apresentados os produtos de acordo com a pesquisa

    Dado que eu clico em um dos produtos
    E escolho o tamanho
    Quando eu clico em Comprar
    E eu clico em Ir para a Sacola

  @fluxoCompra1
  Cenario: CT001 - Finalizar Comprar - Executar a finalização da compra com sucesso
    Dado que eu estou na tela do carrinho de compras
    Quando eu clicar em Finalizar compra
    E a tela de login é exibida
    E preencho o email e senha
    E clico em Entrar e finalizar compra
    E seleciono a forma de pagamento Boleto Bancário
    E clico em Finalizar Compra da tela de checkout finish
    Entao vejo o numero do pedido exibido na tela checkout success

