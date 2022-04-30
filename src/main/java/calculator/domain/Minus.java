package calculator.domain;

public class Minus extends Operator {
    @Override
    public NumberElement execute(NumberElement a, NumberElement b) {
        return new NumberElement(a.getValue() - b.getValue());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        return true;
    }
}
