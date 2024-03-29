package lotto;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    public static String[] splitTextWinNumbers(String input) {
        return input.split(",");
    }

    public static List<Integer> parseWinNumbers(String[] textWinNumbers) {
        List<Integer> winNumbers = new ArrayList<>();
        for (String text : textWinNumbers) {
            winNumbers.add(parseTextToInt(text));
        }
        return winNumbers;
    }

    private static Integer parseTextToInt(String text) {
        return Integer.parseInt(text);
    }
}
