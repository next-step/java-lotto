package util;

import java.util.Objects;
import java.util.regex.Pattern;

public class StringUtils {
    private static final Pattern NATURAL_NUMBER_PATTERN = Pattern.compile("\\d+");

    private StringUtils() {}

    public static boolean isEmpty(String inputString) {
        return Objects.isNull(inputString) || inputString.isEmpty();
    }

    public static boolean isNaturalNumber(String numberString) {
        if (isEmpty(numberString)) {
            return false;
        }

        return NATURAL_NUMBER_PATTERN.matcher(numberString)
                .matches();
    }
}
