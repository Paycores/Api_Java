package lib.beans;

import lib.json.org.json.JSONObject;
import lib.json.org.json.JSONException;

/**
 * Created by paycores.com on 20/06/17.
 *
 * objeto con toda la informacion relevante de la transaccion
 */
public class PurchaseData {
    private String apiPurchaseCode; // string
    private String apiCurrencyCode; // String
    private String apiTotalAmount; // string
    private int apiQuotaId; // int
    private String apiIva; // string
    private String apiIvaReturn; // string

    /**
     * @author Carlos Esteban Montealegre
     *
     * Se crean todos los setters para poder ir llenando el objeto como se necesite
     *
     */

    public void setApiPurchaseCode(String apiPurchaseCode) {
        this.apiPurchaseCode = apiPurchaseCode;
    }


    public void setApiCurrencyCode(String apiCurrencyCode) {
        this.apiCurrencyCode = apiCurrencyCode;
    }

    public void setApiTotalAmount(String apiTotalAmount) {
        this.apiTotalAmount = apiTotalAmount;
    }

    public void setApiQuotaId(int apiQuotaId) {
        this.apiQuotaId = apiQuotaId;
    }

    public void setApiIva(String apiIva) {
        this.apiIva = apiIva;
    }

    public void setApiIvaReturn(String apiIvaReturn) {
        this.apiIvaReturn = apiIvaReturn;
    }


    /**
     * Metodo tipo constructor para llenar el objeto
     * @param apiCurrencyCode - String con el codigo de la moneda ( COP or USD )
     * @param apiTotalAmount - String con el total de la compra
     * @param apiPurchaseCode - String con el PurschaseCode que lo devuelve el metodo de la clase
     *                        PaycoresGenPurchaseCode
     * @param apiQuotaId - Entero con el numero de cuotas de la compra
     * @param apiIva - String con el iva de la compra OJO valor monetario (000.00)
     * @param apiIvaReturn - String con el retorno del iva OJO valor monetario(000.00)
     */
    public void setAllPurchaseData(String apiCurrencyCode, String apiTotalAmount, String apiPurchaseCode,
                                   int apiQuotaId, String apiIva, String apiIvaReturn){

        this.apiCurrencyCode    = apiCurrencyCode;
        this.apiTotalAmount     = apiTotalAmount;
        this.apiPurchaseCode    = apiPurchaseCode;
        this.apiQuotaId         = apiQuotaId;
        this.apiIva             = apiIva;
        this.apiIvaReturn       = apiIvaReturn;
    }

    /**
     * Este metodo lo usamos para sacar toda la informacion en un JSON lo cual lo hace mas facil de trabajar
     *
     * @return - Json con toda la informacion del objeto
     */
    public JSONObject getAllPurchaseData(){
        JSONObject getAll = new JSONObject();
        try {
            getAll.put("apiCurrencyCode",   apiCurrencyCode);
            getAll.put("apiTotalAmount",    apiTotalAmount);
            getAll.put("apiPurchaseCode",   apiPurchaseCode);
            getAll.put("apiQuotaId",        apiQuotaId);
            getAll.put("apiIva",            apiIva);
            getAll.put("apiIvaReturn",      apiIvaReturn);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getAll;
    }

    public String getApiPurchaseCode() {
        return apiPurchaseCode;
    }

    public String getApiCurrencyCode() {
        return apiCurrencyCode;
    }

    public String getApiTotalAmount() {
        return apiTotalAmount;
    }

    public int getApiQuotaId() {
        return apiQuotaId;
    }

    public String getApiIva() {
        return apiIva;
    }

    public String getApiIvaReturn() {
        return apiIvaReturn;
    }
}
