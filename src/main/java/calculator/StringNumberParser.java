package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringNumberParser {
    private static final String DEFAULT_SEPARATOR = ",|:";

    public static List<Integer> parse(String string) {
        String[] strings = string.split(DEFAULT_SEPARATOR);
        return convertNumbers(strings);
    }

    private static List<Integer> convertNumbers(String[] strings) {
        List<Integer> numbers = new ArrayList<>();

        for (String number : strings) {
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }
}
