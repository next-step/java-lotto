package step1;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (StringUtils.isNullOrEmpty(text)) {
            return 0;
        }
        NumericalExpression numericalExpression = new NumericalExpression(text);
        Numbers numbers = new Numbers(numericalExpression.split());
        return numbers.sum();
    }

}
