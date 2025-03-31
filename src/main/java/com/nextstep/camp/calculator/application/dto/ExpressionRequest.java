package com.nextstep.camp.calculator.application.dto;

import com.nextstep.camp.calculator.domain.vo.ExpressionTokens;

public class ExpressionRequest {
    private final ExpressionTokens expressionTokens;

    public ExpressionRequest(ExpressionTokens expressionTokens) {
        this.expressionTokens = expressionTokens;
    }

    public ExpressionTokens getExpressionTokens() {
        return expressionTokens;
    }
}
