package calculator;

public class StringDelimiter {

    private static final String DEFAULT_DELIMITER_REGEX = ",|:";

    private StringDelimiter() {
    }

    public static String[] splitByDelimiter(String text) {
        return text.split(DEFAULT_DELIMITER_REGEX);
    }
}
