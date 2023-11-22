package lotto.util.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    private Converter() {
    }

    public static List<String> splitToList(String separator, String input) {
        return Arrays.asList(input.split(separator));
    }
    public static List<Integer> splitToIntList(String separator, String input) {
        return Arrays.stream(input.split(separator))
                .map(value -> Integer.parseInt(value.trim()))
                .collect(Collectors.toList());
    }

    public static int convertToInt(String value) {
        return Integer.parseInt(value);
    }
}
