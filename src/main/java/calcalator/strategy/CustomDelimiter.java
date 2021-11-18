package calcalator.strategy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter implements DelimiterStrategy {
    @Override
    public String[] getToken(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split("");
    }

}
