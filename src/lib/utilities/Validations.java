package lib.utilities;

import lib.beans.PaycoreConfig;
import lib.beans.*;
import lib.exception.ErrorsEnum;
import lib.exception.PaycoresExceptions;
import lib.json.org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by paycores.com on 18/12/17.
 *
 * Esta clase se creo para poder manejar una serie de validaciones y controlar las excepciones
 */

public class Validations {


    /**
     * se valida el tamaño del json para saber si esta vacío, ojo hacer mas validaciones para
     * el json especifico como sus keys y demas
     * @param objeto - json que se va a validar
     * @throws Exception - la excepcion que queremos mostrar si el json esta vacio
     */
    public static void validarJSON(JSONObject objeto) throws Exception {
        if (objeto.length() <= 0) {
            throw new Exception("El JSON está vacío");
        }
    }

    /**
     * Metodo que valida las cadenas si son vacias o nulas
     *
     * @param data - cadena a validar
     * @param name - nombre del campo para mandarlo hasta la excepcion
     * @return - boolean con la verificacion
     * @throws PaycoresExceptions - Clase donde se manejara las excepciones personalizadas
     */
    public static boolean validateIsNotEmpty(String data, String name) throws PaycoresExceptions {
        boolean status;
        if (data == null || "".equals(data)) {
            throw new PaycoresExceptions(name, ErrorsEnum.EMPTY_OR_NULL_DATA);
        } else {
            status = true;
        }
        return status;
    }

    /**
     * valida el tamaño de la cadena
     *
     * @param length - valor maximo que puede tener la cadena
     * @return - verdadero si el dato es valido
     * @throws PaycoresExceptions - excepcion personalizada
     */
    public static boolean validateStringLength(String data, String name, int length) throws PaycoresExceptions {
        boolean status;

        if (data.length() > length) {
            throw new PaycoresExceptions(name, ErrorsEnum.LENGTH_ERROR);
        } else {
            status = true;
        }
        return status;
    }

    /**
     * valida que los valores de las monedas lleguen con el formato establecido que es 0000.00
     *
     * @param data - dato a validar
     * @param name - nombre para validar en el error
     * @return - verdadero si el dato es valido
     * @throws PaycoresExceptions - excepcion personalizada
     */
    public static boolean validateFormatNumberMoney(String data, String name) throws PaycoresExceptions {
        boolean status;
        Pattern pattern = Pattern.compile("^[0-9]+([.][0-9]{2})");
        Matcher matcher = pattern.matcher(data);
        if (!(matcher.matches())) {
            throw new PaycoresExceptions(name, ErrorsEnum.INVALID_CURRENCY_FORMAT);
        } else {
            status = true;
        }
        return status;
    }

    /**
     * valida el email
     *
     * @param data - dato a validar
     * @param name - nombre para validar en el error
     * @return - verdadero si el dato es valido
     * @throws PaycoresExceptions - excepcion personalizada
     */
    public static boolean validateEmail(String data, String name) throws PaycoresExceptions {
        boolean status;
        Pattern pattern = Pattern.compile("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
        Matcher matcher = pattern.matcher(data);
        if (!(matcher.matches())) {
            throw new PaycoresExceptions(name, ErrorsEnum.INVALID_EMAIL);
        } else {
            status = true;
        }
        return status;

    }

    /**
     * Validamos la fecha que va ingresar y que cumpla con año-mes-dia
     * @param data - dato a validar
     * @param name - nombre para validar en el error
     * @return - verdadero si el dato es valido
     * @throws PaycoresExceptions - excepcion personalizada
     */
    public static boolean validateDate(String data, String name) throws PaycoresExceptions {
        boolean status;
        Pattern pattern = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}");
        Matcher matcher = pattern.matcher(data);
        if (!(matcher.matches())) {
            throw new PaycoresExceptions(name, ErrorsEnum.INVALID_DATE);
        } else {
            status = true;
        }
        return status;
    }

    /**
     * Validamos el año de expiracion de la tarjeta debe ser 4 digitos
     * @param data - dato a validar
     * @param name - nombre para validar en el error
     * @return - verdadero si el dato es valido
     * @throws PaycoresExceptions - excepcion personalizada
     */
    public static boolean validateYearExp(String data, String name) throws PaycoresExceptions {
        boolean status;
        Pattern pattern = Pattern.compile("\\d{4}");
        Matcher matcher = pattern.matcher(data);
        if (!(matcher.matches())) {
            throw new PaycoresExceptions(name, ErrorsEnum.INVALID_DATE);
        } else {
            status = true;
        }
        return status;
    }

    /**
     * Valida si la cadena que llega solo esta compuesta de numeros
     * @param data - cadena que llega para validar
     * @param name - nombre del campo para enviarse al error
     * @return - retorna true si la validacion es correcta
     * @throws PaycoresExceptions - la excepcion personalizasa
     */
    public static boolean validateDateIsNumeric(String data, String name) throws PaycoresExceptions {
        boolean status;
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(data);
        if (!(matcher.matches())) {
            throw new PaycoresExceptions(name, ErrorsEnum.INVALID_NUMERIC);
        } else {
            status = true;
        }
        return status;
    }

    /**
     * valida que el genero sea solo la letra que se pide
     *
     * @param data - dato a validar
     * @param name - nombre para validar en el error
     * @return - verdadero si el dato es valido
     * @throws PaycoresExceptions - excepcion personalizada
     */
    public static boolean validateGender(String data, String name) throws PaycoresExceptions {
        boolean status;
        if (!(data.equals("M") || data.equals("F") )) {
            throw new PaycoresExceptions(name, ErrorsEnum.INVALID_GENDER);
        } else {
            status = true;
        }
        return status;
    }

    /**
     * este metodo se usa en el authorize donde se validan los datos y deja proseguir con la construccion de toda la informacion
     *
     * @param addressData  - objeto de tipo
     * @param cardData     - objeto de tipo addressData
     * @param good         - objeto de tipo cardData
     * @param person       - objeto de tipo good
     * @param purchaseData - objeto de tipo person
     * @param config       - objeto de tipo purchaseData
     * @return - true si todos los datos son validos
     * @throws PaycoresExceptions - excepcion personzalida
     */
    public static boolean validatedataObjects(AddressData addressData, CardData cardData, Good good, Person person,
                                              PurchaseData purchaseData, PaycoreConfig config) throws PaycoresExceptions {

        // validamos el AddressData
        if (Validations.validateIsNotEmpty(addressData.getApiCity(), "apiCity")) {
            Validations.validateStringLength(addressData.getApiCity(), "apiCity", 28);
        }
        if (Validations.validateIsNotEmpty(addressData.getApiState(), "apiState")) {
            Validations.validateStringLength(addressData.getApiState(), "apiState", 15);
        }
        if(Validations.validateIsNotEmpty(addressData.getApiCountryCode(), "apiCountryCode")){
            Validations.validateStringLength(addressData.getApiCountryCode(), "apiCountryCode",2);
        }

        Validations.validateIsNotEmpty(addressData.getApiPhoneNumber(), "apiPhoneNumber");

        Validations.validateIsNotEmpty(addressData.getApiCellPhoneNumber(), "apiCellPhoneNumber");

        if (Validations.validateIsNotEmpty(addressData.getApiEmail(), "apiEmail")) {
            Validations.validateEmail(addressData.getApiEmail(), "apiEmail");
        }
        if (Validations.validateIsNotEmpty(addressData.getApiPostalCode(), "apiPostalCode")) {
            Validations.validateStringLength(addressData.getApiPostalCode(), "apiPostalCode", 6);
            Validations.validateDateIsNumeric(addressData.getApiPostalCode(), "apiPostalCode");
        }

        // validamos el CardData

        if (Validations.validateIsNotEmpty(cardData.getApiBrand(), "apiBrand")) {
            Validations.validateStringLength(cardData.getApiBrand(), "apiBrand", 10);
        }
        if(Validations.validateIsNotEmpty(cardData.getApiNumber(), "ApiNumber")){
            Validations.validateDateIsNumeric(cardData.getApiNumber(), "ApiNumber");
        }
        if(Validations.validateIsNotEmpty(String.valueOf(cardData.getApiExpiryMonth()), "ApiExpiryMonth")){
            Validations.validateStringLength(String.valueOf(cardData.getApiExpiryMonth()), "ApiExpiryMonth",2);
            Validations.validateDateIsNumeric(String.valueOf(cardData.getApiExpiryMonth()), "ApiExpiryMonth");
        }
        if(Validations.validateIsNotEmpty(String.valueOf(cardData.getApiExpiryYear()), "ApiExpiryYear")){
            Validations.validateYearExp(String.valueOf(cardData.getApiExpiryYear()), "ApiExpiryYear");
            Validations.validateDateIsNumeric(String.valueOf(cardData.getApiExpiryYear()), "ApiExpiryYear");
        }
        Validations.validateIsNotEmpty(String.valueOf(cardData.getApiAccountTypeId()), "ApiAccountTypeId");
        if(Validations.validateIsNotEmpty(String.valueOf(cardData.getApiSecurityCode()), "ApiSecurityCode")){
            Validations.validateDateIsNumeric(String.valueOf(cardData.getApiSecurityCode()), "ApiSecurityCode");
        }

        if (Validations.validateIsNotEmpty(cardData.getApiCardName(), "ApiCardName")) {
            Validations.validateStringLength(cardData.getApiCardName(), "ApiCardName", 50);
        }

        // validamos person
        if (Validations.validateIsNotEmpty(person.getApiNames(), "person.ApiNames")) {
            Validations.validateStringLength(person.getApiNames(), "person.ApiNames", 20);
        }
        if (Validations.validateIsNotEmpty(person.getApiLastNames(), "person.ApiLastNames")) {
            Validations.validateStringLength(person.getApiLastNames(), "person.ApiLastNames", 20);
        }
        if (Validations.validateIsNotEmpty(person.getApiNumberIdentifier(), "person.ApiNumberIdentifier")) {
            Validations.validateStringLength(person.getApiNumberIdentifier(), "person.ApiNumberIdentifier", 12);
            Validations.validateDateIsNumeric(person.getApiNumberIdentifier(), "person.ApiNumberIdentifier");
        }
        if (Validations.validateIsNotEmpty(person.getApiGender(), "person.ApiGender")) {
            Validations.validateGender(person.getApiGender(), "person.ApiGender");
        }
        if (Validations.validateIsNotEmpty(person.getApiAddress(), "person.ApiAddress")) {
            Validations.validateStringLength(person.getApiAddress(), "person.ApiAddress", 50);
        }
        if(Validations.validateIsNotEmpty(person.getApiBirthday(), "person.ApiBirthday")){
            Validations.validateDate(person.getApiBirthday(),"person.ApiBirthday");
        }
        if(Validations.validateIsNotEmpty(person.getApiNationality(), "person.ApiNationality")){
            Validations.validateStringLength(person.getApiNationality(), "person.ApiNationality",2);
        }


        // validamos Good
        if (Validations.validateIsNotEmpty(good.getApiName(), "good.ApiName")) {
            Validations.validateStringLength(good.getApiName(), "good.ApiName", 20);
        }
        if (Validations.validateIsNotEmpty(good.getApiDescription(), "good.ApiDescription")) {
            Validations.validateStringLength(good.getApiDescription(), "good.ApiDescription", 20);
        }
        Validations.validateIsNotEmpty(String.valueOf(good.getApiQuantity()), "ApiQuantity");
        if (Validations.validateIsNotEmpty(good.getApiUnitPrice(), "ApiUnitPrice")) {
            Validations.validateFormatNumberMoney(good.getApiUnitPrice(), "ApiUnitPrice");
        }

        if (Validations.validateIsNotEmpty(String.valueOf(good.getApiItem()), "good.ApiItem")) {
            Validations.validateStringLength(String.valueOf(good.getApiItem()), "good.ApiItem", 10);
        }
        if (Validations.validateIsNotEmpty(good.getApiCode(), "good.ApiCode")) {
            Validations.validateStringLength(good.getApiCode(), "good.ApiCode", 10);
        }
        if (Validations.validateIsNotEmpty(good.getApiAmount(), "good.ApiAmount")) {
            Validations.validateFormatNumberMoney(good.getApiAmount(), "good.ApiAmount");
        }
        //Validations.validateIsNotEmpty(good.getApiPromotionCode(), "ApiPromotionCode");

        // validamos PurchaseData
        Validations.validateIsNotEmpty(purchaseData.getApiPurchaseCode(), "ApiPurchaseCode");
        if (Validations.validateIsNotEmpty(purchaseData.getApiCurrencyCode(), "ApiCurrencyCode")) {
            Validations.validateStringLength(purchaseData.getApiCurrencyCode(), "ApiCurrencyCode", 3);
        }
        if (Validations.validateIsNotEmpty(purchaseData.getApiTotalAmount(), "ApiTotalAmount")) {
            Validations.validateFormatNumberMoney(purchaseData.getApiTotalAmount(), "ApiTotalAmount");
        }
        Validations.validateIsNotEmpty(String.valueOf(purchaseData.getApiQuotaId()), "ApiQuotaId");
        if (Validations.validateIsNotEmpty(purchaseData.getApiIva(), "ApiIva")) {
            Validations.validateStringLength(purchaseData.getApiIva(), "ApiIva", 12);
            Validations.validateFormatNumberMoney(purchaseData.getApiIva(), "ApiIva");
        }
        if (Validations.validateIsNotEmpty(purchaseData.getApiIvaReturn(), "ApiIvaReturn")) {
            Validations.validateStringLength(purchaseData.getApiIvaReturn(), "ApiIvaReturn", 12);
            Validations.validateFormatNumberMoney(purchaseData.getApiIvaReturn(), "ApiIvaReturn");
        }

        // validamos config

        Validations.validateIsNotEmpty(config.getPaycores_environment(), "paycores_environment");
        Validations.validateIsNotEmpty(config.getPaycores_access_key(), "paycores_access_key");
        Validations.validateIsNotEmpty(config.getPaycores_access_login(), "paycores_access_login");
        Validations.validateIsNotEmpty(config.getPaycores_CommerceID(), "paycores_CommerceID");
        Validations.validateIsNotEmpty(config.getPaycores_url_res(), "paycores_url_res");
        Validations.validateIsNotEmpty(config.getPaycores_url_conf(), "paycores_url_conf");
        if(Validations.validateIsNotEmpty(config.getCodeSecureForm(), "codeSecureForm")){
            Validations.validateStringLength(config.getCodeSecureForm(), "codeSecureForm",6);
        }

        return true;
    }

}
