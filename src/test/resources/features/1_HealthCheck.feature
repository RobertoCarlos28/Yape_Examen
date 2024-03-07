# language: es

Característica: RESTFUL - BOOKER

Necesidad del negocio:  Confirmar funcionamiento de la api
                        Yo como tester
                        Quiero hacer validacion
                        Para confirmar si la api restful-booker se encuentra en funcionamiento

  @TestBookingIntegracion
  Escenario: [CP001] - Confirmar si la api esta en funcionamiento
    Dado Tengo que validar la comprobacion de estado
    Y configuro la url get "ping"
    Entonces el codigo de respuesta es "201"
    Y valido la respuesta de la api "Created"


