package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatcher {
    private static final String DELIMETER = ",|:";
    private static final String PATTERN = "//(.)\n(.*)";

    private String delimeter;
    private String numbers;

    private StringMatcher(String text) {
        Matcher matcher = matcher(text);
        if (matcher.find()) {
            setByCustomDelimeter(matcher);
            return;
        }
        setByDefaultDelimeter(text);
    }

    public static StringMatcher of(String text) {
        return new StringMatcher(text);
    }

    public String getDelimeter() {
        return delimeter;
    }

    public String getNumbers() {
        return numbers;
    }

    private Matcher matcher(String text) {
        return Pattern.compile(PATTERN).matcher(text);
    }

    private void setByDefaultDelimeter(String text) {
        this.delimeter = DELIMETER;
        this.numbers = text;
    }

    private void setByCustomDelimeter(Matcher matcher) {
        this.delimeter = matcher.group(1);
        this.numbers = matcher.group(2);
    }
}
