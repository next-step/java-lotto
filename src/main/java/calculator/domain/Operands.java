package calculator.domain;

import java.util.List;
import java.util.Objects;

public class Operands {
    private final List<OperandNumber> operands;

    public Operands(List<OperandNumber> operands) {
        this.operands = operands;
    }

    public OperandNumber valueAt(int position) {
        return operands.get(position);
    }

    public int size() {
        return operands.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operands operands1 = (Operands) o;
        return operands.equals(operands1.operands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operands);
    }
}
