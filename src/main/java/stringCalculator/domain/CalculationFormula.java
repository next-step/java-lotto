package stringCalculator.domain;

import java.util.regex.Pattern;
import stringCalculator.error.ErrorMessage;

public class CalculationFormula {

    private String calculationFormula;

    private static final Pattern blankStringCheckPattern = Pattern.compile("^\\b\\d+(?:\\s[*+\\/-]\\s\\b\\d+\\b)*$");

    public CalculationFormula(String input) {
        if (isNullOrBlank(input)) {
            throw new IllegalArgumentException(
                ErrorMessage.INPUT_VALUE_NOT_NULL_AND_BLANK.getErrorMessage());
        }

        if (!isContainLeftBlank(input)) {
            throw new IllegalArgumentException(
                ErrorMessage.INPUT_VALUE_VALID_BLANK_SPACE.getErrorMessage());
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

