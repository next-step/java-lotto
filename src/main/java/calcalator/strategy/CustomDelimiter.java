package calcalator.strategy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter implements DelimiterStrategy {

    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    @Override
    public String[] getToken(String input) {
        if (input == null) {
            return new String[]{"0"};
        }
        Matcher m = PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split("");
    }

}
