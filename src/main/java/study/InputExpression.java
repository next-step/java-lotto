package study;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputExpression {
    public static final Pattern customDelimiter = Pattern.compile("^\\/\\/(.)\\\\n");
    private final String inputString;

    public InputExpression(String inputString) {
        this.inputString = inputString;
    }

    public List<String> split() {
        Matcher matcher = InputExpression.customDelimiter.matcher(inputString);
        while (matcher.find()) {
            return splitWithCustomDelimiter(matcher);
        }
        return splitWithDefaultDelimiter();
    }

    public List<String> splitWithDefaultDelimiter() {
        return splitWithDelimiter(inputString, ",|:");
    }

    public List<String> splitWithCustomDelimiter(Matcher matcher) {
        return splitWithDelimiter(inputString.replace(matcher.group(0), ""),
                                  Pattern.quote(matcher.group(1)));
    }

    private List<String> splitWithDelimiter(String inputString, String delimiter) {
        String[] tokens = inputString.split(delimiter);
        return Arrays.asList(tokens);
    }

}
