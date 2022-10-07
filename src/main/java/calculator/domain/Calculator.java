package calculator.domain;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

    private Calculator() {
    }

    public static int calculate(String input) {
        String[] splitInput = input.split(" ");
        Queue<Integer> numbers = getNumbers(splitInput);
        Queue<String> operations = getOperations(splitInput);

        return calculateProcess(numbers, operations);
    }

    public static int calculateProcess(Queue<Integer> numbers, Queue<String> operations) {
        int result = numbers.poll();

        while (numbers.size() > 0) {
            result = ArithmeticOperation.getOperation(operations.poll()).calculate(result, numbers.poll());
        }
        return result;
    }

    public static Queue<Integer> getNumbers(String[] inputs) {
        Queue<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < inputs.length; i += 2) {
            numbers.add(parseInt(inputs[i]));
        }
        return numbers;
    }

    public static Queue<String> getOperations(String[] inputs) {
        Queue<String> operations = new LinkedList<>();
        for (int i = 1; i < inputs.length; i += 2) {
            checkOperation(inputs[i]);
            operations.add(inputs[i]);
        }
        return operations;
    }

    private static void checkOperation(String input) {
        if (!ArithmeticOperation.hasOperation(input)) {
            throw new InvalidParameterException("연산자가 아닌 문자가 들어왔습니다.");
        }
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자 포멧이 아닙니다.");
        }
    }
}
