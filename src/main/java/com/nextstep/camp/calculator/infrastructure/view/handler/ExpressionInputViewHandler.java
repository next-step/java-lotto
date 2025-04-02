package com.nextstep.camp.calculator.infrastructure.view.handler;


import com.nextstep.camp.calculator.infrastructure.view.ExpressionInputView;
import com.nextstep.camp.calculator.infrastructure.view.component.ExpressionInput;
import com.nextstep.camp.calculator.infrastructure.view.dto.ExpressionInputData;
import com.nextstep.camp.calculator.domain.strategy.ExpressionInputStrategy;

public class ExpressionInputViewHandler {

    public ExpressionInputData handleUserInput() {
        ExpressionInput input = ExpressionInput.create(ExpressionInputStrategy.ofSystemIn());
        ExpressionInputView view = ExpressionInputView.publish(input);
        view.render();
        return view.toInputData();
    }
}
