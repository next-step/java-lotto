package stringCalculator.domain;

import java.util.LinkedList;
import java.util.Queue;

public class MathExpressionFactory {

    public static MathExpression seperateAndCreateMathExpression(String input) {
        checkNullAndThrowException(input);

        String[] inputList = input.split(" ");
        Queue<Integer> numbers = new LinkedList<>();
        Queue<String> operations = new LinkedList<>();

        for (int i = 0; i < inputList.length; i += 2) {
            numbers.add(Integer.parseInt(inputList[i]));
        }

        for (int i = 1; i < inputList.length; i += 2) {
            checkOperationAndThrowException(inputList[i]);
            operations.add(inputList[i]);
        }

        return new MathExpression(numbers, operations);
    }

    public static void checkNullAndThrowException(String input) {
        if (input == null)
            throw new IllegalArgumentException();
    }

    public static void checkOperationAndThrowException(String operation) {
        if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/"))
            return;
        throw new IllegalArgumentException();
    }

}
