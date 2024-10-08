package stringcalculator.model;

import java.util.Objects;

public class Memory {
    private final Operator operator;
    private final Operand operand;

    public Memory(final Operator operator, final Operand operand) {
        this.operator = operator;
        this.operand = operand;
    }

    public Operand calculate(Operand prevOperand) {
        return operator.calculate(prevOperand, operand);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Memory memory = (Memory) o;
        return operator == memory.operator && Objects.equals(operand, memory.operand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator, operand);
    }
}
