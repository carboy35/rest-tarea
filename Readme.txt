1) ejecutar script.sql en base mysql 5 y poner usuario:carlos y contraseña: admin

1) Copiar carpeta instalacion en repositorio local

2) Para instalar el JAR se debe rescatar la estructura se encontrara en la carpeta INSTALACION en el repositorio.

3) Estructura contenida en la carpeta correspondiente a la fecha se debe copiar en la RAIZ del servidor, quedando la estructura de carpetas como se muestran mas abajo:


config/application.properties
config/messages.properties
rest-tarea-0.0.1.jar
start.sh
stop.sh

4) Levantar Microservicio ejecutando el comando (./start.sh 8090) 