
package step1;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    public static List<Integer> parsePositiveInt(List<String> inputWords) {
        List<Integer> result = new ArrayList<>();
        for (String inputWord : inputWords) {
            result.add(parsePositiveInt(inputWord));
        }
        return result;
    }

    public static Integer parsePositiveInt(String word) {
        int number = parseInt(word);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    public static Integer parseInt(String word) {
        try {
            return Integer.parseInt(word);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }
}
