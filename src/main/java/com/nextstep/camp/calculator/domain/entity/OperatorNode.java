package com.nextstep.camp.calculator.domain.entity;

import com.nextstep.camp.calculator.domain.exception.NotFoundOperandException;
import com.nextstep.camp.calculator.domain.exception.NotFoundOperatorException;
import com.nextstep.camp.calculator.domain.exception.UnsupportedOperatorException;
import com.nextstep.camp.calculator.domain.vo.ExpressionToken;
import com.nextstep.camp.calculator.domain.vo.OperatorToken;

public class OperatorNode implements ExpressionNode {

    private final OperatorToken operatorToken;
    private final ExpressionNode left;
    private final ExpressionNode right;

    private OperatorNode(ExpressionToken operatorToken, ExpressionNode left, ExpressionNode right) {
        validate(operatorToken, left, right);
        this.operatorToken = (OperatorToken) operatorToken;
        this.left = left;
        this.right = right;
    }

    public static OperatorNode of(ExpressionToken operatorToken, ExpressionNode left, ExpressionNode right) {
        return new OperatorNode(operatorToken, left, right);
    }

    private static void validate(ExpressionToken operatorToken, ExpressionNode left, ExpressionNode right) {
        if (operatorToken == null) {
            throw new NotFoundOperatorException();
        }
        if (ExpressionToken.isNotOperatorToken(operatorToken)) {
            throw new UnsupportedOperatorException();
        }
        if (left == null || right == null) {
            throw new NotFoundOperandException();
        }
    }

    @Override
    public int evaluate() {
        int l = left.evaluate();
        int r = right.evaluate();
        return operatorToken.operate(l, r);
    }

    @Override
    public String toString() {
        return "(" + left + " " + operatorToken + " " + right + ")";
    }
}
