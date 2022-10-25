package calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class StringCalculator {
    static final List<String> possibleOperators = Arrays.asList("+", "-", "*", "/");

    public static int calculate(final String input) {
        List<String> inputList = Arrays.stream(input.split("\\s"))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        Queue<Integer> operands = extractedOperands(inputList);
        validateOperands(operands);
        Queue<String> operators = extractedOperators(inputList);
        validateOperators(operators);

        return calculateResult(operands, operators);
    }

    private static void validateOperators(final Queue<String> operators) {
        if (operators.stream().anyMatch(o -> !possibleOperators.contains(o))) {
            throw new IllegalArgumentException("허용되지 않은 연산 기호가 포함되어 있습니다");
        }
    }

    private static void validateOperands(final Queue<Integer> operands) {
        if (operands.stream().anyMatch(o -> o < 0)) {
            throw new IllegalArgumentException("양수만 입력해주세요");
        }
    }

    private static int calculateResult(final Queue<Integer> operands, final Queue<String> operators) {
        if (operands.isEmpty()) {
            return 0;
        }

        int result = operands.poll();

        while (!operators.isEmpty()) {
            String operator = operators.poll();
            int operand = operands.poll();

            switch (operator) {
                case "+":
                    result = add(result, operand);
                    break;
                case "-":
                    result = subtract(result, operand);
                    break;
                case "*":
                    result = multiply(result, operand);
                    break;
                case "/":
                    result = divide(result, operand);
                    break;
            }
        }

        return result;
    }

    private static Queue<Integer> extractedOperands(final List<String> inputList) {
        Queue<Integer> operands = new LinkedList<>();
        for (int i = 0; i < inputList.size(); i = i + 2) {
            operands.add(Integer.parseInt(inputList.get(i)));
        }

        return operands;
    }

    private static Queue<String> extractedOperators(final List<String> inputList) {
        Queue<String> operators = new LinkedList<>();
        for (int i = 1; i < inputList.size(); i = i + 2) {
            operators.add(inputList.get(i));
        }

        return operators;
    }

    public static int add(int num1, int num2) {
        return num1 + num2;
    }

    public static int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public static int divide(int num1, int num2) {
        return num1 / num2;
    }
}
