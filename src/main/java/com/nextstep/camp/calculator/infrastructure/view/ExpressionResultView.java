package com.nextstep.camp.calculator.infrastructure.view;

import com.nextstep.camp.calculator.infrastructure.view.component.ExpressionResult;

public class ExpressionResultView {
    private final ExpressionResult expressionResult;

    private ExpressionResultView(ExpressionResult expressionResult) {
        this.expressionResult = expressionResult;
    }

    public static ExpressionResultView publish(ExpressionResult expressionResult) {
        return new ExpressionResultView(expressionResult);
    }

    public void render() {
        expressionResult.action();
    }
}
