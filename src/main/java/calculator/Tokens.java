package calculator;

public class Tokens {
    private final String[] values;

    public Tokens(String expression) {
        validate(expression);
        this.values = parse(expression);
    }

    private void validate(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException("null을 입력할 수 없습니다.");
        }
        if (expression.trim().isEmpty()) {
            throw new IllegalArgumentException("공백 혹은 빈문자열은 입력할 수 없습니다.");
        }
    }

    private String[] parse(String expression) {
        return expression.split(" ");
    }

    public int calculate() {
        return accumulateResult(parseFirstNumber());
    }

    private int parseFirstNumber() {
        return Integer.parseInt(values[0]);
    }

    private int accumulateResult(int result) {
        for (int i = 1; i < values.length; i += 2) {
            result = calculateNext(result, i);
        }
        return result;
    }

    private int calculateNext(int currentResult, int operatorIndex) {
        int operand = Integer.parseInt(values[operatorIndex + 1]);
        OperatorType operator = OperatorType.from(values[operatorIndex]);
        return operator.calculate(currentResult, operand);
    }
}
