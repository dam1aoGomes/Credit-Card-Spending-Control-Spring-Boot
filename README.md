# Sistema de Controle de Gastos Pessoais

Este projeto consiste em uma **API REST** robusta para o gerenciamento de despesas financeiras.

## Tecnologias Utilizadas

* **Java 21+** e **Spring Boot 3**.
* **Spring Data JPA**: Persistência de dados e mapeamento objeto-relacional.
* **PostgreSQL**: Banco de dados relacional para armazenamento seguro.
* **JUnit 5 & Mockito**: Garantia de qualidade através de **testes unitários**.
* **Lombok**: Produtividade e código limpo (Clean Code).
* **Bean Validation**: Validação rigorosa de integridade de dados na entrada da API.

## 🛠️ Funcionalidades (CRUD)

O sistema permite a gestão completa do ciclo de vida de uma despesa:
* **Cadastro de Despesas**: Registro com descrição, valor, data e categoria.
* **Listagem**: Consulta de todos os registros salvos no banco de dados.
* **Regras de Negócio (Validações)**:
    * Impedimento de cadastro com **data futura** (Garantia de integridade histórica).
    * Impedimento de valores **negativos ou zero** (Consistência financeira).

## 🧪 Testes Unitários
* **Mocks**: Uso de Mockito para isolar a camada de serviço do banco de dados.
* **Cenários de Erro**: Testes que validam se o sistema bloqueia corretamente dados inválidos.
* **Caminho Feliz**: Validação do fluxo completo de salvamento com sucesso.

## 📦 Como Executar

1.  **Clone o repositório**:
    ```bash
    git clone https://github.com/dam1aoGomes/Credit-Card-Spending-Control-Spring-Boot.git
    ```
2.  **Configure o Banco de Dados**:
    * Crie um banco no PostgreSQL chamado `controle_gastos`.
    * Renomeie o arquivo `application.properties.example` para `application.properties` e insira suas credenciais locais.
3.  **Rode a aplicação**:
    * Execute via sua IDE favorita ou use o comando `./mvnw spring-boot:run`.
4.  **Acesse a API**:
    * Endpoints base: `POST` e `GET` em `http://localhost:8080/api/expenses`

---

## 👨‍💻 Autor
**Damião**
Ciência da Computação - UFC (Campus Quixadá).
