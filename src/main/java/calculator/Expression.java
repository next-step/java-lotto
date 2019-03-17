package calculator;

import spark.utils.StringUtils;

import java.util.regex.Pattern;

public class Expression {

    private static final String DELIMITER = ",|:";
    private static final String SINGLE_NUMBER_PATTERN = "^[0-9]+$";
    private static final String NUMBER_PATTERN = "^[0-9]$";
    private static final int ZERO = 0;

    public static boolean isNullOrEmpty(String expression) {
        if (StringUtils.isEmpty(expression)) {
            return true;
        }
        return false;
    }

    public static boolean isSingleNumber(String expression) {
        if(Pattern.matches(SINGLE_NUMBER_PATTERN, expression)) {
            return true;
        }
        return false;
    }

    public static int[] extractOperands(String expression) {
        String[] operands = expression.split(DELIMITER);
        int[] result = new int[operands.length];

        return convertToNumbers(operands, result);
    }

    private static int[] convertToNumbers(String[] operands, int[] result) {
        for (int i = 0; i < result.length; i++) {
            result[i] = convertToNumber(operands[i]);
        }
        return result;
    }

    private static int convertToNumber(String operand) {
        checkWrongPattern(operand);
        checkNegativeNumber(operand);
        return Integer.parseInt(operand);
    }

    private static void checkWrongPattern(String operand) {
        if (Pattern.matches(NUMBER_PATTERN, operand)) {
            throw new RuntimeException();
        }
    }

    private static void checkNegativeNumber(String operand) {
        if (Integer.parseInt(operand) < ZERO) {
            throw new RuntimeException();
        }
    }
}
