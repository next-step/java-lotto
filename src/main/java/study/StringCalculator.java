package study;

public class StringCalculator {

    public int calculate(final String input) {
        validateInput(input);
        String[] tokens = input.split(" ");
        validateTokens(tokens);
        return calculateExpression(tokens);
    }

    private void validateInput(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값이 null 이거나 빈 공백 문자열입니다.");
        }
    }

    private void validateTokens(final String[] tokens) {
        if (tokens.length < 1) {
            throw new IllegalArgumentException("유효한 계산식이 아닙니다.");
        }
    }

    private int calculateExpression(final String[] tokens) {
        int result = Integer.parseInt(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            result = calculateNextOperation(result, tokens, i);
        }

        return result;
    }

    private int calculateNextOperation(final int result, final String[] tokens, final int operatorIndex) {
        validateOperatorAndOperand(tokens, operatorIndex);
        int number = Integer.parseInt(tokens[operatorIndex + 1]);

        return Operator.of(tokens[operatorIndex]).operate(result, number);
    }

    private void validateOperatorAndOperand(final String[] tokens, final int operatorIndex) {
        if (operatorIndex + 1 >= tokens.length) {
            throw new IllegalArgumentException("연산자 뒤에 피연산자가 없습니다.");
        }
    }
}
