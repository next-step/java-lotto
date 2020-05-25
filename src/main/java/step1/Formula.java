package step1;

public class Formula {

    private final String formula;

    private Formula(final String formula) {
        this.formula = formula;
    }

    public static Formula valueOf(String formula) {
        return new Formula(formula);
    }

    public boolean isBlank() {
        return this.formula == null || this.formula.trim().isEmpty();
    }

    public String get() {
        return this.formula;
    }
}
