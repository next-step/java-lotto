package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public static int calculate(String input) {
        if (isBlankOrNull(input)) {
            throw new IllegalArgumentException("입력 값은 필수입니다.(공백은 입력할 수 없습니다.)");
        }

        String[] splitInput = input.split(" ");

        List<Operator> operators = splitOperator(splitInput);

        List<Integer> numbers = splitNumber(splitInput);

        return calculation(operators, numbers);
    }

    private static int calculation(List<Operator> operators, List<Integer> numbers) {
        int result = numbers.getFirst();
        for (int i = 0; i < operators.size(); i++) {
            Operator operator = operators.get(i);
            int number = numbers.get(i + 1);
            result = executeOperation(operator, new TargetNumber(result, number));
        }
        return result;
    }

    private static int executeOperation(Operator operator, TargetNumber numbers) {
        if (operator == Operator.PLUS) {
            return numbers.plus();
        }
        if (operator == Operator.MINUS) {
            return numbers.minus();
        }
        if (operator == Operator.MULTIPLICATION) {
            return numbers.multiplication();
        }
        if (operator == Operator.DIVISION) {
            return numbers.division();
        }
        return 0;
    }

    private static List<Integer> splitNumber(String[] values) {
        List<Integer> numbers = new ArrayList<>();
        for (String value : values) {
            if (isNumber(value)) {
                numbers.add(Integer.parseInt(value));
            }
        }
        return numbers;
    }

    private static List<Operator> splitOperator(String[] values) {
        List<Operator> operators = new ArrayList<>();
        for (String value : values) {
            if (!isNumber(value)) {
                operators.add(Operator.fromName(value));
            }
        }
        return operators;
    }

    private static boolean isNumber(String value) {
        return value.matches("^[0-9]+$");
    }


    private static boolean isBlankOrNull(String input) {
        return input == null || input.isBlank();
    }

}
