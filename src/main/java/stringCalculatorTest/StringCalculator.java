package stringCalculatorTest;

public class StringCalculator {
    public static int addition(String input) {
        String[] tokens = input.split(" ");
        return Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[2]);
    }

    public static int subtract(String input) {
        String[] tokens = input.split(" ");
        return Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[2]);
    }

    public static int division(String input) {
        String[] tokens = input.split(" ");
        return Integer.parseInt(tokens[0]) / Integer.parseInt(tokens[2]);
    }

    public static int multiple(String input) {
        String[] tokens = input.split(" ");
        return Integer.parseInt(tokens[0]) * Integer.parseInt(tokens[2]);
    }
}
