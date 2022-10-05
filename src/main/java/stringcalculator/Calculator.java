package stringcalculator;

public class Calculator {
    public static int add(String number1, String number2) {
        return parseNumber(number1) + parseNumber(number2);
    }

    private static int parseNumber(String number) {
        return Integer.parseInt(number);
    }

    public static int minus(String number1, String number2) {
        return parseNumber(number1) -  parseNumber(number2);
    }

    public static int multiply(String number1, String number2) {
        return parseNumber(number1) * parseNumber(number2);
    }

    public static int divide(String number1, String number2) {
        return parseNumber(number1) / parseNumber(number2);
    }
}
