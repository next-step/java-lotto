package calcurator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (checkNullOrEmpty(input)) return Const.INITIAL_NUMBER_ZERO;
        return Integer.parseInt(input);
    }

    private static boolean checkNullOrEmpty(String input) {
        return (input == null || input.isEmpty());
    }
}
