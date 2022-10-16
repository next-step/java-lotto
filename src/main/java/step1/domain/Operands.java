package step1.domain;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Operands implements Iterable<Operand> {

    private final Queue<Operand> operands;

    private Operands(Queue<Operand> operands) {
        this.operands = operands;
    }

    public Operand poll() {
        return operands.poll();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Operands) {
            return this.operands.equals(((Operands) o).operands);
        }
        return false;
    }

    @Override
    public Iterator<Operand> iterator() {
        return operands.iterator();
    }

    public static Operands of(List<String> rawOperands) {
        Queue<Operand> operands = new LinkedList<>();
        for (String rawOperand : rawOperands) {
            Operand operand = new Operand(Integer.parseInt(rawOperand));
            operands.add(operand);
        }
        return new Operands(operands);
    }
}
