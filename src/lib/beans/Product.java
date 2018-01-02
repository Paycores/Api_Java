package lib.beans;

import lib.json.org.json.JSONObject;
import lib.json.org.json.JSONException;

/**
 * Created by paycores.com on 20/06/17.
 * <p>
 * objeto que tiene el resto de la informacion del good o imformacion base de un producto
 */
public class Product {
    private int apiItem;
    private String apiCode;
    private String apiAmount;
    private String apiPromotionCode;

    /**
     * Metodo tipo constructor para llenar el objeto
     *
     * @param apiItem          - entero con el item del producto
     * @param apiCode          - String con el codigo del producto
     * @param apiAmount        - String con el valor total de compra - valor monetario (000.00)
     * @param apiPromotionCode - String con el codigo promocional ( no se esta teniendo en cuenta
     *                         se puede dejar vacio )
     */
    public void setAllProduct(int apiItem, String apiCode, String apiAmount, String apiPromotionCode) {
        this.apiItem = apiItem;
        this.apiCode = apiCode;
        this.apiAmount = apiAmount;
        this.apiPromotionCode = apiPromotionCode;
    }

    /**
     * Metodo que retorna en un json toda la informacion del objeto
     *
     * @return - Json con la informacion del objeto
     */
    public JSONObject getAllProduct() {
        JSONObject getAll = new JSONObject();
        try {
            getAll.put("apiItem", apiItem);
            getAll.put("apiCode", apiCode);
            getAll.put("apiAmount", apiAmount);
            getAll.put("apiPromotionCode", apiPromotionCode);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getAll;
    }

    public int getApiItem() {
        return apiItem;
    }

    /**
     * setter con el item del producto
     * OJO no debe ser mayor a 10 (tamaño)
     *
     * @param apiItem - Entero con el item del producto
     */
    public void setApiItem(int apiItem) {
        this.apiItem = apiItem;
    }

    public String getApiCode() {
        return apiCode;
    }

    /**
     * Setter con el codigo del producto
     * OJO no debe ser mayor a 10 (tamaño)
     *
     * @param apiCode - String con el codigo del producto
     */
    public void setApiCode(String apiCode) {
        this.apiCode = apiCode;
    }

    public String getApiAmount() {
        return apiAmount;
    }

    /**
     * setter con el valor total de la compra
     * OJO Este valor es numerico (000.00)
     *
     * @param apiAmount - String con valor total del producto
     */
    public void setApiAmount(String apiAmount) {
        this.apiAmount = apiAmount;
    }

    public String getApiPromotionCode() {
        return apiPromotionCode;
    }

    /**
     * setter con el codigo promocional
     * OJO este valor se puede dejar vacio ya que no se esta teniendo en cuenta ( "" )
     *
     * @param apiPromotionCode
     */
    public void setApiPromotionCode(String apiPromotionCode) {
        this.apiPromotionCode = apiPromotionCode;
    }
}
