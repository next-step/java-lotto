package stringaccumulator;

import java.util.Objects;

public class StringAccumulator {
    private final String expression;

    public StringAccumulator(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringAccumulator)) return false;
        StringAccumulator that = (StringAccumulator) o;
        return Objects.equals(getExpression(), that.getExpression());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExpression());
    }
}
