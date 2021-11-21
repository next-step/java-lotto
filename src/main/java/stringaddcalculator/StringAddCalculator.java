package stringaddcalculator;

public class StringAddCalculator {

    public static Number splitAndSum(String expression) {
        if (expression == null) {
            return new Number(0);
        }

        if (expression.isEmpty()) {
            return new Number(0);
        }

        return new Number(Integer.parseInt(expression));
    }
}
