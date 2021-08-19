package StringCalculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private static final String INPUT_EMPTY = "";
    private static final String DEFAULT_OUTPUT = "0";
    public static final String CUSTOMIZED_DELIMITER_REGEX = "//(.)\n(.*)";
    public static final String NORMAL_DELIMITER_REGEX = "[,:]";


    private static List<String> parseStringToStringList(String input) {
        if (input == null|| INPUT_EMPTY.equals(input)) {
            return Collections.singletonList(DEFAULT_OUTPUT);
        }

        Pattern pattern = Pattern.compile(CUSTOMIZED_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens= matcher.group(2).split(customDelimiter);
            return Arrays.asList(tokens);
        }

        return Arrays.asList(input.split(NORMAL_DELIMITER_REGEX));
    }

    public static List<Integer> parseStringListToIntegerList(String input) {

        List<String> parsedToStr = parseStringToStringList(input);
        List<Integer> parsedToInt = new LinkedList<>();
        parsedToStr.forEach(item -> parsedToInt.add(Integer.valueOf(item)));
        return parsedToInt;
    }
}
