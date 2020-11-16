package step01;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input.trim() == "") {
            return 0;
        }

        try {
            return Integer.parseInt(input);
        } catch (Exception exception) {
        }

        return 1;
    }
}
