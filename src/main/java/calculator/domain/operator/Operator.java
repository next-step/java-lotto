package calculator.domain.operator;

import java.util.function.IntBinaryOperator;

public class Operator {

    private final IntBinaryOperator operation;

    public Operator(String symbol) {
        this.operation = Operation.findFunctionBySymbol(symbol);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Operator operator = (Operator) obj;

        return this.operation == operator.operation;
    }

    @Override
    public int hashCode() {
        return this.operation.hashCode();
    }
}
