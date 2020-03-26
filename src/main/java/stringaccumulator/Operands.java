package stringaccumulator;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Operands {
    private final List<Operand> operands;

    public Operands(List<String> operands) {
        this.operands = operands.stream()
                .map(Operand::new)
                .collect(toList());
    }

    public int sum() {
        if (operands.isEmpty()) {
            return 0;
        }

        return operands.stream()
                .map(Operand::parseInt)
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Operands)) return false;
        Operands operands1 = (Operands) o;
        return Objects.equals(operands, operands1.operands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operands);
    }
}
