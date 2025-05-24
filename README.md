# MotusWatch - Gerenciamento de Motos

Projeto desenvolvido em Spring Boot para gerenciar motos em diferentes áreas do pátio.  
Inclui funcionalidades de CRUD para motos e usuários, com paginação, ordenação, cache e tratamento de exceções.

## Tecnologias

- Java 
- Spring Boot
- Spring Data JPA
- H2 Database 
- Bean Validation
- Lombok
- Cache simples 
- Maven

## Funcionalidades

- CRUD completo para entidades Moto e Usuário
- Paginação e ordenação nas listagens
- Busca por parâmetros (ex: área, placa)
- Cache para otimização de consultas
- Validação de dados de entrada
- Tratamento centralizado de erros REST

## Endpoints principais

### Moto

- `POST /api/motos` - Criar moto  
- `GET /api/motos` - Listar motos com paginação e ordenação  
- `GET /api/motos/area?area=VERMELHO` - Buscar motos por área  
- `GET /api/motos/{id}` - Buscar moto por id  
- `GET /api/motos/placa/{placa}` - Buscar motos por placa   
- `DELETE /api/motos/{id}` - Deletar moto por id

### Usuário

- `POST /api/usuarios` - Criar usuário  
- `GET /api/usuarios` - Listar usuários com paginação e ordenação  
- `GET /api/usuarios/{id}` - Buscar usuário por id  
- `PUT /api/usuarios/{id}` - Atualizar usuário  
- `DELETE /api/usuarios/{id}` - Deletar usuário

## Como rodar

1. Clone o repositório  
2. Abra no IDE preferido (IntelliJ, VSCode, Eclipse)  
3. Execute a aplicação Java (`MotusWatchApplication.java`)  
4. Acesse a API via `http://localhost:8080/api`  
5. Use o Insomnia ou Postman para testar os endpoints  

##  Prints das Requisições
[📸 Prints das Requisições] (https://drive.google.com/drive/folders/19TghFJtJ2x_2a5IrRFpwIVBU3LkIBPKN?usp=sharing)

##  👥 Integrantes
- Caroline de Oliveira - RM 559123
- Giulia Correa Camillo - RM 554473
- João Pedro Cancian Corrêa RM : 555341
  
