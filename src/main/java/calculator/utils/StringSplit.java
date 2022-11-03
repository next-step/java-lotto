package calculator.utils;

public class StringSplit {
    private static final String DELIMITER = " ";

    public static String[] split(String input) {
        return input.split(DELIMITER);
    }
}
