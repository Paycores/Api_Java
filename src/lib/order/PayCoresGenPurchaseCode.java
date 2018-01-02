package lib.order;

import lib.conection.Http;
import lib.utilities.Utils;
import lib.utilities.Validations;
import lib.json.org.json.JSONObject;

/**
 * Created by paycores.com on 18/12/17.
 * <p>
 * clase creada para lanzar una peticion post al servicio que genera el puschaseCode y el finger print necesario
 * para la iniciar la transaccion
 */
public class PayCoresGenPurchaseCode {
    private static Http http;
    private static String[] get, post;

    /**
     * Metodo que envia la peticion y devuelve el pusrchaseCode necesario para continuar
     *
     * @param paycores_access_key   - String con el Access key suministrado por paycores seteado en la el objeto
     *                              PaycoreConfig
     * @param paycores_access_login - String con el Access login suministrado por paycores seteado en la el objeto
     *                              PaycoreConfig
     * @return - retorna un string con el purchaseCode
     */
    public static String purchaseCodeGenerate(String paycores_access_key, String paycores_access_login) {
        String params = "";
        try {
            http = new Http();

            //String data = PaycoreCrypt.bytesToHex(paycoreCrypt.encrypt(authorize.toString()));

            //Traemos las variables de la clase de propiedades y llenamos el objeto

            JSONObject authorize = new JSONObject();
            authorize.put("paycoresKey", paycores_access_key);
            authorize.put("paycoresLogin", paycores_access_login);

            if (authorize.isNull("paycoresKey") || authorize.isNull("paycoresLogin")) {
                throw new Exception("No se ha Inicializado el objeto de configuraciones");
            }


            //Recorremos el objeto para poder modificarlo valor por valor


            params = Utils.iteratorObjectPOST(authorize);
            post = http.sendPost(Utils.urlServer("GEN_PURCODE"), params);
            System.out.println("decrypted POST GenPurchaseCode = " + post[1]);
            JSONObject objetoResult = new JSONObject(post[1]);
            Validations.validarJSON(objetoResult);
            if (objetoResult.isNull("fingerGen") || objetoResult.isNull("purchaseCode")) {
                throw new Exception("El JSON contiene keys vacias");
            }
            String paycores_purchaseCode = objetoResult.getString("purchaseCode");


            //Se debe ejecutar el ExecuteScript para que el script se ejecute

            PayCoresExecuteScript executeScript = new PayCoresExecuteScript();
            executeScript.startEngine(paycores_purchaseCode);

            return paycores_purchaseCode;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
