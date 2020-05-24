package study.step1;

public class StringAddCalculator {

    public static int splitAndSum(String expression) {
        String [] splitExpression = new Expression(expression).split();
        return new Numbers(splitExpression).sum();
    }
}
