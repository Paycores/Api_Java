package lib.conection;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static lib.utilities.Utils.*;

/**
 * Permite hacer peticiones Post y Get y retornar la respuesta del servidor
 *
 * Created by paycores.com 13/06/17.
 */
public class Http {

    /**
     * Metodo encargado de enviar una peticion GET
     * @param paycore_url
     * @return respuesta del servidor
     * @throws Exception
     */
    public String[] sendGet(String paycore_url) throws Exception {
        URL paycore_obj = new URL(paycore_url);
        HttpURLConnection paycore_connection = (HttpURLConnection) paycore_obj.openConnection();

        //Optional default is GET; add request header
        paycore_connection.setRequestMethod(TAG_GET);
        paycore_connection.setRequestProperty(TAG_USER_AGENT, USER_AGENT);

        int paycore_responseCode = paycore_connection.getResponseCode();

        BufferedReader paycore_in = new BufferedReader(new InputStreamReader(paycore_connection.getInputStream()));
        String paycore_inputLine;
        StringBuffer paycore_response = new StringBuffer();

        while ((paycore_inputLine = paycore_in.readLine()) != null) {
            paycore_response.append(paycore_inputLine);
        }
        paycore_in.close();

        return new String[]{String.valueOf(paycore_responseCode), paycore_response.toString()};
    }

    /**
     * Metodo encargado de enviar una peticion POST
     *
     * @param paycore_url url donde se ba enviar la peticion
     * @param pyc_params parametros de envio
     * @return respuesta del servidor
     * @throws Exception
     */
    public String[] sendPost(String paycore_url,String pyc_params) throws Exception {

        URL obj = new URL(paycore_url);
        HttpURLConnection paycore_connection = (HttpURLConnection) obj.openConnection();

        //add request header
        paycore_connection.setRequestMethod(TAG_POST);
        paycore_connection.setRequestProperty(TAG_USER_AGENT, USER_AGENT);
        paycore_connection.setRequestProperty("Authorization", "login purchase");
        paycore_connection.setRequestProperty(TAG_PAYCORES_TYPE,  PAYCORES_TYPE);

        // Send post request
        paycore_connection.setDoOutput(true);
        DataOutputStream paycore_wr = new DataOutputStream(paycore_connection.getOutputStream());
        paycore_wr.writeBytes(pyc_params);
        paycore_wr.flush();
        paycore_wr.close();

        int paycore_responseCode = paycore_connection.getResponseCode();

        BufferedReader paycore_in = new BufferedReader(new InputStreamReader(paycore_connection.getInputStream()));
        String paycore_inputLine;
        StringBuffer paycore_response = new StringBuffer();

        while ((paycore_inputLine = paycore_in.readLine()) != null) {
            paycore_response.append(paycore_inputLine);
        }
        paycore_in.close();
        return new String[]{String.valueOf(paycore_responseCode), paycore_response.toString()};
    }
}
