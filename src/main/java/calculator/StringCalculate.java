package calculator;

import java.util.List;

public class StringCalculate {
    public static int add(String input) {
        if (isBlankString(input)) {
            return 0;
        }

        return add(StringNumberParser.parse(input));
    }

    private static int add(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }

    private static boolean isBlankString(String str) {
        return str == null || str.length() == 0;
    }
}
