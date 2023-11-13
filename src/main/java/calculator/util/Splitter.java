package calculator.util;

import java.util.Arrays;
import java.util.List;

public class Splitter {

    public static final String BLANK = " ";

    public static final List<String> splitter(String input, String delimiter) {
        return Arrays.asList(input.split(delimiter));
    }
}
