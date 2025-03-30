package com.nextstep.camp.lotto.infrastructure.view.handler;

import com.nextstep.camp.lotto.application.dto.ExpressionResponse;
import com.nextstep.camp.lotto.infrastructure.view.ExpressionResultView;
import com.nextstep.camp.lotto.infrastructure.view.component.ExpressionResult;

public class ExpressionResultViewHandler {

    public void handle(ExpressionResponse response) {
        ExpressionResult result = ExpressionResult.create(response);
        ExpressionResultView view = ExpressionResultView.publish(result);
        view.render();
    }
}
