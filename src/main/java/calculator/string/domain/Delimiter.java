package calculator.string.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    private final Pattern pattern = Pattern.compile("//(.)\n(.*)");
    private final List<String> delimiters;
    private Matcher m;

    public Delimiter() {
        this.delimiters = new ArrayList<>(Arrays.asList(":", ","));
    }

    public boolean hasNewDelimiter(String expression) {
        m = pattern.matcher(expression);
        return m.find();
    }

    public void updateDelimiter() {
        if (m != null) {
            String customDelimiter = m.group(1);
            delimiters.add(customDelimiter);
        }
    }

    public String extractExpression() {
        if (m != null){
            return m.group(2);
        }
        return null;
    }

    public String getDelimiters() {
        StringBuilder result = new StringBuilder();
        for (String symbol : this.delimiters) {
            result.append(symbol).append("|");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
