package stringcalculator;

public class StringCalculator {
    public int calculate(String text) {
        String[] splitArr = text.split(" ");
        int number1 = Integer.parseInt(splitArr[0]);
        int number2 = Integer.parseInt(splitArr[2]);
        String operate = splitArr[1];

        if ("+".equals(operate)) {
            return plus(number1, number2);
        }
        if ("-".equals(operate)) {
            return minus(number1, number2);
        }
        if ("*".equals(operate)) {
            return multiply(number1, number2);
        }
        if ("/".equals(operate)) {
            return divide((double) number1, number2);
        }
        return 0;
    }

    private static int plus(int number1, int number2) {
        return number1 + number2;
    }

    private static int minus(int number1, int number2) {
        return number1 - number2;
    }

    private static int multiply(int number1, int number2) {
        return number1 * number2;
    }

    private static int divide(double number1, int number2) {
        return (int) Math.ceil(number1 / number2);
    }

}
