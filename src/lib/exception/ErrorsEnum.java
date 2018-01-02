package lib.exception;

/**
 * Created by paycores.com 18/12/17.
 *
 * clase para enumerar los errores y asi controlarlos
 */
public enum ErrorsEnum {

    EMPTY_OR_NULL_DATA(0, "is empty or null."),
    LENGTH_ERROR(1, "has an erroneous length"),
    INVALID_CURRENCY_FORMAT(2,"the format of the currency is invalid"),
    INVALID_GENDER(3,"is not valid, it has to be M or F"),
    INVALID_EMAIL(4,"is not valid"),
    INVALID_DATE(5," does not meet the condition YEAR-MOUNT-DAY"),
    INVALID_NUMERIC(6,"not is numeric"),
    INVALID_ENVIORONMENT(7, "there is no kind of ENVIORONMENT");

    private final int code;
    private final String description;

    ErrorsEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}

