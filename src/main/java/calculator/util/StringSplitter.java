package calculator.util;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    private static final String WHITE_SPACE = " ";

    private StringSplitter() {

    }

    public static List<String> splitWithWhiteSpace(String input) {
        return Arrays.asList(input.split(WHITE_SPACE));
    }
}
