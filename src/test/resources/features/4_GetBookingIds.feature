# language: es

Característica: RESTFUL - BOOKER

Necesidad del negocio: Consultar una reserva
                       Como usuario
                       Quiero consultar la información de una reserva
                       Para validar que la reservación se realizó correctamente

  @TestBookingIntegracion
  Escenario: [CP004] - Validar que se puedan consultar todas las reservas existentes
    Dado configuro el api
    Y configuro la url get "booking"
    Entonces el codigo de respuesta es "200"

  @TestBookingIntegracion
  Escenario: [CP005] - Validar que se puedan consultar una reserva por nombre y apellido
    Dado configuro los query params
      |firstname | lastname |
      | John     | Smith    |
    Y configuro la url get "booking"
    Entonces el codigo de respuesta es "200"

  @TestBookingIntegracion
  Escenario: [CP006] - Validar que se puedan consultar una reserva por fechas especificas
    Dado configuro los query params
      |checkin       | checkout    |
      | 2016-01-01   | 2020-12-01   |
    Y configuro la url get "booking"
    Entonces el codigo de respuesta es "200"


