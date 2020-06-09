package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserUtils {

    private final static String DEFAULT_DELIMITER = ",|:" ;
    private final static String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private final static int CUSTOM_DELIMITER_INDEX = 1;
    private final static int TEXT_INDEX = 2;

    private ParserUtils() {
    }

    public static List<Integer> stringToArray(String input) {


        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
            return stringListToIntList(matcher.group(TEXT_INDEX).split(customDelimiter));
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
