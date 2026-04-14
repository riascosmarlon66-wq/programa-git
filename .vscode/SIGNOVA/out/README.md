# SIGNOVA - Aplicación Web
Proyecto desarrollado en Java Web usando Servlets, JSP y MySQL. 
## Requisitos
- Java 11+
- MySQL corriendo
- Base de datos 'signova' con tabla 'usuarios'
-Apache Tomcat
## Despliegue en Tomcat

1. Descarga Tomcat 10 desde https://tomcat.apache.org/download-10.cgi
2. Extrae Tomcat en `c:\tomcat` (o donde prefieras)
3. Copia `SIGNOVA.war` a `c:\tomcat\webapps\`
4. Ejecuta `c:\tomcat\bin\startup.bat`
5. Abre http://localhost:8080/SIGNOVA/RegistroServlet

## URLs
- Formulario: http://localhost:8080/SIGNOVA/registro.jsp
- Lista: http://localhost:8080/SIGNOVA/RegistroServlet

## Funcionalidades
- Registrar usuario
- Listar usuarios
- Buscar usuario
- Actualizar usuario
- Eliminar usuario
## Estructura
- dao
- modelo
- servlet
- JSP
- conexión a MySQL

## Autor
Marlon Riascos
Juan Felipe Tovar
Juliet Briseño
Javier Ortiz
Maicol Otavo
Ficha: 3113988
