# 🛒 API Gestión de Productos y Pedidos

Backend REST desarrollado con **Spring Boot** para la gestión de una tienda online.
Permite administrar **usuarios, productos, categorías y pedidos**, incluyendo control de **stock**, **seguridad con JWT** y **roles de usuario**.

Este proyecto simula el backend de un **e-commerce real**, aplicando buenas prácticas de arquitectura, seguridad y manejo de transacciones.

---

# 🚀 Tecnologías Utilizadas

* **Java**
* **Spring Boot**
* **Spring Security**
* **JWT (JSON Web Tokens)**
* **Spring Data JPA**
* **Hibernate**
* **Maven**
* **MySQL / PostgreSQL**
* **BCrypt Password Encoder**
* **Postman** (para pruebas de la API)

---

# 📌 ¿Para Qué Sirve Esta API?

Esta API permite gestionar el backend de una tienda online con funcionalidades como:
```
✔ Registro y autenticación de usuarios
✔ Seguridad mediante **JWT**
✔ Roles de usuario (**ADMIN / CLIENTE**)
✔ Gestión de **categorías de productos**
✔ Gestión de **productos y stock**
✔ Creación de **pedidos**
✔ Cálculo automático del total del pedido
✔ Reducción automática del stock al realizar compras
✔ Manejo de transacciones para evitar inconsistencias en la base de datos
```

El sistema está diseñado para simular el flujo real de compra de un e-commerce.

---

# 🏗️ Arquitectura del Proyecto

El proyecto sigue una arquitectura por capas típica en aplicaciones **Spring Boot**:

```
controller  →  service  →  repository  →  database
```

Estructura del proyecto:

```
src/main/java/com/tiendaonline/gestion

├── controller
│   ├── AuthController
│   ├── ProductoController
│   ├── CategoriaController
│   └── PedidoController
│
├── service
│   ├── AuthService
│   ├── ProductoService
│   ├── CategoriaService
│   └── PedidoService
│
├── service/impl
│   ├── AuthServiceImpl
│   ├── ProductoServiceImpl
│   ├── CategoriaServiceImpl
│   └── PedidoServiceImpl
│
├── repository
│   ├── UsuarioRepository
│   ├── ProductoRepository
│   ├── CategoriaRepository
│   ├── PedidoRepository
│   └── DetallePedidoRepository
│
├── model
│   ├── Usuario
│   ├── Producto
│   ├── Categoria
│   ├── Pedido
│   └── DetallePedido
│
├── dto
│   ├── auth
│   └── pedido
│
└── security
    ├── config
    ├── jwt
    └── service
```

---

# 📡 Endpoints Disponibles

## 🔐 Autenticación

| Método | Endpoint         | Descripción                       |
| ------ | ---------------- | --------------------------------- |
| POST   | `/auth/register` | Registrar nuevo usuario           |
| POST   | `/auth/login`    | Autenticación y generación de JWT |

---

## 📦 Productos

| Método | Endpoint          | Acceso  | Descripción         |
| ------ | ----------------- | ------- | ------------------- |
| GET    | `/productos`      | Público | Listar productos    |
| GET    | `/productos/{id}` | Público | Obtener producto    |
| POST   | `/productos`      | ADMIN   | Crear producto      |
| PUT    | `/productos/{id}` | ADMIN   | Actualizar producto |
| DELETE | `/productos/{id}` | ADMIN   | Eliminar producto   |

---

## 🗂 Categorías

| Método | Endpoint           | Acceso |
| ------ | ------------------ | ------ |
| GET    | `/categorias`      | ADMIN  |
| GET    | `/categorias/{id}` | ADMIN  |
| POST   | `/categorias`      | ADMIN  |
| PUT    | `/categorias/{id}` | ADMIN  |
| DELETE | `/categorias/{id}` | ADMIN  |

---

## 🛒 Pedidos

| Método | Endpoint   | Acceso  |
| ------ | ---------- | ------- |
| POST   | `/pedidos` | CLIENTE |

Este endpoint:

* valida stock
* reduce stock
* crea detalles del pedido
* calcula el total automáticamente

---

# 🛠️ Requisitos Previos

Antes de ejecutar el proyecto necesitas tener instalado:

* **Java**
* **Maven**
* **MySQL o PostgreSQL**
* **Postman** (opcional para pruebas)

---

# ⚙️ Configuración del Proyecto

1️⃣ Clonar el repositorio

```bash
git clone https://github.com/tuusuario/API_Gestion_Productos_Y_Pedidos.git
```

2️⃣ Entrar al proyecto

```bash
cd API_Gestion_Productos_Y_Pedidos
```

3️⃣ Configurar la base de datos en:

```
src/main/resources/application.properties
```

Ejemplo:

```
spring.datasource.url=jdbc:mysql://localhost:3306/tienda
spring.datasource.username=root
spring.datasource.password=1234

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

4️⃣ Ejecutar la aplicación

```bash
mvn spring-boot:run
```

La API se iniciará en:

```
http://localhost:8080
```

---

# 🧪 Probar la API con Postman

### Registrar usuario

```
POST /auth/register
```

Body:

```json
{
  "username": "cliente1",
  "email": "cliente@email.com",
  "password": "123456"
}
```

---

### Login

```
POST /auth/login
```

Body:

```json
{
  "username": "cliente1",
  "password": "123456"
}
```

Respuesta:

```json
{
  "token": "JWT_TOKEN"
}
```

---

### Usar token

En cada request protegida:

```
Authorization: Bearer TU_TOKEN
```

---

# 📊 Modelo de Datos

Relaciones principales:

```
Usuario 1 ---- N Pedido
Pedido 1 ---- N DetallePedido
Producto 1 ---- N DetallePedido
Categoria 1 ---- N Producto
```

Entidades principales:

* **Usuario**
* **Producto**
* **Categoria**
* **Pedido**
* **DetallePedido**

---

# 👨‍💻 Autor

Desarrollado por **Alejandro Collado Severiano**

Backend Developer | Java | Spring Boot

---

# 🔗 Enlaces Útiles

Spring Boot
https://spring.io/projects/spring-boot

Spring Security
https://spring.io/projects/spring-security

JWT
https://jwt.io

Hibernate
https://hibernate.org

