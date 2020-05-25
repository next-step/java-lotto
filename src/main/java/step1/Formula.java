package step1;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formula formula1 = (Formula) o;
        return Objects.equals(formula, formula1.formula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formula);
    }
}
