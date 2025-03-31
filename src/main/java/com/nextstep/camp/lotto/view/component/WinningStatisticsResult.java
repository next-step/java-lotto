package com.nextstep.camp.lotto.view.component;

import com.nextstep.camp.calculator.application.dto.ExpressionResponse;
import com.nextstep.camp.common.view.component.AbstractResult;

public class WinningStatisticsResult extends AbstractResult<Integer> {

    protected WinningStatisticsResult(Integer value) {
        super(value);
    }

    public static WinningStatisticsResult create(ExpressionResponse response) {
        return new WinningStatisticsResult(response.getResult());
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
