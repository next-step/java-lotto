package stringCalculator.domain;

import java.util.regex.Pattern;
import stringCalculator.error.exception.NullBlankException;
import stringCalculator.error.exception.WhiteSpaceMissingException;

public class CalculationFormula {

    private static final Pattern blankStringCheckPattern = Pattern.compile(
        "^\\b\\d+(?:\\s[*+\\/-]\\s\\b\\d+\\b)*$");
    private String calculationFormula;

    public CalculationFormula(String input) {
        if (isNullOrBlank(input)) {
            throw new NullBlankException(input);
        }

        if (!isContainLeftBlank(input)) {
            throw new WhiteSpaceMissingException(input);
        }

        this.calculationFormula = input;
    }

    private boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }

    private boolean isContainLeftBlank(String input) {
        return blankStringCheckPattern.matcher(input).matches();
    }

    public String[] parseCalculationFormula() {
        return calculationFormula.split(" ");
    }
}

