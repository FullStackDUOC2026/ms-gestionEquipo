# ms-gestionAsignaciones
microservicio de gestion de asignaciones

# Sistema de Gestión de Equipos Tecnológicos

  ## Descripción
  Sistema de microservicios para gestionar empleados, equipos tecnológicos,
  asignaciones y mantenimiento dentro de una organización.
  Desarrollado con Spring Boot y desplegado en Railway.

  ## Integrantes
  - Nombre Apellido
  - Nombre Apellido
  - Nombre Apellido

  ## Microservicios implementados
  | Microservicio | Descripción |
  |---|---|
  | ms-registroUsuarios | Autenticación y registro de usuarios con JWT |
  | ms-empleado | CRUD de empleados |
  | ms-equipo | Gestión de equipos tecnológicos |
  | ms-gestionEquipo | Asignación de equipos a empleados |
  | ms-mantenimiento | Registro de mantenimientos de equipos |
  | ms-historial | Historial de asignaciones por empleado/equipo |
  | ms-apigateway | Enrutador central con filtro JWT |

  ## Rutas del API Gateway
  | Ruta | Microservicio |
  |---|---|
  | /auth/** | ms-registroUsuarios |
  | /equipos/** | ms-equipo |
  | /api/v1/empleado/** | ms-empleado |
  | /api/v1/asignacion/** | ms-gestionEquipo |
  | /mantenimientos/** | ms-mantenimiento |
  | /historial/** | ms-historial |

  ## Documentación Swagger
  - ms-gestionEquipo: https://ms-gestionequipo-production.up.railway.app/swagger-ui.html
  - ms-historial: https://ms-historial-production.up.railway.app/swagger-ui.html

  ## Ejecución local
  1. Clonar el repositorio
  2. Configurar variables de entorno: DB_URL, DB_USERNAME, DB_PASSWORD
  3. Ejecutar con: `mvn spring-boot:run`

  ## Despliegue remoto
  Todos los microservicios están desplegados en Railway.
  Gateway: https://ms-apigateway-production.up.railway.app
