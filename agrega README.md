# ForoHub - Consulta API
### Desafío Alura para desarrolladores Backend

### Descripción
<p>ForoHub API es un proyecto que permite gestionar foros y tópicos con autenticación segura mediante JWT. 
  La aplicación está desarrollada en Java utilizando Spring Boot, y proporciona endpoints para manejar usuarios, 
  autenticación, y operaciones CRUD sobre tópicos.</p>

### Características principales
- Autenticación y seguridad:
  - Implementación de JWT para la autenticación de usuarios.
  - Filtros personalizados para validar y autenticar peticiones.
- Gestor de tópicos:
  - Registro de nuevos tópicos.
  - Actualización, eliminación y detalle de tópicos.
  - Listado de tópicos.
- Arquitectura modular:
  - Separación clara en controladores, servicios, repositorios y entidades.
  - Uso de DTOs para transferir datos entre capas.

### Tecnologías utilizadas
- Java 17 o superior
- Maven
- Base de datos `MySQL`
- Intellij IDEA
- Spring Boot
  - Spring Security
  - Spring Data JPA
- JWT
- Lombok

### Uso de la API - Endpoints principales
#### Autenticación
- POST `/auth/login`
  - Permite autenticar un usuario y genera un token `JWT`.
#### Tópicos
- GET `/topicos`
  - Lista todos los tópicos.
- POST `/topicos`
  - Registra un nuevo tópico.
- GET `/topicos/{id}`
  -Obtiene el detalle de un tópico por su ID.
- PUT `/topicos/{id}`
  - Actualiza un tópico existente.
- DELETE `/topicos/{id}`
  - Elimina un tópico por su ID.
