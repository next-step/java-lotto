package lotto;

public class TextBasedCalculator {
    public static final String DELIMITER = " ";

    public static NumberToken calculate(String inputExpression) {
        String[] tokens = inputExpression.split(DELIMITER);

        NumberToken result = new NumberToken(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            result = result.operate(new NumberToken(tokens[i + 1]), new OperatorToken(tokens[i]));
        }
        return result;
    }
}
