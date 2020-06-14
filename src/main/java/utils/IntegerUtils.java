package utils;

import java.util.ArrayList;
import java.util.List;

public class IntegerUtils {
    public static int parsing(String calcStr) {
        try {
            int num = Integer.parseInt(calcStr);
            return num;
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    public static int[] splitAndParseInt(String stringNumbers) {
        String[] numbers = stringNumbers.split(",");
        int size = numbers.length;
        int[] results = new int[size];

        for (int i = 0; i < size; i++) {
            results[i] = IntegerUtils.parsing(numbers[i]);
        }

        return results;
    }

    public static List<Integer> arrToList(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(i);
        }

        return list;
    }
}
