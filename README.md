🩺 TurnosPro

Sistema web de gestión de turnos médicos desarrollado con Spring Boot + React.

Permite registrar usuarios, iniciar sesión con autenticación JWT y administrar turnos de manera segura, donde cada usuario solo puede visualizar y gestionar sus propios turnos.

🚀 Tecnologías utilizadas

Backend

☕ Java 17

🌱 Spring Boot

🔐 Spring Security + JWT

🗄 PostgreSQL

🧩 JPA / Hibernate

📦 Maven

Frontend

⚛ React

🛣 React Router DOM

🎨 Bootstrap

🔗 Axios

🎯 React Icons

✨ Funcionalidades

✅ Registro de usuarios

✅ Inicio de sesión seguro con JWT

✅ Logout

✅ Protección de rutas

✅ CRUD completo de turnos

✅ Cada usuario ve únicamente sus turnos

✅ Selección de médicos desde una lista

✅ Navbar dinámica con usuario logueado

✅ Diseño responsive y moderno

📸 Capturas
Login

<img width="800" height="650" alt="image" src="https://github.com/user-attachments/assets/9d6824fc-5b4e-44c3-b228-cfc39fe79c1a" />


Registro

<img width="1896" height="558" alt="image" src="https://github.com/user-attachments/assets/1914227b-be2c-440b-b309-37e67e48fbf8" />


Gestión de turnos

<img width="1715" height="406" alt="image" src="https://github.com/user-attachments/assets/48c102b9-5f2f-45ca-8c4e-8012b25100ae" />


⚙ Instalación

1️⃣ Clonar repositorio
git clone https://github.com/smarchettiariza/turnospro.git
🔧 Backend
Entrar al backend
cd backend
Configurar PostgreSQL

Crear una base de datos llamada:

turnospro

Editar:

src/main/resources/application.properties

Con tus datos:

spring.datasource.url=jdbc:postgresql://localhost:5432/turnospro
spring.datasource.username=postgres
spring.datasource.password=TU_PASSWORD
Ejecutar backend
mvn spring-boot:run

Servidor:

http://localhost:8080
💻 Frontend
Entrar al frontend
cd frontend
Instalar dependencias
npm install
Ejecutar proyecto
npm start

Aplicación:

http://localhost:3000
🔐 Autenticación

El sistema utiliza:

JWT Token
Spring Security
Passwords encriptadas con BCrypt
📂 Estructura del proyecto
backend/
 ├── controller/
 ├── model/
 ├── repository/
 ├── security/
 └── service/

frontend/
 ├── src/
 │   ├── components/
 │   ├── pages/
 │   ├── api.js
 │   └── App.js

 
👨‍💻 Autor

Santiago Marchetti Ariza

Estudiante de Desarrollo de Aplicaciones Informáticas
Apasionado por el desarrollo web y móvil 🚀

Proyecto educativo y personal.
