
# API de Autenticação - Java + Spring Boot

Esta é uma API Stateless desenvolvida em Java para autenticação de usuários. A API permite que os usuários se registrem, realizem login e façam uma busca pelos usuários registrados de forma segura.

## 🌐 URL Pública para Testes

Você pode testar a API diretamente usando o seguinte domínio:

```
http://ec2-18-191-72-7.us-east-2.compute.amazonaws.com:8080
```

### Endpoints Disponíveis

| Método | Endpoint      | Descrição                     |
|--------|---------------|-------------------------------|
| POST   | `/auth/register` | Registro de novo usuário      |
| POST   | `/auth/login`    | Login e geração de token JWT  |
| GET    | `/user`          | Lista usuários cadastrados (autenticado) |

---

## 🛠️ Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- BCrypt (hash de senhas)
- PostgreSQL

---

## 📑 Endpoints Detalhados

### 🔐 Autenticação

#### 📥 Registro de Usuário

**POST** `/auth/register`  
🔗 URL: `http://ec2-18-191-72-7.us-east-2.compute.amazonaws.com:8080/auth/register`

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

#### 🔑 Login de Usuário

**POST** `/auth/login`  
🔗 URL: `http://ec2-18-191-72-7.us-east-2.compute.amazonaws.com:8080/auth/login`

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

---

### 👤 Usuários

#### 📋 Listar Usuários Registrados

**GET** `/user`  
🔗 URL: `http://ec2-18-191-72-7.us-east-2.compute.amazonaws.com:8080/user`

**Requisição:**
- Requer autenticação via JWT.
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

---

## ▶️ Como Executar Localmente

1. Clone este repositório:
   ```sh
   git clone https://github.com/LucasDias2002/login-auth-api.git
   ```

2. Acesse a pasta do projeto:
   ```sh
   cd login-auth-api
   ```

3. Configure o banco de dados no arquivo `application.properties`.

4. Execute o projeto via sua IDE

---

## 🔒 Autenticação

- A API utiliza JWT para autenticação.
- Toda requisição a rotas protegidas exige um token JWT no cabeçalho:
  ```
  Authorization: Bearer SEU_TOKEN
  ```

---

💡 Em caso de dúvidas ou sugestões, fique à vontade para abrir uma issue ou contribuir com o projeto!
