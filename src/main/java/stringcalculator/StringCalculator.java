package stringcalculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public static final String DELIMITER = " ";

    public static int calculate(String equation) {
        List<String> targets = splitEquation(equation);

        int result = stringToInt(targets.get(0));
        for (int i = 1; i < targets.size(); i += 2) {
            result = calculateOneOperation(targets, result, i);
        }
        return result;
    }

    private static int calculateOneOperation(List<String> targets, int result, int idx) {
        String curTarget = targets.get(idx);
        if (curTarget.equals("+")) {
            result += stringToInt(targets.get(++idx));
        } else if (curTarget.equals("-")) {
            result -= stringToInt(targets.get(++idx));
        } else if (curTarget.equals("*")) {
            result *= stringToInt(targets.get(++idx));
        }
        return result;
    }

    private static int stringToInt(String string) {
        return Integer.parseInt(string);
    }

    private static List<String> splitEquation(String equation) {
        return Arrays.asList(equation.split(DELIMITER));
    }
}
