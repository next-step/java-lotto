package step1;

import java.util.Queue;

public class Operators {

    private final Queue<Operator> arithmetics;

    public Operators(Queue<Operator> arithmetics) {
        this.arithmetics = arithmetics;
    }

    public int executedResult(int operand, int anotherOperand) {
        return arithmetics.poll().executedResult(operand, anotherOperand);
    }

}
