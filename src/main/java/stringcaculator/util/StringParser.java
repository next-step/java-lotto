package stringcaculator.util;

public class StringParser {

    private static final String DEFAULT_DELIMITER = ",|:";

    private StringParser() {}

    public static String[] splitDefaultDelimiter(String numbers) {
        return numbers.split(DEFAULT_DELIMITER);
    }
}
