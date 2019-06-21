public class StringCalculator {

    private static String DELIMITER = "[,:]";

    public static boolean isEmpty(String input) {
        return null == input || "".equals(input.trim());
    }

    public static int calculate(String input) {
        if (isEmpty(input)) {
            return 0;
        }
        return 0;
    }

    public static String[] split(String input) {
        return input.split(DELIMITER);
    }

    public static boolean hasCustomDelimiter(String input) {
        return false;
    }
}
