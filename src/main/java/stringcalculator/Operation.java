package stringcalculator;

public class Operation {
    public static int addition(int number1, int number2) {
        return number1 + number2;
    }

    public static int subtraction(int number1, int number2) {
        return number1 - number2;
    }

    public static int multiply(int number1, int number2) {
        return number1 * number2;
    }

    public static int division(int number1, int number2) {
        return (int) Math.ceil((double) number1 / number2);
    }
}
