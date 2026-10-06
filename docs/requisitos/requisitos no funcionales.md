# Requisitos No Funcionales

Los requisitos no funcionales establecen las características de calidad, restricciones y condiciones bajo las cuales deberá operar el sistema LoyaltyAccess.

### RNF1. Seguridad y control de acceso

El sistema deberá proteger las funciones y datos de acuerdo con el tipo de usuario, evitando que clientes, cajeros, dueños de negocios y administradores puedan acceder a información o funciones que no les correspondan.

### RNF2. Protección de datos personales

El sistema deberá proteger los datos personales de clientes, cajeros y dueños de negocios, evitando su exposición a usuarios no autorizados.

### RNF3. Integridad de las transacciones

El sistema deberá garantizar que las operaciones de acumulación y canje de puntos o sellos se registren de manera consistente, evitando duplicaciones, pérdidas o modificaciones no autorizadas.

### RNF4. Inmutabilidad del historial

El historial de movimientos de puntos, sellos y canjes deberá conservarse de forma que los registros históricos no puedan ser eliminados o modificados por usuarios del negocio.

### RNF5. Seguridad del código QR

Los códigos QR utilizados para identificar clientes deberán ser únicos y no deberán contener directamente información personal sensible del cliente.

### RNF6. Seguridad de los PIN

Los PIN utilizados para la autenticación de cajeros no deberán almacenarse en texto plano y deberán mantenerse protegidos mediante mecanismos adecuados de almacenamiento seguro.

### RNF7. Rendimiento

Las operaciones principales del sistema, incluyendo la identificación de un cliente, registro de una compra o visita y consulta de puntos o sellos, deberán responder en un máximo de 2 segundos bajo condiciones normales de operación.

### RNF8. Consistencia del saldo

El sistema deberá garantizar que los puntos o sellos disponibles de un cliente sean consistentes después de cada acumulación o canje, evitando que una misma operación pueda aplicarse más de una vez.

### RNF9. Disponibilidad

El sistema deberá estar disponible durante el horario de operación de los negocios afiliados, permitiendo realizar las operaciones principales de los programas de lealtad.

### RNF10. Separación de información

La información perteneciente a cada negocio deberá mantenerse aislada lógicamente, evitando que un negocio pueda consultar o modificar clientes, programas, premios, cajeros o movimientos pertenecientes a otro negocio.

### RNF11. Escalabilidad

El sistema deberá permitir el crecimiento del número de negocios, clientes, cajeros, programas y transacciones sin requerir modificaciones importantes en su arquitectura.

### RNF12. Usabilidad

Las operaciones principales del sistema deberán poder realizarse de manera intuitiva por clientes, cajeros y dueños de negocios, sin requerir conocimientos técnicos especializados.

### RNF13. Accesibilidad de la tarjeta digital

La tarjeta digital del cliente deberá poder consultarse desde un navegador web compatible sin requerir la instalación de una aplicación móvil.

### RNF14. Compatibilidad

La plataforma deberá funcionar correctamente en navegadores web modernos y adaptarse a dispositivos móviles y de escritorio utilizados por clientes y negocios.

### RNF15. Interoperabilidad

La arquitectura del sistema deberá permitir la integración con sistemas externos mediante una API, de acuerdo con las funcionalidades definidas para la integración con sistemas de ventas.

### RNF16. Mantenibilidad

El sistema deberá mantener una estructura modular y organizada que facilite la corrección de errores, mantenimiento y modificación de sus componentes sin afectar innecesariamente otras funcionalidades.

### RNF17. Extensibilidad

El sistema deberá permitir incorporar nuevos tipos de acumulación, premios, promociones y reglas de programas de lealtad sin requerir una reestructuración completa del sistema.

### RNF18. Auditoría

Las operaciones relevantes del sistema deberán conservar información suficiente para identificar cuándo y qué operación fue realizada, particularmente en acumulaciones, canjes, modificaciones de programas y operaciones realizadas por cajeros.

### RNF19. Recuperación ante errores

Si ocurre un error durante una operación de acumulación o canje, el sistema deberá evitar guardar estados parciales que produzcan inconsistencias entre la transacción, el saldo del cliente y el historial.

### RNF20. Respaldo de información

La información de clientes, negocios, programas, movimientos y premios deberá contar con mecanismos de respaldo que permitan recuperar la información ante fallos del sistema o pérdida de datos.

### RNF21. Confiabilidad de las notificaciones

Las notificaciones relacionadas con acumulación de beneficios y disponibilidad o proximidad de premios deberán generarse de acuerdo con las operaciones registradas por el sistema, evitando notificaciones correspondientes a transacciones inexistentes.

### RNF22. Privacidad entre roles

El sistema deberá mostrar a cada tipo de usuario únicamente la información necesaria para realizar sus funciones. Por ejemplo, un cajero deberá poder identificar y operar la cuenta de un cliente sin tener acceso a información administrativa que corresponda exclusivamente al dueño o administrador.

### RNF23. Portabilidad

El sistema deberá poder desplegarse en diferentes entornos compatibles sin requerir modificaciones significativas en el código fuente.

### RNF24. Documentación

El sistema deberá contar con documentación suficiente sobre su arquitectura, reglas principales, estructura de datos y API para facilitar su mantenimiento, integración y evolución.
