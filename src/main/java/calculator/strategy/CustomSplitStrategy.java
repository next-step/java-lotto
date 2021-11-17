package calculator.strategy;

import calculator.DelimiterRegex;
import java.util.regex.PatternSyntaxException;

public class CustomSplitStrategy implements SplitStrategy {

    private static final String TWO_BACKSLASH = "\\";
    private static final String EMPTY = "";

    @Override
    public String[] getSplitInput(String input, String delimiter) {
        input = DelimiterRegex.getInput(input);

        try {
            return input.split(delimiter);
        } catch (PatternSyntaxException e) {
            delimiter = String.join(EMPTY, TWO_BACKSLASH, delimiter);
            return input.split(delimiter);
        }

    }
}
