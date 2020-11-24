package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int sum = 0;

        String[] tokens = input.split(",|:");
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}
