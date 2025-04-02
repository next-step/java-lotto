package com.nextstep.camp.calculator.infrastructure.view;

import com.nextstep.camp.calculator.infrastructure.view.component.ExpressionInput;
import com.nextstep.camp.calculator.infrastructure.view.dto.ExpressionInputData;

public class ExpressionInputView {
    private final ExpressionInput expressionInput;

    private ExpressionInputView(ExpressionInput expressionInput) {
        this.expressionInput = expressionInput;
    }

    public static ExpressionInputView publish(ExpressionInput expressionInput) {
        return new ExpressionInputView(expressionInput);
    }

    public void render() {
        expressionInput.action();
    }

    public ExpressionInputData toInputData() {
        return ExpressionInputData.of(expressionInput);
    }
}
