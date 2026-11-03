# Matriz de trazabilidad RNF ↔ diseño

**Proyecto:** LoyaltyAccess 
**Alcance:** RNF1–RNF24 
**Objetivo:** Relacionar cada requisito no funcional con las clases, componentes o decisiones de diseño que lo cubren.

## RNF1. Seguridad y control de acceso

**Clases, componentes o diseños relacionados:**
- `Usuario`
- `Operador`
- `Dueno`
- `Cajero`
- `AdminPlataforma`
- `Negocio`

**Justificación:**

El `usuario` contiene a ``operador` y `AdminPlaforma`, estos mismos  son padres `dueno` y `cajero`. El sistema deberá de proteger las funciones y datos de acuerdo con el tipo de `usuario`.

---

## RNF2. Protección de datos personales


**Clases, componentes o diseños relacionados:**
- `Cliente`
- `Usuario`
- `TarjetaLealtad`
  
**Justificación:**

`Cliente`se encuentra en `usuario` y su cuenta se encuentra en su `TarjetaLealtad`

---

## RNF3. Integridad de las transacciones



**Clases, componentes o diseños relacionados:**
- `ServicioLealtad`
- `TarjetaLealtad`
- `registrarMovimiento`
- `Movimiento`
- `MovimientoAcumulacion` 
- `MovimientoCanje`


**Justificación:**

`ServicioLealtad` es el único punto que coordina acumulaciones y canjes, y cada operación se materializa como un `Movimiento` registrado mediante `registrarMovimiento`.

---

## RNF4. Inmutabilidad del historial

**Clases, componentes o diseños relacionados:**
- `Movimiento`
- `MovimientoAnulacion`
- `motivo`
- `movimientoOriginal`
- `Dueno.anularMovimiento()`

**Justificación:**

El diseño establece que los movimientos nunca se borran y que una corrección genera un movimiento inverso que referencia al original. Solo `Dueno` puede anular, y la anulación queda registrada. Para que la regla sea efectiva, la capa de persistencia no debe exponer operaciones de actualización o eliminación sobre los movimientos.

---

## RNF5. Seguridad del código QR


**Clases, componentes o diseños relacionados:**
- `TarjetaLealtad`
- `codigoQR`
- `codigoCorto`
- `GeneradorQR`
- `Cliente`

**Justificación:**

El QR se genera a partir del código de la tarjeta, no a partir de datos del cliente. `Cliente` y `TarjetaLealtad` son clases separadas, de modo que el código no contiene nombre ni teléfono.

---

## RNF6. Seguridad de los PIN


**Clases, componentes o diseños relacionados:**
- `Cajero` 
- `Usuario` (`claveHash`)

**Justificación:**

`Cajero` es la única clase que guarda un PIN. La clase base `Usuario` incluye claveHash. Los credenciales y PINs (Cajero.pin) se procesan mediante algoritmos de hashing seguro antes de almacenarse.

---

## RNF7. Rendimiento


**Clases, componentes o diseños relacionados:**
- `TarjetaLealtad`(`codigoQR` `acumuladoHistorico` `saldo()`)
- `ServicioLealtad`


**Justificación:**

Estas clases participan en las operaciones principales, permitiendo consultas ágiles de saldo y generación ligera de códigos.

---

## RNF8. Consistencia del saldo


**Clases, componentes o diseños relacionados:**
- `TarjetaLealtad` 
- `Movimiento `
- `ProgramaLealtad`


**Justificación:**

Al calcular el saldo sumando/restando el histórico de `movimiento`, se previenen inconsistencias.

---

## RNF9. Disponibilidad

**Clases, componentes o diseños relacionados:**
- `AdaptadorManual`
- `Operador`
- `dueno`

**Justificación:**

En el diseño, `AdaptadorManual` permite que el negocio opere sin depender de un sistema de ventas externo, y el `Dueno` puede atender en mostrador aunque no haya cajeros.

---

## RNF10. Separación de información


**Clases, componentes o diseños relacionados:**
- `Negocio`
- `ProgramaLealtad`
- `Cajero`
- `TarjetaLealtad` 
- `Premio` 
- `Movimiento`


**Justificación:**

`Negocio` es la raíz de la que dependen el programa, los cajeros, las tarjetas, los premios y, por medio de la tarjeta, los movimientos. `Cliente` no está ligado directamente a un negocio, solo mediante `TarjetaLealtad`, por lo que cualquier consulta de clientes debe pasar por la tarjeta del negocio.

---

## RNF11. Escalabilidad


**Clases, componentes o diseños relacionados:**
- `ServicioLealtad`
- `Negocio`
- `Strategy` 
- `Factory Method` 
- `Observer`

**Justificación:**

Agregar negocios, clientes o programas solo crea nuevas instancias de las mismas clases. Los patrones permiten sumar reglas, canales y formatos sin reestructurar el sistema.

---

## RNF12. Usabilidad


**Clases, componentes o diseños relacionados:**
- `Operador` (`registrarCompra()`, `canjearPremio()`)
- `TarjetaLealtad` (`codigoQR`, `codigoCorto`)
- `ProgramaLealtad`
- `FabricaReglas`
**Justificación:**

El modelo reduce las operaciones de mostrador a dos acciones y ofrece tres formas de identificar al cliente. `Operador` expone métodos directos y simples `(registrarCompra()`, `canjearPremio()` para evitar complejidad operativa en el mostrador.

---

## RNF13. Accesibilidad de la tarjeta digital

**Clases, componentes o diseños relacionados:**
- `TarjetaLealtad`
- `FormatoTarjeta`
- `TarjetaImagen`
- `TarjetaPDF`
- `TarjetaGoogleWallet`
- `GeneradorQR`


**Justificación:**

`FormatoTarjeta` abstrae la generación de la tarjeta digital para ser visualizada en navegador web estándar o billeteras digitales sin requerir apps nativas instaladas.

---

## RNF14. Compatibilidad


**Clases, componentes o diseños relacionados:**
- `FormatoTarjeta`
- `GeneradorQR`

**Justificación:**

El diseño de representación se adapta a cualquier dispositivo web móvil o de escritorio mediante salidas compatibles universales.

---

## RNF15. Interoperabilidad


**Clases, componentes o diseños relacionados:**
- `ConectorVentas`
- `AdaptadorApiRest`
- `AdaptadorCsv`
- `AdaptadorManual`
- `Compra` (`idExterno`)
- `ServicioLealtad`

**Justificación:**

El patrón Adapter a través de `ConectorVentas` permite que el sistema se conecte con sistemas de punto de venta (POS) externos mediante `AdaptadorApiRest` o `AdaptadorCsv` sin modificar el núcleo de dominio.

---

## RNF16. Mantenibilidad


**Clases, componentes o diseños relacionados:**
- `ServicioLealtad` 
-  `Strategy` 
- `Decorator`
- `Observer`
- `Factory Method`
- `Adapter`
- `Usuario` 
- `Operador`
- `Movimiento`
- `Premio`
- `ReglaAcumulacion`
- `ConectorVentas`
  

**Justificación:**

Cada responsabilidad está en una clase o módulo propio y las dependencias se establecen mediante interfaces. Esto permite corregir o cambiar un componente sin afectar a los demás.

---

## RNF17. Extensibilidad
 
**Clases, componentes o diseños relacionados:**
- `ReglaAcumulacion`
- `ReglaPorVisita` 
- `ReglaPorMonto`
- `ReglaPromocional`
- `FabricaReglas`
- `Premio`
- `Nivel`
- `FormatoTarjeta`
- `ObservadorLealtad`

**Justificación:**

Nuevos tipos de acumulación se agregan implementando `ReglaAcumulacion`. Las promociones se combinan con cualquier regla mediante `ReglaPromocional`. Los nuevos premios son subclases de `Premio` y las nuevas plantillas se registran en `FabricaReglas`. Los nuevos canales de aviso o formatos de tarjeta se agregan sin modificar el código existente.

---

## RNF18. Auditoría


**Clases, componentes o diseños relacionados:**
- `Movimiento` (`fecha`, `registradoPor`, `puntos`)
- `MovimientoAnulacion` (`motivo`, `movimientoOriginal`)
- `Cajero`
- `Operador`


**Justificación:**

Cada `Movimiento` conserva fecha y operador que lo registró. Las anulaciones conservan referencia al movimiento original, proporcionando información para rastrear las operaciones.

---

## RNF19. Recuperación ante errores



**Clases, componentes o diseños relacionados:**
- `ServicioLealtad`
- `TarjetaLealtad` (`registrarMovimiento()`)
- `GestorEventos`

**Justificación:**

`ServicioLealtad` concentra la operación y `registrarMovimiento()` es el único camino para modificar el saldo. Al ejecutarlos en una transacción, un error revierte el movimiento y el saldo juntos. La publicación de eventos debe realizarse después de confirmar la transacción.

---

## RNF20. Respaldo de información


**Clases, componentes o diseños relacionados:**
-`Cliente`
-`Negocio`
-`ProgramaLealtad`
-`Movimiento`
**Justificación:**

La persistencia de `Cliente`,  `Negocio`, `ProgramaLealtad` y `Movimiento` es delegada a la capa de infraestructura/configuración, facilitando respaldos continuos de la base de datos. 

---

## RNF21. Confiabilidad de las notificaciones


**Clases, componentes o diseños relacionados:**
- `TarjetaLealtad` (`registrarMovimiento()`)
- `GestorEventos`
- `EventoLealtad`
- `ObservadorLealtad`
- `NotificadorWhatsApp`
- `NotificadorCorreo`

**Justificación:**

Los eventos se publican cuando la tarjeta registra un movimiento, por lo que no existe aviso sin una operación registrada. Si el movimiento falla	, no se genera evento.

---

## RNF22. Privacidad entre roles


**Clases, componentes o diseños relacionados:**
- `Operador` (`registrarCompra()`, `canjearPremio()`)
- `Cajero`
- `Dueno` (`configurarPrograma()`, `gestionarCajeros()`, `verPanel()`, `anularMovimiento()`)
- `AdminPlataforma` (`suspenderNegocio()`, `gestionarPlantillas()`)

**Justificación:**

`Cajero` hereda únicamente las operaciones de mostrador de `Operador`. Las funciones administrativas pertenecen solo a `Dueno` y las de plataforma a `AdminPlataforma`. Las pantallas y respuestas deben devolver al cajero solo los datos necesarios para identificar y operar la cuenta.

---

## RNF23. Portabilidad

**Clases, componentes o diseños relacionados:**

-Lenguaje portable (Java/POO) y desacoplamiento de infraestructura.

**Justificación:**

El uso de clases puras de dominio sin dependencias rígidas de entorno facilita su despliegue en múltiples servidores o plataformas en la nube.

---

## RNF24. Documentación


**Clases, componentes o diseños relacionados:**
- Documento de diagramas de clases (incluye descripción de clases, patrones y pilares de POO)
- Matriz de trazabilidad RF ↔ clases y  esta matriz RNF
- Documento de arquitectura
- Documentación de la API (`AdaptadorApiRest`)

**Justificación:**

Estructuración clara de responsabilidades, contratos de interfaces y relaciones entre clases documentadas explícitamente.

---


