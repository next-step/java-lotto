package calculator.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Operands {
    private final List<Operand> operands;

    public Operands(List<Operand> operands) {
        this.operands = operands;
    }

    public static Operands of(List<String> operands) {
       return new Operands(operands.stream()
                .map(Operand::new)
                .collect(Collectors.toList()));
    }

    public List<Operand> getOperands() {
        return Collections.unmodifiableList(operands);
    }
}
