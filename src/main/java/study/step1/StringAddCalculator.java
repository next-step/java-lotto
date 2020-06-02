package study.step1;

public class StringAddCalculator {

    public static int splitAndSum(String expression) {
        String validatedExpression = Expression.validateExpression(expression);
        return new Numbers(Expression.split(validatedExpression)).sum();
    }
}
