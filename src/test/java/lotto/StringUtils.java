package lotto;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    private static final String DEFAULT_SEPARATOR = ",";

    private StringUtils() {
    }

    public static List<String> splitString(String value) {
        valid(value);
        return Arrays.asList(deleteBlank(value).split(DEFAULT_SEPARATOR));
    }

    private static void valid(String value) {
        if (value == null || value.isEmpty() || value.equals(" ")) {
            throw new IllegalAccessError(ErrorMessage.WINNING_NUMBER_ERROR);
        }
    }

    private static String deleteBlank(String value) {
        return value.replaceAll(" ", "");
    }
}
