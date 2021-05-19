import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String NOT_AVAILABLE_NEGATIVE_MESSAGE = "음수를 입력할 수 없습니다.";
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int MIN_NUMBER = 0;
    private static final int GROUP_FIRST = 1;
    private static final int GROUP_SECOND = 2;

    public static int splitAndSum(String input){
        if (input == null || input.isEmpty()) {
            return MIN_NUMBER;
        }

        return sum(splitByDelimiter(input));
    }

    private static String[] splitByDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(GROUP_FIRST);
            return matcher.group(GROUP_SECOND).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    private static int sum(String[] splits) {
        int result = MIN_NUMBER;
        for (String split : splits) {
            result += parseIntPositive(split);
        }
        return result;
    }

    private static int parseIntPositive(String split) {
        int result = Integer.parseInt(split);
        if (result < 0) {
            throw new RuntimeException(NOT_AVAILABLE_NEGATIVE_MESSAGE);
        }
        return result;
    }


}
