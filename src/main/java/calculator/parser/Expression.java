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
        checkExpressionRuleOfOperator();
        return operators.poll();
    }

    public Integer nextOperand() {
        checkSize();
        checkExpressionRuleOfOperand();
        return operands.poll();
    }

    private void checkSize() {
        if (hasSize(0)) {
            throw new IllegalArgumentException("남아있는 피연산자와 연산자가 없습니다");
        }
    }

    private void checkExpressionRuleOfOperand() {
        if (operands.size() != (operators.size() + 1)) {
            throw new UnsupportedOperationException("연산자를 먼저 뽑아주세요");
        }
    }

    private void checkExpressionRuleOfOperator() {
        if (operators.size() != operands.size()) {
            throw new UnsupportedOperationException("피연산자 를 먼저 뽑아주세요");
        }
    }


}
