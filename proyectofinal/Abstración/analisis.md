---
marp: true
header: <div class="encabezado"><img src='imagenes/franjaSuperior.png'  /><div class="titulo"><h1 class="texto"></h1></div></div>
footer: '![image](imagenes/franjaInferior.png)' 
_header: '' 
_footer: '' 
paginate: true
_paginate: false
_backgroundImage: url('imagenes/fondo.png')
style: |

  .encabezado {
    position: relative; left: 0; top:0;display: inline-block; text-align: center;
  }
  .titulo {
    position: absolute; top: 40%; left: 50%; transform: translate(0%, -50%); color: gray;
  }
  .columns {
    display: grid;
    grid-template-columns: repeat(2, minmax(0, 1fr));
    gap: 1rem;
  }
  .texto:after {
    content: 'Titulo';
  }
  
  h1 { color: black }
---

<div style="position: absolute; left: 30%; top:45%; width: 70%; text-align: left"><h1 style="color: gray">Programación Orientada a Objetos</h1></div>
<div style="position: absolute; left: 30%; top:55%; width: 70%; text-align: left"><h5 style="color: gray">Área de programación<br />
Programa de Ingeniería de Sistemas y Computación<br />
Facultad de Ingeniería
</h5></div>

<div style="position: absolute; left: 45%; top:20%; background-color: rgb(212, 231, 205); width: 550px">
<b>
Problema: <br />
Parqueadero<br />
</b>
</div>


<div style="position: absolute; left: 93%; top:10px; ">

![width:80](imagenes/licencia.png)
</div>

---


<style scoped>
.texto:after {
    content: 'Problema:';
  }
</style>

<div style="font-size: 20pt">

Se desea desarrollar una aplicación para la administración eficiente de un parqueadero. El
parqueadero cuenta con un número n de puestos, cada uno identificado por una posición
única (i, j). Cada puesto puede estar ocupado por un vehículo, que puede ser de tipo moto
(clásica o híbrida) o carro, y debe tener una placa, un modelo y un propietario registrado en el
sistema.
Para las motos, se debe registrar también su velocidad máxima, ya que el parqueadero es
frecuentado por compradores de motos usadas interesados en conocer este dato. Un vehículo
solo puede ocupar un puesto a la vez, por lo que se debe verificar la disponibilidad del puesto
antes de ubicar un vehículo en él.
El sistema debe llevar un registro completo de todos los vehículos que han parqueado en el
establecimiento, incluyendo información sobre el puesto ocupado y el momento de ingreso.
Además, debe permitir la identificación del propietario de un vehículo ubicado en un puesto
dado y llevar un registro de todos los ingresos al parqueadero, registrando el puesto ocupado
y el vehículo ubicado en el mismo.
   
---

<style scoped>
.texto:after {
    content: 'Problema:';
  }
</style>

<div style="font-size: 20pt">

La implementación del parqueadero debe hacer uso de herencia para una mejor organización
y reutilización del código.
Las funcionalidades del parqueadero son:
- El sistema debe permitir la creación de un parqueadero con un número de puestos.
- Cada puesto debe tener una posición (i, j) y puede estar ocupado por un vehículo.
- Un vehículo puede ser de tipo moto (clásica o híbrida) o carro, y debe tener una placa,
un modelo y un propietario.
- Si el vehículo es una moto, se debe registrar su velocidad máxima.
- El sistema debe permitir verificar si un puesto está ocupado por un vehículo y si un
puesto está disponible.
- El sistema debe llevar un registro de todos los vehículos que han parqueado en el
parqueadero.
---

<style scoped>
.texto:after {
    content: 'Problema';
  }
</style>

- Se debe poder identificar al propietario de un vehículo ubicado en un puesto dado.
- El sistema debe llevar un registro de todos los ingresos al parqueadero, incluyendo el
puesto ocupado y el vehículo ubicado en el mismo.
- Un puesto solo puede estar ocupado por un vehículo a la vez.
- Un vehículo solo puede ocupar un puesto en un momento dado.
- Para que un vehículo se ubique en un puesto, el puesto debe estar vacío.
- Se debe establecer una tarifa por hora de uso del parqueadero para cada tipo de
vehículo (moto clásica, moto híbrida y carro).
- El sistema debe calcular el costo total de estacionamiento de un vehículo basado en el
tiempo de uso y la tarifa por hora correspondiente a su tipo.

---

<style scoped>
.texto:after {
    content: 'Problema';
  }
</style>

- Se debe permitir que el administrador del parqueadero pueda configurar las tarifas por
hora para cada tipo de vehículo.
- El sistema debe ser capaz de generar un reporte diario y mensual del dinero recaudado
en el parqueadero.
- El reporte diario debe incluir el total recaudado en ese día, desglosado por tipo de
vehículo (moto clásica, moto híbrida, carro).
Entregables:
- El sistema debe seguir el principio de desarrollo dirigido por pruebas (TDD).
- Código fuente en github.
- Aplicar los principios de la programación orientada a objetos.
- Documentación detallada del diseño y funcionamiento del sistema

---

<style scoped>
.texto:after {
    content: 'Abstracción';
  }

</style>

<div style="font-size: 20pt;">

**¿Que solicita el problema?**

Un sistema que permita:

- Llevar un registro de todos los vehículos que han parqueadero en el
parqueadero.
- Crear un parqueadero con n puestos, cada uno identificado por una posición
única (i, j).
- Recibir Vehículos que pueden ser de tipo moto
(clásica o híbrida) o carro, y debe tener una placa, un modelo y un propietario registrado.
- Registrar velocidad maxima moto.
- Ocupar un solo puesto a la vez.
- Identificar el propietario de un vehículo ubicado en un puesto
dado y llevar un registro de todos los ingresos al parqueadero.

---

<style scoped>
.texto:after {
    content: 'Abstracción';
  }

</style>

<div style="font-size: 20pt;">

- Establecer una tarifa por hora de uso del parqueadero para cada tipo de
vehículo (moto clásica, moto híbrida y carro).
- Permitir que el administrador del parqueadero pueda configurar las tarifas por
hora para cada tipo de vehículo.
- Generar un reporte diario y mensual del dinero recaudado
en el parqueadero.

---

<style scoped>
.texto:after {
    content: 'Abstracción';
  }
</style>

<div style="font-size: 15pt;">

**¿Que información es relevante?**

- **Parqueadero**:
  - nombre: Texto
  - numeroPuestos: entero

- **Propietario**
    - nombre : Texto
    - apellido : Texto
    - identificacion : Texto
    - numTelefono : Texto

- **Administrador**
    - nombre : Texto
    - apellido : Texto
    - identificacion : Texto
    - numTelefono : Texto    

---

<style scoped>
.texto:after {
    content: 'Abstracción';
  }
</style>

<div style="font-size: 15pt;">

- **Comprador**
    - nombre : Texto
    - apellido : Texto
    - identificacion : Texto
    - numTelefono : Texto  

- **Carro**
    - placa : Texto
    - modelo : Texto
    - propietario : propietario
    - tarifaHora : Real

- **Moto**
    - placa : Texto
    - modelo : Texto
    - propietario : propietario
    - velocidadMaxima
    - tarifaHoraHibrida : Real
    - tarifaHoraClasica : Real


---

<style scoped>
.texto:after {
    content: 'Abstracción';
  }
</style>

<div style="font-size: 15pt;">

- **TipoMoto**
    - CLASICA
    - HIBRIDA
 
- **Puesto**
  - posicionI : Entero
  - posicionJ : Entero

- **Estado**
  - LIBRE
  - OCUPADO

- **Registro**:
  - fechaEntrada: Fecha
  - fechaSalida: Fecha

---

<style scoped>
.texto:after {
    content: 'Abstracción: Diagrama';
  }
</style>

<div style="position: absolute; left: 14%; top:4%; ">

![width:u7000](diagrama-00.svg)
</div>

---


<style scoped>
.texto:after {
    content: 'Descomposición';
  }
</style>

<div style="font-size: 19pt;">

**¿Cómo se distribuyen las funcionalidades?**

- **Parqueadero**

  - Guardar puestos
  - Agregar vehiculos a puestos
  - Quitar vehiculos de puestos
  - Verificar si un puesto está libre o ocupado
  - Actualizar el estado de un puesto
  - Generar un reporte diario del dinero recaudado
  - Generar un reporte mensual del dinero recaudado
  - Identificar el propietario del vehiculo en un puesto
---

<style scoped>
.texto:after {
    content: 'Descomposición';
  }
</style>

- **Administrador**
  - Capacidad de cambiar la tarifa de un vehiculo.

- **Vehiculo**
   - Obtener la tarifa dependiendo del vehiculo y su tipo.
   - Cambiar la tarifa dependiendo del vehiculo y su tipo.

- **Registro**
  - Calcular las horas que un vehiculo ha estado estacionado.
  - Calcular la tarifa que un vehiculo debe pagar dependiendo del tipo del vehiculo y el numero de horas que este estacionado.
  
---


<style scoped>
.texto:after {
    content: 'Descomposición: ¿Cómo se distribuyen las funcionalidades?';
  }
</style>



<div style="position: absolute; left: 5%; top:8%; ">

![width:1200](diagrama-01.svg)
</div>


---

<style scoped>
.texto:after {
    content: 'Descomposición: ¿Qué debo hacer para probar las funcionalidades?';
  }
</style>

- Almacenar y recuperar los datos completos de los vehiculos y las personas.
- Amacenar un numero valido de puestos
- Almacenar datos de prueba
- Recuperar los datos de prueba
- Verificar que los datos almacenados coinciden con los datos recuperados

---



<style scoped>
.texto:after {
    content: 'tabla de pruebas';
  }
</style>

<div style="font-size: 15pt;">

Clase: **Vehiculo**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Datos completos de una moto | se crea una Moto con sus datos completos| Se obtiene sus datos exitosamente |
| Datos completos de un carro | Se crea un Carro con sus datos completos| Se obtienen sus datos exitosamente |
| Datos nulos de una moto | se  intenta crear una Moto con sus datos nulos| Error: los datos de la moto no pueden ser nulos |
| Datos nulos de un carro | Se intenta crear un Carro con sus datos nulos| Error: los datos de la moto no pueden ser nulos |
| Datos negativos de una moto | se intenta crea una moto con datos negativos| Error: la velocidad maxima de la moto debe ser positiva |

</div>


---

<style scoped>
.texto:after {
    content: 'tabla de pruebas';
  }
</style>

<div style="font-size: 15pt;">

Clase: **Propietario**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Datos completos de un propietario | Se crea un Propietario con sus datos completos| Se obtienen sus datos exitosamente |
| Datos nulos de un propietario | Se intenta crea un Propietario con sus datos nulos| Error, no se puede crear un propietario con sus datos nulos |
| Datos vacíos de un propietario | Se intenta crea un propietario sus datos vacíos| Error, no se puede crear un propietario con sus datos vacíos |
| propietario menor de edad | se intenta crea un propietario menor de edad| Error: el propietario debe ser mayor de edad |

</div>


---

<style scoped>
.texto:after {
    content: 'tabla de pruebas';
  }
</style>

<div style="font-size: 15pt;">

Clase: **Puesto**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Datos completos de un puesto | Se crea un puesto con sus datos completos| Se obtiene sus datos exitosamente |
| Datos negativos y nulos de un puesto | Se intenta crea un puesto con su posicion negativa y su estado nulo| Error, no se puede crear un puesto con sus datos nulos ni negativos |

</div>


---

<style scoped>
.texto:after {
    content: 'tabla de pruebas';
  }
</style>

<div style="font-size: 15pt;">

Clase: **Parqueadero**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Datos completos de un parqueadero | Se crea un parqueadero con sus datos completos| Se obtienen sus datos exitosamente |
| Añadir vehiculos diferentes | Se añaden vehiculos a diferentes puestos| se obtienen los el estado de los puestos exitosamente |
| Añadir un vehiculo a un puesto ocupado | Se intenta añadir un vehiculo a un puesto en donde ya hay un vehiculo| Error, no se puede añadir un vehiculo a un puesto que está ocupado |


</div>


---

<style scoped>
.texto:after {
    content: 'tabla de pruebas';
  }
</style>

<div style="font-size: 15pt;">

Clase: **Parqueadero**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| crear puestos | Se crea un parqueadero con un numero de puestos positivo| Se obtiene el numero de puestos exitosamente |
| Generar un reporte de un parqueadero sin vehículos | Se crea un parqueadero y se genera el reporte diario y mensual sin vehiculos| Se obtienen los reportes con valores de cero |
| Generar un reporte de un parqueadero con vehiculos | Se crea un parqueadero y se genera el reporte diario con vehiculos| Se obtienen los reportes con diferentes valores según la instancia de vehiculo |
| Calcular tarifa de un vehiculo después de x horas | Se crea un parqueadero y se genera un reporte mensual de los vehiculos según la cantidad de horas estacionado y su instancia de vehiculo| Se obtiene un total de dinero dada la suma de los valores de cada vehiculo |


</div>


---

<style scoped>
.texto:after {
    content: 'tabla de pruebas';
  }
</style>

<div style="font-size: 15pt;">


Clase: **Parqueadero**

| Prueba                                | Entrada de datos                                          | Salida (Resultado)                                                                                  |
|---------------------------------------|-----------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| Identificar el propietario de un vehiculo estacionado | Se usa el método para identificar el propietario de un vehiculo según su posicion| Se obtiene el propietario del vehiculo exitosamente dada su posicion |
| Identificar el propietario de un puesto sin vehículo | Se usa el método para identificar el propietario de un vehiculo según su posicion| Error: no se ha encontrado ningún vehículo |


</div>


<!-- 
_header: ''
_footer: '' 
_paginate: false
_backgroundImage: url('imagenes/gracias.png')