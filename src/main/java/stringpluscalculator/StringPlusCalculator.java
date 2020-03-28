package stringpluscalculator;

import java.util.Objects;

public class StringPlusCalculator {

    private static final int RETURN_VALUE_WHEN_EMPTY = 0;

    private String input;
    private Separators separators;
    private Formula formula;

    public StringPlusCalculator(String input) {
        this.input = input;
        if (!isInputEmptyOrNull(input)) {
            this.separators = new Separators(input);
            this.formula = new Formula(input, separators.getSplitSeparator());
        }
    }

    public int calculate() {
        if (isInputEmptyOrNull(input)) {
            return RETURN_VALUE_WHEN_EMPTY;
        }
        return formula.sum();
    }

    public boolean isInputEmptyOrNull(String input) {
        return Objects.isNull(input) || input.isEmpty();
    }
}
