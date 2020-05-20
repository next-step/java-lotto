package calculator.delimiter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter implements Delimiter {
    private static final String DELIMITER = "//(.)\n(.*)";

    @Override
    public List<String> split(List<String> expressions) {
        List<String> result = new ArrayList<>();
        for (String expression : expressions) {
            result.addAll(this.split(expression));
        }
        return result;
    }

    private List<String> split(String expression) {
        Matcher matcher = Pattern.compile(DELIMITER).matcher(expression);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(delimiter);
            return Arrays.asList(tokens);
        }
        return Arrays.asList(expression);
    }
}
