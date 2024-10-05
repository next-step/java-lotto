package stringcalculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    private static final String WHITE_SPACE_DELIMITER = " ";

    private StringUtil() {
    }

    public static boolean isBlank(String str) {
        return str == null || str.isBlank();
    }

    public static List<String> splitAsList(String input) {
        return Arrays.stream(input.split(WHITE_SPACE_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toUnmodifiableList());
    }
}
