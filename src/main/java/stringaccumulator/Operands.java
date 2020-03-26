package stringaccumulator;

import java.util.List;
import java.util.Objects;

public class Operands {
    private final List<String> operands;

    public Operands(List<String> operands) {
        this.operands = operands;
    }

    public int sum() {
        if (operands.isEmpty()) {
            return 0;
        }

        return operands.stream()
                .mapToInt(Integer::parseInt)
                .map(this::isNegative)
                .sum();
    }

    private int isNegative(Integer operand) {
        if (operand < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        return operand;
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
