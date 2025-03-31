package com.nextstep.camp.lotto.domain.entity;

import com.nextstep.camp.lotto.domain.type.MatchResult;
import com.nextstep.camp.lotto.domain.vo.LottoAmount;
import com.nextstep.camp.lotto.domain.vo.RateOfReturn;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private final Map<MatchResult, Integer> resultCounts;

    private static final int INIT_COUNT = 1;

    private WinningStatistics(List<MatchResult> results) {
        this.resultCounts = new EnumMap<>(MatchResult.class);
        for (MatchResult result : results) {
            resultCounts.merge(result, INIT_COUNT, Integer::sum);
        }
    }

    public static WinningStatistics of(List<MatchResult> results) {
        return new WinningStatistics(results);
    }

    public int totalPrize() {
        return resultCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public RateOfReturn calculateRateOfReturn(LottoAmount spent) {
        return RateOfReturn.of(totalPrize(), spent);
    }

    public Map<MatchResult, Integer> getResultCounts() {
        return resultCounts;
    }
}
