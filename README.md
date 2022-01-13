# Lab - API para gerenciamento de cadastro de pessoas

### Descrição


Api REST contendo as operações básicas listadas abaixo:

* create : Adiciona uma pessoa
* findAll : Busca todas as pessoas cadastradas
* findById: Busca de pessoa por id
* update: Atualiza o cadastro de uma pessoa
* delete: Apaga o registro de uma pessoa

Depois de executar o projeto, é possível ver a documentação da api em:

```
http://localhost:8080/api-doc.html
```

Esse projeto foi desenvolvido com o objetivo de atender até o nível 2 do modelo de maturidade de Richardson. Futuramente
podemos evoluir para o nível 3. Para saber mais sobre esse modelo consulte a documentação nos links da documentação de
referência abaixo.

### Pré - requisitos e Ferramentas auxiliares para esse projeto

* Java JDK versão 11
* Apache Maven 3.6.3 ou superior
* IDE à sua escolha ( Para esse projeto foi utilizado o IntelliJ IDEA 2021.2 - Community Edition)
* Conta no GITHUB para armazenamento do código fonte
* Conta no HEROKU para deploy da aplicação
* Postman APP para testes da API

Url de publicação no Heroku: https://labs-people-api.herokuapp.com

### Execução do projeto

* Para executar esse projeto, abra um terminal e de dentro da pasta do projeto execute o comando abaixo:

```shell script
mvn spring-boot:run 
```

Caso queira executar pela IDE em caso de estudos para facilitar o DEBUG, basta executar a classe
PersonapiApplication.java que se encontra em:

```
src/main/java/br/com/izabelrodrigues/personapi/PersonapiApplication.java
```

* Após o servidor ter sido inicializado a URL base da api será:

```
http://localhost:8080/api/v1/people
```

### Documentação de referência

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.4/maven-plugin/reference/html/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#using-boot-devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#production-ready)
* [Site oficial do Heroku](https://www.heroku.com/)
* [Documentação oficial do Lombok](https://projectlombok.org/)
* [Documentação oficial do Map Struct](https://mapstruct.org/)
* [Documentação oficial do H2 Database](https://h2database.com/html/main.html)
* [Modelo de maturidade de Richardson](https://restfulapi.net/richardson-maturity-model/)
* [Postman para download](https://www.postman.com/downloads/)
* [Documentação OpenApi 3](https://springdoc.org/)

### Próximos passos

* Testes unitários
