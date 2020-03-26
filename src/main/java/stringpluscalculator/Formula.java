package stringpluscalculator;

public class Formula {
    private String formula;

    public Formula(String input) {
        this.formula = input;
    }

    public boolean isEmpty() {
        if (formula == null || formula.isEmpty()) {
            return true;
        }
        return false;
    }
}
