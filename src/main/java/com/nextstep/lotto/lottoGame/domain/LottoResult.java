package com.nextstep.lotto.lottoGame.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {
    private final Map<Rank, Long> rankMap;

    public LottoResult(List<Rank> ranks) {
        this.rankMap = ranks.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public boolean contains(Rank rank) {
        return rankMap.containsKey(rank);
    }

    public int getCount(Rank rank) {
        if (rankMap.containsKey(rank)) {
            return rankMap.get(rank).intValue();
        }
        return 0;
    }

    public int getPrizeSum() {
        int prizeSum = 0;
        for (Rank rank : rankMap.keySet()) {
            int count = rankMap.get(rank).intValue();
            int prize = rank.getPrize();
            prizeSum += count * prize;
        }
        return prizeSum;
    }
}
