package stringaddcalculator;

import java.util.Objects;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        int result = 0;

        if (isEmptyString(input)) {
            return result;
        }

        String[] splitInput = input.split("[,:]");

        for (String operand : splitInput) {
            result += Integer.parseInt(operand);
        }

        return result;
    }

    private static boolean isEmptyString(String string) {
        return Objects.isNull(string) || string.isEmpty();
    }
}
