package calculator;

public class Operand {

    private static final String DELIMITER = ",|:";


    public static int[] extractOperands(String expression) {
        String[] operands = expression.split(DELIMITER);
        int[] result = new int[operands.length];

        return convertToIntArray(operands, result);
    }

    private static int[] convertToIntArray(String[] operands, int[] result) {
        for (int i = 0 ; i < result.length ; i++) {
            result[i] = Integer.parseInt(operands[i]);
        }
        return result;
    }
}
