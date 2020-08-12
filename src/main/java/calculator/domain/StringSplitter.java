package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {

    public static List<String> split(String input, String delimiters) {
        return Arrays.asList(input.split(delimiters));
    }
}
