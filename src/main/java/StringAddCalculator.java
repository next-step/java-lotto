import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private final static String COMMA = ",";
    private final static String COLON = ":";
    private final static String DELIMITER = ",|:";
    private final static String CUSTOM_DELIMITER_PATTERN = "//(.)\\n(.*)";

    public Integer add(String input) {
        if (isEmptyValue(input)) {
            return 0;
        }

        if (isSingleNumber(input)) {
            return Integer.parseInt(input);
        }

        if (containsDelimiter(input)) {
            String[] numbers = input.split(DELIMITER);
            return getSum(numbers);
        }

        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return getSum(m.group(2).split(customDelimiter));
        }

        return null;
    }

    private boolean containsDelimiter(String input) {
        return input.contains(COMMA) || input.contains(COLON);
    }

    private int getSum(String[] split) {
        int result = 0;
        for (String s : split) {
            result += Integer.parseInt(s);
        }
        return result;
    }

    private boolean isSingleNumber(String input) {
        return input.length() == 1;
    }

    private boolean isEmptyValue(String input) {
        return input == null || input.isEmpty();
    }
}
