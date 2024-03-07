# language: es

Característica: RESTFUL - BOOKER


  Necesidad del negocio: Validar que no se puedan crear/consultar/actualizar/eliminar reservas
                         Yo como PM
                         Quiero tener un mapeo de errores del sistema
                         Para confirmar que el funcionamiento del servicio corresponde al esperado por negocio

  @TestBookingIntegracion
      #Status code: 500 Internal Server Error
  Escenario: [CP011] - Validar que no se pueda crear un reserva al no enviar un campo obligatorio
    Dado configuro los headers
      | Accept           |
      | application/json |
    Cuando configuro body no envio el lastname en el request "createBooking_uh.json"
      | firstname | totalprice  |  checkin     | checkout     | additionalneeds   |
      | Roberto   | 5000        |  2025-01-07  | 2025-01-07   | Breakfast         |
    Y configuro la url "booking"
    Entonces el codigo de respuesta es "500"
    Y valido la respuesta de la api "Internal Server Error"

  @TestBookingIntegracion
     # status code: 404 Not Found
  Escenario: [CP012] Validar que no se pueda consultar una reserva eliminada
    Dado configuro los headers delete
      | Cookie           | Authorization                   |
      | token=abc123     | Basic YWRtaW46cGFzc3dvcmQxMjM=  |
    Y configuro la url get "booking/122"
    Entonces el codigo de respuesta es "404"
    Y valido la respuesta de la api "Not Found"

  @TestBookingIntegracion
     # status code: 405 Method Not Allowed
  Escenario: [CP013]  Validar que no se pueda actualizar una reserva eliminada
    Dado configuro los headers update
      | Accept           | Cookie           | Authorization                   |
      | application/json | token=abc123     | Basic YWRtaW46cGFzc3dvcmQxMjM=  |
    Y configuro body request create "createBooking.json"
      | firstname | lastname  | totalprice  |  checkin     | checkout     | additionalneeds   |
      | Roberto   | Mechan    | 3000        |  2025-11-07  | 2025-11-07   | Breakfast         |
    Y configuro la url put "booking/122"
    Entonces el codigo de respuesta es "405"
    Y valido la respuesta de la api "Method Not Allowed"

