# LoyaltyAccess

**Tarjetas de lealtad digitales con QR para pequeños negocios.**
Software para que cualquier emprendedor premie a sus clientes frecuentes de forma ágil, cómoda y segura, usando únicamente su celular y su laptop.

---

## Descripción

Software dedicado a la creación y operación de programas de lealtad (por sellos o por puntos) con una interfaz clara, directa y eficiente. Su objetivo principal es que los pequeños negocios fidelicen a sus clientes sin necesidad de un punto de venta, equipo especial ni conocimientos técnicos, mediante múltiples facilidades:

- Configuración del programa en minutos a partir de plantillas listas.
- Tarjeta con código QR único para cada cliente, sin que el cliente instale ninguna aplicación.
- Cálculo automático de sellos o puntos, niveles y premios.
- Control antifraude básico (PIN de cajero, intervalo mínimo entre visitas e historial que no se puede borrar).
- Reducción de las tarjetas de cartón perdidas, falsificadas o llenadas por error.

El resultado es un programa de lealtad más confiable para el negocio y más cómodo para el cliente.

## Objetivo principal

Desarrollar una aplicación web para la gestión de programas de lealtad que permita a pequeños emprendedores registrar compras, acumular sellos o puntos y canjear premios desde su celular o laptop, reduciendo el fraude y los errores de las tarjetas físicas y mejorando la comodidad tanto para el negocio como para sus clientes.

> **Nota:** el software no busca ser un punto de venta, un sistema de inventario ni una herramienta de facturación. Es un programa de lealtad ágil, enfocado en registrar visitas o compras, acumular beneficios y canjear premios.

## Implicaciones del desarrollo

- Considerar que cada negocio es distinto (cafeterías, barberías, estéticas, puestos de comida, tiendas de barrio), por lo que las reglas, premios y niveles deben ser configurables por negocio.
- Ofrecer facilidades para el uso diario, como plantillas de programa, escaneo del QR con la cámara del celular y cálculo automático de puntos según la regla vigente.
- Incluir una interfaz para que el cajero encuentre rápido al cliente (QR, código corto o teléfono) y para que el cliente consulte su tarjeta desde un enlace.
- Mantener separada la información de cada negocio, ya que la plataforma atiende a varios negocios a la vez.
- Diseñar la interfaz para uso rápido en mostrador, con pocos toques por operación.

## Obstáculos externos al uso del software

- **Conexión a internet en el negocio.** La aplicación es web, por lo que requiere conexión; en el peor de los casos, la señal del negocio puede ser inestable. Se mitiga con una interfaz ligera y, como extra, con el reenvío de operaciones cuando regrese la conexión.
- **Cámara y navegador del celular.** El escaneo depende de que el dispositivo del cajero tenga cámara y permita su uso desde el navegador. Si no es posible escanear, se puede identificar al cliente con su código corto o teléfono.
- **Adopción por parte de los clientes.** Algunos clientes pueden dudar en compartir su teléfono; por eso se piden solo los datos mínimos y se informa el uso de sus datos.
- **Poca experiencia tecnológica del dueño o del cajero.** Se mitiga con plantillas y una configuración guiada.

## Dinámica del uso del software

El dueño configura su negocio y su programa de lealtad (regla de acumulación, premios y, opcionalmente, niveles). Los clientes se registran con su nombre y teléfono y reciben una tarjeta digital con un QR único. En cada compra, el cajero escanea el QR (o ingresa el código corto), registra el monto o la visita y el sistema abona automáticamente los puntos o sellos. Cuando el cliente alcanza un premio, el cajero lo canjea y el sistema descuenta el saldo. Todos los movimientos quedan guardados en un historial, que el dueño puede consultar en su panel para conocer a sus clientes frecuentes y a los que dejaron de visitar el negocio.

## Usuarios / Clientes

| Tipo | Quiénes son | Cómo usan la aplicación |
|---|---|---|
| Primarios | Dueños de pequeños negocios y sus cajeros | Usan la aplicación día a día. El dueño configura el programa, los premios y consulta su panel; el cajero registra clientes, compras y canjes con su PIN. |
| Secundarios | Los clientes del negocio | No instalan nada: consultan su tarjeta desde un enlace, muestran su QR para acumular y ven sus puntos, nivel y premios disponibles. |
| De soporte | Administrador de la plataforma | No participa en la operación diaria. Aprueba o suspende negocios y administra las plantillas de programas. |

## Escenarios

Un escenario de uso podría ser el siguiente:

1. La dueña de una cafetería se registra, crea su negocio y elige la plantilla "1 sello por visita, el décimo café gratis". Agrega a su cajero con un PIN.
2. Un cliente nuevo llega al mostrador; el cajero registra su nombre y teléfono, y le comparte su tarjeta digital por WhatsApp.
3. En cada visita, el cajero escanea el QR de la tarjeta con su celular y confirma la compra. El sistema suma el sello automáticamente y avisa al cliente cuando se acerca a su premio.
4. Al completar los sellos, el cliente canjea su café gratis en caja; el sistema descuenta el saldo y registra el canje.
5. Al final del mes, la dueña revisa en su panel qué clientes vienen más y quiénes dejaron de venir, y activa una promoción de doble de puntos para reactivarlos.

## Propuesta de valor

### ¿Qué tiene de especial nuestro producto?

El enfoque especial de LoyaltyAccess es ofrecer un programa de lealtad **listo para usar por quien solo tiene un celular y una laptop**, sin invertir en equipo ni sistemas, y reducir el fraude y los errores de las tarjetas de cartón.

Un poco de contexto: muchos emprendedores llevan la lealtad con tarjetas físicas con sellos que se pierden, se falsifican o se llenan sin control, y no dejan ningún dato útil sobre los clientes. Las soluciones digitales que existen suelen exigir un sistema de punto de venta o equipo especial, lo que las deja fuera del alcance de los negocios más pequeños.

Nuestro producto se diferencia porque:

- **No requiere sistemas previos:** funciona desde el navegador del celular o la laptop.
- **El cliente no instala nada:** su tarjeta es un enlace con un QR, y puede guardarla en su wallet como extra.
- **Se configura en minutos** gracias a las plantillas de programa.
- **Es multinegocio:** cada negocio tiene sus propias reglas, premios y clientes.
- **Es integrable:** si el negocio ya cuenta con un sistema de ventas, puede conectarse mediante una API como extra.

### ¿Por qué es una idea de valor?

Porque resuelve un problema cotidiano con una solución sencilla: ayuda a los negocios pequeños a retener clientes, evita fraudes y errores, entrega datos útiles sobre los clientes frecuentes y no exige cambiar la forma en que el negocio ya trabaja ni comprar equipo nuevo.
