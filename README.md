# REQUIRIMIENTOS
## Java & MongoDB (Spring)
***


Desarrollar API REST con JSON que permita consumir dar de alta, consultar y modificar un cliente.

La respuesta de la API para cada petición deberá considerar los siguientes campos base dentro de la respuesta JSON:

- cve_error (donde 0 es exitoso y un valor negativo cuando es error). 
- cve_mensaje (la descripción del código de mensaje).

> Los registros no deben permitir ni repetir **nombre** de usuario ni **correo electrónico**.

Los clientes deberán tener los siguientes campos:

| Name                | Type           |
|---------------------|----------------|
| client_id           | Integer        |
| nombre_usuario      | String         |
| contrasenia         | String         |
| nombre              | String         |
| apellidos           | String         |
| correo_electronico  | String         |
| edad                | Integer        |
| estatura            | Decimal number |
| peso                | Decimal number |
| IMC                 | Decimal number |
| GEB                 | Decimal number |
| ETA                 | Decimal number |
| fecha_creacion      | Date           |
| fecha_actualizacion | Date           |


- Realiza el Siguiente POST para agregar un Cliente

    **POST** */NutriNET/Cliente*
    
    Con la siguiente estructura JSON (Diferentes Valores)

        {
            "Nombre": "Juan",
            "Apellidos": "Perez Hernandez", 
            "Nombre_Usuario": "Ju",
            "Correo_Electronico": "jperez@hotmail.com",
            "Contraseña": "juanitoperez"
        }

- Realiza un Get (Tendrá la opción de todos o por ID)

  **GET** */NutriNET/Cliente*

- Realiza el siguiente **PUT**, para modificar el peso y la estatura de un cliente 
  
  **PUT** */NutriNET/Cliente/59*
  
      {
          "Edad": 39
          "Estatura": 1.80
          "Peso": 60
          "GEB": 1500
      }

