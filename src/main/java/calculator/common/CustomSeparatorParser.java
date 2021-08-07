package calculator.common;

public class CustomSeparatorParser {
    public static final int CUSTOM_SEPARATOR_INDEX = 2;
    public String parse(String value) {
        return String.valueOf(value.charAt(CUSTOM_SEPARATOR_INDEX));
    }
}
