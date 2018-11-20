package lotto.domain;

import java.util.HashMap;

public class LottoResultDefault implements LottoResult {
    private HashMap<Rank, Integer> ranking = new HashMap<>();

    public LottoResultDefault() {
        for(Rank rank : Rank.values()) {
            ranking.put(rank, 0);
        }
    }

    public void setRankingStatus(Rank rank) {
        ranking.put(rank, ranking.get(rank) + 1);
    }

    @Override
    public Integer getRankingCount(Rank rank) {
        return ranking.get(rank);
    }

    @Override
    public Money getTotalPrize() {
        Money totalPrize = new Money(0);
        for(Rank rank : ranking.keySet()) {
            totalPrize = totalPrize.sum(rank.prizePerRanking(ranking.get(rank)));
        }
        return totalPrize;
    }

}
