package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yusik on 2019/11/02.
 */
public class StringAdder {

    private static final String REGEX_DEFAULT_DELIMITER = "[,:]";
    private static final String REGEX_CUSTOM_DELIMITER = "//(.)\n(.*)";

    public int sum(String input) {
        return input.isEmpty()
                ? 0
                : Arrays.stream(split(input))
                .map(Integer::parseUnsignedInt)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private String[] split(String input) {
        Matcher matcher = Pattern.compile(REGEX_CUSTOM_DELIMITER).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return input.split(REGEX_DEFAULT_DELIMITER);
    }
}
