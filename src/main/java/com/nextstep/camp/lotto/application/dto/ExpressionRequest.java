package com.nextstep.camp.lotto.application.dto;

import com.nextstep.camp.lotto.domain.vo.ExpressionTokens;

public class ExpressionRequest {
    private final ExpressionTokens expressionTokens;

    public ExpressionRequest(ExpressionTokens expressionTokens) {
        this.expressionTokens = expressionTokens;
    }

    public ExpressionTokens getExpressionTokens() {
        return expressionTokens;
    }
}
