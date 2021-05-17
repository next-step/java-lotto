package StringCalculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        String[] splited = input.split(",");
        if (splited.length > 1) {
            return Integer.parseInt(splited[0]) + Integer.parseInt(splited[1]);
        }
        return Integer.parseInt(input);
    }
}
