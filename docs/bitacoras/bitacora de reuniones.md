# Bitácora de reuniones — Segunda entrega

Registro de las reuniones del equipo durante la segunda entrega: acuerdos, conflictos resueltos, tareas, responsables y fechas límite.

**Asistentes habituales:** Rodrigo Salazar (SM), Freddy Correa (PO), José Correa, Rodrigo Rivera y Mauricio Álvarez.

---

## Reunión 1 — Revisión de la primera entrega y cohesión

**Fecha:** 24 de octubre de 2026

### Temas

- Revisión de los artefactos de la primera entrega.
- Inconsistencia detectada: el Cajero era el único actor que podía registrar compras, pero el producto está pensado también para negocios de una sola persona.

### Acuerdos

1. Crear el actor genérico **Operador**, del que heredan `Cajero` y `Dueno`; el cajero pasa a ser opcional.
2. Actualizar casos de uso, diagrama de clases, historias de usuario, requisitos funcionales y descripción de producto con el mismo vocabulario.
3. Usar la rama `segunda-entrega` para integrar todo el trabajo de esta entrega.

### Conflictos y resolución

- **Conflicto:** el primer PR de cohesión se integró con cambios que chocaban con la rama principal y tuvo que revertirse.
- **Resolución:** se revirtió (`536d878`), se volvió a aplicar sobre `segunda-entrega` (`91483ef`) y se acordó que todos los PR de la entrega van hacia `segunda-entrega`.

### Tareas

| Tarea | Responsable | Fecha límite | Estado |
|---|---|---|---|
| Cohesión entre artefactos (#37) | Rodrigo Salazar | 25 oct | ✅ |
| Integrar Spring Boot (#41) | Rodrigo Salazar | 25 oct | ✅ |

---

## Reunión 2 — Base técnica

**Fecha:** 26 de octubre de 2026

### Temas

- Elección de la base de datos y estructura del código.

### Acuerdos

1. Usar **Supabase (PostgreSQL)** con credenciales en variables de entorno; el archivo `.env` no se sube al repositorio.
2. Implementar primero la entidad `Usuario` como ejemplo del patrón `entity / repository / controller`, respetando los nombres del diagrama de clases (en español y sin ñ).

### Conflictos y resolución

- **Conflicto:** la primera versión de la entidad se llamó `User` (en inglés), distinta al diagrama de clases.
- **Resolución:** se renombró a `Usuario` con los campos `nombre`, `correo` y `claveHash` (commit `0f495f9`).

### Tareas

| Tarea | Responsable | Fecha límite | Estado |
|---|---|---|---|
| Entidad `Usuario` + conexión a Supabase (#44) | Rodrigo Salazar | 27 oct | ✅ |

---

## Reunión 3 — Planeación del sprint 2

**Fecha:** 27 de octubre de 2026

### Temas

- Revisión de los indicadores de la segunda entrega.
- Reparto de tareas para que todos los integrantes participen.

### Acuerdos

1. Crear un issue por cada indicador de la entrega (#48 a #58).
2. Cada integrante recibe al menos un artefacto técnico y uno de documentación.
3. Fecha de corte para integrar PR: **3 de noviembre**.

### Tareas

| Tarea | Responsable | Fecha límite | Estado |
|---|---|---|---|
| Criterios de aceptación de las historias (#48) | Rodrigo Rivera | 29 oct | ✅ |
| Diagrama general de casos de uso (#49) | José Correa | 2 nov | ✅ |
| Matriz RF ↔ clases (#50) | Mauricio Álvarez | 29 oct | ✅ |
| Resumen de cambios entre entregas (#51) | Freddy Correa | 3 nov | ✅ |
| Documentar sprints (#52) | Rodrigo Salazar | 3 nov | ✅ |
| Bitácora de reuniones (#53) | Mauricio Álvarez | 3 nov | ✅ |
| Métrica de contribución (#54) | Rodrigo Salazar | 3 nov | ✅ |
| Competencias de la entrega (#55) | Todo el equipo | 3 nov | ✅ |
| Video de la entrega (#56) | José Correa | 3 nov | ⏳ |
| Presentación de avance (#57) | Freddy Correa | 27 oct | ✅ |
| Matriz RNF ↔ diseño (#58) | Freddy Correa | 2 nov | ✅ |

---

## Reunión 4 — Seguimiento

**Fecha:** 29 de octubre de 2026

### Temas

- Revisión de los PR abiertos (#59 a #64).

### Acuerdos

1. Se integran los criterios de aceptación (#61), la matriz RF (#64) y las competencias de Rodrigo Rivera (#63).
2. Los PR que apuntaban a `main` (#59, #62) se cierran sin integrar porque ya existen sus equivalentes hacia `segunda-entrega`.

### Conflictos y resolución

- **Conflicto:** varios PR se abrieron hacia `main` en lugar de `segunda-entrega`.
- **Resolución:** se repitieron hacia la rama correcta y se recordó la regla en el grupo del equipo.

---

## Reunión 5 — Cierre de la entrega

**Fecha:** 3 de noviembre de 2026

### Temas

- Integración del diagrama general de casos de uso (#65) y de la matriz RNF (#68).
- Pendientes de documentación de proceso y video.

### Acuerdos

1. Completar la documentación de proceso (#51 a #55) en un solo PR hacia `segunda-entrega`.
2. José Correa termina y publica el video (#56); al tenerlo se agrega el enlace al README.
3. Después de la entrega, reubicar las matrices de trazabilidad dentro de `docs/artefactos/` e integrar `segunda-entrega` a `main`.

### Tareas

| Tarea | Responsable | Fecha límite | Estado |
|---|---|---|---|
| PR de documentación de proceso | Rodrigo Salazar | 3 nov | ✅ |
| Video de la entrega y enlace en README | José Correa | 4 nov | ⏳ |
| Integrar `segunda-entrega` a `main` | Rodrigo Salazar | Tras la entrega | ⏳ |
