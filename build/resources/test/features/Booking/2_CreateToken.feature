# language: es

Característica: RESTFUL - BOOKER

Necesidad del negocio:  Generar token de autenticación
                        Como cliente
                        Quiero autenticarme en el sistema
                        Para poder actualizar y eliminar reservas

Regla: El token expira cada 10 minutos

  @create_token
  Escenario: [CP002] - Realizar la authentication del servicio Auth
    Dado configuro los headers
      | Content-Type     |
      | application/json |
    Y configuro body request "createToken.json"
      | username  |  password     |
      | admin     |  password123  |
    Y configuro la url "auth"
    Entonces el codigo de respuesta es "200"


