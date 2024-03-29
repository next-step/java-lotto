package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    public static List<Integer> parseWinNumbers(String input) {
        List<Integer> winNumbers = new ArrayList<>();
        for (String text : splitTextWinNumbers(input)) {
            winNumbers.add(parseTextToInt(text));
        }
        return winNumbers;
    }

    public static String[] splitTextWinNumbers(String input) {
        return input.split(",");
    }

    private static Integer parseTextToInt(String text) {
        return Integer.parseInt(text);
    }
}
