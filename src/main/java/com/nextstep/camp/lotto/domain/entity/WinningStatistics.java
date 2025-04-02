package com.nextstep.camp.lotto.domain.entity;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.nextstep.camp.lotto.domain.type.MatchResult;
import com.nextstep.camp.lotto.domain.type.ProfitType;
import com.nextstep.camp.lotto.domain.vo.LottoAmount;
import com.nextstep.camp.lotto.domain.vo.RateOfReturn;

public class WinningStatistics {
    private final Map<MatchResult, Integer> resultCounts;
    private final LottoAmount spent;

    private WinningStatistics(List<MatchResult> results, LottoAmount spent) {
        this.spent = spent;
        this.resultCounts = MatchResult.getValidValues().stream()
            .collect(Collectors.toMap(
                Function.identity(),
                matchResult -> Collections.frequency(results, matchResult),
                (a, b) -> a,
                LinkedHashMap::new
            ));
    }

    public static WinningStatistics of(List<MatchResult> results, LottoAmount spent) {
        return new WinningStatistics(results, spent);
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
