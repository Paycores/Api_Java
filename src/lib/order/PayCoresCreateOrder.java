package lib.order;

import lib.conection.Http;
import lib.utilities.Utils;
import lib.json.org.json.JSONObject;


/**
 * paycores.com 18/12/2017
 *
 * Clase desarrollada para atender la ultima peticion
 * que envia todos los datos por post y servicio de la transaccion
 * donde es validado y por ultimo confirmado, esta clase ve a dejar con
 * un system.out.print de la respuesta del servicio ya que es necesario
 * para saber que paso con la transaccion
 *
 */
public class PayCoresCreateOrder {
    private static Http http;
    private static String[] get, post;

    /**
     * Metodo que obtiene el JSON con toda la informacion resultante del metodo authorize.getALLData
     * que gracias ya viene validado, este metodo envia el objeto por un peticion post que
     * esta esperando el servicio este es el ultimo metodo que debe usarse en toda la transaccion
     * @param authorizeAllData - JSON con toda la informacion de los objetos
     */
    public static void createOder(JSONObject authorizeAllData){

        String params = "";

        try {
            http = new Http();
            String data = authorizeAllData.toString();
            params = convertPost(data);
            //System.out.println("params = " + params);
            post = http.sendPost(Utils.urlServer("TRANSFER"), params);
            System.out.println("RESULT POST CREATE_ORDER ----> " + post[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * metodo que emcapsula el json en un String para ser emviado en la peticion
     * @param data - String del json (authorizeAllData.toString())
     * @return - el string con el tag apropiado
     */
    private static String convertPost(String data){
        return Utils.TAG_DATA + "=" + data + "&";
    }
}

