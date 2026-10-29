 # Diagramas de Casos de Uso

Los diagramas de casos de uso representan las principales interacciones entre los usuarios y las funciones de LoyaltyAccess.

## Caso de uso: Dueño del negocio

```mermaid
flowchart LR
    Dueno(["Dueño del negocio"])

    subgraph LoyaltyAccess
        UC1(["Registrarse y registrar negocio"])
        UC2(["Configurar programa de lealtad"])
        UC3(["Gestionar premios"])
        UC4(["Gestionar cajeros"])
        UC5(["Gestionar clientes"])
        UC6(["Gestionar promociones"])
        UC7(["Consultar historial de movimientos"])
        UC8(["Consultar clientes frecuentes"])
        UC9(["Identificar clientes inactivos"])
        UC10(["Revertir canje"])
        UC2a(["Seleccionar plantilla"])
        UC2b(["Configurar reglas de acumulación"])
        UC2c(["Configurar niveles"])
    end

    Dueno --- UC1
    Dueno --- UC2
    Dueno --- UC3
    Dueno --- UC4
    Dueno --- UC5
    Dueno --- UC6
    Dueno --- UC7
    Dueno --- UC8
    Dueno --- UC9
    Dueno --- UC10

    UC2a -. "<<extend>>" .-> UC2
    UC2 -. "<<include>>" .-> UC2b
    UC2 -. "<<include>>" .-> UC2c
```

Este diagrama representa las funciones disponibles para el dueño del negocio, como la configuración del programa de lealtad, la gestión de clientes, cajeros, premios y promociones. El dueño también puede revertir un canje fallido o duplicado para devolver los puntos al consumidor. Además, como se explica en la nota del siguiente diagrama, el dueño también puede ejecutar por su cuenta las operaciones de mostrador del diagrama de Operador.

## Caso de uso: Operador (registrar compras y canjes)

```mermaid
flowchart LR
    Operador(["Operador"])

    subgraph LoyaltyAccess
        UC1(["Autenticarse"])
        UC2(["Identificar cliente"])
        UC3(["Registrar compra o visita"])
        UC4(["Canjear premio"])
        UC2a(["Escanear código QR"])
        UC2b(["Buscar por código corto"])
        UC2c(["Buscar por teléfono"])
        UC3a(["Identificar cliente "])
        UC3b(["Calcular puntos o sellos"])
        UC3c(["Actualizar saldo del cliente"])
        UC3d(["Registrar movimiento en historial"])
        UC3e(["Aplicar control antifraude"])
        UC4a(["Identificar cliente  "])
        UC4b(["Validar premio disponible"])
        UC4c(["Descontar puntos o sellos"])
        UC4d(["Registrar movimiento en historial "])
        UC4e(["Aplicar control antifraude "])
    end

    Operador --- UC1
    Operador --- UC2
    Operador --- UC3
    Operador --- UC4

    UC2a -. "<<extend>>" .-> UC2
    UC2 -. "<<include>>" .-> UC2b
    UC2 -. "<<include>>" .-> UC2c

    UC3 -. "<<include>>" .-> UC3a
    UC3 -. "<<include>>" .-> UC3b
    UC3 -. "<<include>>" .-> UC3c
    UC3 -. "<<include>>" .-> UC3d
    UC3 -. "<<include>>" .-> UC3e

    UC4 -. "<<include>>" .-> UC4a
    UC4 -. "<<include>>" .-> UC4b
    UC4 -. "<<include>>" .-> UC4c
    UC4 -. "<<include>>" .-> UC4d
    UC4 -. "<<include>>" .-> UC4e
```

Este diagrama muestra las operaciones de mostrador —identificación de clientes, registro de compras o visitas y canje de premios— como funciones del actor genérico **Operador**, del cual heredan tanto el `Cajero` (que se autentica con PIN) como el `Dueño` (que se autentica con su cuenta principal). Así, estas operaciones nunca dependen de que exista un cajero registrado.

> **Nota — el `Cajero` es 100% opcional:** como `Dueño` hereda de `Operador`, puede identificar clientes, registrar compras o visitas y canjear premios desde su propia cuenta principal, sin necesidad de registrar empleados. Por eso LoyaltyAccess está pensado tanto para negocios pequeños —personas que operan solo con su celular y su laptop— como para negocios establecidos que ya cuentan con uno o varios cajeros en mostrador.

## Caso de uso: Cliente

```mermaid
flowchart LR
    Cliente(["Cliente"])

    subgraph LoyaltyAccess
        UC1(["Acceder a tarjeta digital"])
        UC2(["Recibir notificaciones"])
        UC1a(["Mostrar código QR"])
        UC1b(["Consultar puntos o sellos"])
        UC1c(["Consultar nivel"])
        UC1d(["Consultar premios disponibles"])
        UC2a(["Consultar avance hacia un premio"])
    end

    Cliente --- UC1
    Cliente --- UC2

    UC1 -. "<<include>>" .-> UC1a
    UC1 -. "<<include>>" .-> UC1b
    UC1 -. "<<include>>" .-> UC1c
    UC1 -. "<<include>>" .-> UC1d

    UC2 -. "<<include>>" .-> UC2a
```

Este diagrama representa la interacción del cliente con su tarjeta digital, permitiéndole consultar sus puntos o sellos, premios disponibles y mostrar su código QR. No se incluye ningún caso de uso de directorio o búsqueda de negocios para el cliente, a fin de respetar el aislamiento de datos entre negocios (RF26).

## Caso de uso: Administrador de la plataforma

```mermaid
flowchart LR
    Admin(["Administrador de la plataforma"])

    subgraph LoyaltyAccess
        UC1(["Gestionar negocios"])
        UC2(["Gestionar plantillas"])
        UC1a(["Aprobar negocio"])
        UC1b(["Suspender negocio"])
        UC2a(["Crear plantilla"])
        UC2b(["Modificar plantilla"])
    end

    Admin --- UC1
    Admin --- UC2

    UC1a -. "<<extend>>" .-> UC1
    UC1b -. "<<extend>>" .-> UC1
    UC2a -. "<<extend>>" .-> UC2
    UC2b -. "<<extend>>" .-> UC2
```

Este diagrama muestra las funciones del administrador de LoyaltyAccess, como la gestión de negocios registrados (incluida la suspensión de negocios con actividad sospechosa) y de las plantillas de programas de lealtad.
