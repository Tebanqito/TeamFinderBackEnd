ENDPOINTS

USUARIO: 
URL: /api/v1/auth/register
Método HTTP: POST
Descripción: Registra un usuario en la base de datos.
Request Body:
json
{
  "user_Name": "Juan perez",
  "user_Email": "juanperez@gmail.com",
  "user_Password": "juan_Perez1234"
}
Response Body:
json
{
  "message": "Usuario registrado con éxito"
}

Errores:
400 — Datos faltantes o inválidos
json
{
  "error": "400 - El campo 'user_Email' no tiene un formato válido"
}
409 — El correo ya está registrado
json
{
  "error": "409 - El correo electrónico ya está registrado"
}
422 — Contraseña no cumple los requisitos
json
{
  "error": "422 - La contraseña debe tener al menos 8 caracteres"
}
500 — Error interno del servidor
json
{
  "error": "500 - Error interno del servidor"
}


URL: /api/v1/auth/login
Metodo HTTP: POST
Descripcion: Loguea un usuario.
Request Body: 
json
{
  "user_Email": "juanperez@gmail.com",
  "user_Password": "juan_Perez1234"
}
Response Body:
json
{
  "token": "string (JWT)",
  "id_User": "1",
  "user_Name": "Juan Perez",
  "user_Email": "juanperez@gmail.com"
}

Errores:

400 — Faltan campos obligatorios
json
{
  "error": "400 - Faltan campos obligatorios"
}
401 — Credenciales incorrectas
json
{
  "error": "401 - Credenciales incorrectas"
}
404 — Usuario no encontrado
json
{
  "error": "404 - Usuario no encontrado"
}
500 — Error interno del servidor
json
{
  "error": "500 - Error interno del servidor"
}

TEAM5: 

URL: /api/v1/teams — Crear equipo
Método HTTP: POST
Descripción: Registra un equipo en la base de datos.

Request Body:
json
{
  "id_Adm": "1",
  "team_Name": "Los Mejores",
  "team_Description": "buscamos formar equipo para el torneo"
}
Response Body:
json
{
  "id_Team": "1",
  "message": "Equipo creado con éxito"
}

Errores:

400 — Faltan campos obligatorios
json
{
  "error": "400 - Faltan campos obligatorios"
}
401 — No autenticado (falta o expiró el token)
json
{
  "error": "401 - Token inválido o expirado"
}
403 — El usuario no tiene permisos de administrador
json
{
  "error": "403 - No tienes permisos para crear un equipo"
}
404 — El admin indicado no existe
json
{
  "error": "404 - Administrador no encontrado"
}
409 — Ya existe un equipo con ese nombre
json
{
  "error": "409 - Ya existe un equipo con ese nombre"
}
500 — Error interno del servidor
json
{
  "error": "500 - Error interno del servidor"
}

URL: /api/v1/teams/{id}/join — Unirse a un equipo
Método HTTP: Post
Descripción: Agrega un usuario a un equipo en la base de datos.
Request body:
json
{
  "id_User": "1"
}
Response Body:
json
{
  "message": "Usuario unido al equipo con éxito",
  "slot_Asignado": "id_player2 | id_player3 | id_player4"
}

Errores:

401 — No autenticado
json
{
  "error": "401 - Token inválido o expirado"
}
404 — Equipo no encontrado
json
{
  "error": "404 - Equipo no encontrado"
}
404 — Usuario no encontrado
json
{
  "error": "404 - Usuario no encontrado"
}
409 — El equipo ya está completo (sin slots disponibles)
json
{
  "error": "409 - El equipo ya alcanzó el máximo de jugadores"
}
409 — El usuario ya pertenece a ese equipo
json
{
  "error": "409 - El usuario ya forma parte de este equipo"
}
500 — Error interno del servidor
json
{
  "error": "500 - Error interno del servidor"
}

URL: /api/v1/teams/{id} — Obtener un equipo
Método HTTP: GET
Descripción: Devuelve un equipo de la base de datos.
Request Body:
Response Body:
json
{
  "id_Team": "1",
  "id_Adm": "1",
  "team_Name": "Los Mejores",
  "team_Description": "buscamos formar equipo para el torneo",
  "id_Player2": "4",
  "id_Player3": "8",
  "id_Player4": "2"
}
Errores:
404 — Equipo no encontrado
json
{
  "error": "404 - Equipo no encontrado"
}
500 — Error interno del servidor
json
{
  "error": "500 - Error interno del servidor"
}


URL: /api/v1/teams/{id} — Actualizar equipo
Método HTTP: PUT
Descripción: Actualiza un equipo de la base de datos.
Request Body: id_Team por URL +
json
{
  "team_Name": "Los Mejores",
  "team_Description": "primer partido lunes a las 7:30",
  "id_Player2": "4",
  "id_Player3": "8",
  "id_Player4": "2"
}
Response Body:
json
{
  "message": "Equipo actualizado con éxito"
}
Errores:
400 — Datos inválidos o faltantes
json
{
  "error": "400 - Datos inválidos"
}
401 — No autenticado
json
{
  "error": "401 - Token inválido o expirado"
}
403 — El usuario no es el administrador del equipo
json
{
  "error": "403 - No tienes permisos para actualizar este equipo"
}
404 — Equipo no encontrado
json
{
  "error": "404 - Equipo no encontrado"
}
404 — Alguno de los jugadores indicados no existe
json
{
  "error": "404 - Uno o más jugadores no fueron encontrados"
}
409 — Ya existe otro equipo con ese nombre
json
{
  "error": "409 - Ya existe un equipo con ese nombre"
}
500 — Error interno del servidor
json
{
  "error": "500 - Error interno del servidor"
}


URL: /api/v1/teams/{id} — Eliminar equipo
Método HTTP: DELETE
Descripción:  Elimina un equipo de la base de datos.
Request Body:
Response Body:
json
{
  "message": "Equipo eliminado con éxito"
}
Errores:
401 — No autenticado
json
{
  "error": "401 - Token inválido o expirado"
}
403 — El usuario no es el administrador del equipo
json
{
  "error": "403 - No tienes permisos para eliminar este equipo"
}
404 — Equipo no encontrado
json
{
  "error": "404 - Equipo no encontrado"
}
500 — Error interno del servidor
json
{
  "error": "500 - Error interno del servidor"
}

TEAM11: 
URL: /api/v1/teams11 — Crear equipo
Método HTTP: POST
Descripción: Registra un equipo en la base de datos.
Request Body:
json
{
  "id_Adm": “2",
  "team_Name": "Los mejores 11",
  "team_Description": "el equipo los mejores busca gente para torneo de futbol 11"
}
Response Body:
json
{
  "id_Team": "2",
  "message": "Equipo creado con éxito"
}

Errores:
400 — Faltan campos obligatorios
json
{
  "error": "400 - Faltan campos obligatorios"
}
401 — No autenticado (falta o expiró el token)
json
{
  "error": "401 - Token inválido o expirado"
}
403 — El usuario no tiene permisos de administrador
json
{
  "error": "403 - No tienes permisos para crear un equipo"
}
404 — El admin indicado no existe
json
{
  "error": "404 - Administrador no encontrado"
}
409 — Ya existe un equipo con ese nombre
json
{
  "error": "409 - Ya existe un equipo con ese nombre"
}
500 — Error interno del servidor
json
{
  "error": "500 - Error interno del servidor"
}

URL: /api/v1/teams11/{id}/join — Unirse a un equipo
Método HTTP: POST
Descripción: Agrega un usuario a un equipo en la base de datos.
Request Body: 
json
{
  "id_User": "2"
}
Response Body:
json
{
  "message": "Usuario unido al equipo con éxito",
  "slot_Asignado": "id_player2 | id_player3 | ... | id_player11"
}

Errores:
401 — No autenticado
json
{
  "error": "401 - Token inválido o expirado"
}
404 — Equipo no encontrado
json
{
  "error": "404 - Equipo no encontrado"
}
404 — Usuario no encontrado
json
{
  "error": "404 - Usuario no encontrado"
}
409 — El equipo ya está completo (sin slots disponibles)
json
{
  "error": "409 - El equipo ya alcanzó el máximo de jugadores"
}
409 — El usuario ya pertenece a ese equipo
json
{
  "error": "409 - El usuario ya forma parte de este equipo"
}
500 — Error interno del servidor
json
{
  "error": "500 - Error interno del servidor"
}

URL: /api/v1/teams11 — Listar todos los equipos
Método HTTP: GET
Descripción: Devuelve una lista de los equipos de la base de datos.
Request Body:
Response Body:
json
[
  {
    "id_Team": "2",
    "id_Adm": "2",
    "team_Name": "Los mejores 11",
    "team_Description": "el equipo los mejores busca gente para torneo de futbol 11",
    "id_Player2": "int | null",
    "id_Player3": "int | null",
    "id_Player4": "int | null",
    "id_Player5": "int | null",
    "id_Player6": "int | null",
    "id_Player7": "int | null",
    "id_Player8": "int | null",
    "id_Player9": "int | null",
    "id_Player10": "int | null",
    "id_Player11": "int | null"
  }
]

Errores:
401 — No autenticado
json
{
  "error": "401 - Token inválido o expirado"
}
500 — Error interno del servidor
json
{
  "error": "500 - Error interno del servidor"
}


URL: /api/v1/teams11/{id} — Obtener un equipo
Método HTTP: GET
Descripción: Devuelve un equipo de la base de datos.

Request Body: 
Response Body:
json
{
  "id_Team": "2",
  "id_Adm": "2",
  "team_Name": "Los Mejores 11",
  "team_Description": "el equipo los mejores busca gente para torneo de futbol 11",
  "id_Player2": "int | null",
  "id_Player3": "int | null",
  "id_Player4": "int | null",
  "id_Player5": "int | null",
  "id_Player6": "int | null",
  "id_Player7": "int | null",
  "id_Player8": "int | null",
  "id_Player9": "int | null",
  "id_Player10": "int | null",
  "id_Player11": "int | null"
}

Errores:

401 — No autenticado
json
{
  "error": "401 - Token inválido o expirado"
}
404 — Equipo no encontrado
json
{
  "error": "404 - Equipo no encontrado"
}
500 — Error interno del servidor
json
{
  "error": "500 - Error interno del servidor"
}


URL: /api/v1/teams11/{id} — Actualizar equipo
Método HTTP:  PUT
Descripción: Actualiza un equipo de la base de datos.
Reuqest Body: id_Team por URL +
json
{
  "team_Name": "Los Mejores 11",
  "team_Description": "primer partido jueves a las 6:00"
}
Response Body:
json
{
  "message": "Equipo actualizado con éxito"
}

Errores:
400 — Datos inválidos o faltantes
json
{
  "error": "400 - Datos inválidos"
}
401 — No autenticado
json
{
  "error": "401 - Token inválido o expirado"
}
403 — El usuario no es el administrador del equipo
json
{
  "error": "403 - No tienes permisos para actualizar este equipo"
}
404 — Equipo no encontrado
json
{
  "error": "404 - Equipo no encontrado"
}
409 — Ya existe otro equipo con ese nombre
json
{
  "error": "409 - Ya existe un equipo con ese nombre"
}
500 — Error interno del servidor
json
{
  "error": "500 - Error interno del servidor"
}


URL: /api/v1/teams11/{id} — Eliminar equipo
Método HTTP: DELETE
Descripción: Elimina un equipo de la base de datos.
Request Body: id_Team por URL
Response Body:
json
{
  "message": "Equipo eliminado con éxito"
}

Errores: 

400 — ID inválido
json
{
  "error": "400 - El parámetro 'id_Team' no es válido"
}
401 — No autenticado
json
{
  "error": "401 - Token inválido o expirado"
}
403 — El usuario no es el administrador del equipo
json
{
  "error": "403 - No tienes permisos para eliminar este equipo"
}
404 — Equipo no encontrado
json
{
  "error": "404 - Equipo no encontrado"
}
500 — Error interno del servidor
json
{
  "error": "500 - Error interno del servidor"
}

FRIEND: 

URL: /api/v1/friends — Agregar amigo
Método HTTP: POST
Descripción: Registra un amigo a un usuario en la base de datos.
Request Body:
json
{
  "id_User": "1",
  "id_Friend": "2"
}
Response Body:
json
{
  "message": "Amigo agregado con éxito"
}

Errores: 
401 — No autenticado
json
{
  "error": "401 - Token inválido o expirado"
}
404 — Usuario no encontrado
json
{
  "error": "404 - Usuario no encontrado"
}
404 — El amigo a agregar no existe
json
{
  "error": "404 - El usuario a agregar no existe"
}
409 — Ya son amigos
json
{
  "error": "409 - Ya existe una amistad entre estos usuarios"
}
409 — Un usuario no puede agregarse a sí mismo
json
{
  "error": "409 - No puedes agregarte a ti mismo como amigo"
}
500 — Error interno del servidor
json
{
  "error": "500 - Error interno del servidor"
}
URL: /api/v1/users/{id_user}/friends — Listar amigos de un usuario
Método HTTP: GET
Descripción: Devuelve una lista de amigos de un usuario de la base de datos.
Request Body: 
Response Body:
json
[
  {
    "id_Friend": "2"
  }
]

Errores: 
400 — ID inválido
json
{
  "error": "400 - El parámetro 'id_User' no es válido"
}
401 — No autenticado
json
{
  "error": "401 - Token inválido o expirado"
}
404 — Usuario no encontrado
json
{
  "error": "404 - Usuario no encontrado"
}
500 — Error interno del servidor
json
{
  "error": "500 - Error interno del servidor"
}

URL: /api/v1/friends — Eliminar amigo
Método HTTP: DELETE
Descripción: Elimina a un amigo de la lista de amigos de un usuario en la base de datos.
Reuqest Body:
json
{
  "id_User": "1",
  "id_Friend": "2"
}
Response Body:
json
{
  "message": "Amigo eliminado con éxito"
}

Errores: 
401 — No autenticado
json
{
  "error": "401 - Token inválido o expirado"
}

404 — Usuario no encontrado
json
{
  "error": "404 - Usuario no encontrado"
}
404 — La amistad no existe
json
{
  "error": "404 - No existe una amistad entre estos usuarios"
}
500 — Error interno del servidor
json
{
  "error": "500 - Error interno del servidor"
}

MATCH: 
URL: /api/v1/matches — Crear partido (esperando rival)
Método HTTP: POST
Descripción: Registra un partido en la base de datos.
Request Body:
json
{
  "id_Team1": "1"
}
Response Body:
json
{
  "id_Match": "1",
  "message": "Partido creado, esperando equipo rival"
}
Errores:
401 — No autenticado
json
{
  "error": "401 - Token inválido o expirado"
}
403 — El usuario no es el administrador del equipo
json
{
  "error": "403 - No tienes permisos para crear un partido con este equipo"
}
404 — Equipo no encontrado
json
{
  "error": "404 - Equipo no encontrado"
}
409 — El equipo ya tiene un partido pendiente
json
{
  "error": "409 - El equipo ya tiene un partido esperando rival"
}
500 — Error interno del servidor
json
{
  "error": "500 - Error interno del servidor"
}
URL: /api/v1/matches/{id}/join — Unirse a un partido
Método HTTP: POST
Descripción: Registra un equipo a un partido en la base de datos.
Request Body: id_Match por URL +
json
{
  "id_Team2": "int"
}
Response Body:
json
{
  "message": "Equipo unido al partido con éxito"
}
Errores: 
401 — No autenticado
json
{
  "error": "401 - Token inválido o expirado"
}
403 — El usuario no es el administrador del equipo
json
{
  "error": "403 - No tienes permisos para unir este equipo al partido"
}
404 — Partido no encontrado
json
{
  "error": "404 - Partido no encontrado"
}
404 — Equipo no encontrado
json
{
  "error": "404 - Equipo no encontrado"
}
409 — El partido ya tiene dos equipos
json
{
  "error": "409 - El partido ya tiene un equipo rival asignado"
}
409 — Un equipo no puede jugar contra sí mismo
json
{
  "error": "409 - El equipo rival no puede ser el mismo que el equipo local"
}
500 — Error interno del servidor
json
{
  "error": "500 - Error interno del servidor"
}

REQUEST:	
URL: /api/v1/requests — Crear solicitud
Método HTTP: POST
Descripción: Registra una solicitud en la base de datos.
Request Body:
json
{
  "id_Sender": "int",
  "id_Receiver": "int",
  "request_Description": "string"
}
Response Body:
json
{
  "id_Request": "int",
  "message": "Solicitud enviada con éxito"
}
Errores:
400 — Faltan campos obligatorios
json
{
  "error": "400 - Faltan campos obligatorios"
}
401 — No autenticado
json
{
  "error": "401 - Token inválido o expirado"
}
404 — El usuario emisor no existe
json
{
  "error": "404 - Usuario emisor no encontrado"
}
404 — El usuario receptor no existe
json
{
  "error": "404 - Usuario receptor no encontrado"
}
409 — Ya existe una solicitud pendiente entre estos usuarios
json
{
  "error": "409 - Ya existe una solicitud pendiente para este usuario"
}
409 — El emisor y receptor no pueden ser el mismo usuario
json
{
  "error": "409 - No puedes enviarte una solicitud a ti mismo"
}
500 — Error interno del servidor 
  "error": "500 - Error interno del servidor"
}

URL: /api/v1/requests/{id_Receiver} — Listar solicitudes recibidas
Método HTTP: GET
Descripción: Devuelve una lista de solicitudes recibidas por un usuario.
Request Body:
Response Body:
json
[
  {
    "id_Request": "int",
    "id_Sender": "int",
    "id_Receiver": "int",
    "request_Status": false,
    "request_Description": "string"
  }
]
URL: /api/v1/requests/{id}/accept — Aceptar solicitud
Método HTTP: PUT
Descripción: Modifica la solicitud pasando a ser aceptada.
Request Body:
Response Body:
json
{
  "message": "Solicitud aceptada"
}
URL: /api/v1/requests/{id} — Eliminar solicitud
Método HTTP: DELETE
Descripción: Elimina una solicitud de la base de datos.
Request Body: 
Response Body:
json
{
  "message": "Solicitud eliminada con éxito"
}
TOURNAMENT:
URL: /api/tournaments — Crear torneo
Método HTTP: POST
Descripción: Crea un torneo en la base de datos.
Request Body:
json
{
  "teams_Quantity": "int",
  "tournament_Type": "string"
}
Response Body:
json
{
  "id_Tournament": "int",
  "message": "Torneo creado con éxito"
}

URL: /api/v1/tournaments — Listar todos los torneos
Método HTTP: GET
Descripción: Devuelve una lista de torneos de la base de datos.
Request Body:
Response Body:
json
[
  {
    "id_Tournament": "int",
    "teams_Quantity": "int",
    "tournament_Type": "string"
  }
]

URL: /api/v1/tournaments/{id} — Obtener un torneo
Método HTTP: GET
Descripción: Devuelve un torneo de la base de datos.
Request Body:
Response Body:
json
{
  "id_Tournament": "int",
  "teams_Quantity": "int",
  "tournament_Type": "string"
}

URL: /api/v1/tournaments/{id} — Actualizar torneo
Método HTTP: PUT
Descripción: Actualiza un torneo de la base de datos.
Request Body: id_Tournament por URL +
json
{
  "teams_Quantity": "int",
  "tournament_Type": "string"
}
Response Body:
json
{
  "message": "Torneo actualizado con éxito"
}

URL: /api/v1/tournaments/{id} — Eliminar torneo
Método HTTP: DELETE
Descripción: Elimina un torneo de la base de datos.
Request Body: 
Response Body:
json
{
  "message": "Torneo eliminado con éxito"
}
TOURNAMENT_MATCHES:
URL: /api/v1/tournament-Matches — Agregar partido a torneo
Método HTTP: POST
Descripción: Agrega un partido al torneo en la base de datos.
Request Body:
json
{
  "id_Match": "int",
  "id_Tournament": "int"
}
Response Body:
json
{
  "message": "Partido agregado al torneo con éxito"
}
URL: /api/v1/tournament-Matches/{id_Tournament} — Listar partidos de un torneo
Método HTTP: GET
Descripción: Devuelve una lista de partidos de un torneo en la base de datos.
Request Body:
Response Body:
json
[
  {
    "id_Match": "int",
    "id_Tournament": "int"
  }
]
URL: /api/v1/tournament-Matches — Eliminar partido de un torneo
Método HTTP: DELETE
Descripción: Elimina un partido de un torneo de la base de datos.
Request Body:
json
{
  "id_Match": "int",
  "id_Tssournament": "int"
}
Response Body:
json
{
  "message": "Partido eliminado del torneo con éxito"
}
