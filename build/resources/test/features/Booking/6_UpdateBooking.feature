# language: es

Característica: RESTFUL - BOOKER

Necesidad del negocio: Actualizar una reserva
                       Como cliente
                       Quiero actualizar la información de mi reserva
                       Para poder actualizar y eliminar reservas

  @update_booking
  Escenario: [CP008] - Validar la actualización de una reserva actual
    Dado configuro los headers update
      | Accept           | Cookie           | Authorization                   |
      | application/json | token=abc123     | Basic YWRtaW46cGFzc3dvcmQxMjM=  |
    Y configuro body request create "createBooking.json"
      | firstname | lastname  | totalprice  |  checkin     | checkout     | additionalneeds   |
      | Roberto   | Mechan    | 3000        |  2025-11-07  | 2025-11-07   | Breakfast         |
    Y configuro la url put "booking/4"
    Entonces el codigo de respuesta es "200"


