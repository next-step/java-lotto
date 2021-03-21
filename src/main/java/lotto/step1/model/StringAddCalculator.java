package lotto.step1.model;

public class StringAddCalculator {
    private StringAddCalculator(){}
    public static int sum(String input){
        Expression expression = new Expression(input);
        return new NonNegativeIntegers(expression.integers()).sum()
                                                             .value();
    }
}
