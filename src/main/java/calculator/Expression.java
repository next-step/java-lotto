package calculator;

import spark.utils.StringUtils;

public class Expression {

    private static final String DELIMITER = ",|:";

    public static boolean isNullOrEmpty(String expression) {
        if (StringUtils.isEmpty(expression)) {
            return true;
        }
        return false;
    }

    public static int[] extractOperands(String expression) {
        String[] operands = expression.split(DELIMITER);
        int[] result = new int[operands.length];

        return convertToIntArray(operands, result);
    }

    private static int[] convertToIntArray(String[] operands, int[] result) {
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(operands[i]);
        }
        return result;
    }
}
