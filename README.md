# Todo API

REST API para gestión de tareas pendientes, desarrollada con Spring Boot.

## Tecnologías
- Java 21
- Spring Boot 3.x
- Spring Data JPA + Hibernate
- MySQL
- Lombok
- Maven

## Endpoints
| Método | URL                      | Descripción                       |
|--------|--------------------------|-----------------------------------|
| GET    | /api/todos               | Listar todas las tareas           |
| GET    | /api/todos/{id}          | Obtener tarea por ID              |
| GET    | /api/todos/complete      | Listar todas las tares terminadas |
| POST   | /api/todos               | Crear tarea                       |
| PUT    | /api/todos/{id}          | Actualizar tarea                  |
| DELETE | /api/todos/{id}          | Eliminar tarea                    |
| PATCH  | /api/todos/{id}/complete | Marcar tarea como terminada       |

## Cómo ejecutar
1. Clonar el repositorio
2. Configurar base de datos MySQL en `application.properties`
3. Ejecutar con `./mvnw spring-boot:run`