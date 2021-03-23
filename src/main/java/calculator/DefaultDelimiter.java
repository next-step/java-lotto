package calculator;

public enum DefaultDelimiter {

    COMMA(","),
    COLON(":")
    ;

    private final String value;

    DefaultDelimiter(String value) {
        this.value = value;
    }

    public static String[] split(String text) {
        for (DefaultDelimiter delimiter : DefaultDelimiter.values()) {
            text = text.replace(delimiter.value, COMMA.value);
        }
        return text.split(COMMA.value);
    }

    public String getValue() {
        return value;
    }
}
