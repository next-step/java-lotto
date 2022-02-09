package stringadder.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringUtils {

    private static final String STANDARD_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\\n(.*)";
    private static final String SLASH = "//";
    private static final int SELECT_DELIMITER_INDEX = 1;
    private static final int SELECT_VALUES_INDEX = 2;
    private static final String ERROR_MESSAGE = "지원하지 않은 형식의 구분자 입니다.";

    private static final Pattern pattern;

    static {
        pattern = Pattern.compile(CUSTOM_DELIMITER);
    }

    private StringUtils() {

    }

    public static List<String> splitInput(final String input) {
        if (input == null) {
            return new ArrayList<>();
        }

        if (input.contains(SLASH)) {
            String[] tokens = split(input);
            return Arrays.stream(tokens)
                .collect(Collectors.toList());
        }
        return Arrays.stream(input.split(STANDARD_DELIMITER))
            .collect(Collectors.toList());

    }

    private static String[] split(String input) {
        Matcher matcher = pattern.matcher(input);
        String[] tokens = null;
        if (!matcher.find()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        String customDelimiter = matcher.group(SELECT_DELIMITER_INDEX);
        tokens = matcher.group(SELECT_VALUES_INDEX).split(customDelimiter);

        return tokens;
    }
}
