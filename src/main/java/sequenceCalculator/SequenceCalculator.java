package sequenceCalculator;

public class SequenceCalculator {

    public int calculate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("null이나 빈 문자열은 들어올 수 없습니다.");
        }

        String[] split = input.split(" ");
        int result = 0;
        Operator operator = Operator.PLUS;
        for (String expression : split) {
            if (ExpressionChecker.isDigit(expression)) {
                result = operator.calculate(result, Integer.parseInt(expression));
                continue;
            }
            if (ExpressionChecker.isBasicOperation(expression)) {
                operator = Operator.findOperator(expression);
            }
        }

        return result;
    }

}
