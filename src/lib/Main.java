package lib;

import lib.beans.*;
import lib.exception.PaycoresExceptions;
import lib.json.org.json.JSONException;
import lib.order.PayCoresCreateOrder;
import lib.order.PayCoresGenPurchaseCode;
import lib.order.PayCoresSendCode;
import lib.order.PayCoresValidateCode;
import lib.utilities.Utils;
import lib.beans.PaycoreConfig;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        try {

            // sanbox
            String paycores_access_key = "n4hzrjarwllezz3g";
            String paycores_access_login = "laa60pprnqjx2opy";
            String paycores_environment = "1";
            String paycores_CommerceID = "68650188";
            String paycores_url_res = "/var/www/html/index.html";
            String paycores_url_conf = "/var/www/html/index.html";

            PaycoreConfig config = new PaycoreConfig();
            config.setPaycores_environment(paycores_environment);
            config.setPaycores_access_key(paycores_access_key);
            config.setPaycores_access_login(paycores_access_login);
            config.setPaycores_CommerceID(paycores_CommerceID);
            config.setPaycores_url_res(paycores_url_res);
            config.setPaycores_url_conf(paycores_url_conf);


            String purchaseCodes = PayCoresGenPurchaseCode.purchaseCodeGenerate(config.getPaycores_access_key(),
                    config.getPaycores_access_login());
            System.out.println("purchaseCodes = " + purchaseCodes);

            PurchaseData purchaseData = new PurchaseData();
            purchaseData.setAllPurchaseData("COP", "1500.00", purchaseCodes,
                    3, "19.00", "9.00");

            CardData cardData = new CardData();
            cardData.setAllCardData("VISA", "4968726866544077",
                    12, 2020, 1, "654", "carlos m");


            AddressData addressData = new AddressData();
            addressData.setAllAddressData("Armenia", "Quindio", "CO",
                    "3105117473", "3105117473", "paycorescesteban@gmail.com",
                    "630001");


            Person billingData = new Person();
            String birthday = Utils.dateFormatBirthday(20, 05, 1996);
            billingData.setAllPerson("Carlos", "Montealegre", "1094957485",
                    "M", addressData.getAllAddressData(), "carrera 15 calle 12", birthday,
                    "CO");

            Good good = new Good();
            good.setGood("Name", "La descripcion", 2, "45896.00",
                    12, "5862", "45896.00", "PROMOTION-CODE");



            PayCoresSendCode sendCode = new PayCoresSendCode(purchaseCodes,addressData.getApiEmail(),
                    billingData.getApiNames()+" "+billingData.getApiLastNames());

            String code = String.valueOf(JOptionPane.showInputDialog("coloque el codigo"));
            System.out.println("code = " + code);

            config.setCodeSecureForm(code);

            Authorize authorize = new Authorize(purchaseData, cardData, billingData, good, config, addressData);

            System.out.println("PaycoreConfig.getCodeSecureForm() = " + config.getCodeSecureForm());


            PayCoresValidateCode.validateCode(code,purchaseCodes);

            PayCoresCreateOrder.createOrder(authorize.getALLData());

        } catch (PaycoresExceptions paycoresExceptions) {
            System.out.println("paycoresExceptions.getErrorMsg() = " + paycoresExceptions.getErrorMsg());
            paycoresExceptions.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
