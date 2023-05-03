package calculator.parser;

import java.util.Deque;

public class Expression {
    private final Deque<Integer> operands;
    private final Deque<String> operators;

    public Expression(Deque<Integer> operands, Deque<String> operators) {
        this.operands = operands;
        this.operators = operators;
    }

    public boolean hasSize(int size) {
        return operands.size() + operators.size() == size;
    }

    public boolean hasOperator() {
        return !operators.isEmpty();
    }

    public String nextOperator() {
        checkSize();
        return operators.poll();
    }

    public Integer nextOperand() {
        checkSize();
        return operands.poll();
    }

    private void checkSize() {
        if(hasSize(0)) {
            throw new IllegalArgumentException("남아있는 피연산자와 연산자가 없습니다");
        }
    }
}
