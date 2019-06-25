package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparateStringExtractor {
    public static String execute(String expression) {

        Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(expression);

        return m.find() ? m.group(1) : null;
    }
}
