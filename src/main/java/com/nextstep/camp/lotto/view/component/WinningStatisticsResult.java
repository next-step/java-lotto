package com.nextstep.camp.lotto.view.component;

import com.nextstep.camp.calculator.application.dto.ExpressionResponse;
import com.nextstep.camp.common.view.component.AbstractResult;
import com.nextstep.camp.lotto.domain.entity.WinningStatistics;

public class WinningStatisticsResult extends AbstractResult<WinningStatistics> {

    protected WinningStatisticsResult(WinningStatistics statistics) {
        super(statistics);
    }

    public static WinningStatisticsResult create(WinningStatistics statistics) {
        return new WinningStatisticsResult(statistics);
    }

    @Override
    public String getLabel() {
        return "\n당첨 통계\n---------\n";
    }

    @Override
    public WinningStatistics getValue() {
        return value;
    }

    @Override
    public WinningStatistics action() {
        System.out.println(getLabel() + value);
        return value;
    }
}
