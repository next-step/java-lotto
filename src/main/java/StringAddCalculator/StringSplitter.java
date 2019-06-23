package StringAddCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

    static final String CUSTOM_PATTERN = "//(.)\n(.*)";

    public static String[] split(String formula) {
        Matcher customPattern = Pattern.compile(CUSTOM_PATTERN).matcher(formula);
        if (customPattern.find()) {
            String customDelimiter = customPattern.group(1);
            return customPattern.group(2).split(customDelimiter);
        }
        return formula.split(",|:");
    }
}
