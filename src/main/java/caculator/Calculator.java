package caculator;

public class Calculator {

    public static int calculateTwoNumber(final int number1, final String operation, final int number2) {
        if ("+".equals(operation)) {
            return number1 + number2;
        }
        if ("-".equals(operation)) {
            return number1 - number2;
        }
        if ("*".equals(operation)) {
            return number1 * number2;
        }
        if ("/".equals(operation)) {
            return number1 / number2;
        }
        return 0;
    }
}
