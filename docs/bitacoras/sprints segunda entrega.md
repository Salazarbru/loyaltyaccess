# Sprints de la segunda entrega

**Periodo:** 24 de octubre al 3 de noviembre de 2026
**Metodología:** Scrum, con el tablero del proyecto en GitHub
**Rama de integración:** `segunda-entrega`

## 1. Roles

| Integrante | Usuario GitHub | Rol Scrum |
|---|---|---|
| Rodrigo Salazar | `Salazarbru` | Scrum Master |
| Freddy Correa | `FreddyCorreaOjeda` | Product Owner |
| José Correa (Capo) | `capiiim` | Developer |
| Rodrigo Rivera | `riverarodrigo` | Developer |
| Mauricio Álvarez (Manu) | `Mauricio-AlvarezV` | Developer |

## 2. Forma de trabajo

- Cada tarea es un **issue** con responsable y talla (S = 1 pt, M = 2 pts, L = 3 pts).
- Cada integrante trabaja en su propia rama y abre un **pull request hacia `segunda-entrega`**; el Scrum Master revisa e integra.
- Un issue se cierra cuando su PR es integrado.
- Al final de la entrega, `segunda-entrega` se integra a `main`.

---

## 3. Sprint 1 — Cohesión y base técnica

| Dato | Valor |
|---|---|
| **Fechas** | 24 al 26 de octubre de 2026 |
| **Duración** | 3 días |
| **Tamaño** | 3 issues · 7 puntos |
| **Objetivo** | Corregir las inconsistencias entre los artefactos de la primera entrega y dejar lista la base del proyecto para empezar a programar. |

### Planeación

Al revisar los artefactos de la primera entrega se detectó que el Cajero aparecía como único actor de mostrador, lo que contradecía la idea de que un negocio de una sola persona pueda usar el sistema. Se decidió corregir eso primero y, en paralelo, preparar el proyecto Spring Boot y la conexión a la base de datos.

### Actividades

| Issue | Actividad | Talla | Responsable | PR | Resultado |
|---|---|---|---|---|---|
| #37 | Cohesión entre diagramas UML, requisitos e historias (actor Operador) | M | Rodrigo Salazar | #38, #40 | ✅ Cerrado |
| #41 | Integración de Spring Boot (Maven Wrapper, estructura de paquetes) | M | Rodrigo Salazar | #42 | ✅ Cerrado |
| #44 | Entidad `Usuario` con repositorio, `POST /api/usuarios` y conexión a Supabase | L | Rodrigo Salazar | #45, #47 | ✅ Cerrado |

### Resultados

- Casos de uso, clases, requisitos y descripción de producto alineados con el actor **Operador**.
- Proyecto Spring Boot funcionando con conexión a Supabase mediante variables de entorno.
- Patrón `entity / repository / controller` listo para que el equipo lo replique en las demás entidades.

### Retrospectiva

- **Bien:** la base técnica quedó lista en tres días.
- **A mejorar:** el primer intento de cohesión se integró y luego se revirtió (commit `536d878`) por un conflicto de ramas; se volvió a aplicar (`91483ef`). Se acordó abrir siempre el PR hacia `segunda-entrega` y no hacia `main`.
- **A mejorar:** todo el sprint recayó en una sola persona; para el sprint 2 se repartió el trabajo entre todo el equipo.

---

## 4. Sprint 2 — Refinamiento de artefactos y gestión

| Dato | Valor |
|---|---|
| **Fechas** | 27 de octubre al 3 de noviembre de 2026 |
| **Duración** | 8 días |
| **Tamaño** | 11 issues · 21 puntos |
| **Objetivo** | Refinar los artefactos (historias, casos de uso y trazabilidad), documentar el proceso y preparar la presentación y el video de la entrega. |

### Planeación

El 27 de octubre se crearon los issues #48 a #58 y se asignó al menos uno a cada integrante, procurando que cada quien tuviera tanto un artefacto técnico como uno de documentación.

### Actividades

| Issue | Actividad | Talla | Responsable | PR | Resultado |
|---|---|---|---|---|---|
| #48 | Criterios de aceptación en las historias de usuario | M | Rodrigo Rivera | #61 | ✅ Cerrado |
| #49 | Diagrama general de casos de uso | M | José Correa | #65 | ✅ Cerrado |
| #50 | Matriz de trazabilidad RF ↔ clases | M | Mauricio Álvarez | #64 | ✅ Cerrado |
| #58 | Matriz de trazabilidad RNF ↔ diseño | M | Freddy Correa | #68 | ✅ Cerrado |
| #57 | Presentación de avance | M | Freddy Correa | — | ✅ Cerrado |
| #51 | Resumen de cambios entre entregas | S | Freddy Correa | este PR | ✅ Listo para revisión |
| #52 | Documentar sprints (este documento) | S | Rodrigo Salazar | este PR | ✅ Listo para revisión |
| #53 | Bitácora de reuniones | S | Mauricio Álvarez | este PR | ✅ Listo para revisión |
| #54 | Métrica de contribución individual | S | Rodrigo Salazar | este PR | ✅ Listo para revisión |
| #55 | Competencias de la entrega | 1 pt c/u | Todo el equipo | #63, este PR | ✅ Listo para revisión |
| #56 | Video de la entrega | M | José Correa | — | ⏳ En curso |

### Resultados

- Siete historias de usuario (HU-01 a HU-07) con criterios de aceptación.
- Diagrama general de casos de uso que consolida los cuatro actores.
- Matriz de trazabilidad RF ↔ clases (RF1–RF19) y matriz RNF ↔ diseño (RNF1–RNF24).
- Documentación de proceso: sprints, reuniones, métrica de contribución y resumen de cambios.

### Retrospectiva

- **Bien:** todos los integrantes tuvieron al menos un issue y un PR integrado.
- **A mejorar:** algunos PR se abrieron hacia `main` por error (#59, #62, #66) y tuvieron que repetirse hacia `segunda-entrega`.
- **A mejorar:** algunos archivos quedaron fuera de la carpeta `docs/` (las matrices de trazabilidad en la raíz). Se reorganizarán al integrar a `main`.

---

## 5. Resumen

| Sprint | Fechas | Issues | Puntos | Completados |
|---|---|---|---|---|
| Sprint 1 | 24–26 oct | 3 | 7 | 3 / 3 |
| Sprint 2 | 27 oct – 3 nov | 11 | 21 | 10 / 11 (video en curso) |
| **Total** | | **14** | **28** | **13 / 14** |
