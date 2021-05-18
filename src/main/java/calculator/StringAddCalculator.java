package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] splits = input.split(",");
        int result = 0;
        for (String split : splits) {
            result += Integer.parseInt(split);
        }
        return result;

    }
}
