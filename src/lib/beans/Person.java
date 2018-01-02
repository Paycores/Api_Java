package lib.beans;

import lib.json.org.json.JSONObject;
import lib.json.org.json.JSONException;

import java.util.Iterator;

/**
 * Created by pacores.com on 20/06/17.
 *
 * objeto de tipo persona que lleva todos los datos del cliente
 */
public class Person {
    private String      apiNames;
    private String      apiLastNames;
    private String      apiNumberIdentifier;
    private String      apiGender;
    private JSONObject  apiDataAddress; // objeto AddressData
    private String      apiAddress;
    private String      apiBirthday;
    private String      apiNationality;

    /**
     * metodo tipo constructor para llenar el objeto
     *
     * @param apiNames            - String con los nombres del cliente
     * @param apiLastNames        - String con los apellidos del cliente
     * @param apiNumberIdentifier - String con el numero de identificacion del cliente
     * @param apiGender           - String con el Genero del cliente
     * @param apiDataAddress      - JSON con los datos del DataAddres (para esto usar addressData.getAllAddressData())
     * @param apiAddress          - String con la direccion del cliente
     * @param apiBirthday         - String con la fecha de nacimiento OJO usar el formater de la clase utils suministrada por nosotros
     * @param apiNationality      - String con la nacionalidad del cliente
     */
    public void setAllPerson(String apiNames, String apiLastNames, String apiNumberIdentifier, String apiGender,
                             JSONObject apiDataAddress, String apiAddress, String apiBirthday, String apiNationality) {

        this.apiNames = apiNames;
        this.apiLastNames = apiLastNames;
        this.apiNumberIdentifier = apiNumberIdentifier;
        this.apiGender = apiGender;
        this.apiDataAddress = apiDataAddress;
        this.apiAddress = apiAddress;
        this.apiBirthday = apiBirthday;
        this.apiNationality = apiNationality;
    }

    /**
     * Devuelve un JSON con toda la informacion de la persona
     */
    public JSONObject getAllPerson() {
        JSONObject getAll = new JSONObject();
        try {
            getAll.put("apiNames", apiNames);
            getAll.put("apiLastNames", apiLastNames);
            getAll.put("apiNumberIdentifier", apiNumberIdentifier);
            getAll.put("apiGender", apiGender);
            getAll.put("apiDataAddress", apiDataAddress);
            getAll.put("apiAddress", apiAddress);
            getAll.put("apiBirthday", apiBirthday);
            getAll.put("apiNationality", apiNationality);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getAll;
    }

    /**
     * setter con los nombres del cliente
     * OJO - no debe ser mayor a 20 (tamaño)
     *
     * @param apiNames - String con los nombres del cliente
     */
    public void setApiNames(String apiNames) {
        this.apiNames = apiNames;
    }

    /**
     * setter con los apellidos del cliente
     *
     * @param apiLastNames - String con los apellidos del cliente
     */
    public void setApiLastNames(String apiLastNames) {
        this.apiLastNames = apiLastNames;
    }

    /**
     * setter con el numero de identifiacion del cliente
     * OJO no puede ser mayor a 12 (tamaño)
     * OJO tiene que ser una cadena de solo numeros
     *
     * @param apiNumberIdentifier - String con el numero de identificacion del cliente
     */
    public void setApiNumberIdentifier(String apiNumberIdentifier) {
        this.apiNumberIdentifier = apiNumberIdentifier;
    }

    /**
     * Setter con el genero del usuario
     * OJO solo debe ser la letra del genero ( M or F )
     *
     * @param apiGender - String con el Genero del cliente
     */
    public void setApiGender(String apiGender) {
        this.apiGender = apiGender;
    }

    /**
     * setter con la direccion del cliente
     * OJO debe ser un json del objeto dataAddress
     *
     * @param apiDataAddress - JSON con los datos del DataAddres (para esto usar addressData.getAllAddressData())
     */
    public void setApiDataAddress(JSONObject apiDataAddress) {
        this.apiDataAddress = apiDataAddress;
    }

    /**
     * setter de la direccion del cliente
     * OJO la cadena no debe ser mayor a 50 (tamaño)
     *
     * @param apiAddress - String con la direccion del cliente
     */
    public void setApiAddress(String apiAddress) {
        this.apiAddress = apiAddress;
    }

    /**
     * setter con la fecha de nacimiento del usuario
     * OJO si no uso el formater que esta en utils debe ir (yyyy-MM-dd)
     *
     * @param apiBirthday - String con la fecha de nacimiento OJO usar el formater de la clase
     *                    utils suministrada por nosotros
     */
    public void setApiBirthday(String apiBirthday) {
        this.apiBirthday = apiBirthday;
    }

    /**
     * setter con la nacionalidad  del usuario
     * OJO debe ser tambien el codigo del pais ( CO )
     *
     * @param apiNationality - String con la nacionalidad del cliente
     */
    public void setApiNationality(String apiNationality) {
        this.apiNationality = apiNationality;
    }

    public String getApiNames() {
        return apiNames;
    }

    public String getApiLastNames() {
        return apiLastNames;
    }

    public String getApiNumberIdentifier() {
        return apiNumberIdentifier;
    }

    public String getApiGender() {
        return apiGender;
    }

    public JSONObject getApiDataAddress() {
        return apiDataAddress;
    }

    public String getApiAddress() {
        return apiAddress;
    }

    public String getApiBirthday() {
        return apiBirthday;
    }

    public String getApiNationality() {
        return apiNationality;
    }
}
