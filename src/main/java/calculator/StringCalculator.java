package calculator;

public class StringCalculator {
    private static final String DELIMITER = " ";
    private static final int FIRST_OPERAND = 0;

    private StringCalculator() {
        throw new IllegalStateException("Util Class");
    }

    public static int calculator(String s) {
        String[] operations = s.split(DELIMITER);

        int operationResult = Integer.parseInt(operations[FIRST_OPERAND]);

        for (int i = 1; i < operations.length; i += 2) {
            String operator = operations[i];
            int operand = Integer.parseInt(operations[i+1]);

            operationResult = Operation.run(operator, operationResult, operand);
        }
        return operationResult;
    }
}