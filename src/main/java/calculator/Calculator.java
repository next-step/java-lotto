package calculator;

import calculator.calculatableImpl.Adder;
import calculator.calculatableImpl.Divider;
import calculator.calculatableImpl.Multiplier;
import calculator.calculatableImpl.Subtractor;

import java.util.Arrays;
import java.util.List;

public enum Calculator {
    ADDER(new Adder(), Operator.ADD_OPERATOR),
    SUBTRACTOR(new Subtractor(), Operator.SUBTRACT_OPERATOR),
    MULTIPLIER(new Multiplier(), Operator.MULTIPLY_OPERATOR),
    DIVIDER(new Divider(), Operator.DIVIDE_OPERATOR);

    private final static String INPUT_REGEX = " ";

    private final static String NO_INPUT_EXCEPTION = "입력 값이 null 이거나 빈 공백 문자입니다.";

    private final Calculatable calculatable;

    private final Operator operator;

    Calculator(Calculatable calculatable, Operator operator) {
        this.calculatable = calculatable;
        this.operator = operator;
    }

    public static int run(String inputString) {
        validateInput(inputString);
        List<String> inputs = List.of(inputString.split(INPUT_REGEX));
        List<String> operators = Operator.parseOperators(inputs);
        List<Integer> digits = Digit.parseDigits(inputs);
        int result = digits.get(0);
        for (int i = 0; i < operators.size(); i++) {
            int nextOperand = digits.get(i + 1);
            String operator = operators.get(i);
            result = calculate(result, nextOperand, operator);
        }
        return result;
    }

    private static void validateInput(String inputString) {
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException(NO_INPUT_EXCEPTION);
        }
    }

    private static int calculate(int firstOperand, int secondOperand, String operator) {
        return calculator(operator).run(firstOperand, secondOperand);
    }

    private static Calculatable calculator(String operatorString) {
        return Arrays.stream(values())
                .filter(calculator -> Operator.of(operatorString).equals(calculator.operator))
                .map(calculator -> calculator.calculatable)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
