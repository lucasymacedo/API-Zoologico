
# API de Zoológico

Uma pequena API que retorna Animais e Cuidados, junto de uma página web para consumir a API.
O projeto utiliza a linguagem Java e algumas ferramentas como Spring Boot, Maven e Thymeleaf, em um banco de dados MySQL.
O banco de dados é populado carregando o arquivo data.sql. Feito com Java 17


### Setup

Instalar o JDK 17 ou superior, adicionar a variável de ambiente JAVA_HOME em variáveis de sistema, com o caminho para a pasta bin da sua instalação, ex: `C:\Program Files\Java\jdk-17.0.1`

Baixar a versão mais recente do Maven em https://maven.apache.org/download.cgi

Alterar a variável PATH em variáveis de sistema, adicionando o caminho para a pasta /bin de sua instalação, ex: `C:\Program Files\apache-maven-3.9.11\bin`


## Alterações

Para rodar o projeto, é necessário fazer as seguintes alterações:

Criar uma conexão com banco de dados MySQL e um banco chamado TesteEstagio (ou alterar o endereço no campo `spring.datasource.url` no arquivo `application.properties` para um banco criado por você), um usuário chamado `apiuser` (ou alterar o nome no campo `spring.datasource.username = apiuser` para o seu usuário mySql)

Abra o arquivo `application.properties`, altere o campo `spring.datasource.password = ${MYSQL_PASSWORD}` e substitua `${MYSQL_PASSWORD}` pela senha do seu banco MySQL, sem aspas.


## Rodando o projeto

Para rodar o projeto:
Certifique-se que está na raiz do projeto e depois rode o seguinte comando no terminal
`mvn spring-boot:run`. Em seguida, abra o navegador e insira a url http://localhost:8080

Certifique-se de que o serviço MySQL está rodando e que o usuário `apiuser` existe com a senha correta antes de rodar os testes ou o projeto, ou que você trocou o usuário e a senha conforme instruído no campo ALTERAÇÕES.

### Próximos passos:

1. Adicionar suporte a containers (docker)
2. Adicionar testes
3. Adicionar mais validações
4. Adicionar arquivo .env para reduzir a quantidade de alterações necessárias
5. Adicionar um script que cria o banco e o usuário MySQL automaticamente
6. Fazer com que a aplicação não derrube (DROP) a tabela cada vez que iniciar, populando o banco com o arquivo data.sql apenas uma vez
