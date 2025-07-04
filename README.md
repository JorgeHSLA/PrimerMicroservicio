# Primer Microservicio Usando SpringBoot
Primer Microservicio que voy a hacer usando de guia un curso de udemy, este tendra mis apuntes para que terceros puedan comprender mejor los temas

## Se debe usar Spring Initializr

- En este ejemplo usaremos maven para las dependencias pero para proyectos mas grandes se recomienda Gradle
- Usaremos Java (tambien se podria usar Kotlin)

### Dependencias y versiones:

  ![image](https://github.com/user-attachments/assets/4ce0679f-9ffb-4b67-8436-1dccd558b19b)

  Se usa Java 21 porque es una version LTS (Long-Term Support), Java 24 no.

# Service Registry and Discovery

¿Cómo sabe un servicio (cliente) dónde encontrar a otro servicio (proveedor), si estos pueden estar cambiando de IP o puerto (por escalado, fallos, reinicios, etc.)?

Ahí es donde entra el Service Registry and Discovery.

### 🔹 Server Registry (Registro de Servicios)
Es un directorio centralizado donde cada microservicio registra su dirección IP, puerto y nombre al iniciar. Es como una guía telefónica de microservicios.

🔧 Ejemplos comunes:

Eureka (Netflix)

Consul (HashiCorp)

Zookeeper

Kubernetes Service Registry (interno de K8s)

### 🔹 Service Discovery (Descubrimiento de Servicios)
Es el mecanismo mediante el cual un servicio encuentra a otro en base a su nombre lógico, consultando el Service Registry.

Hay dos formas de hacerlo:

Client-side Discovery (Descubrimiento en el cliente)
El cliente consulta el registro y decide a qué instancia llamar.

✅ Ejemplo: Spring Cloud + Eureka

Server-side Discovery (Descubrimiento en el servidor)
El cliente envía la solicitud a un load balancer que consulta el registro y reenvía la solicitud al servicio destino.

✅ Ejemplo: Kubernetes con su kube-proxy y servicios tipo ClusterIP

## Como funciona:


<img width="1778" alt="image" src="https://github.com/user-attachments/assets/88c66727-6b1f-458e-ba10-a704ba7390da" />


## Importante
en esta parte del curso paso algo inesperado, teniamos que usar spring cloud pero este no era compatible con la 
ultima version de springboot, por ende se tuvo que cambiar la version a 3.4.7 para que funcionara todo bien

ademas tambien se uso eureka netflix para saber acerca del 

### Dependencias y versiones:

![image](https://github.com/user-attachments/assets/9c7a4ca6-6fef-4981-992a-99e287711bae)


# Config server

Patron de microservicios que sirve oara centralizar la configuracion de los microservicios en un solo lugar, en el caso de spring tenemos los perfiles y ademas si el config server se actualiza los microservcios conectados a el (es decir sus clientes) tambien:

<img width="1793" alt="image" src="https://github.com/user-attachments/assets/627df757-0a02-4d98-b3ba-ff7df23fca4d" />


### Dependencias y versiones:

<img width="1516" alt="image" src="https://github.com/user-attachments/assets/066ef145-ac48-4d6f-82f9-75bbb702dd30" />

no se agrego el dev tools porque no hay que debuggear 

## IMPORTANTE:

El config server usa git, yo para este ejercicio use github, se debe crear un repositorio con las configuraciones, en este se guardan los perfiles. Ejemplo:
![image](https://github.com/user-attachments/assets/ee93f7ee-be9e-47f7-b453-5c48f28a42fc)

Desde el config server, si el repositorio es privado (como deberia serlo porque maneja informacion delicada) se debe agregar usuario y contra, sin embargo la contra se puede cambiar por un token. ejemplo con token:
<img width="952" alt="image" src="https://github.com/user-attachments/assets/4d90ed78-ffb8-407a-948b-523299ee6613" />


Esto lo que genera es que desde nuestro microservicio podemos elegir a que perfil acceder, en este ejeplo accede al config server (puerto 7777) y de este extrae la informacion:
![image](https://github.com/user-attachments/assets/ec8b758f-a025-4ae0-ba2f-28f2d671483a)



Un ejemplo de como se guarda la infomracion en cada perfil seria el siguiente:
<img width="1033" alt="image" src="https://github.com/user-attachments/assets/65dee456-cc8a-4550-8ae2-323d53e35383" />

informacion de github si quieres usar un ssh: https://docs.github.com/en/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent









