public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (isNumeric(text)) {
            return parseInt(text);
        };
        if(isNull(text)) {
            return 0;
        }
        if(text.isEmpty()) {
            return 0;
        }
        return 0;
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
