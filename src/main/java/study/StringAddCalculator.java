package study;


public class StringAddCalculator {
    private static final String SPLIT_SIGN = "[,:]";

    private final String expression;

    public StringAddCalculator(String expression) {
        this.expression = expression;
    }

    public int calculate() {
        if (this.isEmpty()) {
            return 0;
        }

        String[] splitExpression = expression.split(SPLIT_SIGN);
        return this.sum(splitExpression);
    }

    private boolean isEmpty() {
        return expression == null || expression.isEmpty();
    }

    private int sum(String[] splitExpression) {
        if (splitExpression.length == 1) {
            return 1;
        }

        int result = 0;
        for (int i = 1; i < splitExpression.length; i++) {
            int i1 = result == 0 ? Integer.parseInt(splitExpression[i - 1]) : result;
            int i2 = Integer.parseInt(splitExpression[i]);

            result = i1 + i2;
        }

        return result;
    }
}
