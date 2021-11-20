package calculator;

import java.util.List;

public class Operands {

    private final List<Operand> operands;

    public Operands(List<Operand> operands) {
        this.operands = operands;
    }

    public int sumAll() {
        return operands.stream()
                .reduce(Operand.ZERO, Operand::add)
                .value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operands operands1 = (Operands) o;

        return operands != null ? operands.equals(operands1.operands) : operands1.operands == null;
    }

    @Override
    public int hashCode() {
        return operands != null ? operands.hashCode() : 0;
    }

}
