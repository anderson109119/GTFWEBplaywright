# language: pt
# charset: UTF-8
# Supported severity values: blocker, critical, normal, minor, trivial. ex.: @severity=critical
# Every Feature or Scenario can be annotated by following tags: @flaky, @muted, @known


Funcionalidade: Teste de validação Web - Endereço
  Eu como cliente gostaria de realizar a inclusão de um novo endereço principal

Contexto:
  Dado que eu estou na homepage para fazer login
  Quando eu clicar no menu Entrar
  E a tela de login inicial é exibida
  E preencho o email e senha para efetuar login
  Entao clico em Entrar

  @enderecoPrincipal
  Cenario: CT001 - Endereço - Realizar a inclusão de um novo endereço principal com sucesso
    Dado que eu estou na page customer
    Quando eu clico no menu Meus Endereços e  na opção Criar novo
    E a tela de criação de endereço é exibida
    E eu preencho o formulário de cadastro de endereço selecionando-o como endereço principal
    E clico em Salvar Endereço
    Entao o endereço principal é cadastrado com sucesso

  @enderecoEntrega
  Cenario: CT002 - Endereço - Realizar a inclusão de um novo endereço de entrega com sucesso
    Dado que eu estou na page customer
    Quando eu clico no menu Meus Endereços e  na opção Criar novo
    E a tela de criação de endereço é exibida
    E preencho o formulário de cadastro de endereço selecionando-o como endereço entrega
    E clico em Salvar Endereço
    Entao o endereço principal é cadastrado com sucesso

  @ambosEnderecos
  Cenario: CT003 - Endereço - Realizar a inclusão de um novo endereço de entrega e principal com sucesso
    Dado que eu estou na page customer
    Quando eu clico no menu Meus Endereços e  na opção Criar novo
    E a tela de criação de endereço é exibida
    E preencho o formulário de cadastro de endereço selecionando-o como endereço de entrega e principal
    E clico em Salvar Endereço
    Entao o endereço principal é cadastrado com sucesso

