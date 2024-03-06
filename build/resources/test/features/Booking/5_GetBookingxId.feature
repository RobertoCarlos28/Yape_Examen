# language: es

Característica: RESTFUL - BOOKER

Necesidad del negocio: Consultar una reserva
                       Como usuario
                       Quiero consultar la información de una reserva
                       Para validar que la reservación se realizó correctamente

  @bookings_x_id
  Escenario: [CP007] - Validar que se puedan consultar una reserva por id
    Dado Tengo que realizar el logueo en la aplicacion
    Cuando configuro los headers
      | Accept           |
      | application/json |
    Y configuro la url get "booking/1"
    Entonces el codigo de respuesta es "200"


    

