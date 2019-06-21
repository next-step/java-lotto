import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringCalculator {

    private static String DEFAULT_DELIMITER = "[,:]";

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
        return input.split(DEFAULT_DELIMITER);
    }

    public static String pickCustomDelimiterFrom(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            return m.group(1);
        }
        return DEFAULT_DELIMITER;
    }

    public static int add(String[] input) {
        return Stream.of(input).mapToInt(str -> {
            int result;
            try {
                result = Integer.valueOf(str);
                if (result < 0) throw new RuntimeException("음수는 넣을수 없습니다.");
            } catch(NumberFormatException e) {
                throw new RuntimeException("숫자가 아닙니다.");
            }
            return result;
        }).reduce(0, Integer::sum);
    }
}
