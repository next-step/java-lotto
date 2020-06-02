package calcurator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (checkNullOrEmpty(input)) return Const.INITIAL_NUMBER_ZERO;
        if (input.length() == Const.STRING_LENGTH_NUM_ONE) {
            return Integer.parseInt(input);
        }
        return input.split(Const.SYMBOL_COMMA).length;
    }

    private static boolean checkNullOrEmpty(String input) {
        return (input == null || input.isEmpty());
    }
}
