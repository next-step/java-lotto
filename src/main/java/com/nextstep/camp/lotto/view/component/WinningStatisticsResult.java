package com.nextstep.camp.lotto.view.component;

import java.util.stream.Collectors;

import com.nextstep.camp.common.view.component.AbstractResult;
import com.nextstep.camp.lotto.domain.entity.WinningStatistics;
import com.nextstep.camp.lotto.domain.type.ProfitType;
import com.nextstep.camp.lotto.domain.vo.RateOfReturn;

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
        String resultString = value.getResultCounts().entrySet().stream()
            .map(entry -> entry.getKey() + " - " + entry.getValue() + "개")
            .collect(Collectors.joining("\n"));
        RateOfReturn rateOfReturn = value.calculateRateOfReturn(value.getSpent());
        ProfitType profitType = rateOfReturn.getProfitType();

        String formatted = generateStatisticsReport(resultString, rateOfReturn, profitType);

        System.out.println(formatted);
        return value;
    }

    private String generateStatisticsReport(String resultString, RateOfReturn rateOfReturn, ProfitType profitType) {
        return getLabel() +
            resultString + "\n" +
            "총 수익률은 " +
            rateOfReturn.toString() +
            "입니다.(기준이 1이기 때문에 결과적으로 " + profitType.getDescription() + "라는 의미임)";
    }
}
