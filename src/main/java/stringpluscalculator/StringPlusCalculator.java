package stringpluscalculator;

public class StringPlusCalculator {

    private static final int RETURN_VALUE_WHEN_EMPTY = 0;

    private String input;
    private Separators separators;
    private Formula formula;

    public StringPlusCalculator(String input) {
        this.input = input;
        if (!isEmpty()) {
            this.separators = new Separators(input);
            this.formula = new Formula(separators.getInputWithoutCustomSeparator(input), separators.getSplitSeparator());
        }
    }

    public int calculate() {
        if (isEmpty()) {
            return RETURN_VALUE_WHEN_EMPTY;
        }
        return 1;
    }

    private boolean isEmpty() {
        if (input == null || input.isEmpty() || separators.getInputWithoutCustomSeparator(input).isEmpty()) {
            return true;
        }
        return false;
    }
}
