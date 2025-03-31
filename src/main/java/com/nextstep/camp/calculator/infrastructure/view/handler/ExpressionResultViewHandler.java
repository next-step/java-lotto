package com.nextstep.camp.calculator.infrastructure.view.handler;

import com.nextstep.camp.calculator.application.dto.ExpressionResponse;
import com.nextstep.camp.calculator.infrastructure.view.ExpressionResultView;
import com.nextstep.camp.calculator.infrastructure.view.component.ExpressionResult;

public class ExpressionResultViewHandler {

    public void handle(ExpressionResponse response) {
        ExpressionResult result = ExpressionResult.create(response);
        ExpressionResultView view = ExpressionResultView.publish(result);
        view.render();
    }
}
