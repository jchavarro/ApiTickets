# ApiTickets
API que nos permite crear, eliminar, editar y recuperar tickets con paginación.

Esta api esta en una version Java 17 y corre con una base de datos sql embebida llamada h2.

En la raiz del proyecto existe un archivo de tipo JSON que son las peticiones HTTP para la API
se puede importar desde PostMan.

La api esta sobre un contenedor Docker. 
Para correr sigue los siguientes pasos.
```
$ mvn clean
$ mvn install
$ docker build -t apitickets .
$ docker run -p 8080:8080  
```
