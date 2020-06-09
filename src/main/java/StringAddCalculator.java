import java.util.Arrays;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",|\\:";
    private static final int ZERO = 0;

    public static int splitAndSum(String text) {
        if (isNumeric(text)) {
            return parseInt(text);
        };
        if(isNull(text)) {
            return ZERO;
        }
        if(text.isEmpty()) {
            return ZERO;
        }
        return addDefault(text);
    }

    private static int addDefault(String text) {
        String[] split = text.split(DEFAULT_DELIMITER);
        return Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static int parseInt(String text) {
        return Integer.parseInt(text);
    }

    private static boolean isNumeric(String text) {
        return text.chars().allMatch(Character::isDigit);
    }

    private static boolean isNull(String text) {
        return text == null;
    }

}
