package calculator;

import java.util.Arrays;

public class Formula {
    private final String[] elements;

    public Formula(String formula) {
        this.elements = formula.split(" ");
    }

    public Formula(String[] elements) {
        this.elements = elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formula formula = (Formula) o;
        return Arrays.equals(elements, formula.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }
}
