package calcurator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (checkNullOrEmpty(input)) return Const.INITIAL_NUMBER_ZERO;
        return -1;
    }

    private static boolean checkNullOrEmpty(String input) {
        return (input == null || input.isEmpty());
    }
}
