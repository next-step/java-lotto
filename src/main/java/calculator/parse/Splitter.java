package calculator.parse;

import java.util.Arrays;
import java.util.List;

public class Splitter {

    public static final String BLANK = " ";

    public static final List<String> split(String input, String delimiter) {
        return Arrays.asList(input.split(delimiter));
    }
}
