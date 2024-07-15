<h1 align="center" style="font-weight: 900; font-size: 40px; letter-spacing: 2px; color: cadetblue;">Foro Hub</h1>

<p align="center" style="font-weight: 900; font-size: 59px; letter-spacing: 2px; aling-text:center;" >El proyecto Foro Hub es una plataforma de foros diseñada para fomentar la comunicación y la discusión entre usuarios. Permite a los usuarios crear temas de discusión, responder a otros temas y participar activamente en conversaciones significativasEl proyecto Foro Hub es una plataforma de foros diseñada para fomentar la comunicación y la discusión entre usuarios. Permite a los usuarios crear temas de discusión, responder a otros temas y participar activamente en conversaciones significativas</p>

<p  align="center" ><img  src="https://github.com/user-attachments/assets/1cfffbd2-a0c0-4a37-b17f-c8bcc164bc0b](https://github.com/user-attachments/assets/0100dc37-4ec1-4599-9134-79e2bcc020ea" alt="Badge Spring"></p>

<h2 style="font-weight: 900;">📖 Características 📖</h2>
<ul style="font-weight: 500; font-family: system-ui;">
    <li>Registro de nuevos tópicos con validación de campos obligatorios.</li>
    <li>Listado de todos los tópicos disponibles.</li>
    <li>Detalle de un tópico específico por su ID.</li>
    <li>Actualización de tópicos existentes.</li>
    <li>Eliminación de tópicos.</li>
  <li>Mecanismo de autenticación JWT para asegurar las operaciones.</li>
</ul>

<h2 style="font-weight: 900;">⚙️ Requisitos ⚙️</h2>
<ul style="font-weight: 500; font-family: system-ui;">
    <li>Java 11 o superior</li>
    <li>Maven 3.6.3 o superior</li>
    <li>Spring Boot 2.5.4 o superior</li>
    <li>MySQL 8.0 o superior</li>
    <li>pgAdmin 4 (opcional para PostgreSQL)</li>
  <li>JWT (JSON Web Tokens) para autenticación</li>
</ul>

<h2 style="font-weight: 900;">🧱 Estructura del Proyecto 🧱</h2>

  <ul style="font-weight: 500; font-family: system-ui;">
    <li><strong>Entities:</strong> Clases que representan entidades de datos persistentes en la base de datos. </li>
    <li><strong>Dto (Data Transfer Objects):</strong> Clases utilizadas para transferir datos entre la capa de presentación (o cliente) y la capa de servicio.</li>
    <li><strong>Repository:</strong> Interfaces que definen métodos de acceso a datos para interactuar con las entidades en la base de datos.</li>
    <li><strong>Service:</strong> Clases que contienen la lógica de negocio de la aplicación.</li>
    <li><strong>Controller:</strong> Clases que gestionan las solicitudes HTTP entrantes y coordinan las respuestas de la API.</li>
    <li><strong>Security:</strong> Configuraciones y clases relacionadas con la seguridad de la aplicación. Esto puede incluir configuraciones de autenticación (como JWT), autorización, filtros de seguridad, gestión de sesiones, entre otros, para proteger los recursos y controlar el acceso a las funcionalidades de la API.</li>
  </ul>



  <h2 style="font-weight: 900;">🛠️Configuración🛠️</h2>
  <ol style="font-weight: 500; font-family: system-ui;">
    <li><strong>Clonar el Repositorio:</strong><br>
      <code>git clone https://github.com/AnteriorFan/Foro-Hub-Challenge.git</code>
    </li>
    <li><strong>Configuración de la Base de Datos:</strong><br>
      Configura tu base de datos MySQL y ajusta las configuraciones en <code>application.properties</code>.
    </li>
    <li><strong>Compilar y Ejecutar:</strong><br>
      <code>./mvnw spring-boot:run</code>
    </li>
  </ol>

  <h2 style="font-weight: 900;">🚩 Endpoints Disponibles 🚩</h2>
  <ul style="font-weight: 500; font-family: system-ui;">
    <li><code>POST /topicos</code>: Registrar un nuevo tópico.</li>
    <li><code>GET /topicos</code>: Obtener la lista de todos los tópicos.</li>
    <li><code>GET /topicos/{id}</code>: Obtener detalles de un tópico por su ID.</li>
    <li><code>PUT /topicos/{id}</code>: Actualizar un tópico existente.</li>
    <li><code>DELETE /topicos/{id}</code>: Eliminar un tópico.</li>
  </ul>

  <h2 style="font-weight: 900;">Estado del Proyecto</h2>
<p>Actualmente, el endpoint `usuarios/respuestas` ya es funcional y permite interactuar con las respuestas de los usuarios. Sin embargo, es importante tener en cuenta que algunnos endpoint aún está en proceso de construcción. Esto significa que aunque puedes utilizarlo para realizar operaciones básicas, como la obtención, creación, actualización y eliminación de respuestas de usuarios..

Durante este período de construcción, podrías notar cambios ocasionales en la estructura de respuesta o en la lógica de funcionamiento de los endpoint. </p>
