package calculate.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Operands {

    private final List<Operand> operands;

    public Operands(Operand... operand) {
        this.operands = Arrays.asList(operand);
    }

    public Operands(List<Operand> operands) {
        this.operands = operands;
    }

    public List<Operand> getOperands() {
        return operands;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operands operands1 = (Operands) o;
        return Objects.equals(operands, operands1.operands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operands);
    }
}
