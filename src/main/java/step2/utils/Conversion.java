package step2.utils;

import java.util.ArrayList;
import java.util.List;
import step2.exception.CustomNumberFormatException;

public class Conversion {

    private Conversion() {
    }

    public static List<Integer> stringToInt(String[] strings) {
        List<Integer> numbers = new ArrayList<>();
        for (String string : strings) {
            numbers.add(getStringToNumber(string));
        }
        return numbers;
    }

    private static int getStringToNumber(String str) {
        int number = getNumber(str);
        Validation.validate(number);
        return number;
    }

    private static int getNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatException(e.getMessage());
        }
    }
}
