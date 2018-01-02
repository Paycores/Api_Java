package lib.beans;

import lib.json.org.json.JSONObject;
import lib.json.org.json.JSONException;

/**
 * Created by paycores.com on 20/06/17.
 * <p>
 * objeto donde se encuentran los datos del producto que extiende de la clase product (la cual esta compuesta
 * por mas informacion del producto)
 */
public class Good extends Product {
    private String apiName;
    private String apiDescription;
    private int apiQuantity;
    private String apiUnitPrice;

    /**
     * Metodo tipo constructor para llenar el objeto
     *
     * @param apiName - String con el nombre del producto
     * @param apiDescription - String con la Descripcion del producto
     * @param apiQuantity - String con la cantidad del producto
     * @param apiUnitPrice - String con el valor unitario de este producto
     * @param apiItem - Entero con el item del producto
     * @param apiCode - String con el codigo del producto
     * @param apiAmount - String con el valor total del producto - Valor monetario (000.00)
     * @param apiPromotionCode - String con el codigo promocional (no se esta teniendo en cuenta)
     */
    public void setGood(String apiName, String apiDescription, int apiQuantity, String apiUnitPrice, int apiItem,
                        String apiCode, String apiAmount, String apiPromotionCode) {
        this.apiName = apiName;
        this.apiDescription = apiDescription;
        this.apiQuantity = apiQuantity;
        this.apiUnitPrice = apiUnitPrice;
        this.setApiItem(apiItem);
        this.setApiCode(apiCode);
        this.setApiAmount(apiAmount);
        this.setApiPromotionCode(apiPromotionCode);
    }

    /**
     * Metodo que devuelve un Json con toda la informacion del objeto
     *
     * @return - JSON CON TODA LA INFORMACION
     */
    public JSONObject getAllGood() {
        JSONObject getAll = new JSONObject();
        try {
            getAll.put("apiName", apiName);
            getAll.put("apiDescription", apiDescription);
            getAll.put("apiQuantity", apiQuantity);
            getAll.put("apiUnitPrice", apiUnitPrice);
            getAll.put("apiItem", getApiItem());
            getAll.put("apiCode", getApiCode());
            getAll.put("apiAmount", getApiAmount());
            getAll.put("apiPromotionCode", getApiPromotionCode());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getAll;
    }

    /**
     * setter del nombre del prodcuto.
     * OJO no debe ser mayor a 20 (tamaño)
     * @param apiName - String con el nombre del producto
     */
    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    /**
     * Setter de la descripcion del producto
     * OJO no debe ser mayor a 20 (tamaño)
     * @param apiDescription - String de la descripcion del producto
     */
    public void setApiDescription(String apiDescription) {
        this.apiDescription = apiDescription;
    }

    /**
     * Setter de la cantidad del producto
     * @param apiQuantity - entero con la cantidad del producto
     */
    public void setApiQuantity(int apiQuantity) {
        this.apiQuantity = apiQuantity;
    }

    /**
     * Setter del valor unitario del producto
     * OJO debe cumplir con la condicion de modena (000.00)
     * @param apiUnitPrice - String con el valor unitario del producto
     */
    public void setApiUnitPrice(String apiUnitPrice) {
        this.apiUnitPrice = apiUnitPrice;
    }

    public String getApiName() {
        return apiName;
    }

    public String getApiDescription() {
        return apiDescription;
    }

    public int getApiQuantity() {
        return apiQuantity;
    }

    public String getApiUnitPrice() {
        return apiUnitPrice;
    }
}
