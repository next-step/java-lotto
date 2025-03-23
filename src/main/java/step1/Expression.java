package step1;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Expression {
    private final Queue<Operand> _operands;
    private final Queue<Operator> _operators;

    public Expression(Queue<Operand> operands, Queue<Operator> operators) {
        if (operands.isEmpty()) {
            throw new RuntimeException("피연산자가 없는 수식입니다.");
        }
        this._operands = operands;
        this._operators = operators;
    }

    public int evaluate() {
        Queue<Operand> operands = new LinkedList<>(_operands);
        Queue<Operator> operators = new LinkedList<>(_operators);

        if (operands.isEmpty()) {
            throw new RuntimeException("피연산자가 없는 수식입니다.");
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

        return left.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return Objects.equals(_operands, that._operands) && Objects.equals(_operators, that._operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_operands, _operators);
    }
}