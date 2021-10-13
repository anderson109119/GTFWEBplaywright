# PROJETO MODELO PARA TESTE WEB - PLAYWRIGHT
####Versão: 1.0.1
[![CucumberReports: Aproved](https://messages.cucumber.io/api/report-collections/c379d9ee-2064-438c-b63a-a035994a922d/badge)](https://reports.cucumber.io/report-collections/c379d9ee-2064-438c-b63a-a035994a922d)

![](src/test/resources/icon.png)

## O Playwright permite testes confiáveis de ponta a ponta para aplicativos modernos para web.

## PRÉ-REQUISITOS

Requisitos de software e hardware necessários para executar este projeto de automação

*   Java 1.8 JDK
*   Maven 3.5.*
*   Intellij IDE
*   Plugins do Intellij
    * Cumcuber for java
    * Lombok
    * Ideolog
*   Docker

## ESTRUTURA DO PROJETO

| Diretório                    	| finalidade       	                                                                                        | 
|------------------------------	|---------------------------------------------------------------------------------------------------------- |
| src\main\java\support\config 			| Interface com as propriedades dos arquivos de ambiente 'Properties'                                       |
| src\main\java\support\data    		| Reponsável por ler arquivos yaml file e retonar objeto HashMap com os valores dos campos                  |
| src\main\java\support\dates 			| Metodos de suporte para trabalhar com datas                                                              	|
| src\main\java\support\browser 			| Responsável por fabricar os browser para rodar local e remoto para varios navegadores                    	|
| src\main\java\support\browser\navigators 			| Responsável pelo gerenciamento dos browsers                    	|
| src\main\java\pages			| Local onde deve ser criado as pages objects para facilitar a manutenção do projeto                       	|
| src\main\java\support\report			| Metodo responsável pela criação de screenshot anexada no Report Alure                                		|
| src\main\java\support			| Metodos de suporte a interação com os elementos web fazendo ações de click e esperas explicitas          	|
| src\main\resources\conf	    | Arquivos de configuração segregados por ambiente                                                        	|
| src\test\java\hooks          	| Metodos que executam antes e depois de cada teste (@Before, @After)                                   	|
| src\test\java\runner         	| Metodo prinicipal que inicia os testes via cucumber                                                      	|
| src\test\java\steps         	| Local onde deve ser criado as classes que representam os steps definition do cucumber                    	|
| src\test\resources\support\data      	| Massa de dados segregada por ambiente, escritos em arquivos yaml                                      	|
| src\test\resources\features 	| Funcionalidade e cenários de teste escritos em linguagem DSL (Gherkin language)                        	|   

## DOWNLOAD DO PROJETO TEMPLATE PARA SUA MÁQUINA LOCAL

Faça o donwload do template no repositório de código para utilizar no seu projeto em especifico,
feito isso, fique a vontande para usufruir dos recursos disponíveis e
também customizar de acordo com sua necessidade.


## FRAMEWORKS UTILIZADOS

Abaixo está a lista de frameworks utilizados nesse projeto

* Jackson - Responsável pela leitura de dados de arquivo yaml file
* Playwright - Responsável pela interação com páginas web
* Allure - support.report em HTML
* Java Faker - Geracão de dados sintéticos
* Cucumber - Responsável pela especificação executável de cenários
* Cucumber Junit - Responsável por validar as condições de teste
* Lombok - Otimização de classes modelos
* Log4j2 - Responsável pelo Log do projeto
* AeonBits - Responsável por gerenciar as properties

## COMANDO PARA EXECUTAR OS TESTES

Com o prompt de comando acesse a pasta do projeto, onde esta localizado o arquivo pom.xml, execute o comando abaixo para rodar os testes automatizados.

```shell
mvn clean test
```

## COMANDO PARA GERAR EVIDÊNCIAS EM HTML (ALLURE)

Com o prompt de comando acesse a pasta do projeto, onde esta localizado o arquivo pom.xml, execute o comando abaixo para gerar as evidências em HTML

Gera o report
```shell
mvn allure:report
```

Gera o report e abri no navegador automaticamente
```shell
mvn allure:serve
```

## MULTIPLOS COMANDOS

Você também pode mesclar a linha de comando maven com options do cucumber,
sendo assim você pode escolher uma determinada tag que se deseja executar do cucumber,
podendo escolher também a massa de dados que irá utilizar e juntamente aplicar o linha de comando para gerar o support.report HTML.

```shell
mvn clean test -Dcucumber.filter.tags=@Tag -Dbrowser=chrome -Denv=des allure:report
```


## DOCKER

Docker pode ser utilizado para executar scripts do PlayWright

### PRE-REQUISITOS

Configurações necessárias para executar o Docker
*   [Docker instalado na máquina agente](https://www.docker.com/products/docker-desktop)
*   Projeto configurado para executar em headless.

### COMANDOS
Construir a imagem docker
```
docker build -t <IMAGE-NAME> -f ./Dockerfile .
```
Executar os testes com docker
```
docker run --ipc=host -v "$PWD/target:/usr/target" <IMAGE-NAME>:latest mvn test -Dcucumber.filter.tags=@Tag -Denv=des -Dheadless=true
```

## EXECUÇÃO REMOTA EM CLOUD (TESTINGBOT E HEADLESS TESTING)

Você pode executar testes remotamente.
```
mvn clean test -Dcucumber.filter.tags=@Tag -Denv=des -Dbrowser=remote allure:report
```

### Detalhes dos comandos
| Comando                      | Função                                                                                                   | 
|------------------------------    |---------------------------------------------------------------------------------------------------------- |
| -Dcucumber.filter.tags=@Tag | Sobrescreve os parametros do cucumber, neste exemplo estou filtrado os teste pela tag @dev, então somente os cenários com esta tag irão executar                 |
| -Denv=des       | Seleciona qual massa de teste de acordo com o ambiente que vai ser utilizado, exemplo: des, prod ou uat              |
| -Dbrowser=chrome| Seleciona qual navegador será executado os testes, exemplo: Chrome, Firefox, WebKit ou Remote             |




## ALLURE SERVER

Subir servidor Allure Report para compartilhar em uma rede interna

dentro da pasta docker com ferramenta de linha de comando

```
docker-compose up -d allure allure-ui
```

```yaml
version: '3'

services:
  allure:
    image: "frankescobar/allure-docker-service"
    environment:
      CHECK_RESULTS_EVERY_SECONDS: 1
      KEEP_HISTORY: 1
      KEEP_HISTORY_LATEST: 10
    ports:
      - "5050:5050"
  allure-ui:
    image: "rubenslobo/allure-server-ui:latest"
    environment:
      ALLURE_DOCKER_PUBLIC_API_URL: "http://localhost:5050"
      ALLURE_DOCKER_PUBLIC_API_URL_PREFIX: ""
    ports:
      - "5252:5252"
```

Para habilitar a integração você deve popular o arquivo de properties localizado "src/test/resources/allure.properties"

```properties
allure.server.enable = false

allure.results.directory=target/allure-results

allure.server.host = http://localhost
allure.server.port = 5050

allure.server.project = demo
allure.server.force_project_creation = true
```

## EVIDÊNCIAS

Os arquivos com as evidências ficam localizados na pasta target do projeto, esta pasta só é criada depois da primeira execução.

```
 Report HTML: target\site\index.html
 Json Cucumber: target\json-cucumber-reports\cucumber.json
 Xml Junit: tagert\xml-junit\junit.xml
```
Ps.: Caso você necessite utilizar do Allure, o mesmo somente cria os relatórios pelo maven com o paramêtro 'allure:report', conforme exemplo de múltiplos comandos acima.

## LOG DE EXECUÇÃO

Os logs de execução gerados pelo Log4j2 ficam alocados na pasta target/log

## LINKS DE APOIO

* [Playwright - Documentação Oficial](https://playwright.dev/java/docs/1.12.0/intro)