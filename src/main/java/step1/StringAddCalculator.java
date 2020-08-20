package step1;

public class StringAddCalculator {

    public static final int DEFAULT_VALUE = 0;

    public static int splitAndSum(String text) {
        if (StringUtils.isNullOrEmpty(text)) {
            return DEFAULT_VALUE;
        }
        NumericalExpression numericalExpression = new NumericalExpression(text);
        Numbers numbers = new Numbers(numericalExpression.split());
        return numbers.sum();
    }

}
