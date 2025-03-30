package com.nextstep.camp.lotto.domain.vo;

import com.nextstep.camp.common.utils.NumberUtils;

public interface ExpressionToken {
    static ExpressionToken of(String token) {
        if (NumberUtils.isNumber(token)) {
            return NumberToken.of(token);
        }
        return OperatorToken.of(token);
    }

    static boolean isNotNumberToken(ExpressionToken token) {
        return !(token instanceof NumberToken);
    }

    static boolean isNotOperatorToken(ExpressionToken token) {
        return !(token instanceof OperatorToken);
    }
}
