package policy;

public class SplitWinningNumber {
    private static final String SPLIT_PATTERN = ",";

    public static String[] splitByComma(String input) {
        return input.trim().split(SPLIT_PATTERN);
    }

}
