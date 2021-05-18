import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return sumStringNumbers(text);
    }

    private static int sumStringNumbers(String text) {
        int result = 0;
        String[] splitTextArray = createNumberStringArray(text);
        for (String numberString : splitTextArray) {
            result += checkNegativeNumber(numberString);
        }
        return result;
    }

    private static int checkNegativeNumber(String numberString) {
        int number = Integer.parseInt(numberString);
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    private static String[] createNumberStringArray(String text) {
        Matcher matcher = Pattern.compile(REGEX).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }
}
