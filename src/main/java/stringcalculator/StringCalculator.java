package stringcalculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public static final String DELIMITER = " ";

    public static int calculate(String equation) {
        List<String> targets = splitEquation(equation);
        validateTargetList(targets);

        int result = stringToInt(targets.get(0));
        for (int i = 1; i < targets.size(); i += 2) {
            validateString(targets.get(i));
            result = calculateOneOperation(targets, result, i);
        }
        return result;
    }

    private static void validateTargetList(List<String> targets) {
        if (targets.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자이면 안됩니다.");
        }
    }

    private static void validateString(String s) {
        if (s.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자이면 안됩니다.");
        }
    }

    private static int calculateOneOperation(List<String> targets, int result, int idx) {
        String curTarget = targets.get(idx);
        if (curTarget.equals("+")) {
            result += stringToInt(targets.get(++idx));
        } else if (curTarget.equals("-")) {
            result -= stringToInt(targets.get(++idx));
        } else if (curTarget.equals("*")) {
            result *= stringToInt(targets.get(++idx));
        } else if (curTarget.equals("/")) {
            result /= stringToInt(targets.get(++idx));
        }
        return result;
    }

    private static int stringToInt(String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("피연산자 입력 값이 정수형이 아닙니다.");
        }
    }

    private static List<String> splitEquation(String equation) {
        return Arrays.asList(equation.split(DELIMITER));
    }
}
