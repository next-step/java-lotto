package calculator;

public class Calculator {

    public static final String SPACE = " ";

    public int calculate(String input) {
        String[] tokens = input.split(SPACE);
        int result = Integer.parseInt(tokens[0]);
        return applyOperations(tokens, result);
    }

    private int applyOperations(String[] arr, int result) {
        for (int i = 1; i < arr.length; i += 2) {
            OperatorType operatorType = OperatorType.fromSymbol(arr[i]);
            int operand = Integer.parseInt(arr[i + 1]);
            result = operatorType.apply(result, operand);
        }
        return result;
    }
}
