package sequenceCalculator;

public class SequenceCalculator {

    private static final String INPUT_SEPARATOR = " ";

    private int result;
    private Operator operator;

    public SequenceCalculator() {
        this.result = 0;
        this.operator = Operator.PLUS;
    }

    public int calculate(String input) {
        validInput(input);
        for (String expression : input.split(INPUT_SEPARATOR)) {
            if (ExpressionChecker.isDigit(expression)) {
                result = operator.calculate(result, Integer.parseInt(expression));
                continue;
            }
            operator = Operator.findOperator(expression);
        }
        return result;
    }

    private void validInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("null이나 빈 문자열은 들어올 수 없습니다.");
        }
    }

}
