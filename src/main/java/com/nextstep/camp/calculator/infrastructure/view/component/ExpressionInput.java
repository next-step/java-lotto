package com.nextstep.camp.calculator.infrastructure.view.component;

import com.nextstep.camp.calculator.domain.vo.ExpressionTokens;
import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.common.view.component.AbstractInput;

public class ExpressionInput extends AbstractInput<ExpressionTokens> {

    private ExpressionInput(InputStrategy<ExpressionTokens> inputStrategy) {
        super(inputStrategy);
    }

    public static ExpressionInput create(InputStrategy<ExpressionTokens> inputStrategy) {
        return new ExpressionInput(inputStrategy);
    }

    @Override
    public String getLabel() {
        return "연산식을 입력하세요.";
    }
}
