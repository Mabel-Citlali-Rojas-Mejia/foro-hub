# 📝 Forohub API - Challenge Alura Latam / Oracle Next Education

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white)

## 🚀 Sobre el Proyecto
**Forohub** es una API REST robusta diseñada para replicar el funcionamiento de un foro de discusión. El objetivo principal es la gestión de tópicos, permitiendo a los usuarios interactuar, compartir dudas y soluciones técnicas de manera organizada y segura.

Desarrollado como parte del programa **Oracle Next Education (ONE)**, este proyecto aplica principios de **Clean Code**, **SOLID** y seguridad avanzada en el ecosistema Java.

---

## 🛠️ Funcionalidades Principales
* **Autenticación Segura:** Implementación de **Spring Security** y **JWT** (JSON Web Tokens) para el control de acceso y protección de rutas.
* **Gestión de Tópicos (CRUD):** Creación, consulta, actualización y eliminación de discusiones.
* **Validaciones de Negocio:** Prevención de tópicos duplicados y campos obligatorios mediante `Bean Validation`.
* **Persistencia de Datos:** Uso de **Spring Data JPA** y migraciones de base de datos con **Flyway**.
* **Manejo de Errores:** Tratamiento personalizado de excepciones para respuestas HTTP claras y profesionales.

---

## 🏗️ Arquitectura y Tecnologías
El proyecto sigue una arquitectura limpia dividida en capas para facilitar el mantenimiento y la escalabilidad:
* **Controller:** Gestión de solicitudes HTTP y mapeo de rutas.
* **Service:** Orquestación de la lógica de negocio y reglas de validación.
* **Repository:** Capa de abstracción para la comunicación con la base de datos MySQL.
* **Security/Infrastructure:** Configuración de seguridad, filtros JWT y manejo de excepciones globales.

---

## 🔑 Endpoints Principales

| Método | Endpoint | Descripción | Acceso |
| :--- | :--- | :--- | :--- |
| **POST** | `/login` | Autenticación y generación de Token JWT | Público |
| **GET** | `/topicos` | Listado paginado de todos los tópicos | Autenticado |
| **POST** | `/topicos` | Registro de un nuevo tópico (Valida duplicados) | Autenticado |
| **GET** | `/topicos/{id}` | Detalle de un tópico específico por ID | Autenticado |
| **PUT** | `/topicos/{id}` | Actualización de datos de un tópico | Autenticado |
| **DELETE** | `/topicos/{id}` | Eliminación física o lógica del sistema | Autenticado |

---

## 🚦 Requisitos e Instalación

1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/Mabel-Citlali-Rojas-Mejia/foro-hub.git](https://github.com/Mabel-Citlali-Rojas-Mejia/foro-hub.git)
   ```
2. **Configurar la Base de Datos**:
Crea una base de datos en MySQL y ajusta las credenciales en src/main/resources/application.properties:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/forohub_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
api.security.token.secret=${JWT_SECRET:your-secret-here}
 ```
3 **Ejecutar el proyecto:**
 ```
mvn spring-boot:run
 ```
