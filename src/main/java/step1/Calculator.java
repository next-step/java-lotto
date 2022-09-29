package step1;

import java.util.Arrays;

public class Calculator {

    public static int calculator(String input) {
        String[] splitInput = input.split(" ");
        int result = 0;

        for (int i = 1; i < splitInput.length - 1; i += 2) {
            int firstNum = result;
            if (i == 1) {
                firstNum = checkInt(splitInput[i - 1]);
            }
            int secondNum = checkInt(splitInput[i + 1]);
            String operator = checkOperation(splitInput[i]);
            result = caculateResult(firstNum, secondNum, operator);
        }

        return result;
    }

    private static int caculateResult(int firstNum, int secondNum, String operator) {
        int result = 0;
        if (operator.equals(OperatorType.PLUS.getValue())) {
            result = Operator.plus(firstNum, secondNum);
        }
        if (operator.equals(OperatorType.MINUS.getValue())) {
            result = Operator.minus(firstNum, secondNum);
        }
        if (operator.equals(OperatorType.TIMES.getValue())) {
            result = Operator.times(firstNum, secondNum);
        }
        if (operator.equals(OperatorType.DIVISION.getValue())) {
            result = Operator.division(firstNum, secondNum);
        }

        return result;
    }

    private static int checkInt(String input) {
        return Integer.parseInt(input);
    }

    private static String checkOperation(String input) {
        if (Arrays.asList(OperatorType.values()).contains(input)) {
            throw new RuntimeException();
        }
        return input;
    }
}
