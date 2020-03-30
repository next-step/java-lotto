package stringaddcalculator;

import java.util.List;
import java.util.Objects;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        int result = 0;

        if (isEmptyString(input)) {
            return result;
        }

        result += Integer.parseInt(input);

        return result;
    }

    private static boolean isEmptyString(String string) {
        return Objects.isNull(string) || string.isEmpty();
    }
}
