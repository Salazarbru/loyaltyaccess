<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:6d28d9,50:a855f7,100:ec4899&height=300&section=header&text=LoyaltyAccess&fontSize=90&fontColor=ffffff&fontAlignY=38&animation=fadeIn&desc=Tarjetas%20de%20lealtad%20digitales%20con%20QR%20para%20peque%C3%B1os%20negocios&descSize=26&descAlignY=62" alt="LoyaltyAccess" width="100%" />

</div>

<div align="center">

![Estado](https://img.shields.io/badge/Estado-En%20desarrollo-f59e0b?style=for-the-badge&logo=github&logoColor=white)
![Metodología](https://img.shields.io/badge/Metodolog%C3%ADa-Scrum-6d28d9?style=for-the-badge&logo=jira&logoColor=white)

<br/>

**Premia a tus clientes frecuentes de forma ágil, cómoda y segura, usando únicamente tu celular y tu laptop.**

<br/>

[![Producto](https://img.shields.io/badge/🎯_Producto-6d28d9?style=for-the-badge)](#-producto)
[![Requisitos](https://img.shields.io/badge/📋_Requisitos-2563eb?style=for-the-badge)](#-requisitos)
[![Artefactos](https://img.shields.io/badge/🧩_Artefactos-0891b2?style=for-the-badge)](#-artefactos)
[![Repositorio](https://img.shields.io/badge/📂_Repositorio-059669?style=for-the-badge)](#-estructura-del-repositorio)
[![Bitácoras](https://img.shields.io/badge/📊_Bitácoras-d97706?style=for-the-badge)](#-bitácoras)
[![Competencias](https://img.shields.io/badge/🏅_Competencias-dc2626?style=for-the-badge)](#-competencias)
[![Equipo](https://img.shields.io/badge/👥_Equipo-ec4899?style=for-the-badge)](#-equipo)

</div>

---

## 🎯 Producto

> **LoyaltyAccess** es una aplicación web para crear y operar programas de lealtad **por sellos o por puntos**. El cliente recibe una tarjeta digital con un **código QR único**, no instala ninguna app, y sus sellos o puntos se acumulan automáticamente cada vez que se escanea.

El problema: las tarjetas de cartón se pierden, se falsifican o se llenan sin control, y las soluciones digitales suelen exigir un punto de venta o equipo especial. **LoyaltyAccess funciona desde el navegador de un celular o una laptop**, sin inversión ni conocimientos técnicos.

### ✨ ¿Cómo funciona?

```mermaid
flowchart LR
    A([👤 Cliente se registra]) --> B[📱 Obtiene su tarjeta con QR]
    B --> C[📷 Escanea el código QR]
    C --> D[⭐ Acumula sellos o puntos]
    D --> E([🎁 Canjea su premio])

    style A fill:#6d28d9,color:#fff,stroke:none
    style C fill:#2563eb,color:#fff,stroke:none
    style E fill:#ec4899,color:#fff,stroke:none
```

---

## 📋 Requisitos

Especificaciones funcionales y no funcionales del sistema:

[![Requisitos funcionales](https://img.shields.io/badge/✅_Requisitos-Funcionales-2563eb?style=for-the-badge)](docs/requisitos/requisitos%20funcionales.md)
[![Requisitos no funcionales](https://img.shields.io/badge/🛡️_Requisitos-No_funcionales-0891b2?style=for-the-badge)](docs/requisitos/requisitos%20no%20funcionales.md)

---

## 🧩 Artefactos

Documentos clave del diseño y desarrollo del producto:

| | Artefacto | Qué contiene | |
|:-:|:--|:--|:-:|
| 📘 | **Descripción de producto** | Objetivo, usuarios, escenarios y propuesta de valor | [![Ver](https://img.shields.io/badge/Ver-6d28d9?style=flat-square)](docs/producto/descripcion%20de%20producto.md) |
| 🎭 | **Casos de uso** | Cómo interactúan los actores con el sistema | [![Ver](https://img.shields.io/badge/Ver-2563eb?style=flat-square)](docs/artefactos/casos%20de%20uso.md) |
| 🗂️ | **Diagramas de clases** | Modelo de dominio y patrones de diseño aplicados | [![Ver](https://img.shields.io/badge/Ver-0891b2?style=flat-square)](docs/artefactos/diagramas%20de%20clases.md) |
| 📝 | **Historias de usuario** | Necesidades de los usuarios y criterios de aceptación | [![Ver](https://img.shields.io/badge/Ver-ec4899?style=flat-square)](docs/artefactos/historias%20de%20usuario.md) |

---

## 📂 Estructura del Repositorio

*Organización actual de las carpetas y archivos del proyecto:*

```text
loyaltyaccess/
├── 📁 .github/
│   └── 📁 workflows/        # Automatizaciones y CI/CD
├── 📁 docs/                 # Documentación del proyecto
│   ├── 📁 artefactos/       # Casos de uso, diagramas e historias de usuario
│   ├── 📁 bitacoras/        # Seguimiento semanal
│   ├── 📁 competencias/     # Competencias específicas y genéricas
│   ├── 📁 producto/         # Descripción del producto
│   └── 📁 requisitos/       # Requisitos funcionales y no funcionales
├── 📁 src/                  # Código fuente de la aplicación
├── 📄 .gitignore
├── 📄 LICENSE
└── 📄 README.md
```

---

## 📊 Bitácoras

Seguimiento semanal y reportes de desarrollo del equipo, todo reunido en un solo lugar:

[![Ver todas las bitácoras](https://img.shields.io/badge/📊_Ver_todas_las_bitácoras-d97706?style=for-the-badge)](docs/bitacoras/)

---

## 🏅 Competencias

Competencias desarrolladas a lo largo del proyecto:

[![Específicas](https://img.shields.io/badge/🎓_Competencias-Específicas-6d28d9?style=for-the-badge)](docs/competencias/especificas.md)
[![Genéricas](https://img.shields.io/badge/🌐_Competencias-Genéricas-2563eb?style=for-the-badge)](docs/competencias/genericas.md)

---

## 👥 Equipo

<div align="center">

| 👤 Integrante | 🎭 Rol |
|:---|:---|
| **Rodrigo Salazar** | 📋 Scrum Master |
| **Freddy Correa** | 💼 Product Owner |
| **Jose Correa** | ⚙️ Developer |
| **Rodrigo Rivera** | ⚙️ Developer |
| **Mauricio Álvarez** | ⚙️ Developer |

</div>