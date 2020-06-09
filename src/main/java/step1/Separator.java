package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    public static final String DEFAULT_SEPARATOR = ",|:";
    public static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");

    private Separator(){}

    private static String[] split(String formula, String separator) {
        return formula.split(separator);
    }

    public static String[] split(String formula) {
        return split(formula, DEFAULT_SEPARATOR);
    }

    public static String[] splitCustom(String customSeparatorFormula) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(customSeparatorFormula);
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            String formula = matcher.group(2);
            return split(formula, customSeparator);
        }

        return null;
    }
}
