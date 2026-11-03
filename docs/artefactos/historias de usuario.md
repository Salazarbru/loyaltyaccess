# Historias de usuario y criterios de aceptación

## Usuarios primarios

### HU-01. Selección de recompensas

**Historia de usuario:** Como dueño de un establecimiento, quiero elegir y cambiar el tipo de recompensas que ofrezco, para ajustarlas a las necesidades del negocio.

**Criterios de aceptación:**
- Dado que el dueño ha iniciado sesión, cuando selecciona un tipo de recompensa, el sistema debe permitirle guardarlo.
- Dado que existe una recompensa configurada, cuando el dueño la modifica, el sistema debe actualizarla.
- El sistema debe mostrar un mensaje de confirmación cuando los cambios se guarden correctamente.
- El sistema debe informar si ocurre un error al guardar los cambios.

### HU-02. Reglas de acumulación

**Historia de usuario:** Como dueño de un establecimiento, quiero definir reglas de acumulación (por ejemplo, 1 punto por cada $10), para controlar cuánto cuesta mi programa de lealtad.

**Criterios de aceptación:**
- El sistema debe permitir definir cuántos puntos se otorgan por cada cantidad de dinero gastada.
- El sistema debe rechazar valores negativos o iguales a cero.
- Cuando un cliente realice una compra válida, el sistema debe calcular los puntos según la regla configurada.
- El sistema debe aplicar la regla vigente del establecimiento al registrar la compra.

### HU-03. Acceso del cajero

**Historia de usuario:** Como cajero, quiero tener una clave de acceso, para poder administrar las compras y los canjes de los clientes.

**Criterios de aceptación:**
- El sistema debe permitir al cajero ingresar con su clave de acceso.
- Si la clave es correcta, el sistema debe permitirle registrar compras y realizar canjes.
- Si la clave es incorrecta, el sistema debe denegar el acceso y mostrar un mensaje de error.
- El sistema debe impedir que el cajero acceda a funciones exclusivas del dueño o del administrador de la plataforma.

## Usuarios secundarios

### HU-04. Consulta de nivel y puntos

**Historia de usuario:** Como cliente, quiero consultar mi nivel y puntos acumulados, para conocer mis recompensas disponibles.

**Criterios de aceptación:**
- El sistema debe mostrar al cliente su saldo actual de puntos.
- El sistema debe mostrar el nivel de lealtad que tiene el cliente.
- El sistema debe mostrar las recompensas disponibles según sus puntos y nivel.
- Después de una compra o un canje exitoso, el sistema debe reflejar el saldo actualizado.

### HU-05. Avisos de avance hacia un premio

**Historia de usuario:** Como cliente, quiero recibir un aviso cuando acumule puntos o sellos y cuando me acerque a un premio, para saber cuándo puedo canjearlo.

**Criterios de aceptación:**
- Después de registrar una compra o visita, el sistema debe avisar al cliente cuántos puntos o sellos acumuló.
- Cuando al cliente le falte poco para un premio, el sistema debe indicarle cuánto le falta.
- Cuando el cliente alcance un premio, el sistema debe avisarle que ya puede canjearlo.
- El sistema no debe enviar avisos de operaciones que no se registraron o que fueron anuladas.
- El aviso solo debe incluir información del negocio donde el cliente realizó la compra.

## Administración y soporte

### HU-06. Reversión de canjes

**Historia de usuario:** Como dueño de un establecimiento o administrador de la plataforma, quiero revertir un canje fallido o duplicado, para devolver los puntos al consumidor.

**Criterios de aceptación:**
- El dueño debe poder buscar y seleccionar un canje registrado en su negocio; el administrador, el de cualquier negocio al atender un reporte.
- Antes de confirmar la reversión, el sistema debe mostrar los datos del canje seleccionado y solicitar un motivo.
- Al confirmar una reversión válida, el sistema debe devolver los puntos correspondientes al cliente.
- El sistema no debe borrar el canje original: debe registrar un movimiento de anulación que lo referencie.
- El sistema debe impedir que un mismo canje se revierta más de una vez.
- La reversión debe quedar registrada con fecha, motivo y usuario que la realizó para futuras auditorías.

### HU-07. Suspensión de negocios sospechosos

**Historia de usuario:** Como administrador de la plataforma, quiero suspender temporalmente un negocio con actividad sospechosa, para prevenir fraudes mientras se investiga.

**Criterios de aceptación:**
- El sistema debe permitir al administrador suspender temporalmente un negocio.
- Antes de confirmar la suspensión, el sistema debe solicitar un motivo.
- Mientras esté suspendido, en el negocio no se podrán registrar compras ni canjes que afecten el programa de lealtad.
- El sistema debe informar al dueño y a sus cajeros que el negocio está suspendido.
- El sistema debe permitir reactivar el negocio cuando la investigación haya concluido y se autorice su reactivación.
