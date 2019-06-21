public class StringCalculator {

    public static boolean isEmpty(String input) {
        return null == input || "".equals(input.trim());
    }

    public static int calculate(String input) {
        if (isEmpty(input)) {
            return 0;
        }
        return 0;
    }
}
