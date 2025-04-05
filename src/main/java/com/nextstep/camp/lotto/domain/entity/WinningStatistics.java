package com.nextstep.camp.lotto.domain.entity;

import com.nextstep.camp.lotto.domain.type.ProfitType;
import com.nextstep.camp.lotto.domain.type.Rank;
import com.nextstep.camp.lotto.domain.vo.LottoAmount;
import com.nextstep.camp.lotto.domain.vo.RateOfReturn;

import java.util.Map;
import java.util.stream.Collectors;

public class WinningStatistics {
    private final Map<Rank, Integer> resultCounts;
    private final LottoAmount spent;

    private WinningStatistics(Map<Rank, Integer> resultCounts, LottoAmount spent) {
        this.spent = spent;
        this.resultCounts = resultCounts;
    }

    public static WinningStatistics of(Map<Rank, Integer> resultCounts, LottoAmount spent) {
        return new WinningStatistics(resultCounts, spent);
    }

    public int totalPrize() {
        return resultCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public RateOfReturn calculateRateOfReturn(LottoAmount spent) {
        return RateOfReturn.of(totalPrize(), spent);
    }

    public Map<Rank, Integer> getResultCounts() {
        return resultCounts;
    }

    public LottoAmount getSpent() {
        return spent;
    }

    @Override
    public String toString() {
        String resultString = resultCounts.entrySet().stream()
            .map(entry -> entry.getKey() + " - " + entry.getValue() + "개")
            .collect(Collectors.joining("\n"));

        RateOfReturn rateOfReturn = calculateRateOfReturn(spent);
        ProfitType profitType = rateOfReturn.getProfitType();
        return resultString + "\n" +
            "총 수익률은 " +
            rateOfReturn.toString() +
            "입니다.(기준이 1이기 때문에 결과적으로 " + profitType.getDescription() + "라는 의미임)";
    }
}
