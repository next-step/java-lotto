package calculator;

import calculator.calculatableImpl.Adder;
import calculator.calculatableImpl.Divider;
import calculator.calculatableImpl.Multiplier;
import calculator.calculatableImpl.Subtractor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum Calculator {
    ADDER(new Adder()),
    SUBTRACTOR(new Subtractor()),
    MULTIPLIER(new Multiplier()),
    DIVIDER(new Divider());

    private final Calculatable calculatable;

    Calculator(Calculatable calculatable) {
        this.calculatable = calculatable;
    }

    private final static String INPUT_REGEX = " ";

    private final static String DIGIT_REGEX = "^[0-9]*$";

    private final static String NO_INPUT_EXCEPTION = "입력 값이 null 이거나 빈 공백 문자입니다.";

    public static int run(String inputString) {
        validateInput(inputString);
        List<String> inputs = List.of(inputString.split(INPUT_REGEX));
        List<String> operators = Operation.parseOperators(inputs);
        Operation.validateOperators(operators);
        List<Integer> digits = extractDigits(inputs);
        int result = digits.get(0);
        for (int i = 0; i < operators.size(); i++) {
            int nextOperand = digits.get(i + 1);
            String operator = operators.get(i);
            result = calculate(result, nextOperand, operator);
        }
        return result;
    }

    private static void validateInput(String inputString) throws IllegalArgumentException {
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException(NO_INPUT_EXCEPTION);
        }
    }

    private static int calculate(int firstOperand, int secondOperand, String operator) {
        return calculator(operator).run(firstOperand, secondOperand);
    }

    private static Calculatable calculator(String operator) {
        if (Operation.isAddOperator(operator)) {
            return ADDER.calculatable;
        }

        if (Operation.isSubtractOperator(operator)) {
            return SUBTRACTOR.calculatable;
        }

        if (Operation.isMultiplyOperator(operator)) {
            return MULTIPLIER.calculatable;
        }

        return DIVIDER.calculatable;
    }

    private static List<Integer> extractDigits(List<String> inputs) {
        return inputs.stream()
                .filter(Calculator::isDigit)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static boolean isDigit(String inputString) {
        return inputString.matches(DIGIT_REGEX);
    }
}
