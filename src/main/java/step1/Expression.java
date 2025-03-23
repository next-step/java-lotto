package step1;

import java.util.LinkedList;
import java.util.Queue;

public class Expression {
    private final Queue<Operand> operands;
    private final Queue<Operator> operators;

    public Expression(Queue<Operand> operands, Queue<Operator> operators) {
        if (operands.isEmpty()) {
            throw new RuntimeException("잘못된 수식입니다.");
        }
        this.operands = operands;
        this.operators = operators;
    }

    public int evaluate() {
        Queue<Operand> operandsCopy = new LinkedList<>(operands);
        Queue<Operator> operatorsCopy = new LinkedList<>(operators);

        if (operandsCopy.isEmpty()) {
            throw new RuntimeException("잘못된 수식입니다.");
        }

        Operand left = operandsCopy.poll();
        while (!operandsCopy.isEmpty() && !operatorsCopy.isEmpty()) {
            Operator operator = operatorsCopy.poll();
            Operand right = operandsCopy.poll();
            left = operator.apply(left, right);
        }

        if (!operandsCopy.isEmpty() || !operatorsCopy.isEmpty()) {
            throw new RuntimeException("잘못된 수식입니다.");
        }

        return left.value();
    }
}