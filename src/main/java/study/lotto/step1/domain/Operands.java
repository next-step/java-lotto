package study.lotto.step1.domain;

import java.util.*;

public class Operands {
    private static final int FIRST_INDEX = 0;
    private final List<Operand> operands;

    public Operands(List<Operand> operands) {
        this.operands = operands;
    }

    public Operand removeFirst() {
        return operands.remove(FIRST_INDEX);
    }

    public void addFirst(Operand operand) {
        operands.add(FIRST_INDEX, operand);
    }

    public int size() {
        return operands.size();
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
        return Objects.hash(FIRST_INDEX, operands);
    }
}
