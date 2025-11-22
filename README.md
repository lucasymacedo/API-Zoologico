
# Projeto Estágio (placeholder)

Uma pequena API que retorna Animais e Cuidados, junto de uma página web para consumir a API.
O projeto utiliza a linguagem Java e algumas ferramentas como Spring Boot e Thymeleaf.
O banco de dados é populado carregando o arquivo data.sql




## VARIAVEIS DE AMBIENTE

Para rodar o projeto, são necessárias as seguintes VARIÁVEIS DE AMBIENTE:

### Para o profile MySQL
- **`MYSQL_PASSWORD`** - A senha da conta `apiuser`. Obrigatória quando for rodar testes ou na própria aplicação quando usando o perfil `mysql`.

### Setup

Você pode setar essas variáveis usando uma das seguintes formas:

1. **Usando um arquivo `.env`** (recomendado):
   - Crie um arquivo `.env` na raiz do projeto
   - Adicione a seguinte linha:
    MYSQL_PASSWORD=your_password_here
   - O arquivo `.env` já está no `.gitignore` e não será incluído no commit
2. **Usando variáveis de ambiente**:
   - No Windows: Altere em Sistema → Configurações Avançadas do Sistema → Variáveis de Ambiente

Para rodar testes com o perfil MySQL:

`mvn test -Dspring.profiles.active=mysql`

Para rodar o projeto:
Certifique-se que está na raiz do projeto e depois rode o seguinte comando no terminal
`mvn spring-boot:run`

Certifique-se de que o serviço MySQL está rodando e que o usuário `apiuser` existe com a senha correta antes de rodar os testes ou o projeto.
