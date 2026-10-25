# Diagramas de clases

**Proyecto:** LoyaltyAccess
**Alcance:** modelo de dominio del sistema de tarjetas de lealtad con QR para pequeños negocios.

Los diagramas se presentan por bloques para facilitar su lectura: usuarios y negocio, movimientos, premios y niveles, reglas de acumulación, notificaciones y exportación, y conectores externos. Se incluyen solo las clases de dominio; los controladores, la configuración y el acceso a datos se documentan en el documento de arquitectura.

## Notación

| Símbolo | Significado |
|---|---|
| `+` | Miembro público |
| `-` | Miembro privado |
| `<<abstract>>` | Clase abstracta |
| `<<interface>>` | Interfaz |
| `A <\|-- B` | Herencia: B hereda de A |
| `A <\|.. B` | B implementa la interfaz A |
| `A --> B` | Asociación: A conoce o usa a B |
| `A o-- B` | Agregación: A contiene a B |
| `A ..> B` | Dependencia: A usa o crea a B |
| `"1"`, `"*"`, `"0..1"` | Multiplicidad de la relación |

---

## 1. Usuarios, negocio, programa, clientes y tarjetas

Los roles del sistema se organizan así: `Dueno` y `Cajero` heredan de `Operador`, que agrupa lo que puede hacer quien atiende en mostrador (registrar compras y canjes), y `Operador` y `AdminPlataforma` heredan de `Usuario`. Así, un emprendedor que trabaja solo con su celular y su laptop puede operar como dueño sin necesidad de dar de alta cajeros. El dueño administra uno o más negocios; cada negocio tiene su programa de lealtad, cajeros opcionales y emite tarjetas. Un cliente tiene una tarjeta por negocio.

```mermaid
classDiagram
    class Usuario {
        <<abstract>>
        -int id
        -String nombre
        -String correo
        -String claveHash
        +iniciarSesion()
        +cerrarSesion()
    }
    class Operador {
        <<abstract>>
        +registrarCompra()
        +canjearPremio()
    }
    class Dueno {
        +configurarPrograma()
        +gestionarCajeros()
        +verPanel()
        +anularMovimiento()
    }
    class Cajero {
        -String pin
        -boolean activo
    }
    class AdminPlataforma {
        +suspenderNegocio()
        +gestionarPlantillas()
    }
    class Negocio {
        -String nombre
        -String giro
        -String logo
        -EstadoNegocio estado
        -String apiKey
        +activar()
        +suspender()
    }
    class ProgramaLealtad {
        -String nombre
        -int vigenciaMeses
        -int intervaloMinVisitas
        +calcularPuntos(Compra compra) int
        +nivelPara(int acumulado) Nivel
    }
    class Cliente {
        -String nombre
        -String telefono
        -boolean consentimiento
        +solicitarEliminacion()
    }
    class TarjetaLealtad {
        -String codigoQR
        -String codigoCorto
        -int acumuladoHistorico
        -EstadoTarjeta estado
        +saldo() int
        +registrarMovimiento(Movimiento m)
        +nivelActual() Nivel
    }

    Usuario <|-- Operador
    Usuario <|-- AdminPlataforma
    Operador <|-- Dueno
    Operador <|-- Cajero
    Dueno "1" --> "1..*" Negocio : administra
    Negocio "1" --> "0..*" Cajero : emplea, opcional
    Negocio "1" --> "1" ProgramaLealtad : ofrece
    Negocio "1" --> "*" TarjetaLealtad : emite
    Cliente "1" --> "*" TarjetaLealtad : tiene una por negocio
```

---

## 2. Movimientos de la tarjeta

El saldo de una tarjeta no se edita directamente: se calcula a partir de sus movimientos, que nunca se borran. Una anulación genera un movimiento inverso que referencia al original.

```mermaid
classDiagram
    class TarjetaLealtad {
        -int acumuladoHistorico
        +saldo() int
        +registrarMovimiento(Movimiento m)
    }
    class Movimiento {
        <<abstract>>
        -int id
        -DateTime fecha
        -int puntos
        -Operador registradoPor
        -String referenciaExterna
        +aplicar(TarjetaLealtad tarjeta)
    }
    class MovimientoAcumulacion {
        -double montoCompra
        +aplicar(TarjetaLealtad tarjeta)
    }
    class MovimientoCanje {
        +aplicar(TarjetaLealtad tarjeta)
    }
    class MovimientoAnulacion {
        -String motivo
        -Movimiento movimientoOriginal
        +aplicar(TarjetaLealtad tarjeta)
    }
    class Premio {
        <<abstract>>
    }

    Movimiento <|-- MovimientoAcumulacion
    Movimiento <|-- MovimientoCanje
    Movimiento <|-- MovimientoAnulacion
    TarjetaLealtad "1" --> "*" Movimiento : registra
    MovimientoCanje "*" --> "1" Premio : canjea
```

---

## 3. Premios y niveles

El programa ofrece premios de distintos tipos (producto gratis, descuento porcentual o descuento en monto) y define los niveles del cliente según sus puntos acumulados históricos.

```mermaid
classDiagram
    class ProgramaLealtad {
        -String nombre
        +calcularPuntos(Compra compra) int
        +nivelPara(int acumulado) Nivel
    }
    class Premio {
        <<abstract>>
        -String nombre
        -int costoPuntos
        -int existencias
        -Date vigenciaHasta
        +estaDisponible() boolean
        +aplicar() Beneficio
    }
    class PremioProducto {
        -String producto
        +aplicar() Beneficio
    }
    class PremioDescPorcentaje {
        -double porcentaje
        +aplicar() Beneficio
    }
    class PremioDescMonto {
        -double monto
        +aplicar() Beneficio
    }
    class Nivel {
        -String nombre
        -int umbral
        -double multiplicador
        +beneficios()
    }

    Premio <|-- PremioProducto
    Premio <|-- PremioDescPorcentaje
    Premio <|-- PremioDescMonto
    ProgramaLealtad "1" --> "*" Premio : ofrece
    ProgramaLealtad "1" --> "*" Nivel : define
```

---

## 4. Reglas de acumulación (Strategy, Decorator y Factory)

Cada programa usa una regla para calcular los puntos o sellos de una compra. `ReglaPromocional` decora a otra regla con un multiplicador temporal (por ejemplo, doble de puntos los martes). `FabricaReglas` crea la regla a partir de una plantilla.

```mermaid
classDiagram
    class ProgramaLealtad {
        +calcularPuntos(Compra compra) int
    }
    class ReglaAcumulacion {
        <<interface>>
        +calcular(Compra compra, TarjetaLealtad tarjeta) int
    }
    class ReglaPorVisita {
        -int sellosPorVisita
        -int metaSellos
        +calcular(Compra compra, TarjetaLealtad tarjeta) int
    }
    class ReglaPorMonto {
        -double montoPorPunto
        -int topePorCompra
        +calcular(Compra compra, TarjetaLealtad tarjeta) int
    }
    class ReglaPromocional {
        -ReglaAcumulacion base
        -double multiplicador
        -Set~String~ dias
        -Date desde
        -Date hasta
        +calcular(Compra compra, TarjetaLealtad tarjeta) int
    }
    class FabricaReglas {
        +crearDesdePlantilla(String plantilla) ReglaAcumulacion
    }
    class Compra {
        -double monto
        -DateTime fecha
        -String idExterno
    }

    ProgramaLealtad "1" --> "1" ReglaAcumulacion : usa
    ReglaAcumulacion <|.. ReglaPorVisita
    ReglaAcumulacion <|.. ReglaPorMonto
    ReglaAcumulacion <|.. ReglaPromocional
    ReglaPromocional o-- ReglaAcumulacion : envuelve
    FabricaReglas ..> ReglaAcumulacion : crea
    ReglaAcumulacion ..> Compra : lee
```

---

## 5. Notificaciones (Observer) y exportación de la tarjeta (Strategy)

Cuando una tarjeta registra un movimiento, publica un evento (puntos abonados, premio disponible, subida de nivel) y el gestor avisa a los canales suscritos. Por separado, la tarjeta puede exportarse en distintos formatos mediante una interfaz común.

```mermaid
classDiagram
    class TarjetaLealtad {
        +registrarMovimiento(Movimiento m)
    }
    class GestorEventos {
        -List~ObservadorLealtad~ observadores
        +suscribir(ObservadorLealtad o)
        +desuscribir(ObservadorLealtad o)
        +notificar(EventoLealtad evento)
    }
    class EventoLealtad {
        -TipoEvento tipo
        -String detalle
    }
    class ObservadorLealtad {
        <<interface>>
        +actualizar(EventoLealtad evento)
    }
    class NotificadorWhatsApp {
        +actualizar(EventoLealtad evento)
    }
    class NotificadorCorreo {
        +actualizar(EventoLealtad evento)
    }
    class FormatoTarjeta {
        <<interface>>
        +exportar(TarjetaLealtad tarjeta) Archivo
    }
    class TarjetaImagen {
        +exportar(TarjetaLealtad tarjeta) Archivo
    }
    class TarjetaPDF {
        +exportar(TarjetaLealtad tarjeta) Archivo
    }
    class TarjetaGoogleWallet {
        +exportar(TarjetaLealtad tarjeta) Archivo
    }
    class GeneradorQR {
        +generar(String codigo) Imagen
    }

    TarjetaLealtad "*" --> "1" GestorEventos : publica en
    GestorEventos "1" --> "*" ObservadorLealtad : notifica a
    GestorEventos ..> EventoLealtad : emite
    ObservadorLealtad <|.. NotificadorWhatsApp
    ObservadorLealtad <|.. NotificadorCorreo
    FormatoTarjeta <|.. TarjetaImagen
    FormatoTarjeta <|.. TarjetaPDF
    FormatoTarjeta <|.. TarjetaGoogleWallet
    FormatoTarjeta ..> GeneradorQR : usa
```

---

## 6. Conectores para sistemas externos (Adapter)

Módulo opcional para negocios que ya cuentan con un sistema de ventas. El núcleo de lealtad solo conoce la interfaz `ConectorVentas`; cada adaptador traduce los datos de una fuente distinta.

```mermaid
classDiagram
    class ServicioLealtad {
        +registrarCompra(Compra compra)
        +canjear(TarjetaLealtad tarjeta, Premio premio)
        +consultarSaldo(TarjetaLealtad tarjeta) int
    }
    class ConectorVentas {
        <<interface>>
        +recibirCompra(String datos) Compra
        +confirmar(String idExterno)
    }
    class AdaptadorApiRest {
        -String apiKey
        +recibirCompra(String datos) Compra
    }
    class AdaptadorCsv {
        -File archivo
        +recibirCompra(String datos) Compra
    }
    class AdaptadorManual {
        +recibirCompra(String datos) Compra
    }

    ServicioLealtad "*" --> "1" ConectorVentas : usa
    ConectorVentas <|.. AdaptadorApiRest
    ConectorVentas <|.. AdaptadorCsv
    ConectorVentas <|.. AdaptadorManual
```

---

## Descripción de las clases

| Clase | Tipo | Responsabilidad | Relaciones |
|---|---|---|---|
| `Usuario` | Abstracta | Datos y comportamiento comunes de acceso. | Padre de `Operador` y `AdminPlataforma`. |
| `Operador` | Abstracta | Agrupa lo que puede hacer quien atiende en mostrador: registrar compras y canjear premios. | Hereda de `Usuario`; padre de `Dueno` y `Cajero`. |
| `Dueno` | Concreta | Configura el programa, gestiona cajeros, anula movimientos y consulta el panel; también puede operar directamente si trabaja solo. | Hereda de `Operador`; administra `Negocio`. |
| `Cajero` | Concreta | Empleado opcional que registra compras y canjes con su PIN. | Hereda de `Operador`; pertenece a un `Negocio`. |
| `AdminPlataforma` | Concreta | Aprueba o suspende negocios y administra plantillas. | Hereda de `Usuario`. |
| `Negocio` | Concreta | Representa un comercio y agrupa su programa, cajeros y tarjetas. | Pertenece a un `Dueno`; emite `TarjetaLealtad`. |
| `ProgramaLealtad` | Concreta | Define reglas, premios y niveles, y calcula los puntos. | Usa `ReglaAcumulacion`; ofrece `Premio` y `Nivel`. |
| `Cliente` | Concreta | Persona que participa en el programa de un negocio. | Tiene una `TarjetaLealtad` por negocio. |
| `TarjetaLealtad` | Concreta | Cuenta del cliente: QR, código corto, saldo y nivel. | Registra `Movimiento`; publica eventos. |
| `Movimiento` | Abstracta | Cambio inmutable en el saldo de una tarjeta. | Padre de `MovimientoAcumulacion`, `MovimientoCanje` y `MovimientoAnulacion`. |
| `ReglaAcumulacion` | Interfaz | Contrato para calcular puntos o sellos de una compra. | Implementada por `ReglaPorVisita`, `ReglaPorMonto` y `ReglaPromocional`. |
| `ReglaPromocional` | Concreta | Decora otra regla con un multiplicador temporal. | Envuelve a una `ReglaAcumulacion`. |
| `FabricaReglas` | Concreta | Crea reglas a partir de plantillas. | Crea `ReglaAcumulacion`. |
| `Compra` | Concreta | Datos de una compra o visita (monto, fecha, ID externo). | Leída por las reglas. |
| `Premio` | Abstracta | Beneficio canjeable con costo, vigencia y existencias. | Padre de `PremioProducto`, `PremioDescPorcentaje` y `PremioDescMonto`. |
| `Nivel` | Concreta | Categoría del cliente con umbral y multiplicador. | Definido por `ProgramaLealtad`. |
| `GestorEventos` | Concreta | Sujeto del patrón Observer: administra suscriptores y publica eventos. | Notifica a `ObservadorLealtad`. |
| `ObservadorLealtad` | Interfaz | Contrato para reaccionar a eventos del programa. | Implementada por `NotificadorWhatsApp` y `NotificadorCorreo`. |
| `FormatoTarjeta` | Interfaz | Contrato para exportar la tarjeta. | Implementada por `TarjetaImagen`, `TarjetaPDF` y `TarjetaGoogleWallet`. |
| `GeneradorQR` | Concreta | Genera la imagen del código QR a partir del código de la tarjeta. | Usada por `FormatoTarjeta`. |
| `ConectorVentas` | Interfaz | Contrato para recibir compras de sistemas externos. | Implementada por `AdaptadorApiRest`, `AdaptadorCsv` y `AdaptadorManual`. |
| `ServicioLealtad` | Servicio | Coordina los casos de uso: registrar compra, canjear y consultar. | Usa reglas, premios, gestor de eventos y conectores. |

## Patrones de diseño aplicados

| Patrón | Dónde se aplica | Beneficio |
|---|---|---|
| Strategy | `ReglaAcumulacion` y `FormatoTarjeta`. | Agregar reglas o formatos sin modificar las clases existentes. |
| Decorator | `ReglaPromocional` envuelve a otra regla. | Combinar promociones con cualquier regla base sin crear una subclase por cada combinación. |
| Observer | `GestorEventos` y `ObservadorLealtad`. | Desacopla el registro del movimiento de los canales de aviso. |
| Factory Method | `FabricaReglas`. | Centraliza la creación de reglas y oculta las clases concretas. |
| Adapter | `ConectorVentas` y sus adaptadores. | El núcleo no cambia al integrarse con distintos sistemas. |

## Pilares de la POO en el diseño

| Pilar | Aplicación |
|---|---|
| Abstracción | Clases abstractas e interfaces (`Usuario`, `Operador`, `Movimiento`, `Premio`, `ReglaAcumulacion`, `ConectorVentas`) que modelan lo esencial. |
| Encapsulamiento | El saldo no es un atributo editable: se obtiene de los movimientos y solo cambia mediante `registrarMovimiento()`. |
| Herencia | `Dueno` y `Cajero` heredan de `Operador`, y este de `Usuario`; los tipos de movimiento y de premio heredan de sus clases base. |
| Polimorfismo | `calcular()`, `aplicar()` y `exportar()` se comportan distinto según la clase concreta. |

## Notas

- El cajero es opcional: el dueño hereda de `Operador` y puede registrar compras y canjes directamente, lo que permite que un negocio con solo un celular y una laptop use el sistema sin más personal.
- Los nombres de clases no llevan acentos ni la letra ñ (por ejemplo, `Dueno`) para evitar problemas en el código.
- Los diagramas son del diseño inicial y pueden ajustarse durante el desarrollo; cualquier cambio debe reflejarse en este documento en el mismo sprint.
- Los módulos de notificaciones, exportación y conectores incluyen funcionalidades opcionales (Google Wallet, API REST) definidas como extras en los requisitos.
