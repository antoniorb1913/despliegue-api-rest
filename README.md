# 🐾 Protectora de Mascotas API REST

Bienvenido a la API para la gestión de mascotas en una protectora.  
Este proyecto te permitirá listar mascotas y realizar adopciones fácilmente.

---

## 🚀 Características

- **Listar mascotas:** Consulta todas las mascotas disponibles para adopción.
- **Adoptar mascota:** Marca una mascota como adoptada.

---

## 🗄️ Base de datos

La API utiliza una base de datos MySQL con la siguiente estructura:

```sql
CREATE DATABASE PET;

USE PET;

CREATE TABLE PETS (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    born DATE,
    category VARCHAR(255),
    chip VARCHAR(255)
);
```

---

## 📚 Endpoints

### ➤ Listar mascotas

- **URL:** `/list`
- **Método:** `GET`
- **Descripción:** Obtiene todas las mascotas registradas.
- **Ejemplo de respuesta:**
  ```json
  [
    {
      "id": 1,
      "name": "Luna",
      "born": "2022-01-10",
      "category": "Perro",
      "chip": "123456789",
      "adopt": false
    }
  ]
  ```

---

### ➤ Adoptar mascota

- **URL:** `/adopt/{id}`
- **Método:** `POST`
- **Descripción:** Marca como adoptada la mascota con el id indicado.
- **Ejemplo de respuesta:**
  ```json
  {
    "id": 1,
    "name": "Luna",
    "born": "2022-01-10",
    "category": "Perro",
    "chip": "123456789",
    "adopt": true
  }
  ```

---

## 🏁 Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/antoniorb1913/despliegue-api-rest.git
   cd despliegue-api-rest
   ```
2. Instala dependencias:
   ```bash
   npm install
   ```
3. Configura la conexión a MySQL.
4. Inicia el servidor:
   ```bash
   npm start
   ```

---

## 🧑‍💻 Contribuciones

¿Quieres mejorar el proyecto?  
Haz un fork, crea una rama y envía tu pull request.

---

## 📩 Contacto

Para dudas o sugerencias, abre un issue o escribe a [antoniorb1913@gmail.com](mailto:antoniorb1913@gmail.com)

---

_Disfruta ayudando a que más mascotas encuentren un hogar 🏡🐶🐱_
