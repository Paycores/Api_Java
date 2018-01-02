package lib.order;

import lib.conection.Http;
import lib.exception.PaycoresExceptions;
import lib.utilities.Utils;
import lib.utilities.Validations;
import lib.json.org.json.JSONObject;
import lib.json.org.json.JSONException;


/**
 * Created by paycores.com on 18/12/17.
 *
 * clase creada para enviar una peticion post al servicio de sendcode que envia el codigo
 * de segurdad al correo del cliente
 */
public class PayCoresSendCode {
    private static Http http;
    private static String[] get, post;
    private static JSONObject objeto;

    /**
     * Constructor donde se solicita los datos necesarios para enviar el correo con el codigo de verificacion
     * @param purchaseData - PurchaseData obtenido anteriormente con la clase PaycoresGenPurchaseCode
     * @param email - email del cliente que se le va enviar el codigo de seguridad
     * @param namePerson - nombre del cliente
     * @throws PaycoresExceptions - se validan estos campos y si es el caso se lanza la excepcion
     * @throws JSONException -
     */
    public PayCoresSendCode(String purchaseData, String email, String namePerson) throws PaycoresExceptions, JSONException {

        Validations.validateIsNotEmpty(purchaseData,"SendCode.PurchaseData");
        if(Validations.validateIsNotEmpty(email,"SendCode.email")){
            Validations.validateEmail(email,"SendCode.email");
        }
        Validations.validateIsNotEmpty(namePerson,"SendCode.namePerson");
        JSONObject data = new JSONObject();
        data.put("data", purchaseData);
        data.put("user", email);
        data.put("name", namePerson);
        this.objeto = data;
        sendCodeByEmail();
    }

    /**
     * Se envia en este metodo la peticion post con los datos ingresados del cliente y el purchaseCode
     */
    public static void sendCodeByEmail(){
        String params = "";
        try {
            http = new Http();
            params = Utils.iteratorObjectPOST(objeto);
            post = http.sendPost(Utils.urlServer("SENDCODE"), params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




