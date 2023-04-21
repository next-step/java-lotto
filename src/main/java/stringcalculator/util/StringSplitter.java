package stringcalculator.util;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {

    private static final String DELIMITER = " ";

    public static List<String> split(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }
}
