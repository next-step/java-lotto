package stringCalculator.domain.expression;

import java.util.LinkedList;
import java.util.Queue;

public class Operands {

    private final Queue<Integer> operands = new LinkedList<>();

    public void add(Integer type) {
        operands.add(type);
    }

    public Integer poll() {
        return operands.poll();
    }
}
