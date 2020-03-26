package stringpluscalculator;

public class StringPlusCalculator {

    private static final int RETURN_VALUE_WHEN_EMPTY = 0;
    private Formula formula;

    public StringPlusCalculator(String input) {
        this.formula = new Formula(input);
    }

    public int calculate() {
        if (formula.isEmpty()) {
            return RETURN_VALUE_WHEN_EMPTY;
        }
        return 1;
    }
}
