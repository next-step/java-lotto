package calculator.domain.expression;

import java.util.*;
import java.util.stream.Collectors;

import static calculator.domain.expression.Operand.OPERAND_PATTERN;

public class Operands {
    private final Queue<Operand> operands;

    public Operands(Queue<Operand> operands) {
        this.operands = operands;
    }

    public Operands(Operands original) {
        this.operands = new LinkedList<>(original.operands);
    }

    public static Operands extractOperand(List<String> expressions) {
        Queue<Operand> operands = expressions.stream()
                .filter(s -> OPERAND_PATTERN.matcher(s).matches())
                .map(Operand::new)
                .collect(Collectors.toCollection(LinkedList::new));
        return new Operands(operands);
    }

    public int getNumberOfOperands() {
        return operands.size();
    }

    public Operand next() {
        return operands.poll();
    }

    public boolean isInValid() {
        return operands.isEmpty();
    }
}
