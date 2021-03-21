package calculator;

public class StringAddCalculator {

    public static int splitAndSum(Expression expression) {
        Splitted splitted = new Splitted(expression);
        Sum sum = new Sum(splitted);
        return sum.sum();
    }
}
