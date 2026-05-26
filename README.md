<div align="center">

# 🩺 TurnosPro

**Sistema web de gestión de turnos médicos**

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Bootstrap](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white)

*Aplicación full-stack para la gestión segura de turnos médicos con autenticación JWT*

</div>

---

## 📌 Descripción

**TurnosPro** es una aplicación web full-stack que permite a los pacientes registrarse, iniciar sesión y gestionar sus turnos médicos de forma segura. El sistema implementa autenticación con **JWT** y garantiza que cada usuario solo puede acceder y administrar sus propios datos.

---

## 🚀 Tecnologías

### Backend
| Tecnología | Descripción |
|---|---|
| ☕ Java 17 | Lenguaje principal |
| 🌱 Spring Boot | Framework de aplicación |
| 🔐 Spring Security + JWT | Autenticación y autorización |
| 🗄 PostgreSQL | Base de datos relacional |
| 🧩 JPA / Hibernate | ORM para persistencia |
| 📦 Maven | Gestión de dependencias |

### Frontend
| Tecnología | Descripción |
|---|---|
| ⚛ React | Biblioteca de UI |
| 🛣 React Router DOM | Navegación y rutas |
| 🎨 Bootstrap | Estilos y diseño responsive |
| 🔗 Axios | Cliente HTTP |
| 🎯 React Icons | Librería de íconos |

---

## ✨ Funcionalidades

- ✅ Registro de nuevos usuarios
- ✅ Inicio de sesión seguro con JWT
- ✅ Logout con invalidación de sesión
- ✅ Protección de rutas privadas
- ✅ CRUD completo de turnos médicos
- ✅ Aislamiento de datos por usuario (cada uno ve únicamente sus turnos)
- ✅ Selección de médicos desde una lista
- ✅ Navbar dinámica con información del usuario logueado
- ✅ Diseño responsive y moderno

---

## 📸 Capturas de pantalla

### 🔑 Login
> *Agregá acá una captura de tu pantalla de login*

### 📝 Registro
> *Agregá acá una captura de tu pantalla de registro*

### 📅 Gestión de Turnos
> *Agregá acá una captura de tu panel de turnos*

---

## ⚙️ Instalación y configuración

### Prerrequisitos

- Java 17+
- Node.js 16+
- PostgreSQL
- Maven

---

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/smarchettiariza/turnospro.git
cd turnospro
```

---

### 🔧 Backend

**1. Entrar a la carpeta del backend:**
```bash
cd backend
```

**2. Crear la base de datos en PostgreSQL:**
```sql
CREATE DATABASE turnospro;
```

**3. Configurar las credenciales en `src/main/resources/application.properties`:**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/turnospro
spring.datasource.username=postgres
spring.datasource.password=TU_PASSWORD
```

**4. Ejecutar el servidor:**
```bash
mvn spring-boot:run
```

El backend quedará disponible en: `http://localhost:8080`

---

### 💻 Frontend

**1. Entrar a la carpeta del frontend:**
```bash
cd frontend
```

**2. Instalar dependencias:**
```bash
npm install
```

**3. Ejecutar la aplicación:**
```bash
npm start
```

La aplicación quedará disponible en: `http://localhost:3000`

---

## 🔐 Seguridad

El sistema implementa un esquema de seguridad robusto:

- **JWT Tokens** — Autenticación stateless con tokens firmados
- **Spring Security** — Filtros y configuración de seguridad a nivel de API
- **BCrypt** — Encriptación de contraseñas antes de persistirlas en base de datos
- **Protección de rutas** — Las rutas del frontend requieren token válido para acceder

---

## 📂 Estructura del proyecto

```
turnospro/
│
├── backend/
│   ├── controller/       # Endpoints REST
│   ├── model/            # Entidades JPA
│   ├── repository/       # Interfaces de acceso a datos
│   ├── security/         # Configuración JWT y Spring Security
│   └── service/          # Lógica de negocio
│
└── frontend/
    └── src/
        ├── components/   # Componentes reutilizables
        ├── pages/        # Vistas principales
        ├── api.js        # Configuración de Axios
        └── App.js        # Componente raíz y rutas
```

---

## 👨‍💻 Autor

<div align="center">

**Santiago Marchetti Ariza**

Estudiante de Desarrollo de Aplicaciones Informáticas

*Apasionado por el desarrollo web y móvil 🚀*

[![GitHub](https://img.shields.io/badge/GitHub-smarchettiariza-181717?style=for-the-badge&logo=github)](https://github.com/smarchettiariza)

</div>

---

## 📄 Licencia

Este proyecto es de carácter **educativo y personal**. Libre para usar como referencia o inspiración.

---

<div align="center">
  <sub>Desarrollado con ❤️ por Santiago Marchetti Ariza</sub>
</div>
