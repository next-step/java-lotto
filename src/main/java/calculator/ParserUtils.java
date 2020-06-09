package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserUtils {

    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int EXPRESSION_INDEX = 2;
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = ",|:";

    private ParserUtils() {
    }

    public static List<Integer> stringToArray(String input) {

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
            return stringListToIntList(matcher.group(EXPRESSION_INDEX).split(customDelimiter));
        }

        String[] splitText = input.split(DEFAULT_DELIMITER);
        return stringListToIntList(splitText);
    }

    private static List stringListToIntList(String[] splitText) {

        List resultList = new ArrayList();

        for (String text : splitText) {
            int number = Integer.parseInt(text.trim());
            isMinus(number);
            resultList.add(number);
        }
        return resultList;
    }

    private static void isMinus(int inputNumber) {
        if (inputNumber < 0) {
            throw new RuntimeException();
        }
    }

    public static boolean checkValid(String input) {

        return input == null || input.isEmpty();
    }
}
