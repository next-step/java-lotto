package stringpluscalculator;

public class StringPlusCalculator {

    private static final int RETURN_VALUE_WHEN_EMPTY = 0;

    private String input;
    private Separators separators;
    private Formula formula;

    public StringPlusCalculator(String input) {
        this.input = input;
        if (!input.isEmpty()) {
            this.separators = new Separators(input);
            this.formula = new Formula(input, separators.getSplitSeparator());
        }
    }

    public int calculate() {
        if (input.isEmpty()) {
            return RETURN_VALUE_WHEN_EMPTY;
        }
        return formula.sum();
    }
}
