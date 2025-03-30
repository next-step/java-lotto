package com.nextstep.camp.lotto.infrastructure.view.dto;

import com.nextstep.camp.lotto.application.dto.ExpressionRequest;
import com.nextstep.camp.lotto.infrastructure.view.component.ExpressionInput;

public class InputData {
    private final ExpressionInput expressionInput;

    private InputData(ExpressionInput expressionInput) {
        this.expressionInput = expressionInput;
    }

    public static InputData of(ExpressionInput expressionInput) {
        return new InputData(expressionInput);
    }

    public ExpressionInput getExpressionInput() {
        return expressionInput;
    }

    public ExpressionRequest toExpressionRequest() {
        return new ExpressionRequest(expressionInput.getValue());
    }
}
