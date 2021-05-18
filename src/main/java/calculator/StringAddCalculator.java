package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        return sum(splitByDelimiter(input));

    }

    private static String[] splitByDelimiter(String input) {
        return input.split(",|:");
    }

    private static int sum(String[] splits) {
        int result = 0;
        for (String split : splits) {
            result += Integer.parseInt(split);
        }
        return result;
    }
}
