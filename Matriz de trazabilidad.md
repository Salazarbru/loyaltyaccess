
# Matriz de trazabilidad RF ↔ clases

**Proyecto:** LoyaltyAccess  
**Alcance:** RF1–RF19  
**Objetivo:** Relacionar cada requisito funcional con las clases que participan en su implementación.

---

## RF1. Registro de negocio

**Clases relacionadas:**
- `Usuario`
- `Dueno`
- `Negocio`

**Justificación:**

`Usuario` contiene los datos comunes de acceso. `Dueno` representa al propietario y administra uno o más negocios. `Negocio` contiene la información básica del comercio.

---

## RF2. Configuración del programa de lealtad

**Clases relacionadas:**
- `Dueno`
- `Negocio`
- `ProgramaLealtad`
- `ReglaAcumulacion`
- `ReglaPorVisita`
- `ReglaPorMonto`
- `ReglaPromocional`
- `Premio`
- `Nivel`

**Justificación:**

`Dueno` dispone del método `configurarPrograma()`. `ProgramaLealtad` utiliza reglas de acumulación, ofrece premios y define niveles de lealtad.

---

## RF3. Plantillas de programas

**Clases relacionadas:**
- `FabricaReglas`
- `ReglaAcumulacion`
- `ProgramaLealtad`

**Justificación:**

`FabricaReglas` permite crear reglas a partir de una plantilla mediante el método `crearDesdePlantilla()`. El diagrama no muestra una clase independiente llamada `Plantilla`.

---

## RF4. Gestión de clientes

**Clases relacionadas:**
- `Cliente`
- `Negocio`
- `TarjetaLealtad`

**Justificación:**

`Cliente` contiene el nombre y el teléfono. Cada cliente puede tener una tarjeta de lealtad por negocio.

---

## RF5. Tarjeta digital del cliente

**Clases relacionadas:**
- `Cliente`
- `TarjetaLealtad`
- `Negocio`

**Justificación:**

`TarjetaLealtad` representa la cuenta del cliente y contiene el código QR, el código corto y el saldo. Está asociada a un cliente y a un negocio.

---

## RF6. Generación de código QR

**Clases relacionadas:**
- `TarjetaLealtad`
- `GeneradorQR`

**Justificación:**

`TarjetaLealtad` almacena el código QR y `GeneradorQR` genera su imagen a partir de un código.

---

## RF7. Consulta de tarjeta digital

**Clases relacionadas:**
- `Cliente`
- `TarjetaLealtad`
- `FormatoTarjeta`
- `TarjetaImagen`
- `TarjetaPDF`
- `TarjetaGoogleWallet`

**Justificación:**

Las clases permiten representar y exportar la tarjeta en distintos formatos. El acceso mediante un enlace web no aparece explícitamente en el diagrama.

---

## RF8. Identificación del cliente

**Clases relacionadas:**
- `Operador`
- `Dueno`
- `Cajero`
- `Cliente`
- `TarjetaLealtad`
- `GeneradorQR`

**Justificación:**

La tarjeta contiene el código QR y el código corto, mientras que `Cliente` contiene el teléfono. `Operador` agrupa las operaciones de mostrador. El método específico de identificación no está declarado en el diagrama.

---

## RF9. Registro de compras o visitas

**Clases relacionadas:**
- `Operador`
- `Dueno`
- `Cajero`
- `ServicioLealtad`
- `Compra`
- `TarjetaLealtad`
- `MovimientoAcumulacion`

**Justificación:**

`Operador` define `registrarCompra()`. `ServicioLealtad` coordina el registro y `Compra` contiene los datos de la operación.

---

## RF10. Acumulación automática de beneficios

**Clases relacionadas:**
- `ProgramaLealtad`
- `ReglaAcumulacion`
- `ReglaPorVisita`
- `ReglaPorMonto`
- `ReglaPromocional`
- `Compra`
- `TarjetaLealtad`
- `MovimientoAcumulacion`

**Justificación:**

`ProgramaLealtad` calcula los puntos mediante las reglas de acumulación. `MovimientoAcumulacion` representa el abono correspondiente en la tarjeta.

---

## RF11. Gestión de niveles

**Clases relacionadas:**
- `ProgramaLealtad`
- `Nivel`
- `TarjetaLealtad`

**Justificación:**

`ProgramaLealtad` define los niveles mediante `nivelPara()`. `Nivel` contiene el umbral y el multiplicador, mientras que `TarjetaLealtad` permite consultar el nivel actual.

---

## RF12. Consulta de puntos, sellos y premios

**Clases relacionadas:**
- `Cliente`
- `TarjetaLealtad`
- `ProgramaLealtad`
- `Nivel`
- `Premio`

**Justificación:**

`TarjetaLealtad` permite consultar el saldo y el nivel actual. `ProgramaLealtad` define los premios y niveles disponibles.

---

## RF13. Gestión de premios

**Clases relacionadas:**
- `Dueno`
- `ProgramaLealtad`
- `Premio`
- `PremioProducto`
- `PremioDescPorcentaje`
- `PremioDescMonto`

**Justificación:**

`ProgramaLealtad` ofrece premios y `Premio` define su costo, vigencia y disponibilidad. Las subclases representan premios de productos y descuentos.

---

## RF14. Canje de premios

**Clases relacionadas:**
- `Operador`
- `Dueno`
- `Cajero`
- `ServicioLealtad`
- `TarjetaLealtad`
- `Premio`
- `MovimientoCanje`

**Justificación:**

`Operador` define `canjearPremio()`. `ServicioLealtad` coordina el canje y `MovimientoCanje` registra la operación asociada al premio.

---

## RF15. Descuento automático del saldo

**Clases relacionadas:**
- `TarjetaLealtad`
- `Movimiento`
- `MovimientoCanje`
- `ServicioLealtad`

**Justificación:**

El saldo de la tarjeta se calcula a partir de sus movimientos. `MovimientoCanje` registra el canje y permite reflejar el descuento correspondiente.

---

## RF16. Historial de movimientos

**Clases relacionadas:**
- `TarjetaLealtad`
- `Movimiento`
- `MovimientoAcumulacion`
- `MovimientoCanje`
- `MovimientoAnulacion`
- `Operador`

**Justificación:**

`TarjetaLealtad` registra movimientos. Las subclases distinguen acumulaciones, canjes y anulaciones. Los movimientos no se borran; las anulaciones generan un movimiento inverso.

---

## RF17. Consulta del historial

**Clases relacionadas:**
- `Dueno`
- `Negocio`
- `TarjetaLealtad`
- `Movimiento`
- `MovimientoAcumulacion`
- `MovimientoCanje`
- `MovimientoAnulacion`

**Justificación:**

`Dueno` dispone de `verPanel()` y administra negocios. Las tarjetas registran los movimientos que forman el historial. El método específico para consultar o filtrar el historial no aparece en el diagrama.

---

## RF18. Control antifraude

**Clases relacionadas:**
- `Cajero`
- `Usuario`
- `Operador`
- `ProgramaLealtad`
- `TarjetaLealtad`
- `Movimiento`
- `MovimientoAnulacion`

**Justificación:**

`Cajero` contiene un PIN y un estado activo. `ProgramaLealtad` incluye el intervalo mínimo entre visitas. Los movimientos se conservan y las anulaciones quedan registradas.

---

## RF19. Gestión de cajeros

**Clases relacionadas:**
- `Dueno`
- `Negocio`
- `Cajero`
- `Operador`
- `Usuario`

**Justificación:**

`Dueno` dispone del método `gestionarCajeros()`. `Negocio` puede tener varios cajeros y `Cajero` contiene los atributos `pin` y `activo`.