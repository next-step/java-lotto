package calculator.domain;

import java.util.Objects;

public class Formula {
    Elements elements;

    public Formula(String formula) {
        this(Elements.of(formula));
    }

    public Formula(Elements elements) {
        this.elements = elements;
    }

    public int calculate() {
        NumberElement result = (NumberElement) elements.poll();
        while (elements.hasNextElements()) {
            Operator operator = (Operator) elements.poll();
            NumberElement operand = (NumberElement) elements.poll();

            result = operator.execute(result, operand);
        }

        return result.getValue();
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Formula formula = (Formula) obj;
        return this.elements.equals(formula.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}
