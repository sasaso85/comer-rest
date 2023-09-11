# REQUIRIMIENTOS
## Java & MongoDB (Spring)
***


Desarrollar API REST con JSON que permita consumir dar de alta, consultar y modificar un cliente.

La respuesta de la API para cada petición deberá considerar los siguientes campos base dentro de la respuesta JSON:

- cve_error (donde 0 es exitoso y un valor negativo cuando es error). 
- cve_mensaje (la descripción del código de mensaje).

> Los registros no deben permitir ni repetir:
>  - **nombre de usuario**  
>  - **correo electrónico**.

Los clientes deberán tener los siguientes campos:

| Name               | Type           |
|--------------------|----------------|
| clienteId          | Integer        |
| nombreUsuario      | String         |
| contrasenia        | String         |
| nombre             | String         |
| apellidos          | String         |
| correoElectronico  | String         |
| edad               | Integer        |
| estatura           | Decimal number |
| peso               | Decimal number |
| IMC                | Decimal number |
| GEB                | Decimal number |
| ETA                | Decimal number |
| fechaCreacion      | Date           |
| fechaActualizacion | Date           |


- Realiza el Siguiente POST para agregar un Cliente

    **POST** */NutriNET/Cliente*
    
    Con la siguiente estructura JSON (Diferentes Valores)

        {
            "nombre": "Juan",
            "apellidos": "Perez Hernandez", 
            "nombre_Usuario": "Ju",
            "correo_Electronico": "jperez@hotmail.com",
            "contrasenia": "juanitoperez"
        }

- Realiza un Get (Tendrá la opción de todos o por ID)

  **GET** */NutriNET/Cliente*

- Realiza el siguiente **PUT**, para modificar el peso y la estatura de un cliente 
  
  **PUT** */NutriNET/Cliente/59*
  
      {
          "edad": 39
          "estatura": 1.80
          "peso": 60
          "GEB": 1500
      }


# Info para correr la aplicación

## Configuración
*** 
Posicionarse en la raiz del proyecto:
- Construir el jar:

  `mvn clean install`

- Crear la imagen de la aplicación:

  `docker build -t client_rest_docker_image .`

### Contenedor de MongoDB
- Descargar la imagen

  `docker pull mongo`
- Correr la imagen

  `docker run -d --name mongo-on-docker -p 27017:27017 mongo`

### Contenedor de la aplicación
- Correr la imagen

  `docker run -d --name clientapplication-on-docker -p 8080:8080 client_rest_docker_image`


