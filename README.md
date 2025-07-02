# Primer Microservicio Usando SpringBoot
Primer Microservicio que voy a hacer usando de guia un curso de udemy, este tendra mis apuntes para que terceros puedan comprender mejor los temas

## Se debe usar Spring Initializr

- En este ejemplo usaremos maven para las dependencias pero para proyectos mas grandes se recomienda Gradle
- Usaremos Java (tambien se podria usar Kotlin)

### Dependencias y versiones:

  ![image](https://github.com/user-attachments/assets/4ce0679f-9ffb-4b67-8436-1dccd558b19b)

  Se usa Java 21 porque es una version LTS (Long-Term Support), Java 24 no.

# server Regisry y Discovery
Despues de crear un primer microservicio, entre comillas, usaremos este para la implementacion de un server Regisry y Discovery:
Es un directorio centralizado donde cada microservicio registra su dirección IP, puerto y nombre al iniciar. Es como una guía telefónica de microservicios.

🔧 Ejemplos comunes:

Eureka (Netflix)

Consul (HashiCorp)

Zookeeper

Kubernetes Service Registry (interno de K8s)

en este ejemplo se usara eureka, sin embargo este dejo de actualizarse en 2018 y ahora se usa mas kubernetes u otros.

para entender porque se usa esta arquitectura tenemos que pensar en grande, donde un microservicio se instancia muchisimas veces, como se sabria a cual de todas las instancias conectarse, ahi entra service registry, en donde se encuentran las direcciones y puertos de cada instancia

## como funciona:

## importante
en esta parte del curso paso algo inesperado, teniamos que usar spring cloud pero este no era compatible con la 
ultima version de springboot, por ende se tuvo que cambiar la version a 3.4.7 para que funcionara todo bien

### Dependencias y versiones:

![image](https://github.com/user-attachments/assets/9c7a4ca6-6fef-4981-992a-99e287711bae)


