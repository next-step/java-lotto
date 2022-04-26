package utils;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    public static List<String> split(String operands, String delimiter) {
        return Arrays.asList(operands.split(delimiter));
    }
}
