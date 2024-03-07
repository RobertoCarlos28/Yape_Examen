# language: es

Característica: RESTFUL - BOOKER

Necesidad del negocio: Consultar una reserva
                       Como usuario
                       Quiero consultar la información de una reserva
                       Para validar que la reservación se realizó correctamente

  @TestBookingIntegracion
  Escenario: [CP007] - Validar que se puedan consultar una reserva por id
    Dado configuro los headers
      | Accept           |
      | application/json |
    Y configuro la url get "booking/1"
    Entonces el codigo de respuesta es "200"


    

