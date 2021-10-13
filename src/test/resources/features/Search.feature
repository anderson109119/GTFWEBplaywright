# language: pt
# charset: UTF-8
# Supported severity values: blocker, critical, normal, minor, trivial. ex.: @severity=critical
# Every Feature or Scenario can be annotated by following tags: @flaky, @muted, @known


Funcionalidade: Teste de validação Web - Busca
  Eu como cliente gostaria de realizar busca de produtos com sucesso

  @busca
  Cenario: CT001 - Busca - Executar pesquisa de produto com sucesso
    Dado eu estou na home page
    Quando eu realizar a pesquisa com "produto valido"
    Entao sera apresentado produto adidas