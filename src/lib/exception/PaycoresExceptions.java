package lib.exception;

/**
 * Created by paycores.com 18/12/17.
 *
 * clase para tratar los errores personalizados por paycores.com
 */
public class PaycoresExceptions extends Exception {

    private int errorCode;
    private String errorMsg;

    public PaycoresExceptions(String nameData,ErrorsEnum code) {
        this.errorMsg = "The data "+nameData+" "+code.getDescription();
        this.errorCode = code.getCode();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}

