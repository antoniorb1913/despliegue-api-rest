# 🐾 Pet Protector API

Bienvenido a la **Pet Protector API**, diseñada para la gestión de una protectora de mascotas. Esta API te permite listar mascotas disponibles y realizar adopciones de manera sencilla y eficiente.

## 🚀 Características principales

- **Listar mascotas**: Consulta todas las mascotas disponibles para adopción.
- **Adoptar mascota**: Marca una mascota como adoptada e inicia el proceso de adopción.

## 📚 Endpoints

### 1. Listar mascotas

Obtén todas las mascotas disponibles en la protectora.

- **URL:** `/mascotas`
- **Método:** `GET`
- **Respuesta exitosa:**
  ```json
  [
    {
      "id": 1,
      "nombre": "Luna",
      "especie": "Perro",
      "edad": 4,
      "estado": "Disponible"
    },
    ...
  ]
  ```

### 2. Adoptar mascota

Adopta una mascota por su identificador.

- **URL:** `/mascotas/adoptar/:id`
- **Método:** `POST`
- **Parámetros URL:**  
  - `id`: Identificador de la mascota a adoptar
- **Respuesta exitosa:**
  ```json
  {
    "mensaje": "¡Mascota adoptada exitosamente!",
    "mascota": {
      "id": 1,
      "nombre": "Luna",
      "estado": "Adoptada"
    }
  }
  ```

## 🛠️ Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tuusuario/pet-protector-api.git
   ```

2. Instala dependencias:
   ```bash
   npm install
   ```

3. Inicia el servidor:
   ```bash
   npm start
   ```

## 🧑‍💻 Contribuciones

¿Quieres contribuir? ¡Bienvenido! Haz un fork del repo, crea una rama y envía tu pull request.

## 📞 Contacto

Para dudas o sugerencias, escribe a [tu-email@ejemplo.com](mailto:tu-email@ejemplo.com).

---

_Disfruta ayudando a que más mascotas encuentren un hogar 🏠🐶🐱_
