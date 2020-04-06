package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String expression) {
        Numbers numbers = Numbers.create(Expression.toArray(expression));
        return numbers.sum();
    }

}
