package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public enum Calculator {
    PLUS("+", (number1, number2) -> number1 + number2),
    MINUS("-", (number1, number2) -> number1 - number2),
    MULTIPLY("*", (number1, number2) -> number1 * number2),
    DIVIDE("/", (number1, number2) -> number1 / number2);

    private static final String MESSAGE_WRONG_OPERATOR = "잘못된 연산자입니다. 명시된 연산자를 사용하세요.[" + Arrays.toString(Calculator.values()) + "]";

    private final String operator;
    private final BinaryOperator<Integer> calculator;

    Calculator(String operator, BinaryOperator<Integer> calculator) {
        this.operator = operator;
        this.calculator = calculator;
    }

    public static Integer calculate(String inputFormula) {
        validateInput(inputFormula);

        List<Integer> operands = StringParser.parseOperands(inputFormula);
        List<String> operators = StringParser.parseOperators(inputFormula);

        int sum = operands.get(0);
        for (int i = 0; i < operators.size(); i++) {
            sum = Calculator.calculateSingle(operators.get(i), sum, operands.get(i + 1));
        }

        return sum;
    }

    private static Integer calculateSingle(String operator, Integer number1, Integer number2) {
        return getOperator(operator).calculator.apply(number1, number2);
    }

    private static Calculator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(operator + "는 " + MESSAGE_WRONG_OPERATOR));
    }

    private static void validateInput(String inputFormula) {
        Validator.validateInputFormula(inputFormula);
        Validator.validateArithmeticFormula(inputFormula);
    }

    public String getOperator() {
        return operator;
    }
}
