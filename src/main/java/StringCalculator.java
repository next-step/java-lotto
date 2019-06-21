import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        return input.split("\n").length == 2;
    }

    public static String pickCustomDelimiterFrom(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            return m.group(1);
        }
        return DELIMITER;
    }
}
