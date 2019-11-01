package step1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringUtil {
    private static final String REGEX_FOR_CUSTOM_DELIMITER = "//(.)\\\\n(.*)";
    private static final String DEFAULT_REGEX_DELIMITER = ":|,";
    private static final String REGEX_DELIMITER_WITH_CUSTOM_VALUE = ":|,|";

    public static List<String> splitStrings(String input) {
        Matcher delimiterMatcher = Pattern.compile(REGEX_FOR_CUSTOM_DELIMITER).matcher(input);

        String delimiter = DEFAULT_REGEX_DELIMITER;
        if (delimiterMatcher.find()) {
            delimiter = REGEX_DELIMITER_WITH_CUSTOM_VALUE + delimiterMatcher.group(1);
            input = delimiterMatcher.group(2);
        }

        return Arrays.stream(input.trim()
                .split(delimiter))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<Integer> parsePositiveInt(List<String> inputWords) {
        List<Integer> result = new ArrayList<>();
        for (String inputWord : inputWords) {
            result.add(parsePositiveInt(inputWord));
        }
        return result;
    }

    private static Integer parsePositiveInt(String word) {
        int number = parseInt(word);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    private static Integer parseInt(String word) {
        try {
            return Integer.parseInt(word);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }
}
