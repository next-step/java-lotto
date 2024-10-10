package calculator;

public class Calculator {
    public int calculate(String input) {
        String[] tokens = input.split(" ");
        int result = Integer.parseInt(tokens[0]);
        return applyOperations(tokens, result);
    }

    private static int applyOperations(String[] arr, int result) {
        for (int i = 1; i < arr.length; i += 2) {
            OperatorType operatorType = OperatorType.getOperator(arr[i]);
            int operand = Integer.parseInt(arr[i + 1]);
            result = operatorType.apply(result, operand);
        }
        return result;
    }
}
