package calculator;

public class StringAddCalculator {
    public static int calculate(String expression) {
        if (expression == null) {
            return 0;
        }
        if (expression == "") {
            return 0;
        }
        return Integer.parseInt(expression);
    }
}
