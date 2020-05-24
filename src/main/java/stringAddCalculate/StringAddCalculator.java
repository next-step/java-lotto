package stringAddCalculate;

public class StringAddCalculator {
    public static int splitAndSum(String expression) {
        if (expression == null || expression.trim().equals("")) {
            return 0;
        }

        if (expression.trim().length() == 1) {
            return Integer.parseInt(expression.trim());
        }
        return 1;
    }
}
