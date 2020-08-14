package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparatorFactory {

    public static Separator create(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return new CustomSeparator(customDelimiter);
        }

        return BasicSeparator.of();
    }

}
