package step1;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTokenizer {
    private static final String DEFAULT_DELIMITER = ",";

    public String[] tokenize(String input) {
        if(isEmpty(input))
            return new String[]{"0"};

        String[] tokens = splitByCustomDelimiter(input);
        if (tokens.length > 0)
            return tokens;

        return input.split(DEFAULT_DELIMITER);
    }

    private boolean isEmpty(String input) {
        return "".equals(input) || Objects.isNull(input);
    }

    private String[] splitByCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String expression = matcher.group(2);
            return expression.split(customDelimiter);
        }
        return new String[]{};
    }
}

