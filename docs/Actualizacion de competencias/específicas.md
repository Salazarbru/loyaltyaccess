# Competencias Específicas

Las competencias específicas corresponden a los conocimientos y habilidades técnicas aplicados durante el desarrollo del proyecto de software.

## Rodrigo Rivera

| **Competencia** | **Justificación** |
| --- | --- |
| Análisis de requisitos de software | Se analizaron las necesidades de los usuarios de LoyaltyAccess para identificar los requisitos relacionados con la selección y modificación de recompensas. |
| Especificación de historias de usuario | Se trabajó en la descripción de las funcionalidades del sistema desde la perspectiva de los usuarios, considerando sus necesidades y objetivos. |
| Definición de criterios de aceptación | Se incorporaron criterios de aceptación a las historias de usuario para establecer condiciones claras y verificables que permitan comprobar el cumplimiento de los requisitos. |
| Documentación de software | Se organizaron y documentaron las competencias y los artefactos correspondientes a la entrega mediante archivos Markdown dentro del repositorio del proyecto. |
| Control de versiones con GitHub | Se utilizaron ramas y Pull Requests para proponer cambios en la documentación del proyecto y facilitar su revisión por parte del líder del equipo. |

---

## Rodrigo Salazar

| **Competencia** | **Justificación** |
| --- | --- |
| Diseño de software orientado a objetos | Se rediseñó la jerarquía de usuarios agregando la clase abstracta `Operador`, de la que heredan `Dueno` y `Cajero`, para que el cajero sea opcional sin duplicar comportamiento (#37). |
| Desarrollo de aplicaciones con frameworks | Se integró Spring Boot con Maven Wrapper y se estableció la estructura `entity / repository / controller` que el equipo replicará en las demás entidades (#41). |
| Persistencia de datos | Se implementó la entidad `Usuario` con JPA, su repositorio y un endpoint `POST /api/usuarios`, conectados a una base PostgreSQL en Supabase (#44). |
| Seguridad en el manejo de credenciales | Las credenciales de la base se leen de variables de entorno y el archivo `.env` se excluyó del repositorio. |
| Gestión de proyectos de software | Se organizaron los sprints, se revisaron e integraron los PR del equipo hacia `segunda-entrega` y se midió la contribución individual (#52, #54). |

---

## Freddy Correa

| **Competencia** | **Justificación** |
| --- | --- |
| Trazabilidad de requisitos | Se elaboró la matriz RNF ↔ diseño, relacionando cada uno de los 24 requisitos no funcionales con las clases y decisiones de diseño que lo cubren (#58). |
| Comunicación técnica | Se preparó la presentación de avance de la entrega con diagramas y recursos visuales (#57). |
| Gestión del producto | Como Product Owner, se resumió la evolución del producto y de los requisitos entre la primera y la segunda entrega (#51). |

---

## José Correa

| **Competencia** | **Justificación** |
| --- | --- |
| Modelado UML | Se elaboró el diagrama general de casos de uso que consolida los cuatro actores, con relaciones `include`, `extend` y la generalización Operador → Cajero / Dueño (#49). |
| Refinamiento de artefactos | Se revisó la coherencia del diagrama con las historias de usuario, los requisitos funcionales y el diagrama de clases. |
| Comunicación audiovisual | Se coordina la grabación y edición del video de la segunda entrega (#56). |

---

## Mauricio Álvarez

| **Competencia** | **Justificación** |
| --- | --- |
| Trazabilidad de requisitos | Se elaboró la matriz RF ↔ clases, justificando qué clases del diagrama participan en cada requisito funcional (#50). |
| Análisis de diseño orientado a objetos | Se revisaron los métodos y relaciones de cada clase para determinar qué requisito cubren. |
| Documentación del proceso | Se registraron las reuniones del equipo con sus acuerdos, conflictos, responsables y fechas límite (#53). |
