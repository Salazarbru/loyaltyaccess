# Segunda entrega

**Periodo:** 24 de octubre al 3 de noviembre de 2026
**Rama de trabajo:** `segunda-entrega`
**Video:** pendiente (issue #56)

Este documento resume cómo evolucionaron el producto y los requisitos desde la [primera entrega](primera%20entrega.md), con la evidencia de cada cambio.

---

## 1. Evolución del producto

| # | Cambio | Antes (primera entrega) | Ahora (segunda entrega) | Evidencia |
|---|---|---|---|---|
| 1 | **Rol de Operador** | El Cajero era quien identificaba clientes, registraba compras y canjeaba premios. | Se introduce el actor genérico **Operador**, del que heredan `Cajero` y `Dueno`. El cajero pasa a ser **opcional**: un negocio de una sola persona puede operar solo con la cuenta del dueño. | Issue #37, PR #38 y #40, commits `732e608` y `94d4daa` |
| 2 | **Cohesión entre artefactos** | Casos de uso, clases, historias y requisitos se escribieron por separado y tenían diferencias de nombres y actores. | Se alinearon los cuatro artefactos con el mismo vocabulario (Operador, Dueño, Cajero, Administrador) y las mismas operaciones. | Issue #37, PR #40 |
| 3 | **Inicio de la implementación** | Sin código. | Proyecto **Spring Boot** con Maven Wrapper, paquete `com.loyaltyaccess` y estructura `entity / repository / controller`. | Issue #41, PR #42, commit `6a370a2` |
| 4 | **Primera entidad persistida** | — | Entidad `Usuario` (nombre, correo, claveHash) conforme al diagrama de clases, con `UsuarioRepository` y `POST /api/usuarios`. Conexión a **Supabase (PostgreSQL)** mediante variables de entorno; `.env` excluido del repositorio. | Issue #44, PR #45 y #47, commits `15e8e18` y `0f495f9` |
| 5 | **Diagrama general de casos de uso** | Cuatro diagramas independientes, uno por actor. | Un diagrama general que consolida los cuatro actores, muestra la generalización Operador → Cajero/Dueño y marca los casos de uso compartidos. | Issue #49, PR #65, [diagrama general de casos de uso.md](../artefactos/diagrama%20general%20de%20casos%20de%20uso.md) |
| 6 | **Trazabilidad** | No existía. | Matriz **RF ↔ clases** y matriz **RNF ↔ diseño** que relacionan los requisitos con las clases o decisiones que los cubren (RF1–RF28 y RNF1–RNF24). | Issues #50 y #58, PR #64 y #68, [Matriz de trazabilidad.md](../../Matriz%20de%20trazabilidad.md), [Matriz de trazabilidad RNF.md](../../Matriz%20de%20trazabilidad%20RNF.md) |
| 7 | **Gestión del proceso** | Una bitácora weekly y una de contribución. | Documentación de sprints, bitácora de reuniones y métrica de contribución actualizada. | Issues #52, #53 y #54 |

## 2. Evolución de los requisitos

| Requisito / artefacto | Cambio | Motivo | Evidencia |
|---|---|---|---|
| RF8 Identificación del cliente | "el cajero" → "el operador (cajero o dueño)" | El dueño también atiende en mostrador. | Commit `94d4daa` |
| RF9 Registro de compras o visitas | "el cajero" → "el operador (cajero o dueño)" | Ídem. | Commit `94d4daa` |
| RF14 Canje de premios | "el cajero" → "el operador (cajero o dueño)" | Ídem. | Commit `94d4daa` |
| Descripción de producto | La dinámica de uso y la interfaz de mostrador ahora hablan del operador y no solo del cajero. | Coherencia con el nuevo actor. | Commits `732e608` y `94d4daa` |
| Casos de uso | Se agregó el diagrama del actor **Operador**, el caso **Revertir canje** del dueño y la nota de que el cajero es opcional. | Cubrir la historia de reversión de canjes y el nuevo actor. | Commit `732e608` |
| Historias de usuario | Pasaron de enunciados sueltos a **HU-01 a HU-07** con **criterios de aceptación** verificables (formato *Dado / cuando / entonces*). | Poder validar cada historia al implementarla. | Issue #48, PR #61 |
| Historias HU-03, HU-05 a HU-07 | Se unificó el actor "soporte técnico" con el **Administrador de la plataforma**. HU-05 (directorio de negocios) se reemplazó por **avisos de avance hacia un premio**. HU-06 lo realizan el dueño y el administrador. HU-07 suspende **negocios** (no cuentas) con motivo y reactivación. | El directorio contradecía RF26 y "soporte técnico" no existía en ningún otro artefacto. | Revisión de cohesión de la entrega |
| RF24 Administración de negocios | Se agregó la suspensión con motivo y la **reactivación** de negocios. | Cubrir los criterios de aceptación de HU-07. | Revisión de cohesión de la entrega |
| **RF28 Reversión de canjes** (nuevo) | Requisito explícito para que el dueño y el administrador reviertan canjes mediante un movimiento de anulación. | HU-06 y el caso de uso "Revertir canje" no tenían requisito propio. | Revisión de cohesión de la entrega |
| Diagrama de clases | `AdminPlataforma` gana `reactivarNegocio()` y `anularMovimiento()`; `Negocio` guarda el motivo de suspensión; `Movimiento.registradoPor` pasa a ser `Usuario`. Los casos de uso por actor se alinearon con el diagrama general (`«extend»` en la identificación del cliente). | Mantener clases y casos de uso alineados con las historias. | Revisión de cohesión de la entrega |
| Requisitos no funcionales | Sin cambios de redacción; ahora cada RNF tiene su correspondencia de diseño en la matriz RNF. | Demostrar que el diseño los cubre. | Issue #58, PR #68 |

## 3. Qué sigue

- Implementar las entidades restantes del diagrama de clases (`Negocio`, `ProgramaLealtad`, `Cliente`, `TarjetaLealtad`, `Movimiento`) siguiendo el patrón establecido con `Usuario`.
- Guardar la clave del usuario como *hash* (RNF6) y agregar autenticación.
- Integrar la rama `segunda-entrega` a `main` una vez revisada la entrega.
