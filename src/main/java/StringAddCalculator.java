/**
 * @author han
 */
public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (nullOrEmpty(input)) {
            return 0;
        }
        return Integer.parseInt(input);
    }

    private static boolean nullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
