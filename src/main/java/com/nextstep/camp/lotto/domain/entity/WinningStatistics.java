package com.nextstep.camp.lotto.domain.entity;

import java.util.Map;

import com.nextstep.camp.lotto.domain.type.Rank;
import com.nextstep.camp.lotto.domain.vo.LottoAmount;
import com.nextstep.camp.lotto.domain.vo.RateOfReturn;

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
}
