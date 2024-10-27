package stringCalculator.domain;

import java.util.LinkedList;
import java.util.Queue;

public class MathExpressionFactory {

    public static MathExpression seperateAndCreateMathExpression(String input) {
        checkNullAndThrowException(input);

        String[] inputList = input.split(" ");
        Queue<Integer> numbers = new LinkedList<>();
        Queue<OperationEnum> operations = new LinkedList<>();

        for (int i = 0; i < inputList.length; i += 2) {
            numbers.add(Integer.parseInt(inputList[i]));
        }

        for (int i = 1; i < inputList.length; i += 2) {
            operations.add(OperationEnum.findOperationEnum(inputList[i]));
        }

        return new MathExpression(numbers, operations);
    }

    private static void checkNullAndThrowException(String input) {
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException();
    }
}
