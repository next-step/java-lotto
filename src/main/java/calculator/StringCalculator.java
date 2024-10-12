package calculator;

public class StringCalculator {

    public static final Operator operator = Operator.getOperator();

    public int calculate(String input) {
        return calculateExpression(validInput(input));
    }

    public String validInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("null 혹은 공백 문자열은 연산 불가능합니다");
        }
        return input;
    }

    public int calculateExpression(String expression) {
        return operator.calculate(expression);
    }

}
