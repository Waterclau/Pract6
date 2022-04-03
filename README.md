# Pract6

## Testing unitario de DNI y TELF
Se han creado dos archivos de test, DNITest.java & TelefonoTest.java, para realizar a cabo dicha tarea, los cuales se encuentran en la siguiente ruta:
practica-6\src\test\java\com\icai\practicas\DNITest.java
### DNITest
Para el método de validación hay que verificar que:
  1)Si el valor introducidos está entre los valores inválidos de la clase DNI, recibimos un false
  2)El dni tiene la estructura estandar 
### TelefonoTest
De la misma manera, realizamos el test con telefonos validos e invalidosç

### Process Controller END-END
Para este test son importantes tres archivos:
  1) ProcessService.java => request para nombre,DNI y telefono.
  2) ProcessServiceImpl.java => obtine los datos por la interfaz y los pasa por medio del logger
  3) ProcessController.java => se realiza el post de los datos
Para este apartado , realizamos el test que se encuentra en la siguiente ruta:
practica-6\src\test\java\com\icai\practicas\ProcessControlerTest.java
Donde comprobamos ejemplos correctos e incorrectos.
