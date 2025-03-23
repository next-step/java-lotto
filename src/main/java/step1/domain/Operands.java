package step1.domain;

import java.util.List;

public class Operands {
    private final List<Operand> operands;

    public Operands(List<Operand> nums) {
        operands = nums;
    }

    public List<Operand> getOperands() {
        return List.copyOf(operands);
    }
}
