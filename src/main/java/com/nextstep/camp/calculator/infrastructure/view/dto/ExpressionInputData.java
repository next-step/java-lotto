package com.nextstep.camp.calculator.infrastructure.view.dto;

import com.nextstep.camp.calculator.application.dto.ExpressionRequest;
import com.nextstep.camp.calculator.infrastructure.view.component.ExpressionInput;

public class ExpressionInputData {
    private final ExpressionInput expressionInput;

    private ExpressionInputData(ExpressionInput expressionInput) {
        this.expressionInput = expressionInput;
    }

    public static ExpressionInputData of(ExpressionInput expressionInput) {
        return new ExpressionInputData(expressionInput);
    }

    public ExpressionInput getExpressionInput() {
        return expressionInput;
    }

    public ExpressionRequest toExpressionRequest() {
        return new ExpressionRequest(expressionInput.getValue());
    }
}
