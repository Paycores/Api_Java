package lib.beans;

import lib.json.org.json.JSONObject;
import lib.json.org.json.JSONException;

/**
 * Created by paycores.com on 20/06/17.
 * <p>
 * objeto con todos los datos que componen la tarjeta
 */
public class CardData {
    private String apiBrand;
    private String apiNumber;
    private int apiExpiryMonth;
    private int apiExpiryYear;
    private int apiAccountTypeId;
    private String apiSecurityCode;
    private String apiCardName;


    /**
     * Metodo hecho para llenar el objeto mas facil tipo constructor
     */
    public void setAllCardData(String apiBrand, String apiNumber, int apiExpiryMonth, int apiExpiryYear, int apiAccountTypeId, String apiSecurityCode, String apiCardName) {
        this.apiBrand = apiBrand;
        this.apiNumber = apiNumber;
        this.apiExpiryMonth = apiExpiryMonth;
        this.apiExpiryYear = apiExpiryYear;
        this.apiAccountTypeId = apiAccountTypeId;
        this.apiSecurityCode = apiSecurityCode;
        this.apiCardName = apiCardName;
    }

    /**
     * Metodo hecho para sacar toda la informacion del objeto en un json, toda la informacion de los parametros
     * en los setters
     *
     * @return - Json con toda la informacion de la tarjeta
     */
    public JSONObject getAllCardData() {
        JSONObject getAll = new JSONObject();
        try {
            getAll.put("apiBrand", apiBrand);
            getAll.put("apiNumber", apiNumber);
            getAll.put("apiExpiryMonth", apiExpiryMonth);
            getAll.put("apiExpiryYear", apiExpiryYear);
            getAll.put("apiAccountTypeId", apiAccountTypeId);
            getAll.put("apiSecurityCode", apiSecurityCode);
            getAll.put("apiCardName", apiCardName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getAll;
    }

    /**
     * setter del brand de la tarjeta.
     * OJO debe ser maximo de 10 (tamaño)
     *
     * @param apiBrand - String con el brand de la tarjeta
     */
    public void setApiBrand(String apiBrand) {
        this.apiBrand = apiBrand;
    }

    /**
     * setter del Numero de la tarjeta.
     * OJO debe ser un string solo con digitos
     *
     * @param apiNumber - String con el numero de la tarjeta
     */
    public void setApiNumber(String apiNumber) {
        this.apiNumber = apiNumber;
    }

    /**
     * setter del mes en que expira la tarjeta.
     * OJO es un numero de solo 2 digitos
     *
     * @param apiExpiryMonth - Numero con el mes que expira la tarjeta
     */
    public void setApiExpiryMonth(int apiExpiryMonth) {
        this.apiExpiryMonth = apiExpiryMonth;
    }

    /**
     * setter del año en que expira la tarjeta.
     * OJO es un numero de solo 2 digitos
     *
     * @param apiExpiryYear - Numero con el año en que expira la tarjeta
     */
    public void setApiExpiryYear(int apiExpiryYear) {
        this.apiExpiryYear = apiExpiryYear;
    }

    /**
     * setter del AccountTypeId
     *
     * @param apiAccountTypeId - numero con el apiAccountTypeId
     */
    public void setApiAccountTypeId(int apiAccountTypeId) {
        this.apiAccountTypeId = apiAccountTypeId;
    }

    /**
     * setter con el codigo de seguridad de la tarjeta.
     * OJO debe ser un valor numerico.
     *
     * @param apiSecurityCode - String con el codigo de seguridad de la tarjeta
     */
    public void setApiSecurityCode(String apiSecurityCode) {
        this.apiSecurityCode = apiSecurityCode;
    }

    /**
     * setter del nombre del dueño de la tarjeta no el brand
     *
     * @param apiCardName - String con el nombre del dueño de la tarjeta
     */
    public void setApiCardName(String apiCardName) {
        this.apiCardName = apiCardName;
    }

    public String getApiBrand() {
        return apiBrand;
    }

    public String getApiNumber() {
        return apiNumber;
    }

    public int getApiExpiryMonth() {
        return apiExpiryMonth;
    }

    public int getApiExpiryYear() {
        return apiExpiryYear;
    }

    public int getApiAccountTypeId() {
        return apiAccountTypeId;
    }

    public String getApiSecurityCode() {
        return apiSecurityCode;
    }

    public String getApiCardName() {
        return apiCardName;
    }
}
