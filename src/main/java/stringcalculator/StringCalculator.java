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
            result = calculateOneOperation(result, targets.get(i), stringToInt(targets.get(i+1)));
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

    private static int calculateOneOperation(int previousOperand, String curOperation, int nextOperand) {
        if (curOperation.equals("+")) {
            return previousOperand + nextOperand;
        } else if (curOperation.equals("-")) {
            return previousOperand - nextOperand;
        } else if (curOperation.equals("*")) {
            return previousOperand * nextOperand;
        } else if (curOperation.equals("/")) {
            return previousOperand / nextOperand;
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
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
