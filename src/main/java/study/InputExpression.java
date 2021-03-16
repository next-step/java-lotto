package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputExpression {
    public static final Pattern customDelimiter = Pattern.compile("^\\/\\/(.)\\\\n");
    private final String inputString;

    public InputExpression(String inputString) {
        this.inputString = inputString;
    }

    public Expression split() {
        Matcher matcher = InputExpression.customDelimiter.matcher(inputString);
        if (matcher.find()) {
            return splitWithCustomDelimiter(matcher);
        }
        return splitWithDefaultDelimiter();
    }

    public Expression splitWithDefaultDelimiter() {
        return splitWithDelimiter(inputString, ",|:");
    }

    public Expression splitWithCustomDelimiter(Matcher matcher) {
        return splitWithDelimiter(inputString.replace(matcher.group(0), ""),
                                  Pattern.quote(matcher.group(1)));
    }

    private Expression splitWithDelimiter(String inputString, String delimiter) {
        String[] tokens = inputString.split(delimiter);
        return new Expression(tokens);
    }

}
