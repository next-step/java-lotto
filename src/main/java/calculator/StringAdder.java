package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yusik on 2019/11/02.
 */
public class StringAdder {

    public static String REGEX_DEFAULT_DELIMITER = "[,:]";
    public static String REGEX_CUSTOM_DELIMITER = "//(.)\n(.*)";

    public int sum(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] tokens = split(input);
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseUnsignedInt(token);
        }

        return sum;
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
