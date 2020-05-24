package step1;

public class StringUtils {

    private static final String ZERO = "0";

    public static String blankToZero(final String input) {
        if (input == null || input.trim().isEmpty()) {
            return ZERO;
        }

        return input;
    }
}
