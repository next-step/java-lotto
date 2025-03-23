package step1;

import java.util.LinkedList;
import java.util.Queue;

public class Expression {
    private final Queue<Operand> _operands;
    private final Queue<Operator> _operators;

    public Expression(Queue<Operand> operands, Queue<Operator> operators) {
        if (operands.isEmpty()) {
            throw new RuntimeException("잘못된 수식입니다.");
        }
        this._operands = operands;
        this._operators = operators;
    }

    public int evaluate() {
        Queue<Operand> operands = new LinkedList<>(_operands);
        Queue<Operator> operators = new LinkedList<>(_operators);

        if (operands.isEmpty()) {
            throw new RuntimeException("잘못된 수식입니다.");
        }

        Operand left = operands.poll();
        while (!operands.isEmpty() && !operators.isEmpty()) {
            Operator operator = operators.poll();
            Operand right = operands.poll();
            left = operator.apply(left, right);
        }

        if (!operands.isEmpty() || !operators.isEmpty()) {
            throw new RuntimeException("잘못된 수식입니다.");
        }

        return left.value();
    }
}