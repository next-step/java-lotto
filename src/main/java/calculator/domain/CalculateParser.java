package calculator.domain;

public class CalculateParser {

    private static final String DEFAULT_SEPARATOR = ",|:";
    public String[] parse(String value) {
        return value.split(DEFAULT_SEPARATOR);
    }

    public String[] parse(String customSeparator, String value) {
        String separators = customSeparator + "|" + DEFAULT_SEPARATOR;
        return value.split(separators);
    }
}
