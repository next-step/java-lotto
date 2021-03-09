package StringAddCalculator;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return Number.ZERO.toValue();
        }
        String[] stringNumberArray = split(input);
        return sum(stringNumberArray);
    }

    private static String[] split(String input) {
        return TextSplitter.split(input);
    }

    private static int sum(String[] stringNumberArray) {
        Number numberToAdd = Number.ZERO;
        for (String stringNumber : stringNumberArray) {
            numberToAdd = numberToAdd.sum(Number.valueOf(stringNumber));
        }
        return numberToAdd.toValue();
    }

    public static boolean isBlank(String string) {
        return string == null || string.trim().isEmpty();
    }

}
