package calculator.common;

public class StringHelper {

    private static final String DEFAULT_SEPARATOR = ",|:";
    public String[] split(String value) {
        return value.split(DEFAULT_SEPARATOR);
    }
}
