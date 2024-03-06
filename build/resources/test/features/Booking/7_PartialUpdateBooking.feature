# language: es

Característica: RESTFUL - BOOKER

  @partial_update_booking
  Escenario: [CP009] - Validar la actualización parcial una reserva actual
    Dado configuro los headers update
      | Accept           | Cookie           | Authorization                   |
      | application/json | token=abc123     | Basic YWRtaW46cGFzc3dvcmQxMjM=  |
    Y configuro body request "partialUpdateBooking.json"
      | firstname  |  lastname  |
      | Roberto    |  Mechan    |
    Y configuro la url patch "booking/10"
    Entonces el codigo de respuesta es "200"


