package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    public static final String DEFAULT_SEPARATOR = ",|:";
    public static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");

    private Separator(){}

    public static String[] split(String formula) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(formula);
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            String customSeparatorFormula = matcher.group(2);
            return defaultSplit(customSeparatorFormula, customSeparator);
        }

        return defaultSplit(formula, DEFAULT_SEPARATOR);
    }

    private static String[] defaultSplit(String formula, String separator) {
        return formula.split(separator);
    }
}
