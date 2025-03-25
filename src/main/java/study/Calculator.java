package study;

public class Calculator {

    public static int calculate(String expression) {
        String[] values = expression.replace(" ", "").split("\\+");

        return Integer.parseInt(values[0]) + Integer.parseInt(values[1]);
    }
}
