package calculator.domain;

import java.util.Arrays;
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
            result = operators.get(i).calculate(new TargetNumber(result, numbers.get(i + 1)));
        }

        return result;
    }

    private static List<Integer> splitNumber(String[] values) {
        return Arrays.stream(values)
                .filter(Calculator::isNumber)
                .map(Integer::parseInt)
                .toList();
    }

    private static List<Operator> splitOperator(String[] values) {
        return Arrays.stream(values)
                .filter(value -> !isNumber(value))
                .map(Operator::fromName)
                .toList();
    }

    private static boolean isNumber(String value) {
        return value.matches("^[0-9]+$");
    }


    private static boolean isBlankOrNull(String input) {
        return input == null || input.isBlank();
    }

}
