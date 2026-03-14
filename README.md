# Desafio Backend SC TEC

## Descrição do Projeto

Este projeto consiste no desenvolvimento de uma API REST para gerenciamento de empreendimentos. A aplicação permite realizar operações de cadastro, consulta, atualização e remoção de empreendimentos através de endpoints REST.

Cada empreendimento possui informações como nome do empreendimento, nome do empreendedor, município, segmento de atuação, email de contato e status do empreendimento. A API implementa validação de dados para garantir a integridade das informações recebidas e retorna respostas padronizadas em caso de erro.

A solução foi desenvolvida utilizando o framework Spring Boot e segue boas práticas de arquitetura backend, como separação em camadas (controller, service e repository), utilização de DTOs para transferência de dados e tratamento global de exceções.

Essa estrutura facilita a manutenção do código, melhora a organização do projeto e torna a aplicação mais escalável.

---

## Tecnologias Utilizadas

As principais tecnologias utilizadas no projeto foram:

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* H2 Database
* Lombok
* Maven
* Jakarta Validation

O banco de dados utilizado foi o **H2 em memória**, permitindo executar o projeto sem necessidade de configuração de um banco de dados externo.

---

## Estrutura do Projeto

O projeto foi organizado em camadas para manter uma boa separação de responsabilidades:

* **controller** – responsável por expor os endpoints da API
* **service** – contém as regras de negócio da aplicação
* **repository** – responsável pela comunicação com o banco de dados
* **model** – representa as entidades da aplicação
* **dto** – utilizado para transferência de dados entre cliente e servidor
* **mapper** – responsável pela conversão entre entidades e DTOs
* **exception** – tratamento global de exceções da aplicação

Essa organização facilita a leitura, manutenção e evolução do sistema.


```
desafiosctec
│
├── src
│   └── main
│       ├── java
│       │   └── com.br.desafiosctec
│       │       ├── controller        # Endpoints da API
│       │       ├── service           # Regras de negócio
│       │       ├── repository        # Acesso ao banco de dados
│       │       ├── model             # Entidades da aplicação
│       │       ├── dto               # Objetos de transferência de dados
│       │       ├── mapper            # Conversão entre DTO e entidade
│       │       └── exception         # Tratamento global de erros
│       │
│       └── resources
│           └── application.properties
│
├── SCTEC - Empreendimentos.postman_collection.json  # Collection para testes da API
├── pom.xml                                          # Configuração do Maven
└── README.md                                        # Documentação do projeto
```



---

## Instruções para Execução do Projeto

Para executar o projeto localmente é necessário possuir **Java 21** instalado.

### 1 - Clonar o repositório

```bash
git clone https://github.com/Luizbernardi/desafiosctec.git
```

### 2 - Acessar a pasta raiz do projeto

A pasta raiz é o diretório onde está localizado o arquivo **pom.xml**.

```bash
cd desafiosctec
```

### 3 - Executar a aplicação

A forma mais recomendada e à prova de falhas para executar o projeto é utilizando a IDE **IntelliJ IDEA**, que gerencia automaticamente o ambiente do JDK e as dependências.

1. Abra o IntelliJ IDEA.
2. Clique em **File > Open...** e selecione a pasta raiz do projeto (onde está localizado o arquivo `pom.xml`).
3. Aguarde a IDE sincronizar o projeto e o Maven baixar as dependências (você verá uma barra de progresso no canto inferior direito).
4. No painel lateral esquerdo, navegue até a classe principal da aplicação, geralmente localizada em:
   `src/main/java/com/br/desafiosctec/DesafiosctecApplication.java`
5. Clique no botão verde de **Play** (Run) localizado na margem esquerda, ao lado do método `main`, e selecione **Run**.

Após a inicialização, o console exibirá o logo do Spring Boot e a aplicação estará rodando na porta padrão.

Ou no **Prompt de Comando (CMD)**:

```bash
mvnw spring-boot:run
```

No **PowerShell**:

```bash
.\mvnw spring-boot:run
```

O projeto utiliza **Maven Wrapper**, portanto **não é necessário instalar Maven na máquina**, pois o próprio projeto fará o download da versão necessária automaticamente.

Após iniciar, a aplicação estará disponível em:

```
http://localhost:8080
```

---

## Console do Banco de Dados H2

O console do banco H2 pode ser acessado através do navegador em:

```
http://localhost:8080/console
```

Configurações de acesso:

JDBC URL:

```
jdbc:h2:mem:sctecdb
```

Usuário:

```
sa
```

Senha:

```
(em branco)
```

---

## Endpoints da API

### Criar empreendimento

POST

```
/api/empreendimentos
```

Exemplo de requisição:

```json
{
  "nomeEmpreendimento": "Tech Solutions SC",
  "nomeEmpreendedor": "João Silva",
  "municipio": "Florianópolis",
  "segmento": "TECNOLOGIA",
  "email": "contato@techsolutions.com.br",
  "status": "ATIVO"
}
```

---

### Listar empreendimentos

GET

```
/api/empreendimentos
```

---

### Buscar empreendimento por ID

GET

```
/api/empreendimentos/{id}
```

---

### Atualizar empreendimento

PUT

```
/api/empreendimentos/{id}
```

---

### Remover empreendimento

DELETE

```
/api/empreendimentos/{id}
```

Quando removido com sucesso, a API retorna:

```
204 No Content
```

---

## Validações

Foram implementadas validações utilizando **Jakarta Validation** para garantir que os dados enviados para a API estejam corretos.

Exemplos de validações implementadas:

* Campos obrigatórios
* Validação de formato de email
* Validação de valores de enum

Quando ocorre erro de validação, a API retorna uma resposta contendo os campos inválidos e suas respectivas mensagens de erro.

---

## Tratamento de Exceções

A aplicação utiliza um **GlobalExceptionHandler** para tratar exceções de forma centralizada, retornando respostas padronizadas para o cliente da API.

Isso permite lidar com situações como:

* Recurso não encontrado
* Dados inválidos
* Erros internos da aplicação

---

## Collection do Postman

Para facilitar os testes da API, foi incluída no repositório uma **collection do Postman** contendo exemplos de requisições para todos os endpoints.

O arquivo da collection está localizado **na raiz do projeto**:

```
SCTEC - Empreendimentos.postman_collection.json
```

### Como importar no Postman

1. Abrir o Postman
2. Clicar em **Import**
3. Selecionar o arquivo `SCTEC - Empreendimentos.postman_collection.json`
4. A collection será importada automaticamente

Após importar, será possível testar todos os endpoints da API diretamente pelo Postman.

Certifique-se de que a aplicação esteja rodando em:

```
http://localhost:8080
```

---

## Vídeo Pitch

O vídeo pitch explicando o funcionamento da aplicação pode ser acessado no link abaixo:

https://drive.google.com/file/d/1JKGIHaCJS7xKlKi90WtR9UW92L-NLRiv/view?usp=sharing

No vídeo são apresentados:

* Estrutura do projeto
* Funcionamento dos principais endpoints
* Demonstração da execução da aplicação
* Explicação das decisões técnicas adotadas no desenvolvimento da solução
