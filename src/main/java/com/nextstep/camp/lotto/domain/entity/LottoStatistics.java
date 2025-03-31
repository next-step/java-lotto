package com.nextstep.camp.lotto.domain.entity;

import com.nextstep.camp.lotto.domain.type.MatchResult;
import com.nextstep.camp.lotto.domain.vo.Money;
import com.nextstep.camp.lotto.domain.vo.RateOfReturn;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private final Map<MatchResult, Integer> resultCounts;

    public LottoStatistics(List<MatchResult> results) {
        this.resultCounts = new EnumMap<>(MatchResult.class);
        for (MatchResult result : results) {
            resultCounts.merge(result, 1, Integer::sum);
        }
    }

    public int totalPrize() {
        return resultCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public RateOfReturn calculateRateOfReturn(Money spent) {
        return new RateOfReturn(totalPrize(), spent);
    }

    public Map<MatchResult, Integer> getResultCounts() {
        return resultCounts;
    }
}
