package lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterCustomDelimiter {
    private final Pattern pattern = Pattern.compile("^//(\\D)\n.+");

    public Delimiter filter(String rawFormula) {
        Matcher matcher = pattern.matcher(rawFormula);
        if (matcher.find()) {
            return new Delimiter(matcher.group(1));
        }
        return null;
    }
}
