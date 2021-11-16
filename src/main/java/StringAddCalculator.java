/**
 * @author han
 */
public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (nullOrEmpty(input)) {
            return 0;
        }

        String[] numbers = split(input);
        return sum(numbers);
    }

    private static boolean nullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static int sum(String[] numbers) {
        int result = 0;
        for (String n : numbers) {
            result += Integer.parseInt(n);
        }
        return result;
    }

    private static String[] split(String input) {
        return input.split(",|:");
    }
}
