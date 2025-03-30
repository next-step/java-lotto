package com.nextstep.camp.lotto.infrastructure.view;

import com.nextstep.camp.lotto.infrastructure.view.component.ExpressionInput;
import com.nextstep.camp.lotto.infrastructure.view.dto.InputData;

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

    public InputData toInputData() {
        return InputData.of(expressionInput);
    }
}
