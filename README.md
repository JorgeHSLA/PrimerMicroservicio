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

Patron de microservicios que sirve oara centralizar la configuracion en un solo lugar

