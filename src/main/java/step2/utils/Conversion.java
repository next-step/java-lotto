package step2.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import step2.exception.CustomNumberFormatException;

public class Conversion {

    private Conversion() {
    }

    public static List<Integer> stringToInt(String[] strings) {
        List<Integer> numbers = new ArrayList<>();
        Arrays.stream(strings).forEach(str -> numbers.add(getStringToNumber(str)));
        return numbers;
    }

    private static int getStringToNumber(String str) {
        return getNumber(str);
    }

    private static int getNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatException(e.getMessage());
        }
    }
}
