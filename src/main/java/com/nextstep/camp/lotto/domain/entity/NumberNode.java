package com.nextstep.camp.lotto.domain.entity;

import com.nextstep.camp.lotto.domain.exception.UnsupportedTokenTypeException;
import com.nextstep.camp.lotto.domain.vo.ExpressionToken;
import com.nextstep.camp.lotto.domain.vo.NumberToken;

public class NumberNode implements ExpressionNode {
    private final NumberToken numberToken;

    private NumberNode(NumberToken numberToken) {
        this.numberToken = numberToken;
    }

    private NumberNode(ExpressionToken token) {
        if (ExpressionToken.isNotNumberToken(token)) {
            throw new UnsupportedTokenTypeException();
        }
        this.numberToken = (NumberToken) token;
    }

    public static NumberNode of(NumberToken numberToken) {
        return new NumberNode(numberToken);
    }

    public static NumberNode of(ExpressionToken token) {
        return new NumberNode(token);
    }

    @Override
    public int evaluate() {
        return numberToken.getValue();
    }

    @Override
    public String toString() {
        return numberToken.toString();
    }
}
