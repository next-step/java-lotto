package com.nextstep.camp.calculator.domain.entity;

import com.nextstep.camp.calculator.domain.vo.ExpressionToken;
import com.nextstep.camp.calculator.domain.vo.ExpressionTokens;

public class Expression {
    private final ExpressionNode root;

    private Expression(ExpressionTokens tokens) {
        this.root = buildTree(tokens);
    }

    public static Expression of(ExpressionTokens tokens) {
        return new Expression(tokens);
    }

    public int evaluate() {
        return root.evaluate();
    }

    private ExpressionNode buildTree(ExpressionTokens tokens) {
        ExpressionToken first = tokens.poll();
        ExpressionNode current = NumberNode.of(first);

        while (tokens.isNotEmpty()) {
            ExpressionToken opToken = tokens.poll();
            ExpressionToken rightToken = tokens.poll();
            current = OperatorNode.of(opToken, current, NumberNode.of(rightToken));
        }

        return current;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
