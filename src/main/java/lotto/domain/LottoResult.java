package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private Map<Rank, Integer> lottoResultMap;

    public LottoResult() {
        this.lottoResultMap = new HashMap<>();
        for (Rank rank : Rank.values()) {
            lottoResultMap.put(rank, 0);
        }
    }

    public LottoResult(Map<Rank, Integer> lottoResultMap) {
        this.lottoResultMap = lottoResultMap;
    }

    public Money totalPrizeAmount() {
        int totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += Rank.calculate(rank, lottoResultMap.getOrDefault(rank, 0));
        }
        return new Money(totalPrize);
    }

    public int rankCount(Rank rank) {
        return lottoResultMap.get(rank);
    }

    public void add(Rank rank) {
        lottoResultMap.replace(rank, rankCount(rank) + 1);
    }
}
