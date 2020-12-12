package stringcalculator.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputParser {
    public static List<Integer> convert(String input) {
        if (isNullOrEmpty(input)) {
            return Collections.singletonList(0);
        }

        return convertToIntegerList(input);
    }

    private static List<Integer> convertToIntegerList(String input) {
        String[] tokens= input.split(",|:");

        List<Integer> result = new ArrayList<>();
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            result.add(number);
        }
        return result;
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
