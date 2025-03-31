package com.nextstep.camp.lotto.view;

import com.nextstep.camp.calculator.infrastructure.view.component.ExpressionInput;
import com.nextstep.camp.calculator.infrastructure.view.dto.ExpressionInputData;

public class LottoInputView {
    private final ExpressionInput expressionInput;

    private LottoInputView(ExpressionInput expressionInput) {
        this.expressionInput = expressionInput;
    }

    public static LottoInputView publish(ExpressionInput expressionInput) {
        return new LottoInputView(expressionInput);
    }

    public void render() {
        expressionInput.action();
    }

    public ExpressionInputData toInputData() {
        return ExpressionInputData.of(expressionInput);
    }
}
