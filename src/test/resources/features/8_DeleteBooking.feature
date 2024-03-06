# language: es

Característica: RESTFUL - BOOKER

Necesidad del negocio: Eliminar una reserva
                       Como cliente
                       Quiero eliminar mi reserva agenda
                       Para poder cancelar la reservación en cualquier momento

  @delete_booking
  Escenario: [CP10] -  Validar la eliminación de una reserva actual
    Dado configuro los headers delete
      | Cookie           | Authorization                   |
      | token=abc123     | Basic YWRtaW46cGFzc3dvcmQxMjM=  |
    Cuando configuro la url delete "booking/122"
    Entonces el codigo de respuesta es "201"
    Y valido la respuesta de la api "Created"


