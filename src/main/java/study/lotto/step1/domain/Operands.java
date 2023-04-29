package study.lotto.step1.domain;

import java.util.Deque;

public class Operands {
    private final Deque<Operand> operands;

    public Operands(Deque<Operand> operands) {
        this.operands = operands;
    }

    public Operand removeFirst() {
        return operands.removeFirst();
    }

    public void addFirst(Operand operand) {
        operands.addFirst(operand);
    }

    public int size() {
        return operands.size();
    }
}
