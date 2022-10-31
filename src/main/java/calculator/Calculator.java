package calculator;

import calculator.calculatableImpl.Adder;
import calculator.calculatableImpl.Divider;
import calculator.calculatableImpl.Multiplier;
import calculator.calculatableImpl.Subtractor;

import java.util.List;

public enum Calculator {
    ADDER(new Adder()),
    SUBTRACTOR(new Subtractor()),
    MULTIPLIER(new Multiplier()),
    DIVIDER(new Divider());

    private final static String INPUT_REGEX = " ";

    private final static String NO_INPUT_EXCEPTION = "입력 값이 null 이거나 빈 공백 문자입니다.";

    private final Calculatable calculatable;

    Calculator(Calculatable calculatable) {
        this.calculatable = calculatable;
    }

    public static int run(String inputString) {
        validateInput(inputString);
        List<String> inputs = List.of(inputString.split(INPUT_REGEX));
        List<String> operators = Operation.getFrom(inputs);
        List<Integer> digits = Digit.parseDigits(inputs);
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
}
