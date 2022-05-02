package calculator.domain;

public class Division extends Operator {
    @Override
    public NumberElement execute(NumberElement operandA, NumberElement operandB) {
        return new NumberElement(operandA.getValue() / operandB.getValue());
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
