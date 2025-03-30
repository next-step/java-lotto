package com.nextstep.camp.lotto.infrastructure.view.component;

import com.nextstep.camp.lotto.application.dto.ExpressionResponse;

public class ExpressionResult extends AbstractResult<Integer> {

    protected ExpressionResult(Integer value) {
        super(value);
    }

    public static ExpressionResult create(ExpressionResponse response) {
        return new ExpressionResult(response.getResult());
    }

    @Override
    public String getLabel() {
        return "답: ";
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void action() {
        System.out.println(getLabel() + getValue());
    }
}
