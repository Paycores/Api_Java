package lib.utilities;

import lib.beans.PaycoreConfig;
import lib.json.org.json.JSONObject;
import lib.json.org.json.JSONException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

/**
 * Variables globales de la libreria y metodos utilitarios
 * Created by paycores-02 on 13/06/17.
 */
public class Utils {
    public static final String TAG_USER_AGENT = "User-Agent";
    public static final String TAG_GET = "GET";
    public static final String TAG_POST = "POST";
    public static final String TAG_DATA = "data";

    // URLS PARA CONSUMIR LOS SERVICIOS
    private static final String TAG_URL_API_GEN_PURCODE = "/business-tools/genPurCodeApi/";
    private static final String TAG_URL_API_SENDCODE = "/business-tools/sendCodeBuyClientApi";
    private static final String TAG_URL_API_TRANSFER = "/web-checkout/paycoresTransfer";
    private static final String TAG_URL_API_VALIDATE_CODE = "/business-tools/validateCodeApi";

    public static final String USER_AGENT = "Mozilla/5.0";
    public static final String TAG_PAYCORES_TYPE = "paycoresType";
    public static final String PAYCORES_TYPE = "JAVA";

    /**
     * 1 para pruebas 2 para real
     */
    public static final String[] PAYCORE_ENVIRONMENT = {"1", "2"};


    /**
     * Metodo diseñado para devolver la url correcta de pruebas o entorno de produccion
     * @param serviceName - el nombre del servicio
     * @return - la url completa del servicio
     */
    public static String urlServer(String serviceName){
        String TAG_URL_SERVER = Integer.parseInt(PaycoreConfig.getPaycores_environment()) == 1 ? "https://sandbox.paycores.com" : "https://business.paycores.com";
        String url = "";
        if(serviceName.equals("GEN_PURCODE")) {
            url = TAG_URL_SERVER + TAG_URL_API_GEN_PURCODE;
            return url;
        }
        if(serviceName.equals("SENDCODE")) {
            url = TAG_URL_SERVER + TAG_URL_API_SENDCODE;
            return url;
        }
        if(serviceName.equals("TRANSFER")) {
            url = TAG_URL_SERVER + TAG_URL_API_TRANSFER;
            return url;
        }
        if(serviceName.equals("VALIDATE_CODE")) {
            url = TAG_URL_SERVER + TAG_URL_API_VALIDATE_CODE;
            return url;

        }
        return url;
    }
    /**
     * este metodo se hizo para poder iterar los datos de un json y organizarlos como
     * parametros post y asi poderlos agregar a una peticion post
     *
     * @param objeto - Objeto JSON a iterar
     * @return - String con los datos organziados en parametros
     */
    public static String iteratorObjectPOST(JSONObject objeto) {
        String params = "";
        try {

            Iterator<String> keys = objeto.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                String dato = String.valueOf(objeto.get(key));
                params += convertPost(key, dato);
            }
            return params;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return params;
    }

    /**
     * Este metodo ayuda reescribir los datos que vienen del json para mandarlos al servicio
     *
     * @param llave - el key
     * @param valor - el valor
     * @return
     */
    private static String convertPost(String llave, String valor) {
        return llave + "=" + valor + "&";
    }

    /**
     * Da el formato de la fecha que solicitamos para ser enviada
     *
     * @param dayOfMonth - dia del mes
     * @param month      - mes del año
     * @param year       - año
     * @return - una cadena con la fecha formateada correctamente
     */
    public static String dateFormatBirthday(int dayOfMonth, int month, int year) {

        LocalDate today = LocalDate.of(year, month, dayOfMonth);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return formatter.format(today);
    }
}
