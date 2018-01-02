## Integracion con el Api de Java Paycores.com ##
[link a Integracion Api-Java pagina oficial](https://paycores.com/).

En esta guia se establecerán las métricas que se deben tener en cuenta al momento de integrar con el API de Java de Paycores y todo lo que debe ser tenido en cuenta para su correcto funcionamiento.

**Pasos a seguir.**
Despues de descargar la libreria Api-Java.jar o el codigo fuentente el primer paso es establecer el Objeto de configuración llamado PaycoreConfig este objeto se puede llenar de la siguiente manera.

![alt text](https://raw.githubusercontent.com/paycores/steps/master/ApiJava/step_1.png)

**Nota:** en este momento este objeto no tiene el parámetro **codeSecureForm** por que este parámetro lo solicitamos con el servicio de **PaycoresSendCode** y después de esto si podemos agregarlo normalmente, también hay que tener el cuenta el tipo de entorno que vamos a manejar ya que si ponemos 1 nos lleva al ambiente de pruebas **sandbox** y 2 al **business de producción** la variable se llama **Paycores_environment .**

Luego de haber creado el objeto de configuración con todos los parámetros suministrados por **paycores.com**, procederemos hacer la petición del **GeneratorPurchaseCode** que está en la clase **PaycoresGenPurchaseCode.**

Para poder usar la clase **PayCoresGenPurchaseCode** se debe hacer el llamado y pasar los parámetros necesarios como por ejemplo:

![alt text](https://raw.githubusercontent.com/paycores/steps/master/ApiJava/step_2.png)

En la imagen podemos ver que el método es estático y que su resultado lo estamos guardando en una cadena para luego ser usado.

**Nota:** este proceso genera un tiempo de espera por la ejecución de un script interno.

Después de esto procedemos a crear los objetos restantes Como por ejemplo el **PurchaseData:**

![alt text](https://raw.githubusercontent.com/paycores/steps/master/ApiJava/step_3.png)

**Nota:** el valor CurrencyCode debe ir en **mayúscula** y los valores monetarios tienen la restricción que es de tipo **000.00.**

Como vemos esta clase hace uso del **SetAllPurchaseData** ya que este método permite llenar el objeto tipo constructor y le pasamos el parametro que obtuvimos del servicio anterior.

Podemos seguir con el objeto **CardData** por ejemplo:

![alt text](https://raw.githubusercontent.com/paycores/steps/master/ApiJava/step_4.png)

**NOTA:** la cadena del brand o la franquicia debe ir en mayúscula.

Como vemos usamos el método tipo constructor del objeto para agregar todos los datos.

Seguimos con el objeto **AddressData** como por ejemplo:

![alt text](https://raw.githubusercontent.com/paycores/steps/master/ApiJava/step_5.png)

Nota: Este objeto será agregado posteriormente como un json del objeto **persona** se debe usar el método **getAllAddressData** que devuelve un json con toda la información.

Para este objeto también se usó el método tipo constructor para llenarlo mas facil

Seguimos con el objeto **Persona** como por ejemplo:
![alt text](https://raw.githubusercontent.com/paycores/steps/master/ApiJava/step_6.png)

**Nota:** como vemos se instancio el objeto y debajo de la instancia estamos usando el método que formatea la fecha de nacimiento, es recomendable usar este metodo y si no tener claro el formato que es **yyyy-MM-dd** y tambien muy importante es que la letra del género debe ir en **mayúscula** como se ve en el ejemplo.

Como vemos para este objeto también se usó el método tipo constructor para ser llenado.

Procedemos a crear el objeto **Good o item** como por ejemplo:
![alt text](https://raw.githubusercontent.com/paycores/steps/master/ApiJava/step_7.png)

Como vemos aquí también usamos el método tipo constructor para agregar la información.

Para terminar con el proceso de agregar la información usaremos el servicio que envia el codigo de seguridad al correo del cliente que se encuentra en la clase **PaycoresSendCode.**

![alt text](https://raw.githubusercontent.com/paycores/steps/master/ApiJava/step_8.png)

**NOTA:** después de esto al **correo del cliente** debe llegar el **codigo de verificacion** debemos capturarlo y agregarlo para acabar de llenar el objeto de **configuración:**

![alt text](https://raw.githubusercontent.com/paycores/steps/master/ApiJava/step_9.png)

Ahora procederemos a crear el objeto **Authorize** que contiene todos los objetos creados, dentro de esta **clase authorize** se hacen todas las validaciones pertinentes veamos un ejemplo:

![alt text](https://raw.githubusercontent.com/paycores/steps/master/ApiJava/step_10.png)

Luego de crear este objeto y que todo se valide podemos extraer toda la información en el json que necesitamos enviar a la última clase que creara la orden, para esto utilizamos el método **authorize.getALLData()** con este método obtenemos un formato **JSON** con toda la información que vamos a enviar como por ejemplo:

![alt text](https://raw.githubusercontent.com/paycores/steps/master/ApiJava/step_11.png)

Luego de esto procederemos a revisar el código que anteriormente digitó el usuario y que este concuerde con el enviado y que debe estar en la base de datos, usaremos el método **validateCode** que está en la clase **PaycoresValidateCode** como por ejemplo:

![alt text](https://raw.githubusercontent.com/paycores/steps/master/ApiJava/step_12.png)

Como vemos se le debe enviar el código obtenido del cliente y el **purchaseCode** que obtuvimos del primer servicio.

Para terminar procedemos a enviar el objeto que creamos con toda la información al servicio **CreateOrder** que terminara la transacción este método se encuentra en la clase **PaycoresCreateOrder** como por ejemplo:

![alt text](https://raw.githubusercontent.com/paycores/steps/master/ApiJava/step_13.png)

Con esto se habrá terminado la transacción y se espera el codigo de error que debería ser **001** como validación exitosa.
