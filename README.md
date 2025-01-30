# Desafio Itaú - Backend

## 🚀 Sobre o Desafio
Este repositório contém a solução para o **Desafio Técnico de Backend** do Itaú Unibanco. O objetivo do desafio é desenvolver uma API REST que recebe transações e retorna estatísticas dessas transações, utilizando **Java** e **Spring Boot**.

---

## 📌 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
- **Maven**
- **Lombok** (para reduzir boilerplate code)
- **Swagger/OpenAPI** (para documentação da API)

---

## 🔧 Como Executar o Projeto
### Pré-requisitos
- Ter o **Java 17** e **Maven** instalados

### Passos para execução
1. Clone este repositório:
   ```sh
   git clone https://github.com/Pedro-melo12/Desafio_t-cnico_it-u.git
   ```
2. Acesse a pasta do projeto:
   ```sh
   cd desafioitau
   ```
3. Compile o projeto:
   ```sh
   mvn clean install
   ```
4. Execute a aplicação:
   ```sh
   mvn spring-boot:run
   ```
5. A API estará disponível em: `http://localhost:8080`
6. A documentação Swagger pode ser acessada em: `http://localhost:8080/swagger-ui/index.html`

---

## 📌 Endpoints da API

### Criar uma Transação - `POST /transacao`
Recebe uma transação e armazena em memória.
```json
{
  "valor": 123.45,
  "dataHora": "2025-01-30T12:34:56.789-03:00"
}
```
**Respostas:**
- `201 Created` - Transação cadastrada com sucesso.
- `400 Bad Request` - JSON inválido.
- `422 Unprocessable Entity` - Dados inválidos.

### Apagar Todas as Transações - `DELETE /transacao`
Remove todas as transações armazenadas.

**Resposta:** `200 OK`

### Obter Estatísticas - `GET /estatistica`
Retorna estatísticas das transações dos últimos 60 segundos.

**Resposta:**
```json
{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.456,
  "min": 12.34,
  "max": 123.56
}
```

---

## ✅ Diferenciais Implementados
✔️ **Swagger/OpenAPI** para documentação 📖
✔️ **Tratamento de Erros** personalizado 🎯

---

## 📜 Licença
Este projeto foi desenvolvido para fins de estudo e aprendizado. Sinta-se à vontade para explorá-lo, sugerir melhorias ou utilizá-lo como base para seus próprios desafios! 🚀

Feito com 💙 por [Seu Nome](https://github.com/seu-usuario)
