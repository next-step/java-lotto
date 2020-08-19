package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumericalExpression {

    public static final String DELIMITER = ",|:";

    private final String text;

    public NumericalExpression(String text) {
        this.text = text;
    }

    public String[] split() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(DELIMITER);
    }

}
