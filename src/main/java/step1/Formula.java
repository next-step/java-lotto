package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formula {
    private static final String LEFT_SQUARE_BRACKET = "[";
    private static final String RIGHT_SQUARE_BRACKET = "]";
    private static final String DEFAULT_REGEX = ",:";
    private static final int CUSTOM_FORMULA_REGEX_INDEX = 1;
    private static final int CUSTOM_FORMULA_INDEX = 2;

    private String formula;

    public Formula(String formula) {
        this.formula = formula;
    }

    public String getFormula() {
        return formula;
    }

    public String[] split() {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(formula);
        String customRegex = "";
        if (matcher.find()) {
            customRegex = matcher.group(CUSTOM_FORMULA_REGEX_INDEX);
            formula = matcher.group(CUSTOM_FORMULA_INDEX);
        }
        return formula.split(LEFT_SQUARE_BRACKET + DEFAULT_REGEX + customRegex + RIGHT_SQUARE_BRACKET);
    }
}
