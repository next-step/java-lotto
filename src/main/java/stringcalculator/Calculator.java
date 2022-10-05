package stringcalculator;

public class Calculator {
    public static int add(String number1, String number2) {
        return parseNumber(number1) + parseNumber(number2);
    }

    private static int parseNumber(String number) {
        return Integer.parseInt(number);
    }
}
