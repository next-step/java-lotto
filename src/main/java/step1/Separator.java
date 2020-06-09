package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");

    private static final int CUSTOM_SEPARATOR_GROUP_NUMBER= 1;
    private static final int CUSTOM_SEPARATOR_FORMULA_GROUP_NUMBER = 2;

    private Separator(){}

    public static String[] split(String formula) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(formula);
        if (matcher.find()) {
            String customSeparator = matcher.group(CUSTOM_SEPARATOR_GROUP_NUMBER);
            String customSeparatorFormula = matcher.group(CUSTOM_SEPARATOR_FORMULA_GROUP_NUMBER);
            return splitFormulaBySeparator(customSeparatorFormula, customSeparator);
        }

        return splitFormulaBySeparator(formula, DEFAULT_SEPARATOR);
    }

    private static String[] splitFormulaBySeparator(String formula, String separator) {
        return formula.split(separator);
    }
}
