package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Split {
    private final static String DELIMITER = ", ";

    public static List<String> splitDelimiter(String inputString) {
        return Arrays.asList(inputString.split(DELIMITER));
    }
}
