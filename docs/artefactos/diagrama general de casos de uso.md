# Diagrama general de casos de uso

**Indicador:** refinamiento de artefactos

**Fuentes:** `casos de uso.md` (diagramas por actor), `historias de usuario.md` (HU-01 a HU-07), `requisitos funcionales.md` (RF1–RF27), `diagramas de clases.md` y el código de la rama `segunda-entrega`.

Este diagrama consolida en una sola vista los cuatro diagramas por actor de [casos de uso](casos%20de%20uso.md).

![Diagrama general de casos de uso de LoyaltyAccess](https://i.ibb.co/GSHCVtF/casos-de-uso-loyaltyaccess.jpg)



## Notación

| Elemento | Significado |
|---|---|
| Figura de palito | Actor |
| Óvalo | Caso de uso |
| Línea continua | Asociación actor – caso de uso |
| `«include»` (punteada) | El caso de uso base siempre ejecuta el incluido |
| `«extend»` (punteada) | El caso de uso que extiende agrega una variante opcional al base |
| Flecha con triángulo hueco | Generalización (herencia entre actores) |
| Óvalo amarillo | Caso de uso compartido por más de un actor o caso de uso |

## Actores

| Actor | Descripción |
|---|---|
| **Dueño del negocio** | Registra su negocio, configura el programa de lealtad y consulta su panel. Hereda de Operador, por lo que también puede atender en mostrador sin necesidad de registrar cajeros. |
| **Operador** | Actor genérico que atiende en mostrador: identifica clientes, registra compras o visitas y canjea premios. Se especializa en **Cajero** (se autentica con PIN) y en **Dueño** (se autentica con su cuenta). |
| **Cliente** | Consulta su tarjeta digital desde un enlace, sin instalar ninguna aplicación. |
| **Administrador de la plataforma** | Aprueba, suspende y reactiva negocios, administra las plantillas de programas y revierte canjes fallidos o duplicados (rol de soporte técnico). |

## Casos de uso por actor

### Dueño del negocio
| Caso de uso | Descripción | Relaciones |
|---|---|---|
| Registrarse y registrar negocio | Crea su cuenta y los datos básicos del negocio. | — |
| Configurar programa de lealtad | Define tipo de acumulación (sellos o puntos), reglas, premios y niveles. | `«include»` Configurar reglas de acumulación y Configurar niveles; `«extend»` Seleccionar plantilla |
| Gestionar premios | Crea, modifica y administra los premios. | — |
| Gestionar cajeros | Agrega y administra cajeros con su PIN. | — |
| Gestionar clientes | Registra y consulta clientes. | — |
| Gestionar promociones | Modifica temporalmente las reglas de acumulación. | — |
| Consultar historial de movimientos | Revisa acumulaciones y canjes de sus clientes. | — |
| Consultar clientes frecuentes | Identifica a quienes más visitan el negocio. | — |
| Identificar clientes inactivos | Identifica a quienes dejaron de visitar el negocio. | — |
| Revertir canje fallido o duplicado | Devuelve los puntos al cliente. | Compartido con el Administrador |

### Operador (Cajero o Dueño)
| Caso de uso | Descripción | Relaciones |
|---|---|---|
| Autenticarse (PIN o cuenta) | Cajero con PIN, dueño con su cuenta. | — |
| Identificar cliente | Localiza al cliente en mostrador. | `«extend»` Escanear código QR, Buscar por código corto, Buscar por teléfono |
| Registrar compra o visita | Registra la operación y acumula puntos o sellos. | `«include»` Identificar cliente, Calcular y acumular puntos o sellos, Registrar movimiento en historial, Aplicar control antifraude |
| Canjear premio | Canjea un premio si el cliente cumple los requisitos. | `«include»` Identificar cliente, Validar premio disponible, Descontar puntos o sellos, Registrar movimiento en historial, Aplicar control antifraude |

### Cliente
| Caso de uso | Descripción | Relaciones |
|---|---|---|
| Acceder a tarjeta digital | Abre su tarjeta mediante un enlace. | `«include»` Mostrar código QR, Consultar puntos o sellos, Consultar nivel, Consultar premios disponibles |
| Recibir notificaciones | Se le avisa al acumular y al acercarse a un premio. | `«include»` Consultar avance hacia un premio |

### Administrador de la plataforma
| Caso de uso | Descripción | Relaciones |
|---|---|---|
| Gestionar negocios | Administra los negocios registrados. | `«extend»` Aprobar negocio, Suspender negocio, Reactivar negocio |
| Suspender negocio | Suspende temporalmente por actividad sospechosa. | `«include»` Registrar motivo de suspensión |
| Gestionar plantillas | Administra las plantillas de programas. | `«extend»` Crear plantilla, Modificar plantilla |
| Revertir canje fallido o duplicado | Devuelve los puntos y registra la reversión para auditoría. | Compartido con el Dueño |

## Trazabilidad con historias, requisitos y código

Estado del código según la rama `segunda-entrega`: hoy solo existe la entidad `Usuario` y el endpoint `POST /api/usuarios`.

| Caso de uso | Historia | Requisito |
|---|---|---|
| Registrarse y registrar negocio | — | RF1 |
| Configurar programa / reglas / niveles | HU-01, HU-02 | RF2, RF11 |
| Seleccionar plantilla | — | RF3 |
| Gestionar premios | HU-01 | RF13 |
| Gestionar cajeros | HU-03 | RF19 |
| Gestionar clientes | — | RF4 |
| Gestionar promociones | — | RF21 |
| Consultar historial de movimientos | — | RF16, RF17 |
| Consultar clientes frecuentes / inactivos | — | RF22, RF23 |
| Autenticarse (PIN o cuenta) | HU-03 | RF18 |
| Identificar cliente | — | RF8 |
| Registrar compra o visita | HU-02 | RF9, RF10 |
| Canjear premio | HU-04 | RF14, RF15 |
| Aplicar control antifraude | HU-03 | RF18 |
| Acceder a tarjeta digital | HU-04 | RF5, RF6, RF7, RF12 |
| Recibir notificaciones | — | RF20 | Pendiente |
| Gestionar negocios (aprobar, suspender, reactivar) | HU-07 | RF24 |
| Gestionar plantillas | — | RF25 |
| Revertir canje fallido o duplicado | HU-06 | RF16, RF18 |

## Refinamientos respecto a los diagramas anteriores

1. **Vista única:** los cuatro actores en un solo diagrama, con la generalización Dueño → Operador.
2. **Casos de uso compartidos:** Identificar cliente, Registrar movimiento en historial y Aplicar control antifraude se dibujan una sola vez y los comparten Registrar compra y Canjear premio. Antes estaban duplicados (UC3a/UC4a, UC3d/UC4d, UC3e/UC4e).
3. **Alternativas de identificación:** el QR, el código corto y el teléfono son variantes del mismo caso de uso, por lo que las tres usan `«extend»`. Antes solo el QR lo usaba y las otras dos eran `«include»`.
4. **HU-07:** se agregan Reactivar negocio y Registrar motivo de suspensión, según los criterios de aceptación.
5. **HU-06:** Revertir canje queda también disponible para el Administrador (soporte técnico). El Dueño lo conserva, como en la versión anterior.

