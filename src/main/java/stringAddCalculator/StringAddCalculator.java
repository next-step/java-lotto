package stringAddCalculator;

public class StringAddCalculator {
    public static int sumString(String input) {
        if(isNullOrEmpty(input))
            return Number.ZERO;
        return Number.addStringCalculate(Delimiter.isBasicOrCustom(input));
    }
    private static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().equals("");
    }
}
