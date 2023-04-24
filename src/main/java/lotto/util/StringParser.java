package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class StringParser {

    private StringParser() {
    }

    public static List<Integer> parseIntList(List<String> input) {
        List<Integer> result = new ArrayList<>();
        try {
            for (String text : input) {
                int number = Integer.parseInt(text);
                validatePositiveInt(number);
                result.add(number);
            }
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력한 값이 자연수가 아닙니다.");
        }
    }

    private static void validatePositiveInt(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("입력한 값이 자연수가 아닙니다.");
        }
    }
}
