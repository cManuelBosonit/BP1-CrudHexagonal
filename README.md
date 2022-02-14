# BP1-CrudHexagonal

Refactorizar el anterior CRUD, utilizando buenas prácticas. 

Crear CRUD de la siguiente tabla: table persona { id_persona int [pk, increment] usuario string [not null max-length: 10 min-length: 6] password string [not null] name string [not null] surname string company_email string [not null ] personal_email string [not null] city string [not null] active boolean [not null] created_date date [not null] imagen_url string termination_date date }

Realizar validaciones necesarias con lógica en java (no usar etiqueta @Valid) if (usuario==null) {throw new Exception(“Usuario no puede ser nulo”); } if (usuario.length()>10) { throw new Exception(“Longitud de usuario no puede ser superior a 10 caracteres) ...

Poner 3 endpoints en la búsqueda. ⦁ Buscar por ID ⦁ Buscar por nombre de usuario (campo usuario) ⦁ Mostrar todos los registros.

Usar DTOS, interfaces y clases de servicio.
