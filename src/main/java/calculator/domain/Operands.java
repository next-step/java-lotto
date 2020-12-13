package calculator.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Operands {
    private final List<Operand> operands;

    Operands(Operand operand) {
        this.operands = Collections.singletonList(operand);
    }

    Operands(List<Operand> operands) {
        this.operands = Collections.unmodifiableList(operands);
    }

    public int sum() {
        return operands.stream()
                .map(Operand::getNumber)
                .mapToInt(Integer::intValue)
                .sum();
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
