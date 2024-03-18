package stringCalculatorTest;

public class StringCalculator {
    public static int addition(String input) {
//        1 + 2
        String[] tokens = input.split(" ");
        return Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[2]);
    }
}
