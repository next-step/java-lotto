package stringcaculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    private static final Pattern CUSTOM_REGEX = Pattern.compile(DelimiterRegex.CUSTOM.toString());
    private static final int CUSTOM_DELIMITER = 1;
    private static final int LAST_INPUT = 2;
    private final Input input;

    private Matcher matcher;

    public Delimiter(Input input) {
        this.input = input;
    }

    public boolean useCustomDelimeter() {
        this.matcher = CUSTOM_REGEX.matcher(input.getValue());
        return matcher.find();
    }

    public String[] splitedInput(){
        if (useCustomDelimeter()) {
            return this.matcher.group(LAST_INPUT).split(matcher.group(CUSTOM_DELIMITER));
        }
        return input.splitedInput(DelimiterRegex.GENERAL);
    }
}
