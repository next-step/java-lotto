package com.nextstep.camp.lotto.domain.entity;

public interface ExpressionNode {

    static boolean isNotNumberNode(ExpressionNode node) {
        return !(node instanceof NumberNode);
    }

    int evaluate();

}
