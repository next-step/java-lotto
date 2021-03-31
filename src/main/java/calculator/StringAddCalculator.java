package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String expression) {
        Splitted splitted = new Splitted(new Expression(expression));
        Sum sum = new Sum(splitted);
        return sum.sum();
    }
}
