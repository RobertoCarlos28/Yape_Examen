# API AUTOMATION YAPE

Este es un proyecto de Automatización que utiliza Serenity BDD y Rest Assured
para la creación de un framework de automatización que permita probar la
API [RESTFUL - BOOKER](https://restful-booker.herokuapp.com/apidoc/index.html)

Este proyecto ha sido desarrollado por [Roberto Mechan](https://www.linkedin.com/in/roberto-mech%C3%A1n-302735179/) para mejorar el
desarrollo en pruebas avanzadas de api automation.
***

## 🏠 Datos del Tester

* Name: `Roberto Mechan`
* Country: `Peru`
* City: `Chiclayo`
* LinkedIn: [Roberto Mechan](https://www.linkedin.com/in/roberto-mech%C3%A1n-302735179/)

***

## 🛠️ Lenguajes & Frameworks

Este proyecto utiliza los siguientes lenguajes y frameworks:

* [Serenity BDD](https://serenity-bdd.github.io/theserenitybook/latest/index.html) como framework de pruebas
  automatizadas.
* [Rest Assured](https://cucumber.io/) como framework para probar y validar servicios REST en Java.
* [Cucumber](https://cucumber.io/) como software de testing BDD que permite elaborar pruebas a partir de AC.
* [Java 11](https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html) como lenguaje de
  programación.
* [Screen Play](https://serenity-js.org/handbook/thinking-in-serenity-js/screenplay-pattern.html) como el patrón de
  diseño.
* [Gradle](https://gradle.org/) como herramienta de compilación.

***

## 🟢 Pre-requisitos: 🟢

1. Descargar la última versión estable de Java
   JDK [aquí](https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html)
2. Instalar git desde [aquí](https://git-scm.com)
3. Instalar Gradle Buil Tool desde [aquí](https://gradle.org/install/)

**🗒️ Nota**: `build.gradle` tiene toda la configuración del proyecto instalada, ejecutar el siguiente comando para
iniciar todas las tareas (Incluidos los test).

👀 Adicional en su **IDE** de preferencia deberá tener instalados los siguientes plugins:

1. [x] *JUnit*
2. [x] *Cucumber for Java*
3. [x] *Gherkin*

***

### 🚀 Pruebas de Integración continua

> Con GitHub Actions, puedes crear flujos de trabajo de integración continua (IC) directamente en tu repositorio de
> GitHub.

Para este proyecto se hace uso de GitHUb Actions como herramienta para la integración continua del framework de
automatización desarrollado.

La ruta del pipeline se encuentra en: `.github/workflows/automated-testing-integration.yml`

| develop                    | status                                                                                                                                                                                                                                                                      |
|----------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Pruebas de integración** | [![automated-testing-integration ST](https://github.com/RobertoCarlos28/Yape_Examen_API/actions/workflows/automated-testing-integration.yml/badge.svg?branch=main)](https://github.com/RobertoCarlos28/Yape_Examen_API/actions/workflows/automated-testing-integration.yml) |

**⏱️ Ejecución automatizada**:   
El pipeline se ejecutará periódicamente de forma automática por medio la siguiente 'cron schedule expression':

```yml
on:
schedule:
  - cron: "00 13 * * TUE"
```

**📄️ Generando los reportes de prueba**:  
Con la ejecución del pipepile se generará un artefacto `testing-reports` donde se alojarán los reportes con los
resultados de esa ejecución realizada.

![img.png](src/test/resources/img.png)
***

### 🧪 Casos de prueba contemplados

Test diseñados para validar los escenarios **Happy Paths**

> **✨ FEATURE**: Booking | Health Check
> - [x] [CP001] - Confirmar si la api esta en funcionamiento
>
> **✨ FEATURE**: Booking | Create Token
> - [x] [CP002] - Realizar la authentication del servicio Auth
>
> **✨ FEATURE**: Booking | Create Booking
> - [x] [CP003] - Validar la creación de una reserva
>
> **✨ FEATURE**: Booking | Get Booking IDs
> - [x] [CP004] - Validar que se puedan consultar todas las reservas existentes
> - [x] [CP005] - Validar que se puedan consultar una reserva por nombre y apellido
> - [x] [CP006] - Validar que se puedan consultar una reserva por fechas especificas
>
> **✨ FEATURE**: Booking | Get Booking x ID
> - [x] [CP007] - Validar que se puedan consultar una reserva por id
>
> **✨ FEATURE**: Booking | Update Booking
> - [x] [CP008] - Validar la actualización de una reserva actual
> 
> > **✨ FEATURE**: Booking | Partial Update Booking
> - [x] [CP009] - Validar la actualización parcial una reserva actual
>
> **✨ FEATURE**: Booking | Delete Booking
> - [x] [CP10] - Validar la eliminación de una reserva actual
***
Test diseñados para validar los escenarios **UNHappy Paths**

> **✨ FEATURE**: UnHappy Paths | Validar que no se puedan crear/consultar/actualizar/eliminar reservas
> - [x] [CP011] - Validar que no se pueda crear un reserva al no enviar un campo obligatorio
> - [x] [CP012] Validar que no se pueda consultar una reserva eliminada
> - [x] [CP013]  Validar que no se pueda actualizar una reserva eliminada
***

## ▶️ Ejecución del proyecto:

1. Descarga el proyecto desde GitHub
    * **Opción 1** (HTTPS): `https://github.com/RobertoCarlos28/Yape_Examen_API.git`
    * **Opción 2:** Descárgalo como archivo Zip y extráelo

***

2. **CD** en la carpeta `Proyecto_API_YAPE > YapeProject`.
3. Configurar Gradle
    * Ejecute el siguiente comando en el terminal:`./gradlew build`.

***

4. Ejecutar las pruebas en el proyecto
    * **Opción 1**: ejecutar `./gradlew clean test aggregate` en la ruta del proyecto o puede hacerlo por medio de este
      comando:

    ```bash
    gradle clean test --no-build-cache -Dcucumber.filter.tags="@TestBookingIntegracion"
    ```

* **Opción 2**: Ir a las clases de la carpeta **runners** `src/test/java/runner` y ejecutar
  cada Runner.

***

## 📄 Generación de informes

El informe al detalle con los pasos y resultados de las pruebas que se registrará en la ruta:
`target/site/serenity/index.html`.

Adicional se genera un reporte single page si se desea una revisión de alto nivel sobre los resultados de los test, el
cual se registrará en la ruta:
`target/site/serenity/serenity-summary.html`.

Este comando permitirá generar ambos reportes:

```bash
./gradlew reports
```

***
### ENTEGRABLES DE PRUEBAS
> ☑️ Colección en postman, la ruta de su ubicación es: `resources/PlanPruebas/restful-booker-collection.postman_collection.json`  
> ☑️ El plan de pruebas actual, la ruta de su ubicación es: `resources/PlanPruebas/PLAN_DE_PRUEBAS.markdown`  
> ☑️ El informe del resultado de pruebas, la ruta de su ubicación es: `target/site/serenity/serenity-summary.html`
>
***