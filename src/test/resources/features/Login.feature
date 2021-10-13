# language: pt
# charset: UTF-8
# Supported severity values: blocker, critical, normal, minor, trivial. ex.: @severity=critical
# Every Feature or Scenario can be annotated by following tags: @flaky, @muted, @known


Funcionalidade: Teste de validação Web - Login
  Eu como cliente gostaria de realizar o login na plataforma Dafiti com sucesso

  @realizarLogin
  Cenario: CT001 - Login - Realizar login na plataforma Dafiti com sucesso
    Dado que eu estou na homepage para fazer login
    Quando eu clicar no menu Entrar
    E a tela de login inicial é exibida
    E preencho o email e senha para efetuar login
    Entao clico em Entrar

