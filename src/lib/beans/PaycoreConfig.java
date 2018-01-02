package lib.beans;

import lib.exception.ErrorsEnum;
import lib.exception.PaycoresExceptions;
import lib.json.org.json.JSONObject;

import java.util.Arrays;

import static lib.utilities.Utils.*;

/**
 * Created by paycores.com on 14/06/17.
 *
 * Objeto de configuracion donde se settearan todos los parametros de configuracion necesarios
 * OJO no dejar vacio el CodeSecureForm que es enviado al correo del cliente
 */
public class PaycoreConfig {

    private static String paycores_environment;
    private static String paycores_access_key;
    private static String paycores_access_login;
    private static String paycores_CommerceID;
    private static String paycores_url_res;
    private static String paycores_url_conf;
    private static String codeSecureForm;


    /**
     * Devuelve el json con toda la informacion de configuracion
     * @return - Json con la toda la informacion de configuracion debe tener seteado el CodeSecureForm
     */
    public static JSONObject getAllConfig(){
        JSONObject getAll = new JSONObject();
        try {
            getAll.put("paycores_environment",paycores_environment);
            getAll.put("paycores_access_key",paycores_access_key);
            getAll.put("paycores_access_login",paycores_access_login);
            getAll.put("paycores_CommerceID",paycores_CommerceID);
            getAll.put("paycores_url_res",paycores_url_res);
            getAll.put("paycores_url_conf",paycores_url_conf);
            getAll.put("codeSecureForm",codeSecureForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getAll;
    }

    public static String getPaycores_environment() {
        return paycores_environment;
    }

    public String getPaycores_access_key() {
        return paycores_access_key;
    }

    public String getPaycores_access_login() {
        return paycores_access_login;
    }

    public String getPaycores_CommerceID() {
        return paycores_CommerceID;
    }

    public String getPaycores_url_res() {
        return paycores_url_res;
    }

    public String getPaycores_url_conf() {
        return paycores_url_conf;
    }

    /**
     * Set del codigo de seguridad enviado al correo
     * @param codeSecureForm - Codigo de seguridad enviado al correo necesario para la transaccion
     */
    public void setCodeSecureForm(String codeSecureForm) {
        PaycoreConfig.codeSecureForm = codeSecureForm;
    }

    public String getCodeSecureForm() {
        return codeSecureForm;
    }

    /**
     * setea el tipo de ambiente que se va usar
     * @param paycores_environment - String con el numero del ambiente
     * @throws PaycoresExceptions - se valida si es un tipo de ambiente existente
     */
    public void setPaycores_environment(String paycores_environment) throws PaycoresExceptions {
        if (Arrays.asList(PAYCORE_ENVIRONMENT).contains(paycores_environment)) {
            PaycoreConfig.paycores_environment = paycores_environment;
        } else {
             throw new PaycoresExceptions("paycores_environment", ErrorsEnum.INVALID_ENVIORONMENT);
        }
    }

    /**
     * setter del el access key suminitrado por paycores.com, unico
     * @param paycores_access_key - String con el access key suminitrado por paycores.com, unico
     */
    public void setPaycores_access_key(String paycores_access_key) {
        PaycoreConfig.paycores_access_key = paycores_access_key;
    }

    /**
     * setter del access login suministrado por paycores.com
     * @param paycores_access_login - String con el access login suministrado por paycores.com
     */
    public void setPaycores_access_login(String paycores_access_login) {
        PaycoreConfig.paycores_access_login = paycores_access_login;
    }

    /**
     * setter del CommerceID suminstrado por paycores.com
     * @param paycores_CommerceID - String con el CommerceID
     */
    public void setPaycores_CommerceID(String paycores_CommerceID) {
        PaycoreConfig.paycores_CommerceID = paycores_CommerceID;
    }

    /**
     * setter con la url de redirrecion sobre su front-end
     * @param paycores_url_res - string con la ubicacion la pagina de redirrecccion
     */
    public void setPaycores_url_res(String paycores_url_res) {
        PaycoreConfig.paycores_url_res = paycores_url_res;
    }

    /**
     * setter con la url de la pagina de confirmacion en su frond-end
     * @param paycores_url_conf - String con la ubicacion de la pagina de confirmacion
     */
    public void setPaycores_url_conf(String paycores_url_conf) {
        PaycoreConfig.paycores_url_conf = paycores_url_conf;
    }
}
