## Descrição
Esta é uma API Stateless desenvolvida em Java para autenticação de usuários. A API permite que os usuários se registrem, realizem login e façam uma busca pelos usuários registrados de forma segura.

## Tecnologias Utilizadas
- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- BCrypt para hash de senhas
- PostgreSQL

## Endpoints

### Autenticação

#### Registro de Usuário
**POST** `/auth/register`

**Requisição:**
```json
{
  "name": "Lucas Dias",
  "email": "lucasdias@email.com",
  "senha": "senha123"
}
```

**Resposta:**
```json
{
  "name": "Lucas Dias",
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

#### Login de Usuário
**POST** `/auth/login`

**Requisição:**
```json
{
  "email": "lucasdias@email.com",
  "senha": "senha123"
}
```

**Resposta:**
```json
{
  "name": "Lucas Dias",
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

### Usuários

#### Listar Usuários Registrados
**GET** `/user`

**Requisição:**
- Necessita de autenticação via token JWT.
- Cabeçalho da requisição:
  ```
  Authorization: Bearer SEU_TOKEN
  ```

**Resposta:**
```json
[
  {
    "id": 1,
    "nome": "Lucas Dias",
    "email": "lucasdias@email.com"
  },
  {
    "id": 2,
    "nome": "Marcus Felipe",
    "email": "marcusfelipe@email.com"
  }
]
```

## Como Executar
1. Clone este repositório
   ```sh
   git clone https://github.com/LucasDias2002/login-auth-api.git
   ```
2. Acesse a pasta do projeto
   ```sh
   cd NOME_DA_PASTA
   ```
3. Configure o banco de dados no `application.properties`
   
4. Por fim execute o projeto e efetue os testes.

## Autenticação
- A API utiliza JWT para autenticação
- Todas as requisições protegidas exigem um token no cabeçalho Authorization:
  ```
  Authorization: Bearer SEU_TOKEN
  ```
