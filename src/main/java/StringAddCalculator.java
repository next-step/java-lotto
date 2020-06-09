public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (isNumeric(text)) {
            return Integer.parseInt(text);
        };
        if(isNull(text)) {
            return 0;
        }
        if(text.isEmpty()) {
            return 0;
        }
        return 0;
    }

    private static boolean isNumeric(String text) {
        for (char letter : text.toCharArray()) {
            if (!Character.isDigit(letter)) {
                return false;
            }
        }
        return true;
    }


    private static boolean isNull(String text) {
        return text == null;
    }

}
