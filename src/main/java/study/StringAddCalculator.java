package study;


public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static int calculate(String expression) {
        if(ValidateUtil.validateEmptyExpression(expression)) {
            return 0;
        }

        SplitExpression splitExpression = new SplitExpression(expression);
        return splitExpression.sum();
    }
}
