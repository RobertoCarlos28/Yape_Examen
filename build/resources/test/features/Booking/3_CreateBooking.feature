# language: es

Característica: RESTFUL - BOOKER

Necesidad del negocio:  Crear una reserva
                        Como cliente
                        Quiero hacer una reserva
                        Para poder programar mi próximo viaje

  @create_booking
  Escenario: [CP003] - Validar la creación de una reserva
    Dado Tengo que realizar el logueo en la aplicacion
    Cuando configuro los headers
      | Accept           |
      | application/json |
    Y configuro body request create "createBooking.json"
      | firstname | lastname  | totalprice  |  checkin     | checkout     | additionalneeds   |
      | Roberto   | Mechan    | 5000        |  2025-01-07  | 2025-01-07   | Breakfast         |
    Y configuro la url "booking"
    Entonces el codigo de respuesta es "200"


