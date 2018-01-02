package lib.order;

import lib.conection.Http;
import lib.utilities.Utils;
import lib.json.org.json.JSONObject;
import lib.json.org.json.JSONException;

/**
 * Created by paycores.com on 18/12/17.
 *
 * clase creada para enviar la peticion post que valida el codigo segurdad en las bases de datos
 */
public class PayCoresValidateCode {

    private static Http http;
    private static String[] get, post;

    /**
     * Metodo que envia la peticion post al servicio validate code
     * @param codigo - Este es el codigo de validacion capturado despues de que la persona verifico el correo
     *               y lo coloco en el front-end
     * @param purchaseCode - este es el purchase code que fue generado al principio de la transaccion
     * @throws JSONException -
     */
    public static void validateCode(String codigo, String purchaseCode) throws JSONException {

        JSONObject validate = new JSONObject();
        validate.put("data", codigo);
        validate.put("dataPur", purchaseCode);
        String params = "";
        try {
            http = new Http();
            params = Utils.iteratorObjectPOST(validate);
            post = http.sendPost(Utils.urlServer("VALIDATE_CODE") ,params);
            System.out.println("RESULT POST VALIDATE CODE  = " + post[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
