package util;

public class LottoNumberSplit {
    private static final String PATTERN = ",";

    public static String[] splitWinningNumberByComma(String input) {
        return input.split(PATTERN);
    }

}
