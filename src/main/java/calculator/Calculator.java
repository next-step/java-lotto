package calculator;

public class Calculator {
    public int calculate(String input) {
        String[] arr = input.split(" ");
        int result = Integer.parseInt(arr[0]);
        return applyOperations(arr, result);
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
