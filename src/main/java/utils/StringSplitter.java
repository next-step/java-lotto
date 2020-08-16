package utils;

import exception.StringAdderExceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringSplitter {
    private static final String REGEX_DEFAULT_DELIMITER = "[,:]";
    private static final Pattern REGEX_CUSTOM_DELIMITER = Pattern.compile("(.)\\n(.*)");
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int CUSTOM_NUMBER_GROUP = 2;

    private StringSplitter() { }

    public static List<Integer> splitDelimiter(String input) {
        Matcher matcher = REGEX_CUSTOM_DELIMITER.matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP);
            return castingToList(matcher.group(CUSTOM_NUMBER_GROUP).split(customDelimiter));
        }
        return castingToList(input.split(REGEX_DEFAULT_DELIMITER));
    }

    public static List<Integer> castingToList(String[] input) {
        return Arrays.stream(input)
                .map(Integer::parseInt)
                .peek(StringAdderExceptionHandler::validate)
                .collect(Collectors.toList());
    }
}
