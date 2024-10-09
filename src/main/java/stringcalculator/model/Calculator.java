package stringcalculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Calculator {
    private final Operand firstOperand;
    private final List<Memory> memories;

    public Calculator(Operand firstOperand, final Memory... memories) {
        this.firstOperand = firstOperand;
        this.memories = convertMemories(memories);
    }

    private List<Memory> convertMemories(Memory... memories) {
        return Arrays.stream(memories)
                .collect(Collectors.toUnmodifiableList());
    }

    public Result calculate() {
        Operand operand = this.firstOperand;
        for (Memory memory : memories) {
            operand = memory.calculate(operand);
        }
        return new Result(operand.value());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator calculator1 = (Calculator) o;
        return Objects.equals(firstOperand, calculator1.firstOperand) && Objects.equals(memories, calculator1.memories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstOperand, memories);
    }
}
