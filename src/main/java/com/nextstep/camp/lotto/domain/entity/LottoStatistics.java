package com.nextstep.camp.lotto.domain.entity;

import com.nextstep.camp.lotto.domain.type.MatchResult;
import com.nextstep.camp.lotto.domain.vo.Money;
import com.nextstep.camp.lotto.domain.vo.RateOfReturn;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private final Map<MatchResult, Integer> resultCounts;

    private static final int INIT_COUNT = 1;

    private LottoStatistics(List<MatchResult> results) {
        this.resultCounts = new EnumMap<>(MatchResult.class);
        for (MatchResult result : results) {
            resultCounts.merge(result, INIT_COUNT, Integer::sum);
        }
    }

    public static LottoStatistics of(List<MatchResult> results) {
        return new LottoStatistics(results);
    }

    public int totalPrize() {
        return resultCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public RateOfReturn calculateRateOfReturn(Money spent) {
        return RateOfReturn.of(totalPrize(), spent);
    }

    public Map<MatchResult, Integer> getResultCounts() {
        return resultCounts;
    }
}
