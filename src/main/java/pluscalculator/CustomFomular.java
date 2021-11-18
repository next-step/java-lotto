package pluscalculator;

import java.util.regex.Matcher;

public class CustomFomular extends Fomular {
    private final Matcher matcher;

    public CustomFomular(Matcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public int calc(String input) {
        String customDelimiter = matcher.group(1);
        String[] tokens = matcher.group(2).split(customDelimiter);
        int result = 0;
        for (String s : tokens) {
            int number = Integer.parseInt(s);
            validateMinusNum(s);
            result += number;
        }
        return result;
    }
}
