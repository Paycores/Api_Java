package lib.beans;

import lib.json.org.json.JSONObject;
import lib.json.org.json.JSONException;

/**
 * Created by paycores.com on 20/06/17.
 * <p>
 * Objeto que contiene todos los datos de la direccion y informacion personal del usuario
 * este objeto tiene que ser agregado como un json al objeto person (para esto usar el
 * metodo getAllAddressData que devuelve un json con la informacion)
 */
public class AddressData {
    private String apiCity;             // string
    private String apiState;            // string
    private String apiCountryCode;      // string
    private String apiPhoneNumber;      // string
    private String apiCellPhoneNumber;  // string
    private String apiEmail;            // string
    private String apiPostalCode;       // string

    /**
     * Metodo tipo constructor para llenar el objeto, la descripcion de los datos estan con cada set
     */
    public void setAllAddressData(String apiCity, String apiState, String apiCountryCode, String apiPhoneNumber,
                                  String apiCellPhoneNumber, String apiEmail, String apiPostalCode) {
        this.apiCity = apiCity;
        this.apiState = apiState;
        this.apiCountryCode = apiCountryCode;
        this.apiPhoneNumber = apiPhoneNumber;
        this.apiCellPhoneNumber = apiCellPhoneNumber;
        this.apiEmail = apiEmail;
        this.apiPostalCode = apiPostalCode;
    }

    /**
     * metodo para guardar toda la informacion del objeto en un json
     *
     * @return - retorna un JSON con la informacion de la direccion
     */
    public JSONObject getAllAddressData() {
        JSONObject getAll = new JSONObject();
        try {
            getAll.put("apiCity", apiCity);
            getAll.put("apiState", apiState);
            getAll.put("apiCountryCode", apiCountryCode);
            getAll.put("apiPhoneNumber", apiPhoneNumber);
            getAll.put("apiCellPhoneNumber", apiCellPhoneNumber);
            getAll.put("apiEmail", apiEmail);
            getAll.put("apiPostalCode", apiPostalCode);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getAll;
    }


    /**
     * metodo para settear al objeto la ciudad
     * OJO - el string no debe ser mayor a 28 (tamaño)
     *
     * @param apiCity - String con la ciudad
     */
    public void setApiCity(String apiCity) {
        this.apiCity = apiCity;
    }

    /**
     * metodo para settear al objeto el estado (ubicacion)
     * OJO - el string no debe ser mayor a 15 (tamaño)
     *
     * @param apiState - String con el estado
     */

    public void setApiState(String apiState) {
        this.apiState = apiState;
    }

    /**
     * metodo para settear el codigo del pais por ejemplo "CO" (colombia)
     *
     * @param apiCountryCode - string con el codigo del pais
     */

    public void setApiCountryCode(String apiCountryCode) {
        this.apiCountryCode = apiCountryCode;
    }

    /**
     * metodo para setterar el telefono del usuario
     *
     * @param apiPhoneNumber - String con el telefono
     */
    public void setApiPhoneNumber(String apiPhoneNumber) {
        this.apiPhoneNumber = apiPhoneNumber;
    }

    /**
     * metodo para setterar el telefono celular del usuario
     *
     * @param apiCellPhoneNumber - String con el telefono celular
     */
    public void setApiCellPhoneNumber(String apiCellPhoneNumber) {
        this.apiCellPhoneNumber = apiCellPhoneNumber;
    }

    /**
     * metodo que settea el email del usuario
     * OJO - se valida que sea un email bien construido (example@dominio.co)
     *
     * @param apiEmail - String con el email
     */
    public void setApiEmail(String apiEmail) {
        this.apiEmail = apiEmail;
    }

    /**
     * metodo que setta el postalCode
     * OJO - es un string con solo numeros y maximo 6
     *
     * @param apiPostalCode - String con el postalCode
     */
    public void setApiPostalCode(String apiPostalCode) {
        this.apiPostalCode = apiPostalCode;
    }


    public String getApiCity() {
        return apiCity;
    }

    public String getApiState() {
        return apiState;
    }

    public String getApiCountryCode() {
        return apiCountryCode;
    }

    public String getApiPhoneNumber() {
        return apiPhoneNumber;
    }

    public String getApiCellPhoneNumber() {
        return apiCellPhoneNumber;
    }

    public String getApiEmail() {
        return apiEmail;
    }

    public String getApiPostalCode() {
        return apiPostalCode;
    }
}
