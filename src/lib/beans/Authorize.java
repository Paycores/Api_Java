package lib.beans;

import lib.exception.PaycoresExceptions;
import lib.utilities.Validations;
import lib.json.org.json.JSONObject;
import lib.json.org.json.JSONException;

/**
 * Created by paycores.com on 20/06/17.
 * <p>
 * objeto que reune toda la informacion de los demas objetos y debe ser enviado para crear la orden o
 * tranferecia final, este objeto se compone de todos los objetos creados y tambien lanza la validacion en su constructor
 * de todos los campos
 */
public class Authorize {
    private PurchaseData apiPurchaseData;
    private CardData apiCardData;
    private Person apiPerson;
    private Good apiGood;
    private PaycoreConfig apiConfig;
    private AddressData addressData;

    /**
     * Constructor obligatorio para llenar el objeto con los objetos, aqui se hace la validacion de todos los campos
     * por eso se debe dejar para el final para que se puedan tener todos los datos
     */
    public Authorize(PurchaseData apiPurchaseData, CardData apiCardData, Person apiPerson, Good apiGood,
                     PaycoreConfig apiConfig, AddressData addressData) throws PaycoresExceptions {

        this.apiPurchaseData = apiPurchaseData;
        this.apiCardData = apiCardData;
        this.apiPerson = apiPerson;
        this.apiGood = apiGood;
        this.apiConfig = apiConfig;
        this.addressData = addressData;

        if (Validations.validatedataObjects(addressData, apiCardData, apiGood, apiPerson, apiPurchaseData, apiConfig)) {
            System.out.println("Todas las validaciones son correctas");
        }
    }

    /**
     * Devuelve en un JSON toda la informacion que debe tener el authorize compuesto por
     * otros json y este json es el que se necesita para la clase PaycoresCreateOrder
     */
    public JSONObject getALLData() {
        JSONObject getAll = new JSONObject();

        try {
            getAll.put("apiPurchaseData", apiPurchaseData.getAllPurchaseData());
            getAll.put("apiCardData", apiCardData.getAllCardData());
            getAll.put("apiBillingData", apiPerson.getAllPerson());
            getAll.put("apiGood", apiGood.getAllGood());
            getAll.put("apiConfiguration", apiConfig.getAllConfig());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getAll;
    }
}
