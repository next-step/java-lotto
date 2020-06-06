package lotto;

import java.util.ArrayList;
import java.util.List;

public class StringParser {

    public static List<Integer> getParseNumbers(String input) {
        return toIntegers(getSplits(input));
    }

    private static String[] getSplits(String input) {
        input = input.replaceAll(" ", "");
        return input.split(",");
    }

    private static List<Integer> toIntegers(String[] split) {
        List<Integer> result = new ArrayList<>();

        try {
            for (String number : split) {
                result.add(Integer.parseInt(number));
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자와 (,) 구분자로 이루어진 문자열을 입력해 주세요.");
            e.printStackTrace();
        }
        return result;
    }
}
