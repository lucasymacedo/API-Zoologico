
# API de Zoológico

Uma pequena API que retorna Animais e Cuidados, junto de uma página web para consumir a API.
O projeto utiliza a linguagem Java e algumas ferramentas como Spring Boot e Thymeleaf, em um banco de dados MySQL.
O banco de dados é populado carregando o arquivo data.sql*. Feito com Java 17


*Desabilitei o carregamento do script que populava o banco pois estava gerando entradas duplicadas

Criar um banco de dados chamado TesteEstagio (ou alterar o endereço no campo `spring.datasource.url` nos arquivos com final `.properties` para um banco criado por você), um usuário chamado `apiuser` (ou alterar o nome no campo `spring.datasource.username`)


## VARIÁVEIS DE AMBIENTE

Para rodar o projeto, são necessárias as seguintes VARIÁVEIS:

### Para o perfil MySQL
- **`MYSQL_PASSWORD`** - A senha da conta `apiuser`. Obrigatória quando for rodar testes ou na própria aplicação quando usando o perfil `mysql`. Se preferir, abra os arquivos com extensão `.properties`, descomente o campo `spring.datasource.password = ` e complete-o com a senha do banco MySQL, sem aspas 

### Setup

Você pode setar essas variáveis usando uma das seguintes formas:

1. **Usando um arquivo `.env` (recomendado)**:
   - Crie um arquivo de nome `.env` na raiz do projeto (api).
   - Adicione a seguinte linha:
    MYSQL_PASSWORD=<sua_senha_aqui>, sem aspas.
   - O arquivo `.env` está no `.gitignore` e não será incluído no commit, se optar por esse método, você deverá criar seu próprio.
2. **Usando variáveis de ambiente**:
   - No Windows: Altere em Sistema → Configurações Avançadas do Sistema → Variáveis de Ambiente

Para rodar testes com o perfil MySQL:
Certifique-se que está na raiz do projeto e depois rode o seguinte comando no terminal
`mvn test -D spring.profiles.active=mysql`

Para rodar o projeto:
Certifique-se que está na raiz do projeto e depois rode o seguinte comando no terminal
`mvn spring-boot:run`. Em seguida, abra o navegador e insira a url http://localhost:8080

Certifique-se de que o serviço MySQL está rodando e que o usuário `apiuser` existe com a senha correta antes de rodar os testes ou o projeto.


